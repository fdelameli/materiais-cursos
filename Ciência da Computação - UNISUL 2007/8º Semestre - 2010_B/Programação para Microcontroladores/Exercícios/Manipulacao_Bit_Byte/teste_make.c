#include <16F877A.h>
#fuses XT, PROTECT
#use delay(clock=4MHz)
#use rs232(baud=9600,xmit=pin_c6,rcv=pin_c7)

void main() {

   /*
   int16 valor = 6000;
   int i = 0;
   i = make8(valor,0);
   printf("Primeiro Byte: %u\r\n", i);
   // 00010111 0111000 - bin�rio do 6000 divido em dois bytes
   i = make8(valor,1);
   printf("Segundo Byte: %u\r\n", i);
   */
   
   int32 valor = 0;
   int i = 2;
   int j = 3;
   int k = 4;
   int l = 5;
   valor = make32(i,j,k,l);
   printf("Valor: %lu\r\n", valor);
   
}
