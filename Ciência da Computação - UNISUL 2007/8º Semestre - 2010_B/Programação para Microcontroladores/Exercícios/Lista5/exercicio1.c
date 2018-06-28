#include <16F877A.h>
#fuses XT, PROTECT
#use delay(clock=4MHz)
#use rs232(baud=9600,xmit=pin_c6,rcv=pin_c7)


void main() {

   setup_ccp1(CCP_PWM);
   setup_timer_2(T2_DIV_BY_4, 9, 1);

   while(true) {

      if(input(pin_a0))
         set_pwm1_duty(1000); // 25%
      if(input(pin_a1))         
         set_pwm1_duty(2000); // 50%
      if(input(pin_a2))
         set_pwm1_duty(3000); // 75%
     
      
   }
}

