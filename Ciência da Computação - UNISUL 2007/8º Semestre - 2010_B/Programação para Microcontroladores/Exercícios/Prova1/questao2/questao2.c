#include <16F877A.h>
#device adc=8 //Configurar as portas ad com 8 bits
#fuses XT, NOPROTECT
#use delay(clock=4Mhz)
#include <stdlib.h>
#use rs232(baud=9600, xmit=pin_c6, rcv=pin_c7)

int16 leAd(int canal); //Prot�tipo de fun��o
void setResistencia(boolean valor);
void setCooler(boolean valor);
void leTempMinima();
void leTempMaxima();

int16 tempMin = 0;
int16 tempMax = 150;
char temperaturaMin[4];
char temperaturaMax[4];

void main(){

   double temp = 0;
   setup_adc_ports(AN0_AN1_AN3); //Porta que est� sendo usada RA0
   setup_adc(ADC_CLOCK_INTERNAL); //Pegar o pulso do clock do cristal interno 
   


   printf("\fInforme a temperatura minima:");
   leTempMinima();
   
   printf("\fInforme a temperatura maxima:");
   leTempMaxima();
   
   while(tempMax > 150) {
      printf("\fInforme uma temperatura menor que 150C: ");
      leTempMaxima();
   }
   
   printf("\fTemperatura minima e maxima definida: [%lu]  [%lu]", tempMin,tempMax);
   delay_ms(3000);


   setResistencia(1);

   while(true){
        
      printf("%c", 0x0c); //Limpa tela no hyperterminal
      //temp = leAd(3)*0.488;
      temp = (leAd(3) * 5 * 100) / 255;
      printf("Temperatura Atual: %0.2fC\r\nStatus Cooler: %d\r\nStatus Resistencia: %d", temp, input_state(pin_c2), input_state(pin_c1));
      delay_ms(500);

     
      if(temp > tempMax){
         setCooler(1);
         setResistencia(0);
         printf("\fAcionando: Cooler\r\nDesativando: Resistencia");
         delay_ms(3000);
      } else {
         if(temp <= tempMin){
            setCooler(0);
            setResistencia(1);
            printf("\fAcionando: Resistencia\r\nDesativando: Cooler");
            delay_ms(3000);
         }
      }  
   }

}

void leTempMinima(){
   gets(temperaturaMin);
   tempMin = atoi(temperaturaMin);
}

void leTempMaxima(){
   gets(temperaturaMax);
   tempMax = atoi(temperaturaMax);    
}

int16 leAd(int canal){
   set_adc_channel(canal);
   delay_ms(15);
   return read_adc();
}

void setResistencia(boolean valor){
   if(valor)
      output_high(pin_c1);
   else
      output_low(pin_c1);
}

void setCooler(boolean valor){
   if(valor)
      output_high(pin_c2);
   else
      output_low(pin_c2);
}
