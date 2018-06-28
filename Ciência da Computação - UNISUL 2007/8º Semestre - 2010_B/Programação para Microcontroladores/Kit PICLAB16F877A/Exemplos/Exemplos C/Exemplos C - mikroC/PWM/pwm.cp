#line 1 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/PWM/pwm.c"
#line 22 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/PWM/pwm.c"
int leitura_ad;
char string_ad[5];
#line 35 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/PWM/pwm.c"
void main(void)
{
 adcon1=0b10000100;
 adcon0=0b01000001;
 trisa=0b11111111;
 trisc=0b00000000;
 trisd=0b00000000;
 trise=0b00000001;
 option_reg=0b10000000;
 Lcd8_Config(&PORTE, &PORTD, 2, 1, 3, 7, 6, 5, 4, 3, 2, 1, 0);
 Lcd8_Cmd(LCD_CLEAR);
 Lcd8_Cmd(LCD_CURSOR_OFF);
 Lcd8_out(1, 3, "Duty-Cycle");
 Pwm_Init(1000);
 Pwm_Start();


 while (1)
 {
 leitura_ad= ADC_read(0) / 4;
 Pwm_Change_Duty(leitura_ad);
 leitura_ad=(leitura_ad * 100)/255;
 wordtostr(leitura_ad,string_ad);
 strcat(string_ad," %");
 Lcd8_out(2,5,string_ad);
 }
}
