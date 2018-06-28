#include "16F877A.h"
#fuses HS,PROTECT,NOLVP
#use delay(clock=20Mhz)
#include <lcd_4.c>

void main() {

   lcd_init();
   lcd_gotoxy(1,1);

   while(true){
   
       if(input(pin_a1)){
          output_high(pin_a0);
          printf(lcd_putc, "%S", "CHAVE ATIVADA!");
          delay_ms(5000);
          output_low(pin_a0);
          lcd_putc('\f');
       }
   
   }

}
