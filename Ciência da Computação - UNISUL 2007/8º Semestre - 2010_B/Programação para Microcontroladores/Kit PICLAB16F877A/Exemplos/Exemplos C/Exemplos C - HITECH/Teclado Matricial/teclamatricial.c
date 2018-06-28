/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *    			   Programação em C - Módulo B PIC16F877A                  *
 *                               Exemplo 3                                 *
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
	int x;
	
	TRISB=0b00000000;			//Configura todo o PORTB como saída
	
	TRISD=0b00000000;			//Configura todo o PORTD como saída
	
	TRISA=0b00110000;			//Configura I/O do PORTA
		
	TRISE=0b00000001;			//Configura I/O do PORTE
	
	PORTB=0b00000000;			//Habilita o transistor dos leds
	
	ADCON1=0b00000111;			//Desliga o AD do microcontrolador
	
	while(1)
	{
		
		PORTD=0b11111110;		//Seleciona a linha 1 do teclado
		
		if (RA4==0)
		{
			PORTD=0b00000110;	//Carrega o digito 1 no display de 7 segmentos	
			RB1=1;							//Liga o transistor para mostrar no display
			for (x=1;x<1000;x++);			//Faz um pequeno delay
			RB1=0;							//Desliga o transistor		
		}		


		if (RA5==0)
		{
			PORTD=0b01011011;		//Carrega o digito 2 no display de 7 segmentos
			RB1=1;							//Liga o transistor para mostrar no display
			for (x=1;x<1000;x++);			//Faz um pequeno delay
			RB1=0;							//Desliga o transistor		
		}

		if (RE0==0)
		{
			PORTD=0b01001111;	//Carrega o digito 3 no display de 7 segmentos								
			RB1=1;							//Liga o transistor para mostrar no display
			for (x=1;x<1000;x++);			//Faz um pequeno delay
			RB1=0;							//Desliga o transistor		
		}

	}
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *    		                  Fim do programa						   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */



