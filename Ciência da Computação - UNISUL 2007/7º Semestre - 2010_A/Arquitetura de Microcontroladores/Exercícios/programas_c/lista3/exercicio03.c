#include <16F877A.h>
#fuses xt, nolvp, protect
#use delay(clock=4Mhz)

void main() {

   int saida;
   int i;

   while (true) {
   
      saida = 0;
      
      for(i=0; i<8; i++) {
         saida = saida*2+1;
         output_b(saida);
         delay_ms(1000);
      }
      
      for(i=0; i<8; i++) {
         saida = (saida-1)/2;
         output_b(saida);
         delay_ms(1000);
      }
 
   }

}
