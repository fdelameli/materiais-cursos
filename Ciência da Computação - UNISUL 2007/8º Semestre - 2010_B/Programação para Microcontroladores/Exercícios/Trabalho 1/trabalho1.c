#include <16F877A.h>
#device adc=10
#fuses XT, PROTECT
#use delay(clock=4Mhz)
#use rs232(baud=9600, xmit=pin_c6, rcv=pin_c7)

#define EXAUSTOR1 pin_d0
#define EXAUSTOR2 pin_d1
#define EXAUSTOR3 pin_d2

#define PARAM_SENSOR_TEMP 0.2944
#define PARAM_SENSOR_UMID 0.0977


// Fun��o que l� determinado canal anal�gico.
int16 leAd(int canal);


void main() {

   char c = ' ';
   int temp = 0;
   
   setup_adc_ports(ALL_ANALOG); 
   setup_adc(ADC_CLOCK_INTERNAL);
   
   while(true) {
  
      if (kbhit()) {
         c = getc();
         if (c == '1') {
            output_bit(EXAUSTOR1, !input_state(EXAUSTOR1));
         } else if (c == '2') {
            output_bit(EXAUSTOR2, !input_state(EXAUSTOR2));
         } else if (c == '3') {
            output_bit(EXAUSTOR3, !input_state(EXAUSTOR3));
         }
      }
     
      // le sensor de temperatura 1
      temp = leAd(0) * PARAM_SENSOR_TEMP;
      printf("%d;", temp);
      
      // le sensor de temperatura 2
      temp = leAd(1) * PARAM_SENSOR_TEMP;
      printf("%d;", temp);
      
      // le sensor de temperatura 3
      temp = leAd(2) * PARAM_SENSOR_TEMP;
      printf("%d;", temp);
      
      // le sensor de temperatura 4
      temp = leAd(3) * PARAM_SENSOR_TEMP;
      printf("%d;", temp);
      
      // le sensor de umidade 1
      temp = leAd(4) * PARAM_SENSOR_UMID;
      printf("%d;", temp);
      
      // le sensor de umidade 2
      temp = leAd(5) * PARAM_SENSOR_UMID;
      printf("%d;", temp);
      
      // le sensor de umidade 3
      temp = leAd(6) * PARAM_SENSOR_UMID;
      printf("%d;", temp);
      
      // le sensor de umidade 4
      temp = leAd(7) * PARAM_SENSOR_UMID;
      printf("%d\r\n;", temp);
      
      delay_ms(1500);
      
   }
   
}


int16 leAd(int canal) {
   set_adc_channel(canal);
   delay_us(15);
   return read_adc();
}

