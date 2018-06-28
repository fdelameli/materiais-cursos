/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  			   Programa��o em C - M�dulo B PIC16F877A            	   *
 *                               Exemplo 5                                 *
 *                                                                         *
 *                CENTRO DE TREINAMENTO - Cerne Tecnologia	               *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *   VERS�O : 1.0                                                          *
 *   DATA : 16/05/2005                                                     *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                             Descri��o geral                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
// Apresentar a utiliza��o do A/D interno do PIC

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                		 	Defini��o de Cabe�alho						 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#include	<16F877A.h>				//microcontrolador utilizado

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                         Configura��es para grava��o                   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#fuses xt,nolvp,nowdt,nolvp,nobrownout,put,nodebug,noprotect,nowrt,nocpd
 								   // Configura��es da M�quina
                                   // Oscilador: XT
                                   // LVP: Off
                                   // WDT: On
                                   // Brown-out: Off
                                   // Power-up: Off
                                   // Debug: Off
                                   // CP: Off
                                   // CPD: Off

#use delay(clock=4000000)          // Define o clock do sistema

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                 Defini��o e inicializa��o das vari�veis               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos definir as vari�veis globais do sistema

int byte_leds=0;

#bit led1	= byte_leds.0
#bit led2	= byte_leds.1
#bit led3	= byte_leds.2
#bit led4	= byte_leds.3
#bit led5	= byte_leds.4
#bit led6	= byte_leds.5
#bit led7	= byte_leds.6
#bit led8	= byte_leds.7

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                           Constantes internas                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos definir as constantes utilizadas pelo sistema

#define LIMITE_1	(256/8)*1-1
#define LIMITE_2	(256/8)*2-1
#define LIMITE_3	(256/8)*3-1
#define LIMITE_4	(256/8)*4-1
#define LIMITE_5	(256/8)*5-1
#define LIMITE_6	(256/8)*6-1
#define LIMITE_7	(256/8)*7-1
#define LIMITE_8	(256/8)*8-1

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                Sa�das                               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos definir as sa�das do sistema

#define  RS			  PIN_E2		// Pino de sele��o de modo do display
#define  EN			  PIN_E1		// Pino de habilita��o do display
#define  SEL_LEDS  	  PIN_B5		// Pino de sele��o de leds

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                       Prototipagem das fun��es                      *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos declarar todas as fun��es definidas pelo usu�rio

void Inicializa(void);
void Atualiza_tela(long dado);
void Lcd_Inst(char dado);
void Lcd_Dado(char dado);

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                           Rotina Principal                		   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Nessa parte ficar� o loop principal do sistema

void main (void)
{
   float tensao;
	Inicializa();			       	// Chama rotina para inicializar o sistema

	while(1)			      		   // Entra em loop infinito
		{
			restart_wdt();		      // Limpa o wdt
		  	Lcd_Inst(0x81);		   // Posiciona cursor no display
         printf(lcd_dado,"Valor A/D %3u",read_adc());

         Lcd_Inst(0xC1);			// Posiciona cursor no display

         tensao= read_adc();
         tensao*=0.01953125;
         printf(lcd_dado,"Tensao %1.3f V", tensao);


	      if (read_adc()>=LIMITE_1) led1=1;
         else                      led1=0;

      	if (read_adc()>=LIMITE_2) led2=1;
         else                      led2=0;

      	if (read_adc()>=LIMITE_3) led3=1;
         else                      led3=0;

      	if (read_adc()>=LIMITE_4) led4=1;
         else                      led4=0;

       	if (read_adc()>=LIMITE_5) led5=1;
         else                      led5=0;

      	if (read_adc()>=LIMITE_6) led6=1;
         else                      led6=0;

      	if (read_adc()>=LIMITE_7) led7=1;
         else                      led7=0;

      	if (read_adc()>=LIMITE_8) led8=1;
         else                      led8=0;

         output_d(byte_leds);
      	delay_ms(100);

		}
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                       Inicializa��o do Sistema                 	   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Inicializa(void)
{
   
   output_low(pin_b7);
   output_low(pin_b6);                 //Deixa as linhas de grava��o em n�vel baixo
   
   delay_ms(2000);

   setup_adc(ADC_CLOCK_DIV_8);  		 // Configura clock da convers�o
   setup_adc_ports(RA0_RA1_RA3_ANALOG);  // Configura A/D
   set_adc_channel(0);					 // L� a entrada 0

   setup_wdt(WDT_2304MS);		         // Configura WDT para 2,304 s

   Lcd_Inst(0x30);			    		 // Inicializa o display
   delay_ms(3);
   Lcd_Inst(0x30);
   Lcd_Inst(0x30);
   Lcd_Inst(0x38);
   Lcd_Inst(0x01);
   delay_ms(1);
   Lcd_Inst(0x0C);
   Lcd_Inst(0x06);
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                   Rotina para enviar comandos para o LCD			   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Lcd_Inst(char dado)
{
	disable_interrupts(GLOBAL);		// Desliga as interrup��es
	output_low(SEL_LEDS);
	output_low(RS);					// P�e pino de RS em baixo, modo comando
	output_d(dado);					// P�e o dado no portd
	delay_cycles(2);				// Aguarda 2 us, acomoda��o
	output_high(EN);				// Gera pulso de clock
	delay_cycles(2);
	output_low(EN);
	output_d(byte_leds);
	output_high(SEL_LEDS);
	delay_ms(1);					// Aguarda 1ms
	enable_interrupts(GLOBAL);		// Liga as interrup��es
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                   Rotina para enviar  dados para o LCD			   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Lcd_Dado(char dado)
{
	disable_interrupts(GLOBAL);		// Desliga as interrup��es
	output_low(SEL_LEDS);
	output_high(RS);				// Seta o pino RS, modo dado
	output_d(dado);					// P�e o dado no portd
	delay_cycles(2);				// Aguarda 2us, acomoda��o
	output_high(EN);				// Gera pulso de clock
	delay_cycles(2);
	output_low(EN);
	output_d(byte_leds);
	output_high(SEL_LEDS);
	delay_ms(1);					// Aguarda 1ms
	enable_interrupts(GLOBAL);		// Liga as interrup��es
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *    		                  Fim do programa						   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
