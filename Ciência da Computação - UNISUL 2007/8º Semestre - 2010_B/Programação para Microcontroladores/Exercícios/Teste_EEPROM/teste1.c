#include <16f877a.h>
#fuses HS, PROTECT, BROWNOUT
#use delay(clock=4Mhz)
#use rs232(baud=9600, xmit=pin_c6, rcv=pin_c7)

void main() {
   int i=0;
   char c[];
   char nome[] = {"Fabio\0"};
   
   while(true) {
      if(kbhit()) {
         c=getc();
      }
      if(c == 'e') { // escrever
         i=0;
         while(nome[i] != '\0') {
            write_eeprom(i,nome[i]);
            i++;
         }
         write_eeprom(i, '\0');
         c=' ';
         printf("Escreveu\r\n");
      }
      if(c == 'l') { //ler
         i=0;
         while((c=read_eeprom(i)) != '\0') {
            printf("%C", c);
            i++;
         }
         c=' ';
      }
   }  
}
