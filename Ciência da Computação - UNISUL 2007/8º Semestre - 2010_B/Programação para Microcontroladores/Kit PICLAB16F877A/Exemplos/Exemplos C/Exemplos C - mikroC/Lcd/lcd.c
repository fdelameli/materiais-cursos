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

   trisd=0b00000000;
   trise=0b00000001;            //configura i/os

   adcon1=0b00000111;           //desliga os a/ds

   Lcd8_Config(&PORTE, &PORTD, 2, 1, 3, 7, 6, 5, 4, 3, 2, 1, 0);
   Lcd8_Init(&PORTE,&PORTD);
   Lcd8_Cmd(LCD_CLEAR);          //limpa o display
   Lcd8_Cmd(LCD_CURSOR_OFF);     //Desliga o cursor

   while(1)
   {
           lcd8_cmd(lcd_clear);  //Envia comando para apagar lcd
           lcd8_out(1,1,"Pais: Italia");
           lcd8_out(2,1,"Cidade: Roma");
           delay_ms(1000);

           lcd8_cmd(lcd_clear);  //Envia comando para apagar lcd
           lcd8_out(1,1,"Pais: Franca");
           lcd8_out(2,1,"Cidade: Paris");
           delay_ms(1000);

           lcd8_cmd(lcd_clear);  //Envia comando para apagar lcd
           lcd8_out(1,1,"Pais: Alemanha");
           lcd8_out(2,1,"Cidade: Berlin");
           delay_ms(1000);

           lcd8_cmd(lcd_clear);  //Envia comando para apagar lcd
           lcd8_out(1,1,"Pais: Brasil");
           lcd8_out(2,1,"Cidade: Brasilia");
           delay_ms(1000);


   }

}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                       Fim do programa                       *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

