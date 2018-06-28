#include <16f877A.h>
#fuses xt, nolvp, protect
#use delay(clock=4Mhz)

void main() {

   while(true) {
   
      if(input(pin_a0) || input(pin_a2)) {
         output_high(pin_b1);
      } else {
         output_low(pin_b1);
      }
   
   }

}
