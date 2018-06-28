#include "16F877A.h"
#fuses HS, NOLVP, PROTECT
#use DELAY(CLOCK=20MHZ)
#include <lcd_4.c>
#include <stdlib.h>

char leTeclado();

char new[2];

void main() {

   char c = ' ';
   int qtd = 0;
   int hora = 0;
   int minuto = 0;
   int segundo = 0;
   
   lcd_init();

   while(true){
      qtd = 0;
     
      // altera a hora do relógio
      while(input(pin_a0)) {
         if(qtd!=2){
            lcd_gotoxy(1,1);
            lcd_setcursor(1,1);
         }
         while(qtd!=2){
            c = leTeclado();
            if(c!=' '){
               new[qtd] = c;
               qtd++;
               lcd_gotoxy(qtd,1);
               printf(lcd_putc, "%c", c);
               delay_ms(300);
            }
         }
         if(qtd==2){
            hora = strtol(new,null,0);
            lcd_setcursor(0,0);
         }
      }//
      
      // altera os minutos do relógio
      while(input(pin_a1)) {
         if(qtd!=2){
            lcd_gotoxy(4,1);
            lcd_setcursor(1,1);
         }
         while(qtd!=2){
            c = leTeclado();
            if(c!=' '){
               new[qtd] = c;
               qtd++;
               lcd_gotoxy(qtd+3,1);
               printf(lcd_putc, "%c", c);
               delay_ms(300);
            }
         }
         if(qtd==2){
            minuto = strtol(new,null,0);
            lcd_setcursor(0,0);
         }
      }//


      // Exibe a hora no display.
      lcd_gotoxy(1,1);
      printf(lcd_putc, "%02u:%02u:%02u", hora, minuto, segundo);   

      if(++segundo == 60){
        if(++minuto == 60){
           if(++hora == 24){
              hora = 0;
           }
           minuto = 0;
        }
        segundo = 0;
      }
      delay_ms(1000);
   }
   
}


// Faz a leitura di teclado.
char leTeclado(){
  
   output_high(pin_c2); 
   output_low(pin_c1);
   output_low(pin_c0);
   
   if(input(pin_c3))
      return '1';
   if(input(pin_c4))
      return '4';
   if(input(pin_c5))
      return '7';
   if(input(pin_c6))
      return '*';
   
   
   output_low(pin_c2); 
   output_high(pin_c1);
   output_low(pin_c0);
   
   if(input(pin_c3))
      return '2';
   if(input(pin_c4))
      return '5';
   if(input(pin_c5))
      return '8';
   if(input(pin_c6))
      return '0';
   
   
   output_low(pin_c2); 
   output_low(pin_c1);
   output_high(pin_c0);
   
   if(input(pin_c3))
      return '3';
   if(input(pin_c4))
      return '6';
   if(input(pin_c5))
      return '9';
   if(input(pin_c6))
      return '#';
   
   return ' ';
}
