/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * **
*             Programação Em C - Módulo B PIC16F877A          *
*                             Exemplo 3                       *
*                                                             *
*             CENTRO DE TREINAMENTO - Cerne Tecnologia        *
*                                                             *
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
*   VERSÃO : 1.0
*   DATA : 22/07/2005
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                       Início do programa                    *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
Nessa parte ficará o loop principal do sistema*/

void main(void)
{
   delay_ms(2000);
   
   trisd=0b00000000;
   trise=0b00000000;            //configura i/os
   adcon1=0b00000111;           //desliga os a/ds

   Lcd8_Config(&PORTE, &PORTD, 2, 1, 0, 7, 6, 5, 4, 3, 2, 1, 0);
   Lcd8_Init(&PORTE,&PORTD);
   Lcd8_Cmd(LCD_CLEAR);          //limpa o display
   Lcd8_Cmd(LCD_CURSOR_OFF);     //Desliga o cursor

   while(1)
   {
           lcd8_cmd(lcd_clear);  //Envia comando para apagar lcd
           lcd8_out(2,1,"Cidade: Roma");
           delay_ms(1000);

           lcd8_cmd(lcd_clear);  //Envia comando para apagar lcd
           lcd8_out(2,1,"Cidade: Paris");
           delay_ms(1000);

           lcd8_cmd(lcd_clear);  //Envia comando para apagar lcd
           lcd8_out(2,1,"Cidade: Berlin");
           delay_ms(1000);
   }

}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                       Fim do programa                       *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

