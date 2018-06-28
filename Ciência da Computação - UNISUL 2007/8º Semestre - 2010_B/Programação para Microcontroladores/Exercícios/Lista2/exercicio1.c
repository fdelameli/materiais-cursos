#include <16F877A.h>
#fuses XT, PROTECT
#use delay(clock=4Mhz)
#use rs232(baud=9600, xmit=pin_c6, rcv=pin_c7)


void main() {

   char c = ' ';

   while(true) {
   
      if(kbhit()) {
         
         c = getc();
         
         if(c == '0') {
            output_bit(pin_a0, 1);
         } else if (c == '1') {
            output_bit(pin_a1, 1);
         }
         
         
         if (input(pin_a0)) {
            printf("Pressionou A0\r\n");
            output_bit(pin_a0, 0);
         } else if (input(pin_a1)) {
            printf("Pressionou A1\r\n");
            output_bit(pin_a1, 0);
         }
         
         
      }
   
   }

}
