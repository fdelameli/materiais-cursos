/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
*     			   Programação em C - Módulo B PIC16F877A              *
*                                Exemplo 6                             *
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
	RCSTA=0b10010000;			//Habilita a recepção serial
								//Habilita a recepção contínua de dados
	
	TXSTA=0b00100100;			//Habilita a transmissão serial
	
	SPBRG=25;					//Configura o baud-rate para 9600 bps
	
	TRISD=0b00000000;			//Configura o PORTD como saída
	
	TRISB=0b00000000;			//Configura o PORTB como saída
	
	PORTB=0b00100000;			//Liga o transistor dos leds
	
	while(1)
	{
		if (RCIF)				//Chegou algum byte?
		{
			PORTD=RCREG;		//Sim, então carrega nos leds o dado recebido;
			TXREG=RCREG;		//Envia para o PC o dado recebido	
		}
		
	}
}


/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *    		                Fim do programa			  	      		   *	
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
