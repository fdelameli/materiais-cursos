#include <16F877A.h>
//#device adc=8 // define qual a resolu��o (configura as portas adc com 8 bits)
#device adc=10 // define qual a resolu��o (configura as portas adc com 10 bits)
#fuses XT, PROTECT
#use delay(clock=4Mhz)
#use rs232(baud=9600, xmit=pin_c6, rcv=pin_c7)

#define COOLER pin_c2
#define RESISTOR pin_c1
#define TEMP_MAX 30
#define TEMP_MIN 25


int16 leAd(int canal);


void main() {

   double temp = 0.0;
   

   // define qual porta analogica ser� usada
   //setup_adc_ports(RA0_ANALOG);
   setup_adc_ports(AN0_AN1_AN3); 
   // informa qual o pulso de clock ser� usado (nesse caso, do cristal)
   setup_adc(ADC_CLOCK_INTERNAL);

   while(true) {
      temp = leAd(3)*0.48875;
      printf("Temp: %0.2f C\r\n", temp);
      delay_ms(1000);
      printf("%c", 0x0c);
      
      if(temp >= TEMP_MAX) {
         output_bit(COOLER, 1);
         output_bit(RESISTOR, 0);
      }
         
      if(temp < TEMP_MIN) {
         output_bit(COOLER, 0);
         output_bit(RESISTOR, 1);
      }
      
   }

}

int16 leAd(int canal) {
   set_adc_channel(canal);
   delay_us(15);
   return read_adc();
}
