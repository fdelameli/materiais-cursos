#include "16F877A.h"
#fuses HS, PROTECT, NOLVP
#use delay(clock=20Mhz)
#include <lcd_4.c>

// declara uma função...
char leTeclado();


void main() {

   char c = ' ';
   lcd_init();
   lcd_gotoxy(1,1);
//   lcd_setcursor(1,1);

   while(true){
   
      c = leTeclado();
      
      if(c != ' ') {
         printf(lcd_putc, "%c", c);
         delay_ms(300);
      }
      
   }
   
}


// implementação da função leTeclado
char leTeclado() {
   
   // seleciona a primeira coluna do teclado
   output_high(pin_c2); 
   output_low(pin_c1);  
   output_low(pin_c0); 
   
   // resolve a leitura da primeira coluna
   if(input(pin_c3)){   
      return '1';   
   }
   if(input(pin_c4)){    
      return '4';    
   }
   if(input(pin_c5)){    
      return '7';    
   }
   if(input(pin_c6)){    
      return '*';       
   }
   
   
   // seleciona a segunda coluna do teclado
   output_low(pin_c2); 
   output_high(pin_c1);  
   output_low(pin_c0); 
   
   // resolve a leitura da segunda coluna
   if(input(pin_c3)){    
      return '2';    
   }
   if(input(pin_c4)){    
      return '5';    
   }
   if(input(pin_c5)){    
      return '8';    
   }
   if(input(pin_c6)){    
      return '0';    
   }
   
   
   // seleciona a primeira coluna do teclado
   output_low(pin_c2); 
   output_low(pin_c1);  
   output_high(pin_c0); 
   
   // resolve a leitura da primeira coluna
   if(input(pin_c3)){    
      return '3';    
   }
   if(input(pin_c4)){    
      return '6';    
   }
   if(input(pin_c5)){    
      return '9';    
   }
   if(input(pin_c6)){    
      return '#';    
   }
   
   // se nenhum botão for pressionado retorna vazio
   return ' ';
   
}
