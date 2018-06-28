#include <16f877a.h>
#fuses HS, PROTECT, BROWNOUT
#use delay(clock=4Mhz)
#use rs232(baud=9600, xmit=pin_c6, rcv=pin_c7)
#include <internal_eeprom.c>

void main() {
   char c[];
   
   while(true) {
   
      if(kbhit()) {
         c=getc();
      }
      
      if(c == 'e') { // escrever
         write_int16_eeprom(0, 300);
         printf("Escreveu\r\n");
         c=' ';
      }
      
      if(c == 'l') { //ler
         printf("%lu\r\n", read_int16_eeprom(0));
         c=' ';
      }
   }  
}
