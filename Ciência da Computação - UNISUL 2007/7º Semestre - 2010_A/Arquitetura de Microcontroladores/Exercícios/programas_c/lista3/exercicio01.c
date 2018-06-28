#include <16F877A.h>
#fuses xt, nolvp, protect
#use delay(clock=4Mhz)

byte display [10];
int TIME = 100;

void main() {

   int opcao = 0; // 0 = soma; 1 = subtração; 2 = multiplicação; 3 = divisão //
   int numero1 = 0;
   int numero2 = 0;
   int resultado = 0;
   int aux = 0;
   
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
   
      // não sai do loop enquanto não escolher uma opção.
      /*while (true) { 
         if(input(pin_a1)) {
            opcao = 0;
            break;
         }
         if(input(pin_a2)) {
            opcao = 1;
            break;
         }
         if(input(pin_a3)) {
            opcao = 2;
            break;
         }
         if(input(pin_a5)) {
            opcao = 3;
            break;
         }
      }
      
      
      while(!input(pin_e0));
     
      // pega o primeiro valor de entrada na porta c
      numero1 = input_c();
      
      // pega o segundo valor de entrada na porta d
      numero2 = input_d();
      
      // efetua a operação de acordo com a opção selecionada
      switch(opcao) {
         case 0 : resultado = numero1 + numero2; break;
         case 1 : resultado = numero1 - numero2; break;
         case 2 : resultado = numero1 * numero2; break;
         case 3 : resultado = numero1 / numero2; break;
      }
      */
      resultado=12;
      while (true) {
      
         output_b(display[resultado/100]);
         output_low(pin_a0);
         delay_us(TIME);
         output_high(pin_a0);
         
         output_b(display[resultado/10]);
         output_low(pin_e2);
         delay_us(TIME);
         output_high(pin_e2);
         
         output_b(display[resultado%10]);
         output_low(pin_e1);
         delay_us(TIME);
         output_high(pin_e1);
         
         //output_b(resultado);
         
      }
      
   }

}
