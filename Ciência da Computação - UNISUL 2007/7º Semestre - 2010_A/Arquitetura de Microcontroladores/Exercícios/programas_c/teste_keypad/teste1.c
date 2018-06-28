#include "16F877A.h"
#fuses HS, PROTECT, NOLVP
#use delay(clock=20Mhz)
#include <lcd_4.c>

void main() {

   int i;
   char teste[9];
   
   teste[0] = 'F';
   teste[1] = 'a';
   teste[2] = 'b';
   teste[3] = 'i';
   teste[4] = 'o';

   

   lcd_init();
   lcd_gotoxy(1,1); // posiciona o cursor x=coluna y=linha
   lcd_setcursor(1,1); // deixa o cursor piscando: primeiro 1 mostra ou nao o _ / segundo 1 pisca ou não o cursor
   
   printf(lcd_putc, "%s", teste); // mostra valores maiores de 255
   
/*   
   lcd_putc('\f'); // limpa o display
   
   printf(lcd_putc, "%lu", 1223); // mostra valores maiores de 255
   delay_ms(1000);
   
   printf(lcd_putc, "%lx", 1223); // mostra valor hexadecimal (long_hexadecimal)
   delay_ms(1000);
   
   for(i=0;i<=9;i++) {
      printf(lcd_putc, "%u", i); // imprime algo na tela (%u : para imprimir números inteiros)
      delay_ms(500);
   }
*/   
}
