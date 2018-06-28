#include "16F877A.h"
#fuses XT, NOLVP, PROTECT
#use DELAY(CLOCK=4MHZ)

void main() {

   int count2 = 0; // para produtos de 2cm de altura
   int count4 = 0; // para produtos de 4cm de altura
   int count10 = 0; // para produtos de 10cm de altura

   while(true){
   
   // detectado produto de 2cm
   if(input(pin_a0)){
      
      count2++;
      
      output_b(count2/10);
      output_low(pin_b6);
      output_high(pin_b6);
      
      output_b(count2%10);
      output_low(pin_b7);
      output_high(pin_b7);
      
      delay_ms(500);
      
      if(count2==99){
         count2=0;
      }
      
   }
   
      // detectado produto de 4cm
      if(input(pin_a1)){
         
         count4++;
         
         output_c(count4/10);
         output_low(pin_c6);
         output_high(pin_c6);
         
         output_c(count4%10);
         output_low(pin_c7);
         output_high(pin_c7);
         
         delay_ms(500);
         
         if(count4==99){
            count4=0;
         }
      }
   
      // detectado produto de 10cm
      if(input(pin_a2)){
         
         count4++;
         
         output_d(count10/10);
         output_low(pin_d6);
         output_high(pin_d6);
         
         output_d(count10%10);
         output_low(pin_d7);
         output_high(pin_d7);
         
         delay_ms(500);
         
         if(count10==99){
            count10=0;
         }
         
      }
   
   }

}
