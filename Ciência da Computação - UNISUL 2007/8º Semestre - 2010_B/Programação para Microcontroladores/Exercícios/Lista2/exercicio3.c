#include <16F877A.h>
#fuses XT, PROTECT
#use delay(clock=4Mhz)
#use rs232(baud=9600, xmit=pin_c6, rcv=pin_c7)


#define DELAY 5000

void main() {

   int VL_PORTB = 0;

   while(true) {
  
      VL_PORTB = input_b();
      printf("%d\r\n", VL_PORTB);
      delay_ms(DELAY);
   
   }

}
