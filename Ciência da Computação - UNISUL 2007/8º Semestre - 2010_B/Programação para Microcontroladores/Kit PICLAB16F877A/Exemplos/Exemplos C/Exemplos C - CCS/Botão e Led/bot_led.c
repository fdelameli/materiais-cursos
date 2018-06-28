/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                 Programação em C - Módulo B PIC16F877A                  *
 *                                Exemplo 1                                *
 *                                                                         *
 *                            CERNE TECNOLOGIA                             *
 * 		                   www.cerne-tec.com.br                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *   VERSÃO : 1.0                                                          *
 *   DATA : 16/05/2005                                                     *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                             Descrição geral                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	           // Observar o estado de um botão através de um led

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                     	    Definição de Cabeçalho     	                *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#include	<16F877A.h>					//microcontrolador utilizado

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                        Configurações para gravação                    *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#fuses xt,nolvp,wdt,nolvp,nobrownout,put,nodebug,noprotect,nowrt,nocpd
                            								// Configurações da Máquina
                                  						// Oscilador: XT
                                  						// LVP: Off
                                  						// WDT: On, Brown-out: Off
                                   						// Power-up: Off, Debug: Off
                                    					// CPD: Off

#use delay(clock=4000000)       	   	// Define o clock do sistema

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                Entradas                               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
            //Aqui iremos definir as entradas do sistema

#define BOTAO		PIN_A4		   	 // Define entrada para o botão


/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                 Saídas                              *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
          //Aqui iremos definir as saídas do sistema

#define LED			PIN_D7		       //Define a saída para o led
#define COLUNA1	PIN_D0	          //Define a saída da coluna
#define CS_LED		PIN_B5	          //Define a saída da coluna

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                       Prototipagem das funções                  *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos declarar todas as funções definidas pelo usuário

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                           Rotina Principal                	    *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Nessa parte ficará o loop principal do sistema

void main(void)
{
   
	output_high(CS_LED);		   		//Seleciona o barramento para os leds
	output_low(COLUNA1);		     		//Deixa a coluna1 ativa
   output_d(0);                     //Coloca todo o PORTD como saída

	while(1)				         		//Entra em loop infinito
		{
			if (input(BOTAO))    		//Botão está pressionado?
			 output_low(LED);	   		//Não, então apaga o led
			else			   	       	//Sim...
			 output_high(LED);	   	//Então acende o led
		}
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                         Fim do programa	       	                *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


