#line 1 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Ad/ad.c"
#line 23 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Ad/ad.c"
int leitura_ad;
char string_ad[5];
#line 31 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Ad/ad.c"
void main(void)
{
 adcon1=0b10000100;
 adcon0=0b01000001;
 trisa=0b11111111;
 trisd=0b00000000;
 trise=0b00000001;
 option_reg=0b10000000;
 Lcd8_Config(&PORTE, &PORTD, 2, 1, 3, 7, 6, 5, 4, 3, 2, 1, 0);
 Lcd8_Cmd(LCD_CLEAR);
 Lcd8_Cmd(LCD_CURSOR_OFF);
 Lcd8_out(1, 3, "Voltimetro");


 while(1)
 {
 leitura_ad= ADC_read(0);
 wordtostr(leitura_ad,string_ad);
 strcat(string_ad,"uad");
 Lcd8_out(2,3,string_ad);
 }
}
