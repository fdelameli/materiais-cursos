#line 1 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Memória I2C/memoriai2c.c"
#line 25 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Memória I2C/memoriai2c.c"
char linha,coluna,contador,controle;
char recepcao;
char buffer[32];
#line 33 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Memória I2C/memoriai2c.c"
char Le_I2C(char endereco)
{
 char aux;
 i2c_start();
 i2c_wr(0b10100000);
 i2c_wr(endereco);
 I2C_Repeated_Start();
 i2c_wr(0b10100001);
 aux=i2c_rd(0);
 i2c_stop();
 return(aux);
}
#line 50 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Memória I2C/memoriai2c.c"
void Escrever_I2C(char endereco, char dado)
{
 i2c_start();
 i2c_wr(0b10100000);
 i2c_wr(endereco);
 i2c_wr(dado);
 i2c_stop();
 delay_ms(5);
}
#line 65 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Memória I2C/memoriai2c.c"
void Recupera_Dados(void)
{
 for (contador=0;contador<=15;contador++)
 {
 recepcao=le_i2c(contador);
 Lcd8_Chr(1,contador+1,recepcao);
 }

 for (contador=16;contador<=31;contador++)
 {
 recepcao=le_i2c(contador);
 Lcd8_Chr(2,contador-15,recepcao);
 }
}
#line 84 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Memória I2C/memoriai2c.c"
void Salva_Dados(void)
{
 for (contador=0;contador<=31;contador++)
 escrever_i2c(contador,buffer[contador]);
}
#line 95 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Memória I2C/memoriai2c.c"
void main(void)
{
 trisa=0b11111111;
 trisd=0b00000000;
 trise=0b00000001;
 adcon1=7;
 I2C_init(100000);

 option_reg=0b10000000;
 Lcd8_Config(&PORTE, &PORTD, 2, 1, 3, 7, 6, 5, 4, 3, 2, 1, 0);
 Lcd8_Cmd(LCD_CLEAR);
 Lcd8_Cmd(LCD_CURSOR_OFF);
 Usart_Init(9600);
 Recupera_Dados();

 linha=1;
 coluna=1;
 controle=0;

 while (1)
 {
 if (usart_data_ready())
 {
 recepcao=Usart_Read();
 Usart_Write(recepcao);
 buffer[controle]=recepcao;
 controle=controle+1;
 Lcd8_Chr(linha,coluna,recepcao);
 coluna++;
 if (coluna==17)
 {
 coluna=1;
 if (linha==1) linha=2;
 else linha=1;

 Salva_Dados();
 controle=0;
 }
 }
 }
}
