#include "16F877A.h"
#fuses XT, NOLVP, PROTECT
#use DELAY(CLOCK=4MHZ)
#include <lcd_4.c>


void main() {

   int16 count = 0;

   while(true){
   
      if(input(pin_a0)){
      
         count++;
      
         // controla display da esquerdo
         output_b(count/100);
         output_low(pin_c0);
         delay_us(20);
         output_high(pin_c0);
   
         // controla display central
         if(count/10 < 10) {
            output_b(count/10);
         } else {
            output_b((count%100)/10);
         }
         output_low(pin_c1);
         delay_us(20);
         output_high(pin_c1);
         
         // controla diplay direito
         output_b(count%10);
         output_low(pin_c2);
         delay_us(20);
         output_high(pin_c2);
      
         delay_ms(500);
         
         if(count==999){
            count=0;
         }
         
      }
       
   }

}
