#include <16f877A.h>
#fuses xt, nolvp, protect
#use delay(clock=4Mhz)

void main() {

   int count = 0;

   while(true){
   
      if(input(pin_a1)) {
         count = 0;// zera a contagem caso for pressionado o botão reset
         output_c(count);
      }
      
      if(input(pin_a3)) {
         count = input_b(); // pega a o valor que está na porta b
         output_c(count);
      }
   
      if(input(pin_a0)){
         
         if(input(pin_a2)) { // se a chave estiver ligada...
            count++;         // a contagem é crescente.
         } else {            // senão...
            count--;         // a contagem é decrescente...
         }
         
         output_c(count);
         
         while(input(pin_a0)); // trava o programa para não contar automáticamente.
         
      }   
   }
}
