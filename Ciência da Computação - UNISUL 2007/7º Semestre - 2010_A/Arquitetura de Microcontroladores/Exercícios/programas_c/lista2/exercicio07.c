#include <16f877A.h>
#fuses xt, nolvp, protect
#use delay(clock=4Mhz)

void main() {

   while(true) {

      if (!input(pin_b3)) {
         output_high(pin_a2);
      } else {
         output_low(pin_a2);
      }
      
      if (!input(pin_b4)) {
         output_high(pin_a3);
      } else {
         output_low(pin_a3);
      }

   }

}
