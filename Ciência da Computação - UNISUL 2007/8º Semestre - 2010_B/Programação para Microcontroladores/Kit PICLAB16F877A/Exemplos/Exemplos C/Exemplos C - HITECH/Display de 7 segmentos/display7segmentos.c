/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *    			   Programação em C - Módulo B PIC16F877A                  *
 *                               Exemplo 2                                 *
 *                                                                         *
 *                CENTRO DE TREINAMENTO - Cerne Tecnologia	               *
 *                www.cerne-tec.com.br     (21) 4063-9798                  *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *   VERSÃO : 1.0                                                          *
 *   DATA : 16/05/2005                                                     *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                		 	Definição de Cabeçalho						 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#include	<pic.h>				//microcontrolador utilizado
				  		                                   
/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                           Rotina Principal                		   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Nessa parte ficará o loop principal do sistema

void main(void)
{
	TRISB=0b00000000;			//Configura todo o PORTB como saída
	
	TRISD=0b00000000;			//Configura todo o PORTD como saída
	
	PORTB=0b00010000;			//Habilita o transistor dos leds
	
	PORTD=0b01001111;			//Carrega o caracter 3 no display
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *    		                  Fim do programa						   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */



