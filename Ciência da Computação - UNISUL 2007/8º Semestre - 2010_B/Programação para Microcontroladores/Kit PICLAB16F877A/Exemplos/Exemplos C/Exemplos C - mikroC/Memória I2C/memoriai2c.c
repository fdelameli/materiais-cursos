/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * **
*             Programação Em C - Módulo B PIC16F877A          *
*                             Exemplo 9                       *
*                                                             *
*             CENTRO DE TREINAMENTO - Cerne Tecnologia        *
*                                                             *
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
*   VERSÃO : 1.0
*   DATA : 22/07/2005
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
*                         Descrição geral                     *
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
Este exemplo irá receber uma série de bytes da porta serial
e quando preeencher toda uma tela do display, irá
salvar este a partir de um buffer de 32 posições na
memória I2C externa*/

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *             Definição e inicialização das variáveis         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
Aqui iremos definir as variáveis globais do sistema*/

char linha,coluna,contador,controle;
char recepcao;
char buffer[32];

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                 Rotina de Leitura no Barramento I2C         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

char Le_I2C(char endereco)
{
     char aux;
     i2c_start();           	      //Condição de início
     i2c_wr(0b10100000);	      //Envia um byte de escrita
     i2c_wr(endereco);		      //Envia endereço
     I2C_Repeated_Start();	      //Nova condição de início
     i2c_wr(0b10100001);	      //Envia o byte de controle de leitura
     aux=i2c_rd(0);         	      //lê o dado armazenado na E²PROM e envia nack
     i2c_stop();                      //Condição de parada
     return(aux);              	      //retorna o dado lido
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                 Rotina de Escrita no Barramento I2C         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Escrever_I2C(char endereco, char dado)
{
     i2c_start();		      //Condição de início
     i2c_wr(0b10100000); 	      //Envia o byte de e escrita
     i2c_wr(endereco);		      //Envia endereço
     i2c_wr(dado);	              //Escreve dado na E²PROM
     i2c_stop();		      // Condição de parada
     delay_ms(5);		      // espera a gravação estar completa
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *              Rotina para ler dados da memória serial          *
 *                    e apresenta-los no display                 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

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

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *            Rotina para salvar o buffer do display               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Salva_Dados(void)
{
   for (contador=0;contador<=31;contador++)
        escrever_i2c(contador,buffer[contador]);
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                       Início do programa                    *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
Nessa parte ficará o loop principal do sistema*/

void main(void)
{
   trisa=0b11111111;             // põe todos os pinos para entrada
   trisd=0b00000000;
   trise=0b00000001;             //configura i/os
   adcon1=7;                     //desliga todos os a/ds
   I2C_init(100000);             //inicializa o módulo para funcionar a 100kHz
                                 //em modo master
   option_reg=0b10000000;        //configura prescaler do timer 0
   Lcd8_Config(&PORTE, &PORTD, 2, 1, 3, 7, 6, 5, 4, 3, 2, 1, 0);
   Lcd8_Cmd(LCD_CLEAR);          //limpa o display
   Lcd8_Cmd(LCD_CURSOR_OFF);     //Desliga o cursor
   Usart_Init(9600);             //Inicializa o módulo Usart para trabalhar a 9600bps
   Recupera_Dados();             //Chama rotina para ler e mostrar os
                                 //dados salvos na memória no display
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
           controle=controle+1;      //salva dado no buffer
           Lcd8_Chr(linha,coluna,recepcao);
           coluna++;
           if (coluna==17)
            {
             coluna=1;
             if (linha==1) linha=2;
             else          linha=1;

             Salva_Dados();          //Chama rotina para salvar dados na I2C
             controle=0;
            }
        }
     }
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                       Fim do programa                       *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


