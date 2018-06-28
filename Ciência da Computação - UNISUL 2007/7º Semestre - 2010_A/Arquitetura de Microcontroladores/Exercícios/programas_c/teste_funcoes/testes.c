#include "16F877A.h"
#fuses HS, NOLVP, PROTECT
#use DELAY(CLOCK=20MHZ)
#include <lcd_4.c>
#include <stdlib.h>
#include <math.h>

void main() {

   char v[6];
   int16 t=0;
   int16 r=0;
   
   lcd_init();
   
   v[0]='1';
   v[1]='2';
   v[2]='1';
   v[3]='\0';
   
   while(true){
   
      t = atol(v);
      lcd_gotoxy(1,1);
      printf(lcd_putc, "Convercao: %lu", t);
      
      r = sqrt(atol(v));
      lcd_gotoxy(1,2);
      printf(lcd_putc, "Raiz: %lu", r);
   
   }

}
