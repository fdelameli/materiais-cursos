#include <16F877A.h>
#fuses XT, PROTECT
#use delay(clock=4MHz)
#use rs232(baud=9600,xmit=pin_c6,rcv=pin_c7)
#include <string.h>


void main() {
   
   signed int n = 0;
   char c;
   char s[10], outro[10];
 
   while(true) {
  
      //c = getc();
      //gets(s);
      
      /*
      printf("%S --> Tamanho: %u\r\n", s, strlen(s)); // imprime o tamanho da string digitada
      */
      
      /*
      strcpy(s, "Testando"); // copia uma string para um vetor de caracteres
      printf("%S\r\n", s);
      strncpy(outro, s, 6)/ // copia uma string at� a 6� posicao para um vetor de caracteres
      printf("%S\r\n", outro);
      // compara duas strings 
      // se as strings forem iguais retorna 0 | Se for maior retorna numero positivo | Sen�o retorna numero negativo
      n = strcmp(s,outro);
      if(n == 0) {
         printf("Iguais\r\n");
      } else if (n > 0) {
         printf("Diferentes e maior\r\n");
      } else if (n < 0) {
         printf("Diferentes e menor\r\n");
      }
      delay_ms(10000);
      */
      
      /*
      if(isalnum(c)){ // verifica se uma string � num�rica
         printf("String numerica\r\n"); 
      } else {
         printf("String nao numerica\r\n");
      }
      */
      /*
      if(isalpha(c)){ // verifica se uma string � alfanum�rica
         printf("String alfanumerica\r\n"); 
      } else {
         printf("String nao alfanumerica\r\n");
      }
      */
      /*
      if(isdigit(c)){ // verifica se � um d�gito
         printf("E um digito\r\n"); 
      } else {
         printf("Nao e um digito\r\n");
      }
      */
      /*
      if(iscntrl(c)){ // verifica se um caracter de controle {ENTER, ESC, BACKSPACE...}
         printf("Caracter de controle\r\n"); 
      } else {
         printf("Nao e caracter de controle\r\n");
      }
      */
      /*
      if(islower(c)){ // verifica se � minusculo
         printf("Minusculo\r\n"); 
      } else {
         printf("Mauisculo\r\n");
      }
      */
      /*
      if(ispunct(c)){ // verifica se um caracter especial {!, @, #, $...}
         printf("Especial\r\n"); 
      } else {
         printf("Nao especial\r\n");
      }
      */
      /*
      if(isamoung(c, "*-pos%12)")){ // verifica se um cont�m um caracter dentro da String passada
         printf("Contem\r\n"); 
      } else {
         printf("Nao contem\r\n");
      }
      */
  
   }
   
}
