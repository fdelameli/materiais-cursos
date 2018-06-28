#include <16F877A.h>
#fuses xt, nolvp, protect
#use delay(clock=4Mhz)

void main() {

   int b = 0;

   while(true) {
  
      b = input_b();
      
      switch(b) {
      
         case 0 : output_c(0b00000001); break;
         case 1 : output_c(0b00000010); break;
         case 2 : output_c(0b00000100); break;
         case 3 : output_c(0b00001000); break;
         case 4 : output_c(0b00010000); break;
      
      }
     
   }

}
