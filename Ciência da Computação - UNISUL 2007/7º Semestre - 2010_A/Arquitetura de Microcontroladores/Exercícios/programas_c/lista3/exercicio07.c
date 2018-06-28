#include <16F877A.h>
#fuses xt, nolvp, protect
#use delay(clock=4Mhz)

void main() {

   while(true) {
   
      if (input(pin_b0)) {
         output_high(pin_b2);
      }
      
      if (!input(pin_b1)) {
         output_low(pin_b2);
      }
   
   }

}
