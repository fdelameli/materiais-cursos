#include "16F877A.h"
#fuses hs, nolvp, protect
#use delay(clock=20MHz)
#include <Lcd_4.c>

void main() {

   int16 count = 0;
   
   lcd_init();

   while(true) {
   
      lcd_gotoxy(1,1);
      printf(lcd_putc, "%s", "Insira o talao!");
      lcd_gotoxy(1,2);
      printf(lcd_putc, "Qtd: %lu", count);
      
      if(input(pin_b3)){
        output_high(pin_b0);
        delay_ms(100);
        output_low(pin_b0);
        output_high(pin_b1);
        delay_ms(100);
        output_low(pin_b1);
        count++;
            
        lcd_gotoxy(1,1);
        printf(lcd_putc, "\f%s", "Talao Grampeado!");
        delay_ms(2000);
        lcd_putc('\f');
      } 
   }

}
