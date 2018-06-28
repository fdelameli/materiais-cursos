#include <16F877A.h>
#fuses XT, PROTECT
#use delay(clock=4MHz)
#use rs232(baud=9600,xmit=pin_c6,rcv=pin_c7)

#define TIME_DELAY 500

int old_values[4];

#int_rb 
void interrupt_on_change() {
   
   if(old_values[0] != input(pin_b4)) {
      printf("%s\r\n", "Pino B4 sofreu mudan�a de estado!");
      old_values[0] = input(pin_b4);
   } else if(old_values[1] != input(pin_b5)) {
      printf("%s\r\n", "Pino B5 sofreu mudan�a de estado!");
      old_values[1] = input(pin_b5);
   } else if(old_values[2] != input(pin_b6)) {
      printf("%s\r\n", "Pino B6 sofreu mudan�a de estado!");
      old_values[2] = input(pin_b6);
   } else if(old_values[3] != input(pin_b7)) {
      printf("%s\r\n", "Pino B7 sofreu mudan�a de estado!");
      old_values[3] = input(pin_b7);
   }
   
}


void main() {

   old_values[0] = input(pin_b4);
   old_values[1] = input(pin_b5);
   old_values[2] = input(pin_b6);
   old_values[3] = input(pin_b7);
   
   enable_interrupts(global | int_rb);
   
   while(true) {
      output_bit(pin_d7, 1);
      delay_ms(TIME_DELAY);
      output_bit(pin_d7, 0);
      output_bit(pin_d6, 1);
      delay_ms(TIME_DELAY);
      output_bit(pin_d6, 0);
      output_bit(pin_d5, 1);
      delay_ms(TIME_DELAY);
      output_bit(pin_d5, 0);
   }

}
