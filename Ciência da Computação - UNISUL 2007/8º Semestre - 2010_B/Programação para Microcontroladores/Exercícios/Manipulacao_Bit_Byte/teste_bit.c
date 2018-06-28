#include <16F877A.h>
#fuses XT, PROTECT
#use delay(clock=4MHz)
#use rs232(baud=9600,xmit=pin_c6,rcv=pin_c7)
#include <stdlib.h>

void main() {

   byte var = 0b00000101;
   char comando = ' ';
   char c[2];
   int i = 0;
   
   
   while (true) {
   
     comando = getc();
     if(comando == 's') {
        printf("Bit Set:\r\n");
        gets(c);
        i=atoi(c);
        printf("Valor antigo: %u\r\n", var);
        bit_set(var,i); // bit_set(var, x) - seta o valor do bit para 1 (true)
        printf("Novo valor: %u\r\n", var); 
     }
     if(comando == 'c') {
        printf("Set Clear:\r\n");
        gets(c);
        i=atoi(c);
        printf("Valor antigo: %u\r\n", var);
        bit_clear(var,i); // bit_clear(var, x) - seta o valor do bit para 0 (false)
        printf("Novo valor: %u\r\n", var); 
     }
     if(comando == 't') {
        printf("Bit Test:\r\n");
        gets(c);
        i=atoi(c);
        if(bit_test(var,i)) { // bit_teste(var, x) - faz o teste de um bit específico - verifica se é true ou false
           printf("Bit TRUE\r\n");
        } else {
           printf("Bit FALSE\r\n");
        }
     }
      
   }

}
