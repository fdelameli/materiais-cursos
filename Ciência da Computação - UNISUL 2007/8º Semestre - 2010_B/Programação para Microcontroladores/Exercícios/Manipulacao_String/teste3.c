#include <16F877A.h>
#fuses XT, PROTECT
#use delay(clock=4MHz)
#use rs232(baud=9600,xmit=pin_c6,rcv=pin_c7)
#include <string.h>
#include <stdlib.h>

void main() {

   /*
   // quebra uma string em partes de acordo com o par�metro passado
   // funciona do mesmo jeito que o split no java.
   char string[30], term[3], *ptr;
   strcpy(string, "um,dois,tres;");
   strcpy(term, ",;");
   ptr = strtok(string, term);
   
   while(ptr != 0) {
     printf("%s\r\n", ptr);
     ptr = strtok(0, term);
   }
   */
   
   /*
   char str[20];
   while(true) {
      // concatena os dados dentro de um vetor de caracteres
      sprintf(str, "%d, %d, %f;", input(pin_b0), input(pin_b1), 20.30);
      printf("%s", str);
      delay_ms(2000);
   }
   */
   
   /*
   float result;
   char str[12] = "123.45Oi";
   char *ptr;
   result = strtod(str, &ptr);
   printf("%f\r\n", result);;
   printf("%s\r\n", ptr);
   */
   
   
   char str[20], str1[10];
   strcpy(str, "Test");
   strcpy(str1, "ando...");
   //strncat(str, str1, 5); // copia os 5 primeiro caracteres da string
   strncat(str, str1, strlen(str1)); // copia todos os caracteres da string
   printf("%s", str);

}
