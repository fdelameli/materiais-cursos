#line 1 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Recepção Serial/recepcao.c"
#line 24 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Recepção Serial/recepcao.c"
char linha,coluna;
char recepcao;
#line 32 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Recepção Serial/recepcao.c"
void main(void)
{
 trisa=0b11111111;
 trisd=0b00000000;
 trise=0b00000001;
 adcon1=7;
 option_reg=0b10000000;
 Lcd8_Config(&PORTE, &PORTD, 2, 1, 3, 7, 6, 5, 4, 3, 2, 1, 0);
 Lcd8_Cmd(LCD_CLEAR);
 Lcd8_Cmd(LCD_CURSOR_OFF);
 Usart_Init(9600);
 linha=1;
 coluna=1;

 while(1)
 {
 if (usart_data_ready())
 {
 recepcao=Usart_Read();
 Usart_Write(recepcao);
 Lcd8_Chr(linha,coluna,recepcao);
 coluna=coluna+1;
 if (coluna==17)
 {
 coluna=1;
 if (linha==1) linha=2;
 else linha=1;
 }
 }
 }
}
