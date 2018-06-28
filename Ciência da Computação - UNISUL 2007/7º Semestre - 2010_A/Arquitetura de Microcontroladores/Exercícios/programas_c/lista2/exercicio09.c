#include <16F877A.h>
#fuses xt, nolvp, protect
#use delay(clock=4Mhz)

void main() {

   int i = 0;

   while(i<20) {
  
      output_high(pin_a1);
      output_high(pin_a2);
  
      delay_ms(500);
  
      output_low(pin_a1);
      output_low(pin_a2);

      delay_ms(500);
      
      i++;

   } 
 
   if (input_state(pin_a1)) {
      output_low(pin_a1);
   }
   
   if (input_state(pin_a2)) {
      output_low(pin_a2);
   }
   
   output_high(pin_a3);

}
