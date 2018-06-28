#include <16F877A.h>
#fuses xt, nolvp, protect
#use delay(clock=4Mhz)

void main() {

   int portb = 0, portc = 0;

   while(true) {
      
      portb = input_b();
      portc = input_c();
      
      if(portb==231 && portc==146) {
         output_high(pin_a0);
         delay_ms(2000);
         output_low(pin_a0);
      }
      
      while(portb==231 && portc==146) {
         portb = input_b();
         portc = input_c();
      }
         
   }

}


