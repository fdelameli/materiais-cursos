/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  			      Programação em C - Módulo B PIC16F877A            	      *
 *                               Exemplo 9                                 *
 *                                                                         *
 *                CENTRO DE TREINAMENTO - Cerne Tecnologia	               *
 *                          www.cerne-tec.com.br                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *   VERSÃO : 1.0                                                          *
 *   DATA : 16/05/2005                                                     *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                             Descrição geral                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
// Apresentar a utilização da Memória FLASH  do PIC

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                		 	Definição de Cabeçalho						 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#include	<16F877A.h>				//microcontrolador utilizado

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                         Configurações para gravação                   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#fuses xt,nolvp,wdt,nolvp,nobrownout,put,nodebug,noprotect,nowrt,nocpd
 								   // Configurações da Máquina
                           // Oscilador: XT, LVP: Off, WDT: On, Brown-out: Off
                           // Power-up: Off, Debug: Off, CP: Off, CPD: Off

#use delay(clock=4000000)           // Define o clock do sistema
#use rs232(baud=9600,xmit=pin_c6,rcv=pin_c7)
         								   // Configura Usart

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                 Definição e inicialização das variáveis               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos definir as variáveis globais do sistema

int1 tecla0=0, tecla1=0, tecla2=0, tecla3=0, tecla4=0, tecla5=0, tecla6=0,
     tecla7=0, tecla8=0, tecla9=0, teclaE=0, teclaC=0;

int indice=0,indice_buffer=0;
int buffer[16]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
									// Declara e inicializa o vetor

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                           Constantes internas                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos definir as constantes utilizadas pelo sistema

#define ENDERECO_FLASH	0x800

#define SEL_LINHA1	0b00001110	// Seleção da linha 1
#define SEL_LINHA2	0b00001101	// Seleção da linha 2
#define SEL_LINHA3	0b00001011	// Seleção da linha 3
#define SEL_LINHA4	0b00000111	// Seleção da linha 4

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                Entradas                               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos definir as entradas do sistema

#define  COL1	      PIN_A4
#define  COL2	      PIN_A5
#define  COL3         PIN_E0

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                Saídas                               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos definir as saídas do sistema

#define  RS			  PIN_E2		// Pino de seleção de modo do display
#define  EN			  PIN_E1		// Pino de habilitação do display

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                       Prototipagem das funções                      *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos declarar todas as funções definidas pelo usuário

void Inicializa(void);
void Lcd_Inst(char dado);
void Lcd_Dado(char dado);
void Lcd_Inst_Int(char dado);
void Lcd_Dado_Int(char dado);
void Grava_Buffer(void);
void Restaura_EEPROM(void);
void Le_Dados(void);

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                Definição de Prioridade das Interrupções             *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos definir as prioridades das interrupções

#priority	rda, timer0

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *       	              Inicialização da EEPROM             		   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos inicializar a EEPROM Interna do PIC

#rom 0x800 = {"Cerne Tecnologia"}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                           Rotina Principal                		   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Nessa parte ficará o loop principal do sistema

