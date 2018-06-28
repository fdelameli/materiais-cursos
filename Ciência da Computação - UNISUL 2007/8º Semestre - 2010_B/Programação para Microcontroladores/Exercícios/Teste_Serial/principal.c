#include <16F877A.h>
#fuses  HS,PROTECT,NOWDT
#use delay(clock=8Mhz)//velocidade do cristal
#use rs232(baud=9600,xmit=pin_c6,rcv=pin_c7)

void main(){
    char c=' ';
    while(true){
      if(kbhit()){
         c=getc();
         if(c=='L'){
            output_high(pin_b0);
            printf("Ligado\r\n");
         }
         if(c=='D'){
            output_low(pin_b0);
            printf("Desligado\r\n");
         }
      }
    }
}

   

    




    
   

