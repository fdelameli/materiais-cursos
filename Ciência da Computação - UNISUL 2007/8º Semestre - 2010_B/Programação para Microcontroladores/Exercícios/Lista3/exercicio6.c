#include <16f877a.h>
#fuses XT,PROTECT,BROWNOUT
#use delay(clock=4Mhz)
#use rs232(baud=9600,xmit=pin_c6,rcv=pin_c7)

#include <string.h>

#define COOLER pin_c2;
#define RELE pin_b0;

void liga_cooler(int16 time);
void liga_rele(int16 time);
void grava_senha(char *str);
void le_senha();

char senhaLida[7]; //senha lida da eeprom

void main() {
   char c = ' ';
   char senha[7];

   while(true) {
      
      if(kbhit()) {
      
         c = getc();
         
         if(c == 'G') {
            printf("Digite a senha: ");
            gets(senha);
            grava_senha(senha);
         }
         
         if(c == 'S') {
            printf("Digite a senha: ");
            gets(senha);
            le_senha();
            if((strcmp(senha, senhaLida)) == 0) {
               printf("Senha correta!\r\n");
               liga_cooler(10000);
            } else {
               printf("Senha incorreta!\r\n");
               liga_rele(5000);
            }
         }
         
      }
      
   }

}

// Liga o cooler por um determinado tempo
void liga_cooler(int16 time) {
   output_bit(pin_c2, 1);
   printf("Cooler ligado!\r\n");
   delay_ms(time);
   output_bit(pin_c2 0);
   printf("Cooler desligado!\r\n");
}

// Liga o rele por um determinado tempo
void liga_rele(int16 time) {
   output_bit(pin_b0, 1);
   printf("Rele ativado!\r\n");
   delay_ms(time);
   output_bit(pin_b0, 0);
   printf("Rele desativado!\r\n");
}

// Grava a senha na Eeprom
void grava_senha(char *str) {
   int i = 0;
   while(str[i] != '\0') {
      write_eeprom(i, str[i]);
      i++;
   }
   write_eeprom(i, str[i]); // grava '\0'
   le_senha();
   printf("Senha gravada: %S\r\n", senhaLida);
}

// L� a senha da Eeprom
void le_senha() {
   int i = 0;
   char c = ' ';
   while(c != '\0' && i < 7) {
      c = read_eeprom(i);
      senhaLida[i] = c;
      i++;
   }
   senhaLida[i] = '\0';
}
