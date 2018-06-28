#include <16F877A.h>
#fuses XT, PROTECT
#use delay(clock=4MHz)
#use rs232(baud=9600,xmit=pin_c6,rcv=pin_c7)
#include <string.h>
#byte RCSTA=0x18 // #byte significa que vai mexer em um endere�o na mem�ria RAM


void main() {
   
   char c[10], *ptr; // � preciso declarar um ponteiro, pois em c, n�o � poss�vel atribuir a modifica��o de uma string a ela mesma
   
   while(true) {
      printf("%u\r\n", RCSTA); //mostra o valor do endere�o de memoria 0x18
      // para indicar que o programa est� rodando
      output_bit(pin_b0,1);
      delay_ms(1000);
      output_bit(pin_b0,0);
      delay_ms(1000);
   
      if(kbhit()) {
         // CONVERTE UM CARACTER PARA CAIXA ALTA 
         // (O MESMO PODE SER FEITO PARA CAIXA BAIXA USANDO A FUN��O tolower())
         /*c = getc();
         putc(c);
         putc(0xD0); // valor hexadecimal do [\n]
         putc(0x10); // valor hexadecimal do [\r]
         c = toupper(c);
         putc(c);
         putc(0xD0); // valor hexadecimal do [\n]
         putc(0x10); // valor hexadecimal do [\r]
         */
         
         // CONVERTE UMA STRING PARA CAIXA BAIXA
         // (TAMB�M PODE-SE CONVERTER PARA CAIXA ALTA USANDO A FUN��O str)
         gets(c);
         puts(c);
         ptr = strlwr(c); // converte uma string por inteiro para caixa baixa
         puts(ptr);
         strcpy(c, ptr); // copia o conte�do de um ponteiro para o vetor de caracteres
         puts(c);
      }
      
      printf("%u\r\n", RCSTA);
      
      // para resetar
      if(input(pin_b1)) {
         RCSTA &= 0xEf; //opera��o bin�ria 'E' bit a bit
         RCSTA |= 0x10; //opera��o bin�ria 'OU' bit a bit
      }
      
   }
  
}


