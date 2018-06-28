#include <16F877A.h>
#fuses XT, PROTECT
#use delay(clock=4Mhz)
#use rs232(baud=9600, xmit=pin_c6, rcv=pin_c7)

#define led1 pin_d0
#define led2 pin_d1
#define led3 pin_d2
#define led4 pin_d3
#define led5 pin_d4
#define led6 pin_d5
#define led7 pin_d6
#define led8 pin_d7

#define setLed pin_b5
#define DELAY 100

void main() {

   char c = ' ';
   int count = 0;
   output_bit(setLed,1);
   output_d(0x00);

   while(true) {
  
      if(kbhit()){
         c = getc();
         if(c == '+' && count <= 8) {
            count++;
            if(count == 1)
               output_bit(led1, 1);
            if(count == 2)
               output_bit(led2, 1);
            if(count == 3)   
               output_bit(led3, 1);   
            if(count == 4)
               output_bit(led4, 1);
            if(count == 5)
               output_bit(led5, 1);
            if(count == 6)
               output_bit(led6, 1);
            if(count == 7)
               output_bit(led7, 1);
            if(count == 8)
               output_bit(led8, 1);

         }
         if (c=='-' && count >= 0) {
            if(count == 8)
               output_bit(led8, 0);
            if(count == 7)
               output_bit(led7, 0);
            if(count == 6)
               output_bit(led6, 0);
            if(count == 5)
               output_bit(led5, 0);
            if(count == 4)
               output_bit(led4, 0);
            if(count == 3)
               output_bit(led3, 0);
            if(count == 2)
               output_bit(led2, 0);
            if(count == 1)
               output_bit(led1, 0);
            count--;
         }
      }      
   }

}
