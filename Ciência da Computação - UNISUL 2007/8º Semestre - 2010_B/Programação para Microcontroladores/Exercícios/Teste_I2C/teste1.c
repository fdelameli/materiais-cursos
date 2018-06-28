#include <16F877A.h>
#fuses XT, PROTECT, BROWNOUT
#use delay(clock=4MHz)
#include <2404.c>
#include <external_eeprom.c>
#use rs232(baud=9600, xmit=pin_c6, rcv=pin_c7)

void main() {
   
//   int16 dado = 0;
   float dado = 0;

   init_ext_eeprom();
   
//   write_int16_ext_eeprom(0, 1345);
//   write_int16_ext_eeprom(2, 2000);
//   dado = read_int16_ext_eeprom(0);
//   printf("Dado: %lu\r\n", dado);
//   dado = read_int16_ext_eeprom(2);
//   printf("Dado: %lu\r\n", dado);

   write_float_ext_eeprom(0, 23.43);
   printf("DADO: %.2f\r\n", dado);


//   while(true) { }

}
