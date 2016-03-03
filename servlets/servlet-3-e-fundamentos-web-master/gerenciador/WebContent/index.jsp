<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	Bem vindo ao nosso gerenciador de empresas!
	<br />
<c:if test="${not empty usuarioLogado}">
    Você está logado como ${usuarioLogado.email}<br/>
</c:if>
	<form action="controller?alvo=NovaEmpresa" method="POST">
		Nome: <input type="text" name="nome" /><br /> <input type="submit"
			value="Enviar" />
	</form>

<c:if test="${empty usuarioLogado}">
	<form action="controller?alvo=Login" method="post">
		Email: <input type="text" name="email" /><br /> Senha: <input
			type="password" name="senha" /><br /> <input type="submit"
			value="Login" />
	</form>
</c:if>
<c:if test="${not empty usuarioLogado}">
	<form action="controller?alvo=Logout" method="POST">
		<input type="submit" value="Logout" />
	</form>
</c:if>
</body>
</html>