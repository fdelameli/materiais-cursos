#line 1 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Memória EEPROM/memoriaeeprom.c"
#line 26 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Memória EEPROM/memoriaeeprom.c"
char dado;
#line 33 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Memória EEPROM/memoriaeeprom.c"
void main(void)
{
 portb=0;
 trisb=0b00000000;
 trisd=0b00000000;
 adcon1=7;
 option_reg=0b10000000;
 dado=eeprom_read(0);

 while (1)
 {

 portb.f5=1;
 portd=dado;
 delay_ms(500);

 portb.f5=0;
 portd=0b11111110;
 delay_us(10);

 if (porta.f4==0)
 {
 dado++;
 eeprom_write(0,dado);
 }

 if (porta.f5==0)
 {
 dado--;
 eeprom_write(0,dado);
 }
 }
}
