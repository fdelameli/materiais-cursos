/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
*     			   Programação em C - Módulo B PIC16F877A              *
*                                Exemplo 4                             *
*                                                                      *
*                  CENTRO DE TREINAMENTO - Cerne Tecnologia	           *
*                  www.cerne-tec.com.br     (21) 4063-9798             *
*                                                                      *
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * **
*   VERSÃO : 1.0                                                       *
*   DATA : 16/05/2005                                                  *
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ** */

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *              	 	    Definição de Cabeçalho			           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#include	<pic.h>				//microcontrolador utilizado
			  		                                   
/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                           Rotina Principal                	       *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Nessa parte ficará o loop principal do sistema

void main(void)
{
	TRISB=0b00000000;			//Configura todo o PORTB como saída
	
	TRISD=0b00000000;			//Configura todo o PORTD como saída
	
	PORTB=0b00100000;			//Habilita o transistor dos leds
	
	ADCON0=0b11000001;			//Liga o AD
								//Seleciona a frequencia interna
								//Escolhe o canal 0 para conversão

	ADCON1=0b00001110;			//Justificação a esquerda
								//Coloca o RA0 como entrada analógica	
		
	while(1)
	{
		ADCON0=ADCON0 | 0b00000100;
								//Inicia uma conversão AD
		while(ADCON0 & 0b00000100);
								//Aguarda finalizar a conversão
											
		PORTD=ADRESH;			//Carrega nos leds o resultado da conversão
		
	}
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *    		                Fim do programa			  	      		   *	
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
