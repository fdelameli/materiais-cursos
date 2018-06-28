#include <16F877A.h>
#fuses XT, PROTECT
#use delay(clock=4Mhz)
#include <Lcd_4.c>
#include <stdlib.h>
#use rs232(baud=9600, xmit=pin_c6, rcv=pin_c7)

#define setLed pin_b5

void main() {

   int valor = 0;
   char v1[4];

   lcd_init();
   lcd_gotoxy(0,0);
   output_bit(setLed,1);
   output_d(0x00);

   while(true) {

      gets(v1);
      valor = atoi(v1);

      printf(lcd_putc, "\f%u", valor);
      output_d(valor);


   
   }

}

