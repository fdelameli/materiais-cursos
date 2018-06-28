/*************************************************************************\
 * Nome: IP.h                                                            *
 * Versão: 1.0                                                           *
 * Data: Setembro de 2003                                                *
 * Autor: Marcos Perez Mokarzel                                          *
 * Função: Declarações de funções e variáveis da camada IP.              *
 * Histórico:                                                            *
\*************************************************************************/

// Declaração das funções Publicas da classe IP.
void IP_Init(void);        //Construtor da classe IP, inicializa camada IP.
void IP_Trata(_IN_ t_IPData *ptBuf);//Trata pacote IP vindo da camada rede.
void IP_BufEnviado(_IN_ BYTE bId);//Libera buffer que acaba de ser enviado.
void IP_Ping(_IN_ WORD *pwIPAlvo, _IN_ WORD wNumSeq); //Evia um comando de
                                                      // ECHO p/ IP alvo.
BOOLEAN IP_Envia(_IN_ WORD *pwIPDestino, _IN_ BYTE bProt,   //Envia pacote
                 _IN_ void *pvCab,       _IN_ WORD wTamCab, // usando IP.
                 _IN_ WORD *pwData,      _IN_ WORD wTamData);


//Declaração das variáveis publicas da camada IP.
extern const WORD pwMeuIP[];
extern const WORD pwMasc[];
extern const WORD pwGateway[];
