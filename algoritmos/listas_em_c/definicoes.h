 #define INICIO 1
 #define MAXTAM 1000 

 typedef int TChave;
 typedef int TApontador;

 typedef struct {
	 TChave Chave;
 } TItem;

typedef struct {
	TItem Item[MAXTAM];
	TApontador Primeiro, Ultimo;
} TLista;

void TLista_Inicia(TLista *pLista);
int TLista_EhVazia(TLista *pLista);
int TLista_Insere(TLista *pLista, TItem x);
int TLista_Retira(TLista *pLista, TApontador p, TItem *pX);
void TLista_Imprime(TLista *pLista);