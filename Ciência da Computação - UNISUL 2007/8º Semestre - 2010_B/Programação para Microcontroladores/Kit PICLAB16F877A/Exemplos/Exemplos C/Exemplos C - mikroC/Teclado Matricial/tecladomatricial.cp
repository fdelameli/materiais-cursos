#line 1 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Teclado Matricial/tecladomatricial.c"
#line 22 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Teclado Matricial/tecladomatricial.c"
char teclado0,teclado1,indice;
char vetor_display[4];
#line 30 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Teclado Matricial/tecladomatricial.c"
const
 CHR_0 = 0b00111111,
 CHR_1 = 0b00000110,
 CHR_2 = 0b01011011,
 CHR_3 = 0b01001111,
 CHR_4 = 0b01100110,
 CHR_5 = 0b01101101,
 CHR_6 = 0b01111101,
 CHR_7 = 0b00000111,
 CHR_8 = 0b01111111,
 CHR_9 = 0b01101111,
 CHR_A = 0b01110111,
 CHR_B = 0b01111100,
 CHR_C = 0b00111001,
 CHR_D = 0b01011110,
 CHR_E = 0b01111001,
 CHR_F = 0b01110001,
 tecla_0 = 0,
 tecla_1 = 1,
 tecla_2 = 2,
 tecla_3 = 3,
 tecla_4 = 4,
 tecla_5 = 5,
 tecla_6 = 6,
 tecla_7 = 7,
 tecla_8 = 0,
 tecla_9 = 1,
 tecla_C = 2,
 tecla_E = 3,
 SEL_LINHA1 = 0b00001110,
 SEL_LINHA2 = 0b00001101,
 SEL_LINHA3 = 0b00001011,
 SEL_LINHA4 = 0b00000111;
#line 76 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Teclado Matricial/tecladomatricial.c"
char Converte_to_7seg(char dado)
{
 switch(dado)
 {
 case 0 : return CHR_0; break;
 case 1 : return CHR_1; break;
 case 2 : return CHR_2; break;
 case 3 : return CHR_3; break;
 case 4 : return CHR_4; break;
 case 5 : return CHR_5; break;
 case 6 : return CHR_6; break;
 case 7 : return CHR_7; break;
 case 8 : return CHR_8; break;
 case 9 : return CHR_9; break;
 case 10 : return CHR_A; break;
 case 11 : return CHR_B; break;
 case 12 : return CHR_C; break;
 case 13 : return CHR_D; break;
 case 14 : return CHR_E; break;
 case 15 : return CHR_F; break;
 }
}
#line 103 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Teclado Matricial/tecladomatricial.c"
void interrupt(void)
{

 intcon.t0if=0;
 indice++;

 switch(indice)
 {
 case 1:
 portb.f4=0;
 Delay_us(5);
 portd=SEL_LINHA1;
 teclado0.tecla_1=0;
 teclado0.tecla_2=0;
 teclado0.tecla_3=0;
 if (porta.f4 == 0) teclado0.tecla_1=1;
 if (porta.f5 == 0) teclado0.tecla_2=1;
 if (porte.f0 == 0) teclado0.tecla_3=1;
 portd=vetor_display[0];
 portb.f1=1;
 break;

 case 2:
 portb.f1=0;
 Delay_us(5);
 portd=SEL_LINHA2;
 teclado0.tecla_4=0;
 teclado0.tecla_5=0;
 teclado0.tecla_6=0;
 if (porta.f4 == 0) teclado0.tecla_4=1;
 if (porta.f5 == 0) teclado0.tecla_5=1;
 if (porte.f0 == 0) teclado0.tecla_6=1;
 portd=vetor_display[1];
 portb.f2=1;
 break;

 case 3:
 portb.f2=0;
 Delay_us(5);
 portd=SEL_LINHA3;
 teclado0.tecla_7=0;
 teclado1.tecla_8=0;
 teclado1.tecla_9=0;

 if (porta.f4 == 0) teclado0.tecla_7=1;
 if (porta.f5 == 0) teclado1.tecla_8=1;
 if (porte.f0 == 0) teclado1.tecla_9=1;

 portd=vetor_display[2];
 portb.f3=1;
 break;

 case 4:

 portb.f3=0;
 Delay_us(5);
 portd=SEL_LINHA4;
 teclado1.tecla_c=0;
 teclado0.tecla_0=0;
 teclado1.tecla_e=0;

 if (porta.f4 == 0) teclado1.tecla_c=1;
 if (porta.f5 == 0) teclado0.tecla_0=1;
 if (porte.f0 == 0) teclado1.tecla_e=1;

 portd=vetor_display[3];
 portb.f4=1;
 indice=0;
 break;

 }
}
#line 181 "C:/Cerne/CDs/kit PICLAB16f877A/Exemplos/Exemplos C/Exemplos C - mikroC/Teclado Matricial/tecladomatricial.c"
void main(void)
{

 trisa=0b00110000;
 trisb=0b00000000;
 trisd=0b00000000;
 trise=0b00000001;
 option_reg=0b10000000;
 indice=0;
 teclado0=0;
 teclado1=0;
 adcon1=0b00000111;
 intcon=0b10100000;
 vetor_display[0]=0;
 vetor_display[1]=0;
 vetor_display[2]=0;
 vetor_display[3]=0;

 while (1)
 {
 if (teclado0.tecla_1 == 1) vetor_display[0]=Converte_to_7seg(1);
 if (teclado0.tecla_2 == 1) vetor_display[0]=Converte_to_7seg(2);
 if (teclado0.tecla_3 == 1) vetor_display[0]=Converte_to_7seg(3);

 if (teclado0.tecla_4 == 1) vetor_display[1]=Converte_to_7seg(4);
 if (teclado0.tecla_5 == 1) vetor_display[1]=Converte_to_7seg(5);
 if (teclado0.tecla_6 == 1) vetor_display[1]=Converte_to_7seg(6);

 if (teclado0.tecla_7 == 1) vetor_display[2]=Converte_to_7seg(7);
 if (teclado1.tecla_8 == 1) vetor_display[2]=Converte_to_7seg(8);
 if (teclado1.tecla_9 == 1) vetor_display[2]=Converte_to_7seg(9);

 if (teclado1.tecla_C == 1) vetor_display[3]=Converte_to_7seg(12);
 if (teclado0.tecla_0 == 1) vetor_display[3]=Converte_to_7seg(0);
 if (teclado1.tecla_E == 1) vetor_display[3]=Converte_to_7seg(14);
 }

}
