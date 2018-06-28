/*************************************************************************\
 * Nome: Aplicação.c                                                     *
 * Versão: 1.0                                                           *
 * Data: Setembro de 2003                                                *
 * Autor: Marcos Perez Mokarzel                                          *
 * Função: Aplicação para teste das APIs criadas para comunicação TCP/IP.*
 * Histórico:                                                            *	
\*************************************************************************/

#include "..\IE_API\Diretivas.h"
#include "..\IE_API\Bios.h"
#include "..\IE_API\Rede.h"
#include "..\IE_API\IP.h"
#include "..\IE_API\Trsp.h"
#include "aplicação.h"
#include "stdio.h"
#include "string.h"


//Declaração das constantes da camada aplicação.
WORD pbBuf[116];
char getPagina();
WORD wNumPing;
WORD wContaDelay;
WORD wDelay;
WORD wtTempoPing;

//Declaração das variáveis privadas da camada aplicação.
BYTE  pbEstPag[TOTAL_SKT];    //Controla o estado de transmissão da página.

struct
{
  WORD wDia;
  BYTE bHor;
  BYTE bMin;
  BYTE bSeg;
  WORD wMseg;
} tTempo;

WORD wNumAcesso;

WORD pwIPTeste[2];
  
//Declaração de funções privadas da camada Aplicação.
void App_Init(void);



///////////////////////////////////////////////////////////////////////////
// main
// Função principal.
// Parâmetros: Void
// Retorno: void
///////////////////////////////////////////////////////////////////////////
void main(void)
{
	
  Bios_Init();                //Iniciailiza Bios (interfaces físicas).
  Rede_Init();                //Inicializa camada Rede.
  IP_Init();                  //Inicializa camada IP.
  Trsp_Init();                //Inicializa camada transporte.
  App_Init();                 //Inicializa camada Aplicação.
  

  while(1)                    //Entra em loop infinito.
  {
	
    if(!wtTempoPing)
    {
      wNumPing ++;                  //Soma 1 no contador de seq de ping.
      IP_Ping(pwIPTeste, wNumPing); //Comando o Ping.
      wContaDelay = 0;              //Reseta o contador de tempo de delay.
      wtTempoPing = APP_PING_INTERVALO;
    }

    Rede_Loop();
    Trsp_Loop();
  }

}


///////////////////////////////////////////////////////////////////////////
// App_Init
// Inicializa camada aplicação.
// Parâmetros:  void
// Retorno: void
///////////////////////////////////////////////////////////////////////////

void App_Init(void)
{
  pwIPTeste[0] = 0xC8DD;
  pwIPTeste[1] = 0x0233;

  wtTempoPing = APP_PING_INTERVALO;
  wContaDelay = APP_PING_DELAY_MAX + 1;
  wDelay = 1;
  
  tTempo.wDia = 0;
  tTempo.bHor = 0;
  tTempo.bMin = 0;
  tTempo.bSeg = 0;
  tTempo.wMseg = 0;
  
  wNumAcesso = 0;
}



///////////////////////////////////////////////////////////////////////////
// App_Trata
// Trata pacote enviado pela camada TCP.
// Parâmetros:  wPrtLocal - Porta local desta conexão.
//              bSkt  - Número dado ao socket que gerencia esta conexão.
//              pbBuf - Ponteiro para o buffer onde estão os dados.
//              wTam  - Número de bytes no buffer.
// Retorno: void
///////////////////////////////////////////////////////////////////////////
void App_Trata(_IN_ WORD wPrtLocal, _IN_ BYTE bSkt,
               _IN_ BYTE *pbBuf, _IN_ WORD wTam)
{
  if((pbBuf[1] == 'G') && (pbBuf[0] == 'E') && 
     (pbBuf[3] == 'T') && (pbBuf[2] == ' '))
  {
    pbEstPag[bSkt] = APP_TX_TEMP;
    TCP_Envia(bSkt, (WORD*)pszInicio, strlen(pszInicio));
  }
}


///////////////////////////////////////////////////////////////////////////
// App_TrataPing
// Trata resposta de ping.
// Parâmetros:  pwIPAlvo  - IP que respondeu o ping.
//              wSeqAlvo  - Número sequencial do ping respondido.
//              Enviado   - Identifica se é para tratar o envio 
//                          ou o recebimento da resposta do domando Ping.
// Retorno: void
///////////////////////////////////////////////////////////////////////////
void App_TrataPing(WORD *pwIPAlvo, WORD wSeqAlvo, BOOLEAN Enviado)
{
  if(wSeqAlvo == wNumPing)//Se e resposta do ping atual.
  {
    if(Enviado)
      wContaDelay = 0;    //Reinicia o contador de tempo para a resposta.
    else
    {
      wDelay = wContaDelay; //Armazena o delay.
      wContaDelay = APP_PING_DELAY_MAX + 1; //Para a contagem de tempo.
    }
  }
}


///////////////////////////////////////////////////////////////////////////
// App_BufEnviado
// Libera o buffer que acaba de ser enviado.
// Parâmetros:  bId     - Identificador do buffer dentro da camada.
// Retorno: void
///////////////////////////////////////////////////////////////////////////
void App_BufEnviado(_IN_ BYTE bSkt)
{
  WORD wVal;
  WORD wMin, wMax;
    
  
}
///////////////////////////////////////////////////////////////////////////
// App_Relogio
// Interrupção de relógio que ocorre a cada 1mS.
// Parâmetros:  void
// Retorno: void
///////////////////////////////////////////////////////////////////////////
void App_Relogio(void)
{
  if(wContaDelay <= APP_PING_DELAY_MAX) //Se deve contar tempo do ping.
    wContaDelay++;                      //Conta tempo.

  if(wContaDelay == APP_PING_DELAY_MAX) //Se passou de 3 segundos
  {
    wDelay = 0xFFFF;              //Assinala pacote perdido.
    wNumPing ++;                  //Não aceita mais resposta de ping.
  }
  
  if(wtTempoPing)                 //Conta tempo para o próximo ping.
    wtTempoPing --;
    
  //Atualiza relógito de tempo no ar.
  tTempo.wMseg++;
  if(tTempo.wMseg == 1000)        //Se passou 1 segundo.
  {
    tTempo.wMseg = 0;
    tTempo.bSeg++;
    if(tTempo.bSeg == 60)         //Se passou 1 minuto.
    {
      tTempo.bSeg = 0;
      tTempo.bMin++;
      if(tTempo.bMin == 60)       //Se passou 1 hora.
      {
        tTempo.bMin = 0;
        tTempo.bHor++;
        if(tTempo.bHor == 24)     //Se passou 1 dia.
        {
          tTempo.bHor = 0;
          tTempo.wDia++;
        }
      }
    }
  }
}




