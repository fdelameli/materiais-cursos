#include <16f877a.h>
#fuses XT,PROTECT,BROWNOUT
#use delay(clock=4Mhz)
#use rs232(baud=9600,xmit=pin_c6,rcv=pin_c7)
#include <2404.c>
#include <external_eeprom.c>


void main(){
   int16 dado=0;
   init_ext_eeprom();
   //escreve no indice 0 (zero) o valor 1030
   write_int16_ext_eeprom(0,1030);
   // lê endereço 0 (zero)
   dado=read_int16_ext_eeprom(0);
   printf("Dado:%lu\r\n",dado);   
   
}
