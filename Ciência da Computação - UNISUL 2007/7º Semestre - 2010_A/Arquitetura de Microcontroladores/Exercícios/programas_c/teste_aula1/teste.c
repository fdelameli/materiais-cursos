#include <16f877A.h>       // inclui uma biblioteca (biblioteca do microcontrolador 16f877A).
#fuses xt, nolvp, protect  // xt - oscilador do tipo XT (de 1 a 4 Mhz) --- hs - (>4 e <= 20MHz)
                           // nolvp - se vai ser gravado em alta(12V) ou em baixa tens�o(5V), nesse caso � em baixa tens�o.
                           // protege o c�digo no hardware 
#use delay(clock=4Mhz)     // deixa o tempo sincronizado

void main() {     // programa principal
   
//   int v = 0;
   boolean led = false;
   
   while(true) {  // sempre tem que ter, para deixar o programa executando


/* Teste1    
      v = input_b(); // l� porta B
      
      if (v == 15) {
         output_high(pin_a0); // liga bit a0
      } else {
         output_low(pin_a0); // desliga bit a0
      }
*/ 
  
/* Teste2
      if (input(pin_c0)) { // testa se c0 possui n�vel l�gico 1
         output_high(pin_a0); // liga
      } else {
         output_low(pin_a0); // desliga
      }
*/

// Teste3
/*
      if (!input(pin_c0)) { // testa se c0 possui n�vel l�gico 0
         output_b(0x0A);
      } else {
         output_b(0xFF);
      }
*/

// Teste4
/*
      output_bit(pin_a0, led); // seta o valor da vari�vel led no pino a0.
      led = !led; // nega o valor do da vari�vel led.
      delay_ms(500); // instru��o de retardo (trava o programa por 500 milisegundos).
*/

// Teste 5
     
     output_high(pin_a0);
     if (input_state(pin_a0)) {
         output_high(pin_a1);
     } else {
         output_low(pin_a1);
     }
     
     
   }
   
}
