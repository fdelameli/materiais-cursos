#include <16F877A.h>
#fuses XT, PROTECT, BROWNOUT
#use delay(clock=4MHz)
#use rs232(baud=9600,xmit=pin_c6,rcv=pin_c7)
#include <stdlib.h>


void main() {
/*
   int a = 50;
   int b = 20;
   signed int c =  0;
   
   c = abs(b-a);
   printf("%d\n\r", c);
*/


   while(true) {
      printf("%u\r\n", (int) (rand()%50)); // gera numeros aleatorios com valor maximo 50
      delay_ms(300);
   }

}
