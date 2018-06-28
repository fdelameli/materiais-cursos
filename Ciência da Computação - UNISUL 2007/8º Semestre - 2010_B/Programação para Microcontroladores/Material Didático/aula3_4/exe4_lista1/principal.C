#include <16f877a.h>
#fuses XT,PROTECT,BROWNOUT
#use delay(clock=4Mhz)
#use rs232(baud=9600,xmit=pin_c6,rcv=pin_c7)
#include <stdlib.h>
#define setLeds pin_b5
void main(){
   char c=' ';
   output_bit(pin_b5,1);
   
   while(true){
      if(kbhit()){
         c=getc();
         switch(c){
            case 'L':
               output_d(0x00);
            break;
            case '0':
               output_bit(pin_d0,!input_state(pin_d0));              
            break;
            case '1':
              output_bit(pin_d1,!input_state(pin_d1));
            break;
            
         }
      }
   }
}
    
