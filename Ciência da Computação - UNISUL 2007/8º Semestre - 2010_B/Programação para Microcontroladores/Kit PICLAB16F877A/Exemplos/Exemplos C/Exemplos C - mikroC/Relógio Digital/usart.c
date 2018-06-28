/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *              Programação Em C - Módulo B PIC16F877A         *
 *                             Exemplo 1                       *
 *                                                             *
 *             CENTRO DE TREINAMENTO - Cerne Tecnologia        *
 *                                                             *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *   VERSÃO : 1.0
 *   DATA : 22/07/2005
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                        Descrição geral                      *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 Implementar um relógio digital sem ajuste via teclado
 O horário será apresentado no display de 7 segmentos*/

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *             Definição e inicialização das variáveis         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
Aqui iremos definir as variáveis globais do sistema*/

char indice,pisca,vezes_tmr1;
char hora_msb=0,hora_lsb=0,minuto_msb=0,minuto_lsb=0;
char vetor_display[4];

/** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * **
 *                Declaração de labels de software             *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 Aqui iremos definir os labels utilizados no sistema*/

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * **
 *                      Constantes internas                   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * **
 'Aqui iremos definir as constantes utilizadas pelo sistema*/

const CHR_0 = 0b00111111;	                // RETORNA CARACTERE 0
const CHR_1 = 0b00000110;	                // RETORNA CARACTERE 1
const CHR_2 = 0b01011011;	                // RETORNA CARACTERE 2
const CHR_3 = 0b01001111;	                // RETORNA CARACTERE 3
const CHR_4 = 0b01100110;		        // RETORNA CARACTERE 4
const CHR_5 = 0b01101101;		        // RETORNA CARACTERE 5
const CHR_6 = 0b01111101;	         	// RETORNA CARACTERE 6
const CHR_7 = 0b00000111;	          	// RETORNA CARACTERE 7
const CHR_8 = 0b01111111;	           	// RETORNA CARACTERE 8
const CHR_9 = 0b01101111;	              	// RETORNA CARACTERE 9
const CHR_A = 0b01110111;	               	// RETORNA CARACTERE A
const CHR_B = 0b01111100;	                // RETORNA CARACTERE B
const CHR_C = 0b00111001;	                // RETORNA CARACTERE C
const CHR_D = 0b01011110;	                // RETORNA CARACTERE D
const CHR_E = 0b01111001;	                // RETORNA CARACTERE E
const CHR_F = 0b01110001;		        // RETORNA CARACTERE F


/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *             Rotina de conversão BCD para 7 segmentos        *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

unsigned char Converte_to_7seg (char dado)
{
 switch(dado)           //tabela de conversão para display de 7 segmentos
 {
    case 0 : return(CHR_0);
             break;
    case 1 : return(CHR_1);
             break;
    case 2 : return(CHR_2);
             break;
    case 3 : return(CHR_3);
             break;
    case 4 : return(CHR_4);
             break;
    case 5 : return(CHR_5);
             break;
    case 6 : return(CHR_6);
             break;
    case 7 : return(CHR_7);
             break;
    case 8 : return(CHR_8);
             break;
    case 9 : return(CHR_9);
             break;
    case 10 : return(CHR_A);
              break;
    case 11 : return(CHR_B);
              break;
    case 12 : return(CHR_C);
              break;
    case 13 : return(CHR_D);
              break;
    case 14 : return(CHR_E);
              break;
    case 15 : return(CHR_F);
              break;
 }
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *    Rotinas de Tratamento de Timer0 e Timer1 Interrupções    *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void interrupt(void)
{

   if (intcon.t0if == 1)             //Tratamento da interrupção
   {
       intcon.t0if=0;                //de timer 0
       indice++;

       switch(indice)
       {
          case 1:
               portb.f4=0;
               portd=vetor_display[indice-1];
               portb.f1=1;
               break;

          case 2:
               portb.f1=0;
               portd=vetor_display[indice-1];
               portb.f2=1;
               if (pisca) portd.f7=1;        //Seta o pino para piscar o display
               break;
               
          case 3:
               portb.f2=0;
               portd=vetor_display[indice-1];
               portb.f3=1;
               break;

          case 4:
               portb.f3=0;
               portd=vetor_display[indice-1];
               portb.f4=1;
               indice=0;
               break;

       }
   }
   else
   {
          tmr1h=0X0B;
          tmr1l=0XDC;
          pir1.tmr1if=0;            //limpa flag de interrupção
          pisca=!pisca;           //inverte o estado do pisca
          vezes_tmr1--;            //decrementa variável para dar 1 segundo
          
          if (vezes_tmr1==0)
          {
           vezes_tmr1=120;
           minuto_lsb++;
           
           if (minuto_lsb==10)
           {
             minuto_lsb=0;
             minuto_msb++;
             if (minuto_msb==6)
             {
                minuto_msb=0;
                hora_lsb++;
                if (hora_msb==2)
                {
                   if (hora_lsb==4)
                   {
                    hora_msb=0;
                    hora_lsb=0;
                   }
                }
                if (hora_lsb==10)
                 {
                  hora_lsb=0;
                  hora_msb++;
                 }
             }
          }

        }
    }
}


/** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * **
 *                       Início do Programa                    *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 Nessa parte ficará a inicialização do sistema*/

void main(void)
{

   trisa=0b00000000;
   trisb=0b00000000;
   trisd=0b00000000;            //configura i/os
   option_reg=0b10000000;       //configura prescaler do timer 0
   indice=0;                    //inicializa a variável de índice
   hora_msb=0;
   hora_lsb=0;
   minuto_msb=0;
   minuto_lsb=0;               //inicializa as variáveis de tempo
   pie1=0b00000001;             //habilita interrupção de timer 1
   t1con=0b00110001;            //configura timer 1 para prescaler de 1:8
   tmr1h=0x0B;
   tmr1l=0xDC;
   vezes_tmr1=120;             //inicializa variável de contagem
   pisca=0;                    //inicializa variável de piscagem
   intcon=0b11100000;          //configura interrupção de timer0


     while (1)
     {
       vetor_display[0]=Converte_to_7seg(hora_msb);
       vetor_display[1]=Converte_to_7seg(hora_lsb);
       vetor_display[2]=Converte_to_7seg(minuto_msb);
       vetor_display[3]=Converte_to_7seg(minuto_lsb);
     }

}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                       Fim do programa                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
