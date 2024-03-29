#include <16f877a.h>
#device adc=8
#fuses XT,PROTECT,BROWNOUT
#use delay(clock=4Mhz)
#use rs232(baud=9600,xmit=pin_c6,rcv=pin_c7)

int leAd(int canal);

void main(){
    int trimpot_1,trimpot_2;
    trimpot_1=trimpot_2=0;
    setup_adc_ports(RA0_RA1_RA3_ANALOG);
    setup_adc(ADC_CLOCK_INTERNAL);
    printf("Iniciado\r\n");
    while(true){
      trimpot_1=leAd(0);
      printf("Canal 0: %u\r\n",trimpot_1);
      delay_ms(500);
      if((trimpot_1>=200) && (trimpot_1<=210)){
         printf("Sinal alto no canal 0\r\n");
         printf("While canal 0\r\n");
         while((trimpot_1>=200) && (trimpot_1<=210)){
            trimpot_1=leAd(0);
            printf("Canal 0: %u\r\n",trimpot_1);
            delay_ms(500);
         }
         printf("Saiu while canal 0\r\n");
      }
      trimpot_2=leAd(1);
      if((trimpot_2>=20) && (trimpot_2<=100)){
         printf("Sinal baixo no canal 1\r\n");
         while((trimpot_2>=20) && (trimpot_2<=100)){
            trimpot_2=leAd(1);
         }
      }
    }
   
}
int leAd(int canal){
   set_adc_channel(canal);
   delay_us(15);
   return read_adc();
   
}
