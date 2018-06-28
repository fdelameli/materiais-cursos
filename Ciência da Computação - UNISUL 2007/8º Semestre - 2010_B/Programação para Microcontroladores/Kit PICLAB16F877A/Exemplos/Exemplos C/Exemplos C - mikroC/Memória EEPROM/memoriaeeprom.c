/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * **
*             Programação Em C - Módulo B PIC16F877A          *
*                             Exemplo 7                       *
*                                                             *
*             CENTRO DE TREINAMENTO - Cerne Tecnologia        *
*                                                             *
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
*   VERSÃO : 1.0
*   DATA : 22/07/2005
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
*                         Descrição geral                     *
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 Este exemplo irá demonstrar a utilização da memória
 EEPROM interna do PIC. Para isso, iremos implementar
 um contador no barramento de leds e assim que o sistema
 acordar, o mesmo lerá a memória e carregará o dado
 novamente no barramento*/

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *             Definição e inicialização das variáveis         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
Aqui iremos definir as variáveis globais do sistema*/

char  dado;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                       Início do programa                    *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
Nessa parte ficará o loop principal do sistema*/

void main(void)
{
   portb=0;
   trisb=0b00000000;            //inicializa o barramento
   trisd=0b00000000;            //configura i/o do sistema
   adcon1=7;                    //desliga a/d
   option_reg=0b10000000;       //configura prescaler do timer 0
   dado=eeprom_read(0);         //lê a posição zero de memória e carrega no barramento

     while (1)
     {

       portb.f5=1;                //liga a saída de leds
       portd=dado;               //atualiza a saída de leds
       delay_ms(500);             //aguarda 1000ms

       portb.f5=0;                //desliga saída de leds
       portd=0b11111110;          //seleciona linha 1 do teclado matricial
       delay_us(10);              //tempo de acomodação

       if (porta.f4==0)           //se o botão estiver pressioando...
       {
           dado++;                //incrementa o dado
           eeprom_write(0,dado);  //atualiza a eeprom
       }

       if (porta.f5==0)          //se o botão estiver pressioando...
       {
           dado--;                //decrementa o dado
           eeprom_write(0,dado);  //atualiza a eeprom
       }
     }
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                       Fim do programa                       *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

