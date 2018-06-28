/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *    			   Programação em C - Módulo B PIC16F877A            	      *
 *                               Exemplo 3                                 *
 *                                                                         *
 *                CENTRO DE TREINAMENTO - Cerne Tecnologia	               *
 *                           www.cerne-tec.com.br                          *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *   VERSÃO : 1.0                                                          *
 *   DATA : 16/05/2005                                                     *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                             Descrição geral                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
// Implementar uma rotina para ler o Teclado Matricial

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                		 	Definição de Cabeçalho						 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#include	<16F877A.h>				//microcontrolador utilizado

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                         Configurações para gravação                   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#fuses xt,nolvp,wdt,nolvp,nobrownout,put,nodebug,noprotect,nowrt,nocpd
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

int milhar=0,centena=0,dezena=0,unidade=0,indice=0;
int1 tecla0=0, tecla1=0, tecla2=0, tecla3=0, tecla4=0, tecla5=0;
int1 tecla6=0, tecla7=0, tecla8=0, tecla9=0, teclaE=0, teclaC=0;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                           Constantes internas                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos definir as constantes utilizadas pelo sistema

#define CHR_0  		0b00111111
#define CHR_1  		0b00000110
#define CHR_2  		0b01011011
#define CHR_3  		0b01001111
#define CHR_4  		0b01100110
#define CHR_5  		0b01101101
#define CHR_6  		0b01111101
#define CHR_7  		0b00000111
#define CHR_8  		0b01111111
#define CHR_9  		0b01101111
#define CHR_A  		0b01110111
#define CHR_B  		0b01111100
#define CHR_C  		0b00111001
#define CHR_D  		0b01011110
#define CHR_E  		0b01111001
#define CHR_F  		0b01110001

const int converte_to_7seg[]={CHR_0,CHR_1,CHR_2,CHR_3,CHR_4,CHR_5,CHR_6,
                              CHR_7,CHR_9,CHR_A,CHR_B,CHR_C,CHR_D,CHR_E,CHR_F};
                                    //Caracteres para o displayt de 7 segmentos

#define SEL_LINHA1	0b00001110
#define SEL_LINHA2	0b00001101
#define SEL_LINHA3	0b00001011
#define SEL_LINHA4	0b00000111

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                Entradas                               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos definir as entradas do sistema

#define  COL1	      PIN_A4
#define  COL2	      PIN_A5
#define  COL3        PIN_E0

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                Saídas                               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos definir as saídas do sistema

#define SEL_UNIDADE   PIN_B1
#define SEL_DEZENA    PIN_B2
#define SEL_CENTENA   PIN_B3
#define SEL_MILHAR    PIN_B4

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                       Prototipagem das funções                      *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos declarar todas as funções definidas pelo usuário

void Inicializa(void);
void Verifica_Linha(int linha);

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                           Rotina Principal                		   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Nessa parte ficará o loop principal do sistema

