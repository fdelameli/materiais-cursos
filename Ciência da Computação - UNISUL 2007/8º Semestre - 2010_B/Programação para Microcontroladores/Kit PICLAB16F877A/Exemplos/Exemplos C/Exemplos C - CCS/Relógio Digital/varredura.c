/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  		  	       Programação em C - Módulo B PIC16F877A            	   *
 *                                Exemplo 2                                *
 *                                                                         *
 *                CENTRO DE TREINAMENTO - Cerne Tecnologia	               *
 *                        www.cerne-tec.com.br                             *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *   VERSÃO : 1.0                                                          *
 *   DATA : 16/05/2005                                                     *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                             Descrição geral                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
// Implementar a varredura de 4 displays para se montar um relógio digital

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                		 	Definição de Cabeçalho						 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#include	<16F877A.h>				//microcontrolador utilizado


/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                         Configurações para gravação                   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#fuses xt,nolvp,nowdt,nolvp,nobrownout,put,nodebug,noprotect,nowrt,nocpd
 								   // Configurações da Máquina
                                   // Oscilador: XT
                                   // LVP: Off
                                   // WDT: On
                                   // Brown-out: Off
                                   // Power-up: Off
                                   // Debug: Off
                                   // CP: Off
                                   // CPD: Off


/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                 Definição e inicialização das variáveis               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos definir as variáveis globais do sistema

int unidade=0,centena=0,dezena=0,milhar=0,indice=0;
int vezes_tmr1=120;
boolean pisca=0;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                           Constantes internas                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos definir as constantes utilizadas pelo sistema

#define CHR_0  	0b00111111
#define CHR_1  	0b00000110
#define CHR_2  	0b01011011
#define CHR_3  	0b01001111
#define CHR_4  	0b01100110
#define CHR_5  	0b01101101
#define CHR_6  	0b01111101
#define CHR_7  	0b00000111
#define CHR_8  	0b01111111
#define CHR_9  	0b01101111
#define CHR_A  	0b01110111
#define CHR_B  	0b01111100
#define CHR_C  	0b00111001
#define CHR_D  	0b01011110
#define CHR_E  	0b01111001
#define CHR_F  	0b01110001

const int converte_to_7seg[]={CHR_0,CHR_1,CHR_2,CHR_3,CHR_4,CHR_5,CHR_6,
                              CHR_7,CHR_9,CHR_A,CHR_B,CHR_C,CHR_D,CHR_E,CHR_F};
                                    //Caracteres para o displayt de 7 segmentos

#define BASE_TEMPO  (65536-62500)   //	Base de tempo para timer

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                Saídas                               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos definir as saídas do sistema

#define SEL_UNIDADE   PIN_B4        // Define pino para seleção de display
#define SEL_DEZENA    PIN_B3        // Define pino para seleção de display
#define SEL_CENTENA   PIN_B2        // Define pino para seleção de display
#define SEL_MILHAR    PIN_B1        // Define pino para seleção de display
#define PINO_PISCA    PIN_D7        // Define pino para piscar o ponto

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                       Prototipagem das funções                      *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos declarar todas as funções definidas pelo usuário

void Inicializa(void);

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                           Rotina Principal                		   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Nessa parte ficará o loop principal do sistema

void main(void)
{
   Inicializa();                    // Chama rotina para inicializar a máquina
   while(1)
      {
       restart_wdt();               // Entra em loop infinito e limpa o wdt
      }
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                       Inicialização do Sistema                 	   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Inicializa(void)
{

   setup_wdt(WDT_2304MS);         	// Configura WDT para 2,304 s

   set_timer0(0);                 	// Inicializa timer 0 com 0
   setup_timer_0(RTCC_INTERNAL | RTCC_DIV_1);
         									// Timer configurado para clock
                                    // Interno com prescaler de 1:4

   set_timer1(BASE_TEMPO);        	// Inicializa timer 1
   setup_timer_1(T1_INTERNAL | T1_DIV_BY_8);
         									// Timer configurado para clock
                                    // Interno com prescaler de 1:8

   enable_interrupts(INT_TIMER0);   // Habilita interrupção de timer 0
   enable_interrupts(INT_TIMER1);   // Habilita interrupção de timer 1
   enable_interrupts(GLOBAL);       // Habilita todas as interrupções
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                  Tratamento da Interrupção de Timer 1               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#int_timer1
void Isr_Timer1(void)
{

   set_timer1(BASE_TEMPO);          // Recarrega timer 1
   pisca=!pisca;                    // Inverte o estado do pisca
   vezes_tmr1--;                    // Decrementa variável
      if (vezes_tmr1) return;       // Verifica se variável chegou a zero
   vezes_tmr1=120;                  // Recarrega variável

   unidade++;                       // Incrementa unidade
      if (unidade!=10) return;      // Verifica se variável chegou a 10
   unidade=0;                       // Zera a variável

   dezena++;                        // Incrementa dezena
      if (dezena!=6) return;        // Verifica se variável chegou a 6
   dezena=0;                        // Zera a variável

   centena++;                       // Incrementa a variável

   if (milhar==2)                   // Verifica se milhar vale 2
    {
      if (centena==4)               // Verifica se centena chegou a 4
         {
            milhar=0;               // Zera variável
            centena=0;              // Zera variável
            return;                 // Zera variável
         }
    }

      if (centena!=10) return;      // Verifica se variável chegou a 10
   centena=0;                       // Limpa a variável
   milhar++;                        // Limpa a variável
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                  Tratamento da Interrupção de Timer 0               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#int_timer0
void Isr_Timer0(void)
{

   set_timer0(62000);
   indice++;                        // Incrementa indice

   switch(indice)                   // Seleção de casos com indice
      {

         case 1:                    // Caso seja 1...
            output_low(SEL_UNIDADE);// Retira a seleção do display anterior
            output_d(converte_to_7seg[milhar]);
            output_high(SEL_MILHAR);// Mostra o dado no barramento
            break;					   // Liga display selecionado

         case 2:                     // Caso seja 2...
            output_low(SEL_MILHAR);  // Retira a seleção do display anterior
            output_d(Converte_to_7seg[centena]);
            output_high(SEL_CENTENA);// Mostra o dado no barramento
	           								 // Liga display selecionado
		    if (pisca) output_high(PINO_PISCA);
            break;

         case 3:                     // Caso seja 3...
            output_low(SEL_CENTENA); // Retira a seleção do display anterior
            output_d(Converte_to_7seg[dezena]);
            output_high(SEL_DEZENA); // Mostra o dado no barramento
            break;					 // Liga display selecionado

         case 4:                     // Caso seja 4...
            indice=0;                // Reinicia indice
            output_low(SEL_DEZENA);  // Retira a seleção do display anterior
            output_d(Converte_to_7seg[unidade]);
            output_high(SEL_UNIDADE);// Mostra o dado no barramento
            break;					    // Liga display selecionado
      }
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                  		Fim do Programa              			   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
