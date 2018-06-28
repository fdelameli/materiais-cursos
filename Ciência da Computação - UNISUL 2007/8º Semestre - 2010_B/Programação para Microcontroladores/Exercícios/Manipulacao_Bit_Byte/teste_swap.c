#include <16F877A.h>
#fuses XT, PROTECT
#use delay(clock=4MHz)


void main() {

   byte var = 0b00001111;
   
   // swap(var) - quebra um byte ao meio e troca as duas metades de posição.
   while(true) {
      swap(var);
      delay_ms(500);
      output_b(var);
      delay_ms(500);
   }

}
