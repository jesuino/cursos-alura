var express = require('express');
var bodyParser = require('body-parser')
var app = express();

var session = require('express-session');
app.use(
    session(
      {secret: 'session_secret',
      resave: false,
      saveUninitialized: false}
));

app.use( bodyParser.json() );       

app.use(bodyParser.urlencoded({
  extended: true
})); 

//HTTP GET /
app.get('/', function (req, res) {
  logRequest(req);
  res.send('<HTML> HTTP e os fundamentos da web ' + 
    '<br />    ' + 
    '<hr /> ' + 
    '<br /> ' + 
        'Formulario para testar HTTP POST' + 
    '<br /> ' + 
    '<br /> ' + 
       '<form action="/calcula/parcelas" method="POST">' + 
            'Valor: ' + 
            '<input name="valor" />' + 
            '<br />' + 
            'Quantidade: ' +            
          '<input name="qtd" />' +
          '<br /> <br />' + 
        '<input value="Calcule Parcelas" type="submit" />' +
        '</form>' + 
    '<hr /> ' + 
    '<br /> ' + 
        'Link para testar HTTP GET' +
        '<br /> ' + 
        '<br /> ' + 
        ' <a href="/calcula/parcelas?valor=300&qtd=5">R$ 300 em 5 Parcelas?</a> ' + 
    '</HTML> ');
});

//Para saber mais
app.get('/autenticacao', function(req, res) {
  var authorization = req.headers.authorization

  if(authorization) {
    authorization = authorization.substring(6)
    
    var decoded = decode(authorization);
    if("alura:http" === decoded) {
      res.status(200)
      res.send("<html>Parabéns!</html>") 
    } else {
      forbidden(res)
    }
  } else {
    forbidden(res)
  }

});

//Content negotiation
app.get('/produtos', function(req, res) {
  var produtos;
  var accept = req.headers.accept;
  
  if('application/xml' === accept) {
    produtos = '<produtos>' +
                '<produto>' +
                  '<nome>Livro de Java</nome>' +
                  '<preco>R$ 50,00</preco>' +
                '</produto>' +
                '<produto>' +
                  '<nome>Livro de Scrum</nome>' +
                  '<preco>R$ 40,00</preco>' +
                '</produto>' +
                '<produto>' +
                  '<nome>Macbook Pro</nome>' +
                  '<preco>R$ 6000,00</preco>' +
                '</produto>' +                                
               '</produtos>'; 

    res.header('Content-Type', 'application/xml');
  } else if(accept.search('text/html') > -1) {
    produtos = '<html>' +
                 '<table border=1>' +
                   '<tr>' +
                     '<td>Nome</td><td>Preço</td>' +
                   '</tr>' +
                   '<tr>' +
                     '<td>Livro de Java</td><td>R$ 50,00</td>' +                     
                   '</tr>' +
                   '<tr>' +
                     '<td>Livro de Scrum</td><td>R$ 40,00</td>' +                     
                   '</tr>' +
                   '<tr>' +
                     '<td>Macbook Pro</td><td>R$ 6000,00</td>' +                     
                   '</tr>' +                   
                 '</table>' +
               '</html>';  
  } else {
    res.status(406);
  }

  res.send(produtos);
});

//HTTP POST /calcula/parcelas
app.post('/calcula/parcelas', function(req, res) {
  logRequest(req);

  var valor = parseFloat(req.body.valor);
  var qtd = parseFloat(req.body.qtd);
  var parcela = valor / qtd;

  if(isNaN(parcela)) {
    throw "Algo deu errado no calculo."
  }

  res.send('<HTML> R$ ' + valor + ' em ' + qtd + ' parcela(s) de R$ ' + ( parcela ) + ' </HTML>\n');
});

//HTTP GET /calcula/parcelas
app.get('/calcula/parcelas', function(req, res) {
  logRequest(req);

  var valor = parseFloat(req.query.valor);
  var qtd = parseFloat(req.query.qtd);
  var parcela = valor / qtd;

  if(isNaN(parcela)) {
    throw "Algo deu errado no calculo.";
  }

  res.send('<HTML> R$ ' + valor + ' em ' + qtd + ' parcela(s) de R$ ' + ( parcela ) + ' </HTML>\n');
});

app.get('/codigo-http-1', function(req, res) {
  logRequest(req);

  res.status(201).send('<HTML> Qual é o código da resposta? </HTML>\n');
});

app.get('/codigo-http-2', function(req, res) {
  logRequest(req);

  res.setHeader('Location', '/codigo-http-3');
  res.status(302).send('<HTML> Qual é o código da resposta? </HTML>\n');
});

app.get('/codigo-http-3', function(req, res) {
  logRequest(req);
  res.send('<HTML> O que aconteceu? </HTML>\n');
});

app.get('/contador', function(req, res) {
  logRequest(req);
  var sess = req.session;
  res.send('<HTML><p>Quantidade de requests: ' + sess.views + '</p> </HTML>');
});


//Tratamento de erro, codigo HTTP 500
app.use(function(err, req, res, next) {
  console.error(err.stack);
  res.status(500).send('<HTML> ' + (err.msg || 'Deu problema ao processar a requisição') + ' </HTML>');
});

//Tratamento de erro, codigo HTTP 404
app.use(function(req, res) {
  res.status(404);
  res.send('<HTML> Recurso não encontrado </HTML>');
});


var forbidden = function(res) { 
  res.status(401)
  res.header("WWW-Authenticate", "Basic")

  res.send()
}

var decode = function(encoded) {
  return new Buffer(encoded, 'base64').toString('utf8');
} 

//Logando request
var logRequest = function(req) {
  console.log('---');
  console.log('Caminho:', req.path);
  console.log('Metodo:', req.method);
  var session = req.session
  if (session.views) {
    session.views++
  } else {
    session.views = 1
  }
}

var server = app.listen(3000, function () {
  console.log('Aplicacao rodando http://localhost:%s', server.address().port);

});