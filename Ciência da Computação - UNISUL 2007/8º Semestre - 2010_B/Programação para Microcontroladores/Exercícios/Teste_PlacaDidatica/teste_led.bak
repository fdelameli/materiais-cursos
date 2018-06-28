#include <16F877A.h>
#fuses XT, PROTECT
#use delay(clock=4Mhz)


// Renomeia o pino d0 para "led"
#define led1 pin_d0
#define led2 pin_d1
#define led3 pin_d2
#define led4 pin_d3
#define led5 pin_d4
#define led6 pin_d5
#define led7 pin_d6
#define led8 pin_d7

#define setLed pin_b5
#define cooler pin_c2

#define DELAY 25

void main() {

   // lega "chave geral" dos led's
   output_bit(setLed, 1);
   // liga o cooler
   output_bit(cooler, 1);
   // limpa a porta d
   output_d(0x00);

   while(true) {
 
      output_bit(led1, 1);
      delay_ms(DELAY);
      output_bit(led1, 0);
      delay_ms(DELAY);
      
      output_bit(led2, 1);
      delay_ms(DELAY);
      output_bit(led2, 0);
      delay_ms(DELAY);
      
      output_bit(led3, 1);
      delay_ms(DELAY);
      output_bit(led3, 0);
      delay_ms(DELAY);
      
      output_bit(led4, 1);
      delay_ms(DELAY);
      output_bit(led4, 0);
      delay_ms(DELAY);
      
      output_bit(led5, 1);
      delay_ms(DELAY);
      output_bit(led5, 0);
      delay_ms(DELAY);
      
      output_bit(led6, 1);
      delay_ms(DELAY);
      output_bit(led6, 0);
      delay_ms(DELAY);
      
      output_bit(led7, 1);
      delay_ms(DELAY);
      output_bit(led7, 0);
      delay_ms(DELAY);
      
      output_bit(led8, 1);
      delay_ms(DELAY);
      output_bit(led8, 0);
      delay_ms(DELAY);
 
   }
   
}
