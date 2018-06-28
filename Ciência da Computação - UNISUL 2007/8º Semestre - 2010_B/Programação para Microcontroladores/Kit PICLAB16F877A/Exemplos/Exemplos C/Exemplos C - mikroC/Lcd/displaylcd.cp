#line 1 "C:/Cerne/CD Revisado 2007/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Lcd/displaylcd.c"
#line 17 "C:/Cerne/CD Revisado 2007/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Lcd/displaylcd.c"
void main(void)
{
 delay_ms(2000);

 trisd=0b00000000;
 trise=0b00000000;
 adcon1=0b00000111;

 Lcd8_Config(&PORTE, &PORTD, 2, 1, 0, 7, 6, 5, 4, 3, 2, 1, 0);
 Lcd8_Init(&PORTE,&PORTD);
 Lcd8_Cmd(LCD_CLEAR);
 Lcd8_Cmd(LCD_CURSOR_OFF);

 while(1)
 {
 lcd8_cmd(lcd_clear);
 lcd8_out(2,1,"Cidade: Roma");
 delay_ms(1000);

 lcd8_cmd(lcd_clear);
 lcd8_out(2,1,"Cidade: Paris");
 delay_ms(1000);

 lcd8_cmd(lcd_clear);
 lcd8_out(2,1,"Cidade: Berlin");
 delay_ms(1000);
 }

}
