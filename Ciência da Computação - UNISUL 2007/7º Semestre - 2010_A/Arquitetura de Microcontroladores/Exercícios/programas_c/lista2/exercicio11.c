#include <16f877A.h>
#fuses xt, nolvp, protect
#use delay(clock=4Mhz)

void main() {

   int count = 0;

   while(true){
   
      if(input(pin_a0)){
         count++;
         
         while(input(pin_a0)){
            output_c(count);
         }
         
      }   
   }
}
