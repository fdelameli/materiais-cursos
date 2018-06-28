#include "16F877A.h"
#fuses hs, nolvp, protect
#use delay(clock=20Mhz)
#include <lcd_4.c>
#include <stdlib.h>
#include <math.h>

#define MAX_DISPLAY_CHAR 10 
#define TIME 300

char le_teclado(void);
boolean test_key(char c);
boolean is_oper(char c);
void refresh_display_char(char res);
void refresh_display(float res);
void reset_vector(char v[]);
void calc_functions(char op);


static float memoria;
static float numb1;
static float numb2;
static char oper;
//static char number[];

void main() {

   char c, char_ant, number[MAX_DISPLAY_CHAR];
   int pos, dot;
   float tmp;
   boolean mem;

   dot = 0;
   numb1 = 0;
   numb2 = 0;
   memoria = 0;
   oper = '0';
   mem = false;

   lcd_init();
   lcd_gotoxy(1,1);
   
   refresh_display(0);
   
   while(true) {
      
      c = le_teclado();
      
      // Apenas zera a variável de verificação
      if(char_ant == 'm' && c != 'm')
         char_ant = null;
      
      // verifica se digitou numero ou ponto
      if(test_key(c)){
         
         //somente um ponto por numero
         if ((c == '.') && dot != 1) {
            number[pos++] = c;
            dot++;
         } else if (c != '.') {
            number[pos++] = c;
         }
         
         // verifica onde deve armazenar o número
         if (pos != 0) {
            tmp = atof(number);
            if (oper == '0') {
               numb1 = tmp;
               refresh_display(numb1);
               delay_ms(TIME);
            } else {
               numb2 = tmp;
               refresh_display(numb2);
               delay_ms(TIME);
            }   
         }
      }
         
      // verifica se é um operador: ( +, -, *, / )
      if (is_oper(c)) {
         oper = c;
         pos = 0;
         // limpa o vetor
         reset_vector(number);
         delay_ms(TIME);
      }
      
      // verifica se é a tecla igual (=)
      if (c == '='){
         calc_functions(oper);
         reset_vector(number);
         pos=0;
         delay_ms(TIME);
      }
      
      if (c == '%') {
         if(oper == '+'){
            numb1 = 100 * (numb2/100 + 1);
            refresh_display(numb1);
            delay_ms(TIME);
         } else if (oper == '-') {
            numb1 = numb1 - 100 * (numb2/100);
            refresh_display(numb1);
            delay_ms(TIME);
         }
      }
         
      // verifica se é tecla limpar (ON/C)
      if (c == 'c') {
         numb1 = 0;
         numb2 = 0;
         oper = '0';
         pos = 0;
         refresh_display(0);
         reset_vector(number);
         delay_ms(TIME);
      }
         
      // verifica se a tecla de raiz quadrada
      if (c == 'r') {
         numb1 = sqrt(numb1);
         refresh_display(numb1);
         reset_vector(number);
         delay_ms(TIME);
      }
      
      // verifica se clicou em M+
      if (c == 'o') {
         // verifica se memoria está vazia
         if(memoria == 0) {
            memoria = numb1;
         } else {
            // verifica se a tecla MRC foi clicada
            if(numb1 != 0 && oper != '0' && numb2 != 0) {
               calc_functions(oper);
               memoria = numb1;
            }
            if(numb1 == 0)
               memoria += memoria;
            else
               memoria = memoria + numb1;
         }
         reset_vector(number); 
         pos = 0;
         delay_ms(TIME);
      }
      
      // verifica se clicou em M-
      if(c == 'n') {
         if(memoria != numb1)
            memoria -= numb1;
         if(memoria != 0) {
            memoria -= memoria;
         }
         delay_ms(TIME);
      }
      
      // verifica se clicou em MRC
      if(c == 'm') {
         if(char_ant == 'm'){ // verifica se já clicou duas vezes seguidas em MRC
            memoria = 0;
            char_ant = null;
         } else { // se ainda não clicou duas vezes seguidas... mostra o valor da memoria na tela
            numb1 = memoria;
            refresh_display(memoria);
            char_ant = 'm'; // armazena o caracter digitado anteriormente
         }
         delay_ms(TIME);
      }
      
      if(c == 'i'){
         numb1 *= -1;
         refresh_display(numb1);
      }
      
   }

}

