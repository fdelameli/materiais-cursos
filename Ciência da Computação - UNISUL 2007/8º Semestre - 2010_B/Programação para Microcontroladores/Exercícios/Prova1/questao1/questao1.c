#include <16F877A.h>
#device adc=10
#fuses XT, PROTECT
#use delay(clock=4Mhz)
#include <2404.c>
#include <external_eeprom.c>
#use rs232(baud=9600, xmit=pin_c6, rcv=pin_c7)

#define DELAY 5000
#define RESISTENCIA pin_c1


int16 leAd(int canal);


void main() {

   int16 temp = 0;
   int ADDRESS = 0; // endere�o onde ser� guardado a temperatura na memoria externa.
   int i = 0;
   
   init_ext_eeprom();

   // define qual porta analogica ser� usada
   // setup_adc_ports(RA0_ANALOG);
   setup_adc_ports(AN0_AN1_AN3); 
   setup_adc(ADC_CLOCK_INTERNAL);

   printf("\f");
   printf("Obtendo informacoes de temperatura!\r\nAguarde...\r\n");
   output_bit(RESISTENCIA, 1); // liga a resistencia.

   while(ADDRESS < 20) {
      temp = leAd(3)*0.48875;
      write_int16_ext_eeprom(ADDRESS, temp);
      ADDRESS += 2;
      delay_ms(DELAY);
   }
   
   for(i = 0; i < 20; i+=2) {
      temp = read_int16_ext_eeprom(i);
      printf("Temp. %d: %.2luC\r\n", i/2+1, temp);
   }

   printf("Programa finalizado!\r\n");
   output_bit(RESISTENCIA, 0); // desliga a resistencia.

}

// Faz a leitura de um canal anal�gico
int16 leAd(int canal) {
   set_adc_channel(canal);
   delay_us(15);
   return read_adc();
}
