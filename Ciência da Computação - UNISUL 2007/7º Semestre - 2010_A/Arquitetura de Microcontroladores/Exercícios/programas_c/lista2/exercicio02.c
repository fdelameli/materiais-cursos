#include <16F877A.h>
#fuses xt, nolvp, protect
#use delay(clock=4Mhz)

void main() {
   
   while(true) { 
   
      if (input(pin_a1)) {
         output_high(pin_b4);
      } else {
         output_low(pin_b4);
      }  
   
   }

}
