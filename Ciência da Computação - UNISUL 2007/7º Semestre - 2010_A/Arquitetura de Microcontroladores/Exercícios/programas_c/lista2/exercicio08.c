#include <16f877A.h>
#fuses xt, nolvp, protect
#use delay(clock=4Mhz)

void main() {

   while (true) {
         
      if (input(pin_a3)) {
         output_high(pin_a2);
         break;
      } 
   
   }

}
