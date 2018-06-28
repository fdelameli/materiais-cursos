#include <16F877A.h>
#fuses xt, nolvp, protect
#use delay(clock=4Mhz)

void main() {

   int saida;
   int i;
   int tempo = 1000;

   while (true) {
   
      saida = 0;
      
      for(i=0; i<8; i++) {
         if(saida!=0)
            saida *= 2;
         else
            saida = 1;
         output_b(saida);
         delay_ms(tempo);
      }
      
      output_b(0b00000000); // desliga todos os bits da porta b.
      delay_ms(tempo);
      
      for(i=0; i<=8; i++) {
         output_b(saida);
         saida /= 2;
         delay_ms(tempo);
      }
 
   }

}
