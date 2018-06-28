/*************************************************************************\
 * Nome: Aplicação.h                                                     *
 * Versão: 1.0                                                           *
 * Data: Setembro de 2003                                                *
 * Autor: Marcos Perez Mokarzel                                          *
 * Função: Declaração de variáveis e constantes da camada aplicação.     *
 * Histórico:                                                            *
\*************************************************************************/


//Estados da transmissão da página.
#define APP_TX_INICIO 0x00
#define APP_TX_TEMP   0x01
#define APP_TX_DELAY  0x02
#define APP_TX_SYS    0x03
#define APP_FIM_PAG   0x04

//Tempos do comando PING.
#define APP_PING_INTERVALO  30000
#define APP_PING_DELAY_MAX  3000


//Definição das contantes.
extern const char pszInicio[];
extern const char pszFim[];

