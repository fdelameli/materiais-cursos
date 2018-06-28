#include "16F877A.h"
#fuses hs, nolvp, protect
#use delay(clock=4MHz)

void main() {

   int16 count = 0;
   
   while(true) {
               
      // controla display da esquerdo
      output_c(count/100);
      output_low(pin_d0);
      delay_us(20);
      output_high(pin_d0);
   
      // controla display central
      if(count/10 < 10) {
         output_c(count/10);
      } else {
         output_c((count%100)/10);
      }
      output_low(pin_d1);
      delay_us(20);
      output_high(pin_d1);
         
      // controla diplay direito
      output_c(count%10);
      output_low(pin_d2);
      delay_us(20);
      output_high(pin_d2);
     
      if(count==999){
         count=0;
      }

      
      if(input(pin_b3)){
         output_high(pin_b0);
         delay_ms(100);
         output_low(pin_b0);
         output_high(pin_b1);
         delay_ms(100);
         output_low(pin_b1);
         count++;  
      }
   
   }

}
