#include <16F877A.h>
#fuses XT, PROTECT
#use delay(clock=4Mhz)
#use rs232(baud=9600, xmit=pin_c6, rcv=pin_c7)


void main() {

   char c = ' ';

   while(true) {
    
      if (kbhit()) {
         
         c = getc();
         
         if(c == 'A') {
            output_bit(pin_d0, !input_state(pin_d0));
            printf("PIN_D0: %d\r\n", input_state(pin_d0));
         } else if(c == 'B') {
            output_bit(pin_d1, !input_state(pin_d1));
            printf("PIN_D1: %d\r\n", input_state(pin_d1));
         } else if(c == 'C') {
            output_bit(pin_d2, !input_state(pin_d2));
            printf("PIN_D2: %d\r\n", input_state(pin_d2));
         } else if(c == 'D') {
            output_bit(pin_d3, !input_state(pin_d3));
            printf("PIN_D3: %d\r\n", input_state(pin_d3));
         }
      
      }
      
   }

}