void main (void)
{
	Inicializa();					// Chama rotina para inicializar o sistema

	while(1)						// Entra em loop infinito
		{
			restart_wdt();			// Limpa o wdt

			if (tecla1)	milhar=1; 	// Atualiza valor da variável milhar
			if (tecla2) milhar=2; 	// Atualiza valor da variável milhar
			if (tecla3) milhar=3; 	// Atualiza valor da variável milhar

			if (tecla4) centena=4; 	// Atualiza valor da variável centena
			if (tecla5) centena=5; 	// Atualiza valor da variável centena
	 		if (tecla6) centena=6; 	// Atualiza valor da variável centena

			if (tecla7) dezena=7;	// Atualiza valor da variável dezena
			if (tecla8) dezena=8; 	// Atualiza valor da variável dezena
			if (tecla9) dezena=9; 	// Atualiza valor da variável dezena

			if (teclaC) unidade=12; // Atualiza valor da variável unidade
			if (tecla0) unidade=0;  // Atualiza valor da variável unidade
			if (teclaE) unidade=14; // Atualiza valor da variável unidade

		}
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                       Inicialização do Sistema                 	   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Inicializa(void)
{
   setup_wdt(WDT_2304MS);           // Configura WDT para 2,304 s

   setup_adc_ports(no_analogs);   	// Todos os AD´s desligados

   set_timer0(0);                 	// Inicializa timer 0 com 0
   setup_timer_0(RTCC_INTERNAL | RTCC_DIV_16);
                                    // Timer configurado para clock
                                    // Interno com prescaler de 1:4

   enable_interrupts(INT_TIMER0);   // Habilita interrupção de timer 0
   enable_interrupts(GLOBAL);       // Habilita todas as interrupções
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

         case 1:                     // Caso seja 1...
            output_low(SEL_UNIDADE); // Retira a seleção do display anterior
   			output_d(SEL_LINHA1);	 // Seleciona no barramento a linha 1
	    		tecla1=0;			       // Limpa a tecla pressionada
	  	  	   tecla2=0;			       // Limpa a tecla pressionada
	     		tecla3=0;			     	 // Limpa a tecla pressionada
			   if (!input(COL1)) tecla1=1; // Verifica se tecla está pressionada
   			if (!input(COL2)) tecla2=1; // Verifica se tecla está pressionada
	     		if (!input(COL3)) tecla3=1; // Verifica se tecla está pressionada
            output_d(Converte_to_7seg[milhar]);
            output_high(SEL_MILHAR);    // Mostra o dado no barramento
            break;				        	 // Liga display selecionado

         case 2:                     // Caso seja 2...
            output_low(SEL_MILHAR);  // Retira a seleção do display anterior
   			output_d(SEL_LINHA2);	 // Seleciona no barramento a linha 1
   	  		tecla4=0;	   			 // Limpa a tecla pressionada
   	  		tecla5=0;		 		    // Limpa a tecla pressionada
   			tecla6=0;				    // Limpa a tecla pressionada
   			if (!input(COL1)) tecla4=1; // Verifica se tecla está pressionada
   			if (!input(COL2)) tecla5=1; // Verifica se tecla está pressionada
   			if (!input(COL3)) tecla6=1; // Verifica se tecla está pressionada
            output_d(Converte_to_7seg[centena]);
            output_high(SEL_CENTENA);   // Mostra o dado no barramento
            break;					       // Liga display selecionado

         case 3:                     // Caso seja 3...
            output_low(SEL_CENTENA); // Retira a seleção do display anterior
   			output_d(SEL_LINHA3);	 // Seleciona no barramento a linha 3
   			tecla7=0;				       // Limpa a tecla pressionada
   			tecla8=0;				       // Limpa a tecla pressionada
   			tecla9=0;			          // Limpa a tecla pressionada
   			if (!input(COL1)) tecla7=1; // Verifica se tecla está pressionada
   			if (!input(COL2)) tecla8=1; // Verifica se tecla está pressionada
   			if (!input(COL3)) tecla9=1; // Verifica se tecla está pressionada
            output_d(Converte_to_7seg[dezena]);
            output_high(SEL_DEZENA);    // Mostra o dado no barramento
            break;					       // Liga display selecionado

         case 4:                    // Caso seja 4...
            indice=0;               // Reinicia indice
            output_low(SEL_DEZENA); // Retira a seleção do display anterior
   			output_d(SEL_LINHA4);   // Seleciona no barramento a linha 4
   			teclaC=0;				   // Limpa a tecla pressionada
   			tecla0=0;				   // Limpa a tecla pressionada
   			teclaE=0;				   // Limpa a tecla pressionada
   			if (!input(COL1)) teclaC=1; // Verifica se tecla está pressionada
   			if (!input(COL2)) tecla0=1; // Verifica se tecla está pressionada
   			if (!input(COL3)) teclaE=1; // Verifica se tecla está pressionada
            output_d(Converte_to_7seg[unidade]);
            output_high(SEL_UNIDADE);// Mostra o dado no barramento
            break;	     				 // Liga display selecionado
      }
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                  		Fim do Programa              			   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


