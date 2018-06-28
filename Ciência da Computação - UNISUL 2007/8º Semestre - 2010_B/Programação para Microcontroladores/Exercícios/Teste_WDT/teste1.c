#include <16F877A.h>
#fuses XT, PROTECT, BROWNOUT, WDT
#use delay(clock=4MHz)
#use rs232(baud=9600,xmit=pin_c6,rcv=pin_c7)

#define LEDS pin_b5

void causa();

void main() {

   causa();
   setup_wdt(WDT_2304MS);
   printf("Iniciado\r\n");
   output_high(LEDS);
  
   
   while(true) {
      restart_wdt();
      //getc(); // forca ele a travar e reiniciar (caso nao seja digitado nada na serial)
      sleep(); // modo dormência. Consumo 4uA
      causa();
      output_d(0x01);
      delay_ms(300);
      output_d(0x10);
   }

}

void causa(){
   switch(restart_cause()){
      case WDT_FROM_SLEEP: 
         printf("Modo Sleep!\n\r");
         break;
      case WDT_TIMEOUT: 
         printf("Estouro de Tempo!\r\n"); 
         break;
      case NORMAL_POWER_UP: 
         printf("Inicializacao Normal!\r\n"); 
         break;
      case MCLR_FROM_SLEEP: 
         printf("Reset pr MCLR!\r\n"); 
         break;
   }
}
