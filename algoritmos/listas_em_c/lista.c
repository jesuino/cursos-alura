#include <stdio.h>
#include <stdlib.h>
#include "definicoes.h"

int main() {
	TLista *pLista, lista;
	int n = 10, i;
	TItem itens[n];
	pLista = &lista;

	TLista_Inicia(pLista);
	if (TLista_EhVazia(pLista)) {
		printf("Lista eh Vazia!\n");
	}

	for (i = 0; i < n; i++) {
		itens[i].Chave = random() % n;
		TLista_Insere(pLista, itens[i]);
	}

	TLista_Imprime(pLista);

	TApontador apontador = 1;

	TLista_Retira(pLista, apontador, &itens[0]);

	TLista_Imprime(pLista);

	printf("Hello World!\n");
	return 0;
}

void TLista_Inicia(TLista *pLista) {
	pLista->Primeiro = INICIO;
	pLista->Ultimo = pLista->Primeiro;
}

int TLista_EhVazia(TLista *pLista) {
	return pLista->Primeiro == pLista->Ultimo;
}

int TLista_Insere(TLista *pLista, TItem x) {
	if (pLista->Ultimo > MAXTAM) {
		return 0;
	}

	pLista->Item[pLista->Ultimo -1] = x;
	pLista->Ultimo++;
	return 1;
}

int TLista_Retira(TLista *pLista, TApontador p, TItem *pX) {
	TApontador q;
	if (TLista_EhVazia(pLista) || 
			p <  pLista->Primeiro  ||
			p >= pLista->Ultimo) {
				return 0;
	}

	*pX = pLista->Item[p-1];
	pLista->Ultimo--;

	for (q = p; q < pLista->Ultimo; q++) {
		pLista->Item[q -1] = pLista->Item[q];
	}
	return 1;
}

void TLista_Imprime(TLista *pLista) {
	TApontador p;
	if (! TLista_EhVazia(pLista)) {
		for (p = pLista->Primeiro - 1; p < pLista->Ultimo -1; p++) {
			printf("\"%d\", ", pLista->Item[p].Chave);
		}
		printf("\b\b  \n");
	}

}