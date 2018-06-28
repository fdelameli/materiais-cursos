/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *        	 Programa��o em C para o microcontrolador PIC16F877A           *
 *                               Exemplo 7                                 *
 *                                                                         *
 *                CENTRO DE TREINAMENTO - Cerne Tecnologia	               *
 *                         www.cerne-tec.com.br                            *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *   VERS�O : 1.0                                                          *
 *   DATA : 16/05/2005                                                     *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                             Descri��o geral                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
// Receber via RS232 dois par�metros e aplicar nestes as quatro
// opera��es b�sicas e retornando com o dado para o PC com a conta efetuada

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                		 	Defini��o de Cabe�alho						 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#include	<16F877A.h>				//microcontrolador utilizado

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                         Configura��es para grava��o                   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#fuses xt,nolvp,nowdt,nolvp,nobrownout,put,nodebug,noprotect,nowrt,nocpd
         								  // Configura��es da M�quina
                                   // Oscilador: XT, LVP: Off, WDT: On, Brown-out: Off
                                   // Power-up: Off, Debug: Off, CP: Off
                                   // CPD: Off

#use delay(clock=4000000)          // Define o clock do sistema
#use rs232(baud=9600,xmit=pin_c6,rcv=pin_c7)
         						        // Configura Usart

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                 Defini��o e inicializa��o das vari�veis               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos definir as vari�veis globais do sistema

long parametro1,parametro2;
int1 pode_converter;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                Sa�das                               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos definir as sa�das do sistema

#define  RS			  PIN_E2		// Pino de sele��o de modo do display
#define  EN			  PIN_E1		// Pino de habilita��o do display

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                       Prototipagem das fun��es                      *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos declarar todas as fun��es definidas pelo usu�rio

void Inicializa(void);				// Prototipagem da procedure
void Tela_Inicial(void);			// Prototipagem da procedure
void Lcd_Inst(char dado);		  	// Prototipagem da procedure
void Lcd_Dado(char dado);			// Prototipagem da procedure
void Soma(void);	    				// Prototipagem da procedure
void Subtrai(void);					// Prototipagem da procedure
void Multiplica(void);				// Prototipagem da procedure
void Divide(void);					// Prototipagem da procedure

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                           Rotina Principal                		   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Nessa parte ficar� o loop principal do sistema

void main (void)
{
	Inicializa();				// Chama rotina para inicializar o sistema

	while(1)				     	// Entra em loop infinito
		{
			restart_wdt();
			if (pode_converter)
			{
				pode_converter=0;
				Soma();
				Subtrai();
				Multiplica();
				Divide();
			}
		}
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                       Inicializa��o do Sistema                 	   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Inicializa(void)
{

   delay_ms(2000);

   setup_adc_ports(no_analogs);    // Todos os AD�s desligados
   setup_wdt(WDT_2304MS);          // Configura WDT para 2,304 s
   enable_interrupts(INT_RDA);     // Habilita interrup��o de timer 0
   enable_interrupts(GLOBAL);      // Habilita todas as interrup��es

   Lcd_Inst(0x30);			        // Inicializa o display
   delay_ms(3);
   Lcd_Inst(0x30);
   Lcd_Inst(0x30);
   Lcd_Inst(0x38);
   Lcd_Inst(0x01);
   delay_ms(1);
   Lcd_Inst(0x0C);
   Lcd_Inst(0x06);
   Tela_Inicial();
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *               Rotina de Tratamento de Interrup��o Serial			   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#int_rda
void Isr_Serial(void)
{
	parametro1=getc();
	while(!kbhit());
	parametro2=getc();
	pode_converter=1;
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *     		           Rotina para Somar dois valores				   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Soma(void)
{
	long int soma;
	soma=parametro1+parametro2;
	Lcd_Inst(0x82);
   printf(lcd_dado,"%4lu",soma);
   printf("A soma e %4lu \n \r",soma);
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *     		           Rotina para Subtrair dois valores			   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Subtrai(void)
{
	long int subtrai;
	if (parametro2>parametro1)
		{puts("000");
       return;}

	subtrai=parametro1-parametro2;
	Lcd_Inst(0x8B);
   printf(lcd_dado,"%4lu",subtrai);
   printf("A subtracao e %4lu \n \r",subtrai);
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  	              Rotina para Multiplicar dois valores			   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Multiplica(void)
{
	long int multiplica;
	multiplica=parametro1*parametro2;

   Lcd_Inst(0xC2);
   printf(lcd_dado,"%5lu",multiplica);
   printf("A multiplicacao e %5lu \n \r",multiplica);

}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *     		           Rotina para Dividir dois valores				   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Divide(void)
{
	long int divide;
	divide=parametro1/parametro2;
   Lcd_Inst(0xCB);
   printf(lcd_dado,"%3lu",divide);
   printf("A divisao e %3lu \n \r",divide);
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *              Rotina para Apresentar a tela Inicial do Sistema       *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Tela_Inicial(void)
{
	Lcd_Inst(0x80);			     // Atualiza a tela do LCD
   printf(lcd_dado,"+:0000   -:000 ");
	Lcd_Inst(0xC0);			     // Atualiza a tela do LCD
   printf(lcd_dado,"*:00000  /:000 ");
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                Rotina de Envio de Instru��o para o LCD			   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Lcd_Inst(char dado)
{
	disable_interrupts(GLOBAL);	// Desliga as interrup��es
	output_low(RS);					// P�e pino de RS em baixo, modo comando
	output_d(dado);					// P�e o dado no portd
	delay_cycles(2);		     		// Aguarda 2 us, acomoda��o
	output_high(EN);	   			// Gera pulso de clock
	delay_cycles(2);
	output_low(EN);
	delay_ms(1);		   			// Aguarda 1ms
	enable_interrupts(GLOBAL);		// Liga as interrup��es
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                  Rotina de Envio de Dados para o LCD			       *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Lcd_Dado(char dado)
{
	disable_interrupts(GLOBAL);	// Desliga as interrup��es
	output_high(RS);		     		// Seta o pino RS, modo dado
	output_d(dado);					// P�e o dado no portd
	delay_cycles(2);	   			// Aguarda 2us, acomoda��o
	output_high(EN);    				// Gera pulso de clock
	delay_cycles(2);
	output_low(EN);
	delay_ms(1);				    	// Aguarda 1ms
	enable_interrupts(GLOBAL);		// Liga as interrup��es
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *      	                  Fim do Programa						   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
