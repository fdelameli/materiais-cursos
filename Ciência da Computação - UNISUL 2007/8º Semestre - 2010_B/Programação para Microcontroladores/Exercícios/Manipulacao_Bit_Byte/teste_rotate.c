#include <16F877A.h>
#fuses XT, PROTECT
#use delay(clock=4MHz)


void main() {

   byte var = 0b10100100;
   
   while (true) {
   
      /*
      // rotaciona x quantidade de bits para a esquerda - nesse caso, de bit em bit, pois o parâmetro é 1
      rotate_left(&var,1);
      delay_ms(1000);
      output_b(var);
      */
      
      // rotaciona x quantidade de bits para a direita - nesse caso, de bit em bit, pois o parâmetro é 1
      rotate_right(&var,1);
      delay_ms(1000);
      output_b(var);
      
   }

}
