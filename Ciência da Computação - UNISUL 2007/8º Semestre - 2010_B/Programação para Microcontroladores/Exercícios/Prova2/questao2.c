#include <16F877A.h>
#fuses XT,PROTECT,BROWNOUT,NOWDT
#use delay(clock=4Mhz)
#use rs232(baud=9600,xmit=pin_c6,rcv=pin_c7)
#include <stdlib.h>

void setarBits();
void setarRolagem();

char bit = ' ';
char rolar = ' ';
byte valor = 0b00000000;
long i = 0;

void main(){

   byte valorAnt = 0b00000000;
   char opcao = 'S';

   while(true){
      if(opcao == 'S'){
         output_b(0x00);
         valor = 0b00000000;
         printf("\r\n\r\nValor inicial da porta: %d", valor);
         setarBits();
         setarRolagem();   
      } else {
         setarRolagem();
      }
      
      
      if(rolar == 'E'){           
         valorAnt = valor;
         do{
            rotate_left(&valor, 1);
            printf("\r\nRolando Bit para Esquerda: %u", valor);
            output_b(valor);
            delay_ms(1000);
         }while(valorAnt != valor);
      } 
      if (rolar == 'D'){
         valorAnt = valor;
         do{
            rotate_right(&valor, 1);
            printf("\r\nRolando Bit para Direita: %u", valor);
            output_b(valor);
            delay_ms(1000);
         }while(valorAnt != valor);
      }

      do{
         printf("\r\nDeseja modificar os valores atuais? Sim [S] / Nao [N]");
         opcao = getc();
      }while(opcao != 'N' && opcao != 'S')   ;

   }
}

void setarBits(){
      printf("\r\nDigite o numero do bit a ser setado pra true: ");
      gets(bit);
      printf("\r\nSetado pino %s para true!", bit);
      i=atol(bit);
      bit_set(valor, i);
      printf("\r\nValor atual da porta: %u", valor);
      output_b(valor);
}

void setarRolagem(){
      printf("\r\nDeseja rolar o bit para direita [D] ou para esquerda [E]? ");
      rolar = getc();
      if(rolar == 'E')
         printf("\r\nSetado rolagem para Esquerda [E]!");
      else 
         printf("\r\nSetado rolagem para Direita [D]!"); 
      
}

