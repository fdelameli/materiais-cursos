#include <16F877A.h>
#fuses xt, nolvp, protect
#use delay(clock=4Mhz)

void main() {

   while(true) {
   
      if (input(pin_a0)) {
      
         while (!input(pin_a1)) {
            output_high(pin_b0);
            delay_ms(1000);       // mantém o led aceso por 1 seg
            output_low(pin_b0);
            delay_ms(2000);       // mantém o led apagado por 2 seg
         }
         
      }
   
   }

}