/**
 * Limpa o vetor de caracteres.
 */
void reset_vector(char v[]) {
   int count;
   for(count=0; count<MAX_DISPLAY_CHAR; count++){
      v[count]=null;
   }
}

/**
 * Faz o cálculo das operações básicas matemáticas.
 */
void calc_functions(char op) {
   //definido como OK = 0 e ERRO = 1
   boolean erro = false;
   switch (op) {
      case '+' : numb1 += numb2; break;
      case '-' : numb1 -= numb2; break;
      case '*' : numb1 *= numb2; break;
      case '/' : 
         if (numb2 != 0) 
            numb1 /= numb2;
         else
            erro = true;
         break;      
   }

   if (!erro)
      refresh_display(numb1);
   else
      refresh_display_char('E'); // indica erro
}

/**
 * Testa se o caracter selecionado é um dos
 * operadores +, -, * ou /.
 */
boolean is_oper(char c) {
   if (c == '+' || c == '-' || c == '*' || c == '/')
      return true;
   return false;
}

/**
 * Testa se o caracter selecionado é um ponto ou um dígito.
 */
boolean test_key (char c){ 
   if ((c == '.') || (isDigit(c)))
      return true;
   else
      return false;
}

/**
 * Atualiza o display passando um vetor de caracteres por parâmetro.
 */
void refresh_display_char (char res){
   if(res=='E'){
      printf(lcd_putc, "\f%s", "*ERRO*");
      delay_ms(1000);
      refresh_display(0);
   } else {
      printf(lcd_putc, "\f%s", res);
   }
}

/**
 * Atualiza o display passando um float por parâmetro.
 */
void refresh_display (float res){
   printf(lcd_putc, "\f%f", res);
}

/**
 * Faz a leitura do teclado.
 */
char le_teclado() {

   output_high(pin_c0);
   output_low(pin_c1);
   output_low(pin_c2);
   output_low(pin_c3);
   
   if(input(pin_d0))
      return 'c';
   if(input(pin_d1))
      return '7';
   if(input(pin_d2))
      return '8';
   if(input(pin_d3))
      return '9';
   if(input(pin_d4))
      return '*';
   if(input(pin_d5))
      return '/';
      
      
   output_low(pin_c0);
   output_high(pin_c1);
   output_low(pin_c2);
   output_low(pin_c3);
   
   if(input(pin_d0))
      return 'i'; // retorna algo para indicar +/-
   if(input(pin_d1))
      return '4';
   if(input(pin_d2))
      return '5';
   if(input(pin_d3))
      return '6';
   if(input(pin_d4))
      return '-';
   if(input(pin_d5))
      return 'm'; // retorna algo para indicar MRC
   
   
   output_low(pin_c0);
   output_low(pin_c1);
   output_high(pin_c2);
   output_low(pin_c3);
   
   if(input(pin_d0))
      return '%'; 
   if(input(pin_d1))
      return '1';
   if(input(pin_d2))
      return '2';
   if(input(pin_d3))
      return '3';
   if(input(pin_d4))
      return '+';
   if(input(pin_d5))
      return 'n'; // retornar algo para indicar M-  
      
   
   output_low(pin_c0);
   output_low(pin_c1);
   output_low(pin_c2);
   output_high(pin_c3);
   
   if(input(pin_d0))
      return 'r';
   if(input(pin_d1))
      return '0';
   if(input(pin_d2))
      return '.';
   if(input(pin_d3))
      return '=';
   if(input(pin_d4))
      return '+';
   if(input(pin_d5))
      return 'o'; // retornar algo para indicar M+  
   
   return ' ';
}
 
