#include <16F877A.h>
#fuses XT, PROTECT
#use delay(clock=4MHz)
#use rs232(baud=9600,xmit=pin_c6,rcv=pin_c7)

// colocando esta diretiva, o compilador entende que toda 
// interrupção gerada ao receber dados do canal serial vai 
// ser tratada pelo bloco de código abaixo.
#int_rda 
void serial() {
   putc(getc());
}


void main() {

   // habilitação recepção de dados  no canal serial
   enable_interrupts(int_rda);
   
   // habilitação da chave geral das interrupções
   enable_interrupts(global);
   
   while(true) {
      
   }

}
