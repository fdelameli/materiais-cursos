#include <16F877A.h>
#fuses xt, nolvp, protect
#use delay(clock=4Mhz)

void main() {

   int saida;
   int i;

   while (true) {
   
      saida = 1;
      
      for(i = 0; i<8; i++) {
         output_b(saida);
         saida = saida*2+1;
         delay_ms(1000);
      }
      
      output_b(0b00000000); // desliga todos os bits da porta b
      delay_ms(2000);
   
   }

}
