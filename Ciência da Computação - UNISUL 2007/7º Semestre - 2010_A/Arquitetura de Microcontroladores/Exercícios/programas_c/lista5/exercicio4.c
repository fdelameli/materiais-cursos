#include "16F877A.h"
#fuses HS, NOLVP, PROTECT
#use DELAY(CLOCK=20MHZ)
#include <lcd_4.c>

void incrementa(int, int, int);

void main() {

   int count2 = 0; // para produtos de 2cm de altura
   int count4 = 0; // para produtos de 4cm de altura
   int count10 = 0; // para produtos de 10cm de altura
   
   lcd_init();

   incrementa(count2, count4, count10);

   while(true){
   
       if(input(pin_a1)){
          incrementa(++count2, count4, count10);
       }
       
       if(input(pin_a2)){
          incrementa(count2, ++count4, count10);
       }
       
       if(input(pin_a3)){
          incrementa(count2, count4, ++count10);
       }
   
   }
   
}

void incrementa(int a, int b, int c) {
   lcd_gotoxy(1,1);
   printf(lcd_putc, "%S", "A:");
   printf(lcd_putc, "%D", a);
   lcd_gotoxy(7,1);
   printf(lcd_putc, "%S", "B:");
   printf(lcd_putc, "%D", b);
   lcd_gotoxy(13,1);
   printf(lcd_putc, "%S", "C:");
   printf(lcd_putc, "%D", c);
   delay_ms(300);
}
