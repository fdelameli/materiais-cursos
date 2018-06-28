/*************************************************************************\
 * Nome: Rede.h                                                          *
 * Versão: 1.0                                                           *
 * Data: Setembro de 2003                                                *
 * Autor: Marcos Perez Mokarzel                                          *
 * Função: Declarações de funções e variáveis da camada Rede.            *
 * Histórico:                                                            *
\*************************************************************************/

#include "CS8900A.h"

// Declaração das funções Publicas da classe Rede.
void Rede_Init(void);     //Construtor da classe Rede, inicializa camada
                          // Rede do protocolo TCP/IP.
void Rede_Relogio(void);  //Interrupção de relógio que ocorre a cada 20ms.
void Rede_Loop(void);     //Loop infinito para rodar rotinas periódicas.
void Rede_Envia(_IN_ WORD *pwBuf,   _IN_ WORD wTam,   //Envia buffer via
                _IN_ WORD *pwCont,  _IN_ WORD wTamCont, // Ethernet.
                _IN_ WORD *pwIPDest, _IN_ WORD wTipo, _IN_ BYTE bId);

//Definição de tipos da classe rede.
typedef struct
{
  WORD  *pwBuf;         //Aponta para o buffer que deve ser transmitido.
  WORD  wTam;           //Número de bytes que devem ser transmitido.
  WORD  *pwCont;        //Continuação do Buffer.
  WORD  wTamCont;       //Número de bytes da continuação.
  WORD  wTipo;          //Tipo de frame que será transmitido.
  WORD  pwIPDestino[2]; //IP de destino do pacote.
  BYTE  bFlag;          //Flags de transmissão.
  BYTE  bId;            //Identificador do buffer dentro da camada.
  BYTE  bTempoVida;     //Conta tempo para que este buffer seja liberado.
} t_Rede_TxControl;


//Declaração das variáveis publicas da camada Rede.
extern const WORD pwMeuMAC[];


