#include "16F877A.h"
#fuses HS,PROTECT,NOLVP
#use delay(clock=20Mhz)
#include <lcd_4.c>

char leTeclado();
boolean verificaSenha();
char senha[4];
char senhaDigitada[4];

void main(){

   char c = ' ';
   int qtd = 0;

   senha[0] = '1';
   senha[1] = '2';
   senha[2] = '3';
   senha[3] = '4';
   
   lcd_init();
   lcd_gotoxy(1,1);
   lcd_setcursor(1,1);
   
   while(true) {
   
   //verifica se foi obtido 4 d�gitos
   if(qtd==4) { 
      lcd_putc('\f');
      if(verificaSenha()){
         printf(lcd_putc,"%S"," SENHA CORRETA! ");
         output_high(pin_d0);
      }else{
         printf(lcd_putc,"%S","SENHA INCORRETA!");
         output_high(pin_d1);
      }
      delay_ms(2000);
      lcd_putc('\f');
      output_low(pin_d0);
      output_low(pin_d1);
      qtd=0;
   }
   
   
   c = leTeclado();
   if(c!=' '){
      senhaDigitada[qtd] = c;
      printf(lcd_putc,"%C",'*');
      delay_ms(300);
      qtd++;
   }
   
   
 /*  
   
      // l� senha digitada pelo usu�rio
      for(i=0;i<4;i++){
         c = leTeclado();
         if(c!=' '){
            senhaDigitada[i] = c;
            printf(lcd_putc,"%C",'*');
            delay_ms(100);
         }
      }
      
      if(senhaDigitada[0]==senha[0] && senhaDigitada[1]==senha[1] && 
         senhaDigitada[2]==senha[2] && senhaDigitada[3]==senha[3]){
         
         lcd_putc('\f');
         printf(lcd_putc,"%C",'*');
         
      
      }
   
   */   
   
   }

 
}


// verifica se a senha digitada corresponde � senha do sistema
boolean verificaSenha() {
   if(senhaDigitada[0]==senha[0] && senhaDigitada[1]==senha[1] && 
      senhaDigitada[2]==senha[2] && senhaDigitada[3]==senha[3])
      return true;
      
   return false;
}


// faz a leitura do teclado.
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
