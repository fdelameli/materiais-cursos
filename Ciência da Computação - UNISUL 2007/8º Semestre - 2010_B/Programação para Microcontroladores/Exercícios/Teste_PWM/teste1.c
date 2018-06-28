#include <16F877A.h>
#fuses XT, PROTECT, BROWNOUT 
#use delay(clock=4Mhz)
#use rs232(baud=9600,xmit=pin_c6,rcv=pin_c7)

void main() {
   setup_ccp1(CCP_PWM);
   
   // frequencia=5Khz
   // PWM=(PR2+1)*4*Tosc*TMR2 Prescale
   // 1/5Khz=(PR2+1)*4*(1/4.000.000)*4
   // 0,0000002=(PR2+1)*4*0,00000025*4
   // 0,0000002=(PR2+1)0,000004
   // PR2=20-1 = 19 Per�odo
   setup_timer_2(T2_DIV_BY_4,19,1);
   
   // resolucao
   // 1/F_PWM=2^pwm_resolution*4*(Tosc)*Prescale
   // 1/5Khz=2^pwm_resolution*4*(1/4.000.000)*4
   // 0.2=2^pwm_resolution*0,000004
   // log(50000)=pwm_resolution*log(2)
   // 4.7pwm_resolution*0,3
   // aproximadamente 15 bits
   
   // duty_cycle=Fosc*(F_PWM*TRM2 Prescale)
   // duty_cycle=4.000.000(5.000*4)
   // duty_cycle_maximo=200
   while(true) {
      set_pwm1_duty(5);
   }


}
