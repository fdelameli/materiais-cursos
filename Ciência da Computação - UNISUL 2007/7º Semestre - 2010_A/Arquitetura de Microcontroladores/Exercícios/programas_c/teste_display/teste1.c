#include <16F877A.h>
#fuses xt, nolvp, protect
#use delay(clock=4Mhz)

byte display [10];

void main() {

   int i = 0;
   int valor = 69;

   display[0]=0b0111111;
   display[1]=0b0000110;
   display[2]=0b1011011;
   display[3]=0b1001111;
   display[4]=0b1100110;
   display[5]=0b1101101;
   display[6]=0b1111101;
   display[7]=0b0100111;
   display[8]=0b1111111;
   display[9]=0b1101111;

   while(true) {
    
      for(i=0; i<10; i++) {
         output_b(display[valor/10]);
         output_low(pin_c0);
         delay_us(100);
         output_high(pin_c0);
         
         output_b(display[valor%10]);
         output_low(pin_c1);
         delay_us(100);
         output_high(pin_c1);
      }
      
   }

}
