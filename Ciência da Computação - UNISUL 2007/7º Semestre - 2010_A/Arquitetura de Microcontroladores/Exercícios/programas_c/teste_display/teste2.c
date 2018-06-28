#include <16F877A.h>
#fuses xt, nolvp, protect
#use delay(clock=4mhz)

void main() {

   int16 time = 1000;
   int i;
   
   while(true) {
  
      for (i=0;i<=59;i++) {
  
         output_b(i/10);
         output_low(pin_c0);
         output_high(pin_c0);
         
         output_b(i%10);
         output_low(pin_c1);
         output_high(pin_c1);
         
         delay_ms(time);
         
      }
      
   }

}
