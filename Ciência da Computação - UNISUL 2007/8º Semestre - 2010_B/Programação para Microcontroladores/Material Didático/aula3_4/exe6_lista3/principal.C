#include <16f877a.h>
#fuses XT,PROTECT,BROWNOUT
#use delay(clock=4Mhz)
#use rs232(baud=9600,xmit=pin_c6,rcv=pin_c7)
#include <string.h>

#define cooler pin_c2
#define rele   pin_b0

void gravaSenha(char *str);
void leSenha();

char senhaLida[7];

void main(){
   char c=' ';
   char senha[7];
   
   while(true){
      if(kbhit()){
         c=getc();
         if(c=='G'){//gravar senha 
            printf("Gravando senha\r\n");
            gets(senha);
            gravaSenha(senha);
         }
         if(c=='S'){
            printf("Lendo senha\r\n");
            gets(senha);
            leSenha();
            if((strcmp(senha,senhaLida))==0){
               printf("Senha válida\r\n");
               output_bit(cooler,1);
               delay_ms(10000);
               output_bit(cooler,0);
            }else{
               printf("Senha inválida\r\n");
               output_bit(rele,1);
               delay_ms(5000);
               output_bit(rele,0);
            }            
         }
      }
   }
}
void gravaSenha(char *str){
   int i=0;
   
   while(str[i]!='\0'){
      write_eeprom(i,str[i]);
      putc(str[i]);   
      i++;     
   }
   write_eeprom(i,str[i]);//grava /0
   leSenha();
   printf("Senha gravada:%S\r\n",senhaLida);
}
void leSenha(){
   
   char c=' ';
   int i=0;
   while(c!='\0' && i<7){      
      c=read_eeprom(i);
      senhaLida[i]=c;
      i++;
   }
   senhaLida[i]='\0';  
}
    
