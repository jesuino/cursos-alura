porco1 = [1, 1, 0]
porco2 = [1, 1, 0]
porco3 = [1, 1, 0]

cachorro4 = [1, 1, 1]
cachorro5 = [0, 1, 1]
cachorro6 = [0, 1, 1]

dados = [porco1, porco2, porco3,
	cachorro4, cachorro5, cachorro6]

marcacoes = [1,1,1,-1,-1,-1]

from sklearn.naive_bayes import MultinomialNB

algoritmo = MultinomialNB()
algoritmo.fit(dados, marcacoes)

teste = [
	[1,0,0],
	[0,0,0],
	[1,1,1]
]
marcacoes_teste = [1, -1, 1]
resultado = algoritmo.predict(teste)
diferenca = resultado - marcacoes_teste
total_acertos = len([ a for a in diferenca if a == 0])
total_testes = len(teste)
taxa_acertos = 100.0 * (total_acertos / float(total_testes))
print resultado 
print "Total de acertos: ", taxa_acertos
