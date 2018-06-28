#include <16F877A.h>
//#device adc=8 // define qual a resolução (configura as portas adc com 8 bits)
#device adc=10 // define qual a resolução (configura as portas adc com 10 bits)
#fuses XT, PROTECT
#use delay(clock=4Mhz)
#use rs232(baud=9600, xmit=pin_c6, rcv=pin_c7)

int16 leAd(int canal);


void main() {

   // define qual porta analogica será usada
   //setup_adc_ports(RA0_ANALOG);
   setup_adc_ports(AN0_AN1_AN3); 
   // informa qual o pulso de clock será usado (nesse caso, do cristal)
   setup_adc(ADC_CLOCK_INTERNAL);

   while(true) {
      printf("AD0: %lu\r\n", leAd(0));
      printf("AD1: %lu\r\n", leAd(1));
      delay_ms(1000);
      printf("%c", 0x0c);
   }

}

int16 leAd(int canal) {
   set_adc_channel(canal);
   delay_us(15);
   return read_adc();
}
