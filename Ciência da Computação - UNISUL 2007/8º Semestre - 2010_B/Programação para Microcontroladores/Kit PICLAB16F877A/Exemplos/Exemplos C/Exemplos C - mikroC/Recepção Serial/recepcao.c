/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *              Programação Em C - Módulo B PIC16F877A         *
 *                             Exemplo 6                       *
 *                                                             *
 *             CENTRO DE TREINAMENTO - Cerne Tecnologia        *
 *                                                             *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *   VERSÃO : 1.0
 *   DATA : 22/07/2005
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                         Descrição geral                     *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 Este exemplo irá demonstrar a recepção serial
  do PIC. Todos os dados recebidos da porta serial
 serão apresentados no display*/

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *             Definição e inicialização das variáveis         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
Aqui iremos definir as variáveis globais do sistema*/

char linha,coluna;
char recepcao;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                       Início do programa                    *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
Nessa parte ficará o loop principal do sistema*/

void main(void)
{
   trisa=0b11111111;            // põe todos os pinos para entrada
   trisd=0b00000000;
   trise=0b00000001;            //configura i/os
   adcon1=7;                    //desliga todos os a/ds
   option_reg=0b10000000;       //configura prescaler do timer 0
   Lcd8_Config(&PORTE, &PORTD, 2, 1, 3, 7, 6, 5, 4, 3, 2, 1, 0);
   Lcd8_Cmd(LCD_CLEAR);          //limpa o display
   Lcd8_Cmd(LCD_CURSOR_OFF);     //Desliga o cursor
   Usart_Init(9600);             //Inicializa o módulo Usart para trabalhar a 9600bps
   linha=1;
   coluna=1;

   while(1)
   {
       if (usart_data_ready())
       {
           recepcao=Usart_Read();
           Usart_Write(recepcao);
           Lcd8_Chr(linha,coluna,recepcao);
           coluna=coluna+1;
           if (coluna==17)
            {
             coluna=1;
             if (linha==1) linha=2;
             else          linha=1;
            }
       }
   }
}
/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                       Fim do programa                       *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

