#line 1 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Relógio Digital/usart.c"
#line 23 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Relógio Digital/usart.c"
char indice,pisca,vezes_tmr1;
char hora_msb=0,hora_lsb=0,minuto_msb=0,minuto_lsb=0;
char vetor_display[4];
#line 37 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Relógio Digital/usart.c"
const CHR_0 = 0b00111111;
const CHR_1 = 0b00000110;
const CHR_2 = 0b01011011;
const CHR_3 = 0b01001111;
const CHR_4 = 0b01100110;
const CHR_5 = 0b01101101;
const CHR_6 = 0b01111101;
const CHR_7 = 0b00000111;
const CHR_8 = 0b01111111;
const CHR_9 = 0b01101111;
const CHR_A = 0b01110111;
const CHR_B = 0b01111100;
const CHR_C = 0b00111001;
const CHR_D = 0b01011110;
const CHR_E = 0b01111001;
const CHR_F = 0b01110001;
#line 59 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Relógio Digital/usart.c"
unsigned char Converte_to_7seg (char dado)
{
 switch(dado)
 {
 case 0 : return(CHR_0);
 break;
 case 1 : return(CHR_1);
 break;
 case 2 : return(CHR_2);
 break;
 case 3 : return(CHR_3);
 break;
 case 4 : return(CHR_4);
 break;
 case 5 : return(CHR_5);
 break;
 case 6 : return(CHR_6);
 break;
 case 7 : return(CHR_7);
 break;
 case 8 : return(CHR_8);
 break;
 case 9 : return(CHR_9);
 break;
 case 10 : return(CHR_A);
 break;
 case 11 : return(CHR_B);
 break;
 case 12 : return(CHR_C);
 break;
 case 13 : return(CHR_D);
 break;
 case 14 : return(CHR_E);
 break;
 case 15 : return(CHR_F);
 break;
 }
}
#line 102 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Relógio Digital/usart.c"
void interrupt(void)
{

 if (intcon.t0if == 1)
 {
 intcon.t0if=0;
 indice++;

 switch(indice)
 {
 case 1:
 portb.f4=0;
 portd=vetor_display[indice-1];
 portb.f1=1;
 break;

 case 2:
 portb.f1=0;
 portd=vetor_display[indice-1];
 portb.f2=1;
 if (pisca) portd.f7=1;
 break;

 case 3:
 portb.f2=0;
 portd=vetor_display[indice-1];
 portb.f3=1;
 break;

 case 4:
 portb.f3=0;
 portd=vetor_display[indice-1];
 portb.f4=1;
 indice=0;
 break;

 }
 }
 else
 {
 tmr1h=0X0B;
 tmr1l=0XDC;
 pir1.tmr1if=0;
 pisca=!pisca;
 vezes_tmr1--;

 if (vezes_tmr1==0)
 {
 vezes_tmr1=120;
 minuto_lsb++;

 if (minuto_lsb==10)
 {
 minuto_lsb=0;
 minuto_msb++;
 if (minuto_msb==6)
 {
 minuto_msb=0;
 hora_lsb++;
 if (hora_msb==2)
 {
 if (hora_lsb==4)
 {
 hora_msb=0;
 hora_lsb=0;
 }
 }
 if (hora_lsb==10)
 {
 hora_lsb=0;
 hora_msb++;
 }
 }
 }

 }
 }
}
#line 187 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Relógio Digital/usart.c"
void main(void)
{

 trisa=0b00000000;
 trisb=0b00000000;
 trisd=0b00000000;
 option_reg=0b10000000;
 indice=0;
 hora_msb=0;
 hora_lsb=0;
 minuto_msb=0;
 minuto_lsb=0;
 pie1=0b00000001;
 t1con=0b00110001;
 tmr1h=0x0B;
 tmr1l=0xDC;
 vezes_tmr1=120;
 pisca=0;
 intcon=0b11100000;


 while (1)
 {
 vetor_display[0]=Converte_to_7seg(hora_msb);
 vetor_display[1]=Converte_to_7seg(hora_lsb);
 vetor_display[2]=Converte_to_7seg(minuto_msb);
 vetor_display[3]=Converte_to_7seg(minuto_lsb);
 }

}
