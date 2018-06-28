/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *     			   Programação em C - Módulo B PIC16F877A            	      *
 *                               Exemplo 4                                 *
 *                                                                         *
 *                CENTRO DE TREINAMENTO - Cerne Tecnologia	               *
 *                          www.cerne-tec.com.br                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *   VERSÃO : 1.0                                                          *
 *   DATA : 16/05/2005                                                     *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                             Descrição geral                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
// Apresentar a tecla pressionada no display LCD

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                		 	Definição de Cabeçalho						 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#include	<16f877a.h>				//microcontrolador utilizado

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

#use delay(clock=4000000)          // Define o clock do sistema

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                 Definição e inicialização das variáveis               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos definir as variáveis globais do sistema

int1 tecla0=0, tecla1=0, tecla2=0, tecla3=0, tecla4=0, tecla5=0, tecla6=0, tecla7=0,
     tecla8=0, tecla9=0, teclaA=0, teclaB=0, teclaC=0, teclaD=0, teclaE=0;
     
int indice=0;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                           Constantes internas                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos definir as constantes utilizadas pelo sistema

#define SEL_LINHA1	0b00001110
#define SEL_LINHA2	0b00001101
#define SEL_LINHA3	0b00001011
#define SEL_LINHA4	0b00000111

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                Entradas                               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos definir as entradas do sistema

#define  COL1	       PIN_A4
#define  COL2	       PIN_A5
#define  COL3         PIN_E0

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                Saídas                               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos definir as saídas do sistema

#define  RS			  PIN_E2		// Pino de seleção de modo do display
#define  EN			  PIN_E1    // Pino de habilitação do display

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                       Prototipagem das funções                      *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos declarar todas as funções definidas pelo usuário

void Inicializa(void);
void Atualiza_tela(char dado);
void Lcd_Inst(char dado);
void Lcd_Dado(char dado);

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                           Rotina Principal                		   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Nessa parte ficará o loop principal do sistema

