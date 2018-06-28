/*************************************************************************\
 * Nome: Trsp.h                                                          *
 * Versão: 1.0                                                           *
 * Data: Setembro de 2003                                                *
 * Autor: Marcos Perez Mokarzel                                          *
 * Função: Declarações de funções e variáveis da camada Transporte.      *
 * Histórico:                                                            *
\*************************************************************************/


//Funções publicas da classe transporte.
void Trsp_Init(void);
void Trsp_Loop(void);
void Trsp_Relogio(void);
void TCP_Trata(t_IPData *ptBuf);
BOOLEAN TCP_Conecta(_IN_ WORD wPrtLocal,   _IN_ WORD wPrtRemota, 
                    _IN_ WORD *pwIPRemoto, _OUT_ BYTE *pbSkt);
BYTE TCP_Estado(_IN_ BYTE bSkt);
BOOLEAN TCP_Envia(BYTE bSkt, WORD *pwBuf, WORD wTam);
void TCP_BufEnviado(_IN_ WORD wPrtOrigem, _IN_ WORD wPrtDestino, 
                    _IN_ WORD *pwIPDestino);
void TCP_Desconecta(BYTE bSkt);

//Estruturas de controle da classe Transporte.
typedef struct
{
  WORD  wPrtLocal;    //Porta de comunicação da origem.
  WORD  wPrtRemota;   //Porta de comunicação do destino.
  WORD  pwIPRemoto[2];//IP dono do socket.
  BYTE  bEstado;      //Estado do socket.
  BYTE  bTempo;       //Tempo de vida do socket.
  
  DWORD dwSeqTx;      //Contagem de bytes transmitidos.
  WORD  *pwBufTx;     //Aponta o buffer que deve ser transmitido.
  WORD  wTamBufTx;    //Número de bytes que deve ser transmitido.
  WORD  wPtrBufTx;    //Aponta para o inicio da próxima porção a ser tx.
  WORD  wWin;         //Tamanho máximo da janela de comunicação.
  
  DWORD dwSeqRx;      //Contagem de bytes recebidos.
} t_Skt;              //Controle de Socket.


//Portas abertas para comunicação TCP/IP.
extern const WORD TCP_PrtAberta[];
extern t_Skt ptSkt[TOTAL_SKT];



