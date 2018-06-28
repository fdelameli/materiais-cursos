#include <16F877A.h>
#fuses XT, PROTECT
#use delay(clock=4Mhz)
#include <Lcd_4.c>
#use rs232(baud=9600, xmit=pin_c6, rcv=pin_c7)




void main() {

   char c = ' ';
   char msg[15];
   int1 bool = 0;
   lcd_init();
   lcd_gotoxy(0,0);

   while(true) {

      if(kbhit()) {
      
         c = getc();
         
         if(c == 13)
            printf(lcd_putc, "%S", "Fabio");
            //printf(lcd_putc, "%S", c);
            
            if(bool) { // se  estiver na primeira linha 
               lcd_gotoxy(0,1);
               bool = 1;
            } else { // se estiver na segunda linha
               lcd_gotoxy(0,0);
               bool = 0;  
            }
            
         if(c == 27)
            lcd_putc("\f");   
      
      }
      
  
   }

}

