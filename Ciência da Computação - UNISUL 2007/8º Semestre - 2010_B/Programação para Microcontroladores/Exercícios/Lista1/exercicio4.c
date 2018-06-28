#include <16F877A.h>
#fuses XT, PROTECT
#use delay(clock=4Mhz)
#include <Lcd_4.c>
#include <constants.c>
#include <string.h>
#use rs232(baud=9600, xmit=pin_c6, rcv=pin_c7)

void main() {

//   char c[];
   char c = ' ';
//   char L1_ON[] = {"led1on"};
//   char L1_OFF[] = {"led1off"};
   output_bit(SET_LED, 1);

   while(true) {
  
      if(kbhit()) {
         
         c = getc();
         
         if (c == 'o') {
            output_bit(LED1, 1);
         } else if (c == 'f') {
            output_bit(LED1, 0);
         }
         
      }
  
  
   /* 
      gets(c);
    
      if ( !strcmp(c,L1_ON) ) {
         output_bit(LED1, 1);
      } else if ( !strcmp(c,L1_OFF) ) {
         output_bit(LED1, 0);
      }
  */ 
   }  

}