void main (void)
{
 	Inicializa();				// Chama rotina para inicializar o sistema

	while(1)			   		// Entra em loop infinito
		{
			restart_wdt();		// Limpa o wdt

			if (tecla1)	Atualiza_tela('1'); // Atualiza lcd
			if (tecla2) Atualiza_tela('2'); // Atualiza lcd
			if (tecla3) Atualiza_tela('3'); // Atualiza lcd

			if (tecla4) Atualiza_tela('4'); // Atualiza lcd
			if (tecla5) Atualiza_tela('5'); // Atualiza lcd
	 		if (tecla6) Atualiza_tela('6'); // Atualiza lcd

			if (tecla7) Atualiza_tela('7'); // Atualiza lcd
			if (tecla8) Atualiza_tela('8'); // Atualiza lcd
			if (tecla9) Atualiza_tela('9'); // Atualiza lcd

			if (teclaC) Atualiza_tela('C'); // Atualiza lcd
			if (tecla0) Atualiza_tela('0'); // Atualiza lcd
			if (teclaE) Atualiza_tela('E'); // Atualiza lcd


		}
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                       Inicialização do Sistema                 	   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Inicializa(void)
{

   delay_ms(2000);			    	        // Aguarda 2s

   setup_adc(ADC_CLOCK_DIV_8);  	        // Configura clock da conversão
   setup_adc_ports(RA0_RA1_RA3_ANALOG);  // Configura A/D
   set_timer0(0);                        // Inicializa timer 0 com 0
   setup_timer_0(RTCC_INTERNAL | RTCC_DIV_1);
               				    			  // Timer configurado para clock
                                         // Interno com prescaler de 1:4
   setup_wdt(WDT_2304MS);                // Configura WDT para 2,304 s
   enable_interrupts(INT_TIMER0);        // Habilita interrupção de timer 0
   enable_interrupts(GLOBAL);            // Habilita todas as interrupções

   Lcd_Inst(0x30);		                 // Rotina de Inicialização do Display
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
 *                  Tratamento da Interrupção de Timer 0               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#int_timer0
void Ist_Timer0(void)
{
   indice++;                        // Incrementa indice

   switch(indice)                   // Seleção de casos com indice
      {

         case 1:                    // Caso seja 1...
   			output_d(SEL_LINHA1);	// Seleciona no barramento a linha 1
            tecla1=0;			      // Limpa a tecla pressionada
   			tecla2=0;			   	// Limpa a tecla pressionada
   			tecla3=0;				   // Limpa a tecla pressionada
   			if (!input(COL1)) tecla1=1; // Verifica se tecla está pressionada
   			if (!input(COL2)) tecla2=1; // Verifica se tecla está pressionada
   			if (!input(COL3)) tecla3=1; // Verifica se tecla está pressionada
            break;

         case 2:                    // Caso seja 2...
   			output_d(SEL_LINHA2);   // Seleciona no barramento a linha 1
   			tecla4=0;			   	// Limpa a tecla pressionada
   			tecla5=0;		    		// Limpa a tecla pressionada
   			tecla6=0;				   // Limpa a tecla pressionada
   			if (!input(COL1)) tecla4=1; // Verifica se tecla está pressionada
   			if (!input(COL2)) tecla5=1; // Verifica se tecla está pressionada
   			if (!input(COL3)) tecla6=1; // Verifica se tecla está pressionada
            break;

         case 3:                    // Caso seja 3...
   			output_d(SEL_LINHA3);	  // Seleciona no barramento a linha 3
   			tecla7=0;				  // Limpa a tecla pressionada
   			tecla8=0;				  // Limpa a tecla pressionada
   			tecla9=0;				  // Limpa a tecla pressionada
   			if (!input(COL1)) tecla7=1; // Verifica se tecla está pressionada
   			if (!input(COL2)) tecla8=1; // Verifica se tecla está pressionada
   			if (!input(COL3)) tecla9=1; // Verifica se tecla está pressionada
   			break;

         case 4:                    // Caso seja 4...
            indice=0;               // Reinicia indice
   			output_d(SEL_LINHA4);	   // Seleciona no barramento a linha 4
   			teclaC=0;				   // Limpa a tecla pressionada
   			tecla0=0;				   // Limpa a tecla pressionada
   			teclaE=0;				   // Limpa a tecla pressionada
   			if (!input(COL1)) teclaC=1; // Verifica se tecla está pressionada
   			if (!input(COL2)) tecla0=1; // Verifica se tecla está pressionada
   			if (!input(COL3)) teclaE=1; // Verifica se tecla está pressionada
   			break;
      }
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                  Rotina de Atualização de Tela do LCD               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Atualiza_tela(char dado)
{
	Lcd_Inst(0x82);				       // Posiciona o cursor
   printf(lcd_dado,"A tecla %c foi",dado);
  	Lcd_Inst(0xC3);				       // Posiciona o cursor
   printf(lcd_dado,"Pressionada");	
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                  Rotina de Envio de Comando para o LCD              *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Lcd_Inst(char dado)
{
	disable_interrupts(GLOBAL);	  // Desliga as interrupções
	output_low(RS);					  // Põe pino de RS em baixo, modo comando
	output_d(dado);					  // Põe o dado no portd
	delay_cycles(2);	   			  // Aguarda 2 us, acomodação
	output_high(EN);      		     // Gera pulso de clock
	delay_cycles(2);
	output_low(EN);
	delay_ms(1);				    	  // Aguarda 1ms
	enable_interrupts(GLOBAL);		  // Liga as interrupções
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                  Rotina de Envio de Dados para o LCD                *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Lcd_Dado(char dado)
{
	disable_interrupts(GLOBAL);		// Desliga as interrupções
	output_high(RS);       				// Seta o pino RS, modo dado
	output_d(dado);		   			// Põe o dado no portd
	delay_cycles(2);			       	// Aguarda 2us, acomodação
	output_high(EN);	      			// Gera pulso de clock
	delay_cycles(2);
	output_low(EN);
	delay_ms(1);	       				// Aguarda 1ms
	enable_interrupts(GLOBAL);		   // Liga as interrupções
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *     		                 Fim do Programa						   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */




