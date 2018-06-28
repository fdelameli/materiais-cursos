#include <16F877A.h>
#fuses XT, PROTECT
#use delay(clock=4MHz)
#use rs232(baud=9600,xmit=pin_c6,rcv=pin_c7)

// define a prioridade das interrupções
#priority int_ext, int_rda

// colocando esta diretiva, o compilador entende que toda 
// interrupção gerada ao receber dados do canal serial vai 
// ser tratada pelo bloco de código abaixo.
#int_rda 
void serial() {
   putc(getc());
}

// ocorre quando o pino B0 detectar um sinal alto - rampa de subida
#int_ext
void externa() {
   output_high(pin_b1);
   delay_ms(500);
   output_low(pin_b1);
   delay_ms(500);
}


void main() {

   // habilitação recepção de dados  no canal serial
   enable_interrupts(int_rda);
   
   // habilitação de interrupções externas
   enable_interrupts(int_ext);
   
   // define se a interrução vai ser na rampa de subida ou descida
   // o padrão é L_TO_H (LOW TO HIGH - rampa de subida)
   ext_int_edge( H_TO_L );
   
   // habilitação da chave geral das interrupções
   enable_interrupts(global);
   
   while(true) {

   }

}
