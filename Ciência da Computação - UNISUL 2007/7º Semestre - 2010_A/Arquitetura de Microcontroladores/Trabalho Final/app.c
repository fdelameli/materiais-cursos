#include <16F877A.h>
#fuses xt, nolvp, protect
#use delay(clock=4Mhz)

void pisca_led(int16 delay);

void main() {
   
   int count;
   int16 delay = 350;
   
   while(true) { 
   
      for(count = 0; count<3; count++)
         pisca_led(delay);
      
      delay-=50;
   
      if(delay==50){
         while(delay<350) {
            for(count=0; count<3; count++)
               pisca_led(delay);
            delay += 50;
         }
      }
   
   }

}

void pisca_led(int16 d) {
      output_high(pin_b5);
      delay_ms(d);
      output_low(pin_b5);
      output_high(pin_b6);
      delay_ms(d);
      output_low(pin_b6);
      output_high(pin_b7);
      delay_ms(d);
      output_low(pin_b7);
}