void main (void)
{
	Inicializa();				 // Chama rotina para inicializar o sistema

	while(1)					    // Entra em loop infinito
		{
		 restart_wdt();		 // Limpa o wdt
		 if (teclaE) Grava_Buffer();    // Chama rotina para salvar o buffer
 		 if (teclaC) Restaura_EEPROM(); // Chama rotina para restaurar
         	  								  // os dados armazenados na EEPROM
		}
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                       Inicialização do Sistema                 	   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Inicializa(void)
{

   delay_ms(2000);

   setup_adc_ports(no_analogs);   // Todos os AD´s desligados

   set_timer0(0);                 // Inicializa timer 0 com 0
   setup_timer_0(RTCC_INTERNAL | RTCC_DIV_1); // Timer configurado para clock
                                              // Interno com prescaler de 1:4
   setup_wdt(WDT_2304MS);         // Configura WDT para 2,304 s
   enable_interrupts(INT_TIMER0); // Habilita interrupção de timer 0
   enable_interrupts(INT_RDA);    // Habilita interrupção serial
   enable_interrupts(GLOBAL);     // Habilita todas as interrupções

   Lcd_Inst(0x30);			      // Inicializa o display
   delay_ms(3);
   Lcd_Inst(0x30);
   Lcd_Inst(0x30);
   Lcd_Inst(0x38);
   Lcd_Inst(0x01);
   delay_ms(1);
   Lcd_Inst(0x0C);
   Lcd_Inst(0x06);
   Le_Dados();
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *			Rotina para Led os Dados da EEPROM e tocar o beep	   	   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Restaura_EEPROM(void)
{
	Le_Dados();
	while(teclaC){restart_wdt();}
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *      Rotina para Led os Dados da EEPROM e apresentar no display	   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Le_Dados(void)
{
	int contador;
	Lcd_Inst(0x80);

	for(contador=0;contador<=15;contador++)
	 {
		 buffer[contador]=read_program_eeprom(contador+ENDERECO_FLASH);
		 Lcd_Dado(buffer[contador]);
	 }
	Lcd_Inst(0x80);
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *   		    Rotina para Gravar o Buffer na EEPROM				   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Grava_Buffer(void)
{
	int contador;
	for(contador=0;contador<=15;contador++)
	 {
		 write_program_eeprom(contador+ENDERECO_FLASH,buffer[contador]);
	 }

	 while(teclaE){restart_wdt();}
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *   		    Rotina para Enviar Comandos para o LCD				   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Lcd_Inst(char dado)
{
	disable_interrupts(GLOBAL);	// Desliga as interrupções
	output_low(RS);					// Põe pino de RS em baixo, modo comando
	output_d(dado);					// Põe o dado no portd
	delay_cycles(2);			    	// Aguarda 2 us, acomodação
	output_high(EN);			    	// Gera pulso de clock
	delay_cycles(2);
	output_low(EN);
	delay_ms(1);		   			// Aguarda 1ms
	enable_interrupts(GLOBAL);		// Liga as interrupções
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *   		        Rotina para Enviar Dados para o LCD				   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Lcd_Dado(char dado)
{
	disable_interrupts(GLOBAL);	// Desliga as interrupções
	output_high(RS);				   // Seta o pino RS, modo dado
	output_d(dado);					// Põe o dado no portd
	delay_cycles(2);			     	// Aguarda 2us, acomodação
	output_high(EN);			    	// Gera pulso de clock
	delay_cycles(2);
	output_low(EN);
	delay_ms(1);	    				// Aguarda 1ms
	enable_interrupts(GLOBAL);		// Liga as interrupções
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *       Rotina para Enviar Comandos para o LCD pela Interrupção	   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Lcd_Inst_Int(char dado)
{
	output_low(RS);					// Põe pino de RS em baixo, modo comando
	output_d(dado);					// Põe o dado no portd
	delay_cycles(2);				// Aguarda 2 us, acomodação
	output_high(EN);				// Gera pulso de clock
	delay_cycles(2);
	output_low(EN);
	delay_ms(1);					// Aguarda 1ms
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *        Rotina para Enviar Dados para o LCD pela Interrupção		   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Lcd_Dado_Int(char dado)
{
	output_high(RS);				// Seta o pino RS, modo dado
	output_d(dado);					// Põe o dado no portd
	delay_cycles(2);				// Aguarda 2us, acomodação
	output_high(EN);				// Gera pulso de clock
	delay_cycles(2);
	output_low(EN);
	delay_ms(1);					// Aguarda 1ms
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *   		        Rotina de Tratamento de Recpção Serial			   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#int_rda
void Isr_Serial(void)
{
	if (indice_buffer==16)
		{
			indice_buffer=0;
			Lcd_Inst_Int(0x80);
		}

	buffer[indice_buffer]=getc();
	Lcd_Dado_Int(buffer[indice_buffer]);
	indice_buffer++;
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *   		        Rotina de Tratamento de Timer 0			   		   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#int_timer0
void Ist_Timer0(void)
{
   indice++;                        // Incrementa indice

   switch(indice)                   // Seleção de casos com indice
      {

         case 1:                     // Caso seja 1...
   			output_d(SEL_LINHA1);	// Seleciona no barramento a linha 1
   			tecla1=0;			    // Limpa a tecla pressionada
   			tecla2=0;				// Limpa a tecla pressionada
   			tecla3=0;				// Limpa a tecla pressionada
   			if (!input(COL1)) tecla1=1; // Verifica se tecla está pressionada
   			if (!input(COL2)) tecla2=1; // Verifica se tecla está pressionada
   			if (!input(COL3)) tecla3=1; // Verifica se tecla está pressionada
            break;

         case 2:                     // Caso seja 2...
   			output_d(SEL_LINHA2);	 // Seleciona no barramento a linha 1
   			tecla4=0;				 // Limpa a tecla pressionada
   			tecla5=0;				 // Limpa a tecla pressionada
   			tecla6=0;				 // Limpa a tecla pressionada
   			if (!input(COL1)) tecla4=1; // Verifica se tecla está pressionada
   			if (!input(COL2)) tecla5=1; // Verifica se tecla está pressionada
   			if (!input(COL3)) tecla6=1; // Verifica se tecla está pressionada
            break;

         case 3:                     // Caso seja 3...
   			output_d(SEL_LINHA3);	  // Seleciona no barramento a linha 3
   			tecla7=0;				  // Limpa a tecla pressionada
   			tecla8=0;				  // Limpa a tecla pressionada
   			tecla9=0;				  // Limpa a tecla pressionada
   			if (!input(COL1)) tecla7=1; // Verifica se tecla está pressionada
   			if (!input(COL2)) tecla8=1; // Verifica se tecla está pressionada
   			if (!input(COL3)) tecla9=1; // Verifica se tecla está pressionada
            break;

         case 4:                     // Caso seja 4...
            indice=0;                // Reinicia indice
   			output_d(SEL_LINHA4);	   // Seleciona no barramento a linha 4
   			teclaC=0;				   // Limpa a tecla pressionada
   			tecla0=0;				   // Limpa a tecla pressionada
   			teclaE=0;				   // Limpa a tecla pressionada
   			if (!input(COL1)) teclaC=1; // Verifica se tecla está pressionada
   			if (!input(COL2)) tecla0=1; // Verifica se tecla está pressionada
   			if (!input(COL3)) teclaE=1; // Verifica se tecla está pressionada
            break;
      }
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *   				        Fim do Programa							   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */



