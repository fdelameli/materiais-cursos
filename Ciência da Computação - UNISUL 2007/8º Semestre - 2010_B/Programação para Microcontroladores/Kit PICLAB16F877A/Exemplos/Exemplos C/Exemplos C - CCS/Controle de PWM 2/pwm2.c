/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *    	 	       Programação em C - Módulo B PIC16F877A            	   *
 *                               Exemplo 12                                *
 *                                                                         *
 *                 CENTRO DE TREINAMENTO - Cerne Tecnologia	               *
 *                          www.cerne-tec.com.br                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *   VERSÃO : 1.0                                                          *
 *   DATA : 16/05/2005                                                     *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                             Descrição geral                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
// Demonstrar a utilização dos dois módulos de PWM
// utilizando para isto o ventilador e resistor externo
// e além disso medir a temperatura e rotação em Hz e RPM do ventilador

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

#use delay(clock=4000000)		   // Utiliza biblioteca de delay									

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                 Definição e inicialização das variáveis               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos definir as variáveis globais do sistema

int1 pode_converter=0;
int1 tecla0=0, tecla1=0, tecla2=0, tecla3=0, tecla4=0, tecla5=0, tecla6=0,
     tecla7=0, tecla8=0, tecla9=0, teclaE=0, teclaC=0;
int indice=0;
long pulsos;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                           Constantes internas                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Aqui iremos definir as constantes utilizadas pelo sistema

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
#define  COL3        PIN_E0

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
void Tela_Inicial(void);
void Atualiza_PWM_0(int dado);
void Atualiza_PWM_20(int dado);
void Atualiza_PWM_40(int dado);
void Atualiza_PWM_60(int dado);
void Atualiza_PWM_80(int dado);
void Atualiza_PWM_100(int dado);
void Lcd_Inst(char dado);
void Lcd_Dado(char dado);
void Atualiza_Temperatura(int dado);

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                           Rotina Principal                		   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
//Nessa parte ficará o loop principal do sistema

void main (void)
{
	Inicializa();				// Chama rotina para inicializar o sistema

	while(1)					   // Entra em loop infinito
		{
			restart_wdt();		// Limpa o wdt

			if (tecla1)	Atualiza_PWM_0(0x83);  // Atualiza PWM e LCD
			if (tecla2) Atualiza_PWM_20(0x83); // Atualiza PWM e LCD
			if (tecla3) Atualiza_PWM_40(0x83); // Atualiza PWM e LCD
	 		if (tecla4) Atualiza_PWM_60(0x83); // Atualiza PWM e LCD
			if (tecla5) Atualiza_PWM_80(0x83); // Atualiza PWM e LCD
	 		if (tecla6) Atualiza_PWM_100(0x83);// Atualiza PWM e LCD

			if (tecla7)	Atualiza_PWM_0(0x8C);  // Atualiza PWM e LCD
			if (tecla8) Atualiza_PWM_20(0x8C); // Atualiza PWM e LCD
			if (tecla9) Atualiza_PWM_40(0x8C); // Atualiza PWM e LCD
	 		if (teclaC) Atualiza_PWM_60(0x8C); // Atualiza PWM e LCD
			if (tecla0) Atualiza_PWM_80(0x8C); // Atualiza PWM e LCD
	 		if (teclaE) Atualiza_PWM_100(0x8C);// Atualiza PWM e LCD

	 		Atualiza_Temperatura(read_adc());

			if (pode_converter)
			 {
				 pode_converter=0;
				 pulsos=pulsos/9;		           // Acha o RPS
				 Lcd_Inst(0xC0);
             printf(lcd_dado,"%02lu",pulsos);

				 Lcd_Inst(0xC6);
             printf(lcd_dado,"%04lu",pulsos*60);

			}

		}
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                       Inicialização do Sistema                 	   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Inicializa(void)
{

   delay_ms(2000);

   setup_adc(ADC_CLOCK_DIV_8);  		      // Configura clock da conversão
   setup_adc_ports(RA0_RA1_RA3_ANALOG);   // Configura três entradas como AD
   set_adc_channel(3);			   		   // Seleciona o canal 3(Temperatura)

   setup_ccp1(CCP_PWM);			            // Confirura modo CCP para PWM
   setup_ccp2(CCP_PWM);

   output_low(PIN_C1);
   output_low(PIN_C2);			            // Garante estado do port

   setup_timer_1(T1_EXTERNAL | T1_DIV_BY_1);

   set_pwm1_duty(0);
   set_pwm2_duty(0);			               // Garante estado inicial do modo CCP

   setup_timer_2(T2_DIV_BY_4,249,10);

   set_timer0(0);                         // Inicializa timer 0 com 0
   setup_timer_0(RTCC_INTERNAL | RTCC_DIV_1); // Timer configurado para clock
                                              // Interno com prescaler de 1:4
   setup_wdt(WDT_2304MS);                  // Configura WDT para 2,304 s
   enable_interrupts(INT_TIMER2);          // Habilita interrupção de timer 0
   enable_interrupts(INT_TIMER0);          // Habilita interrupção de timer 0
   enable_interrupts(GLOBAL);              // Habilita todas as interrupções

   Lcd_Inst(0x30);			                // Inicializa o display
   delay_ms(3);
   Lcd_Inst(0x30);
   Lcd_Inst(0x30);
   Lcd_Inst(0x38);
   Lcd_Inst(0x01);
   delay_ms(1);
   Lcd_Inst(0x0C);
   Lcd_Inst(0x06);
   Tela_Inicial();
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                 Rotina para Apresentar a Tela Inicial               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Tela_Inicial(void)
{
	Lcd_Inst(0x80);			// Atualiza a tela do LCD
   printf(lcd_dado,"Vt: 0 % Res: 0 %");
   
	Lcd_Inst(0xC0);			// Atualiza a tela do LCD
   printf(lcd_dado," 0 Hz   0 RM   C");
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *           Rotina para Atualizar o Duty-Cycle do PWM para 0%         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Atualiza_PWM_0(int dado)
{
    Lcd_Inst(dado);
    Lcd_Dado('0');
    Lcd_Dado('0');
    Lcd_Dado('0');

	if(dado==0x83)
	 { set_pwm1_duty(0);}
	else
	 { set_pwm2_duty(0);}
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *           Rotina para Atualizar o Duty-Cycle do PWM para 20%        *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Atualiza_PWM_20(int dado)
{
    Lcd_Inst(dado);
    Lcd_Dado(' ');
    Lcd_Dado('2');
    Lcd_Dado('0');

	if(dado==0x83)
	 { set_pwm1_duty(50);}
	else
	 { set_pwm2_duty(50);}
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *           Rotina para Atualizar o Duty-Cycle do PWM para 40%        *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Atualiza_PWM_40(int dado)
{
    Lcd_Inst(dado);
    Lcd_Dado(' ');
    Lcd_Dado('4');
    Lcd_Dado('0');

	if(dado==0x83)
	 { set_pwm1_duty(101);}
	else
	 { set_pwm2_duty(101);}
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *           Rotina para Atualizar o Duty-Cycle do PWM para 60%        *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Atualiza_PWM_60(int dado)
{
    Lcd_Inst(dado);
    Lcd_Dado(' ');
    Lcd_Dado('6');
    Lcd_Dado('0');

	if(dado==0x83)
	 { set_pwm1_duty(152);}
	else
	 { set_pwm2_duty(152);}
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *           Rotina para Atualizar o Duty-Cycle do PWM para 80%        *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Atualiza_PWM_80(int dado)
{
    Lcd_Inst(dado);
    Lcd_Dado(' ');
    Lcd_Dado('8');
    Lcd_Dado('0');

	if(dado==0x83)
	 { set_pwm1_duty(203);}
	else
	 { set_pwm2_duty(203);}
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *          Rotina para Atualizar o Duty-Cycle do PWM para 100%        *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Atualiza_PWM_100(int dado)
{
    Lcd_Inst(dado);
    Lcd_Dado('1');
    Lcd_Dado('0');
    Lcd_Dado('0');

	if(dado==0x83)
	 { set_pwm1_duty(255);}
	else
	 { set_pwm2_duty(255);}
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *               Rotina para escrever comandos no display	 		   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Lcd_Inst(char dado)
{
	disable_interrupts(GLOBAL);		// Desliga as interrupções
	output_low(RS);					// Põe pino de RS em baixo, modo comando
	output_d(dado);					// Põe o dado no portd
	delay_cycles(2);				// Aguarda 2 us, acomodação
	output_high(EN);				// Gera pulso de clock
	delay_cycles(2);
	output_low(EN);
	delay_ms(1);					// Aguarda 1ms
	enable_interrupts(GLOBAL);		// Liga as interrupções
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                 Rotina para escrever dados no display	 		   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Lcd_Dado(char dado)
{
	disable_interrupts(GLOBAL);		// Desliga as interrupções
	output_high(RS);				// Seta o pino RS, modo dado
	output_d(dado);					// Põe o dado no portd
	delay_cycles(2);				// Aguarda 2us, acomodação
	output_high(EN);				// Gera pulso de clock
	delay_cycles(2);
	output_low(EN);
	delay_ms(1);					// Aguarda 1ms
	enable_interrupts(GLOBAL);		// Liga as interrupções
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                  Tratamento da Interrupção de Timer 2			   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#int_timer2
void Isr_Timer2(void)
{
	static int vezes_timer2=100;

	vezes_timer2--;
	if(vezes_timer2) return;
	vezes_timer2=100;
	setup_timer_1(T1_DISABLED);
	pulsos=get_timer1();
	set_timer1(0);
	setup_timer_1(T1_EXTERNAL | T1_DIV_BY_1);
	pode_converter=1;
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                  Tratamento da Interrupção de Timer 0			   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#int_timer0
void Ist_Timer0(void)
{
   indice++;                            // Incrementa indice

   switch(indice)                       // Seleção de casos com indice
      {

         case 1:                        // Caso seja 1...
            output_d(SEL_LINHA1);	    // Seleciona no barramento a linha 1
   			tecla1=0;			          // Limpa a tecla pressionada
   			tecla2=0;				       // Limpa a tecla pressionada
   			tecla3=0;			     	    // Limpa a tecla pressionada
   			if (!input(COL1)) tecla1=1; // Verifica se tecla está pressionada
   			if (!input(COL2)) tecla2=1; // Verifica se tecla está pressionada
   			if (!input(COL3)) tecla3=1; // Verifica se tecla está pressionada
            break;

         case 2:                        // Caso seja 2...
   			output_d(SEL_LINHA2);	    // Seleciona no barramento a linha 1
   			tecla4=0;				       // Limpa a tecla pressionada
   			tecla5=0;				       // Limpa a tecla pressionada
   			tecla6=0;				       // Limpa a tecla pressionada
   			if (!input(COL1)) tecla4=1; // Verifica se tecla está pressionada
   			if (!input(COL2)) tecla5=1; // Verifica se tecla está pressionada
   			if (!input(COL3)) tecla6=1; // Verifica se tecla está pressionada
            break;

         case 3:                         // Caso seja 3...
   			output_d(SEL_LINHA3);	     // Seleciona no barramento a linha 3
   			tecla7=0;			      	  // Limpa a tecla pressionada
   			tecla8=0;				        // Limpa a tecla pressionada
   			tecla9=0;				        // Limpa a tecla pressionada
   			if (!input(COL1)) tecla7=1;  // Verifica se tecla está pressionada
   			if (!input(COL2)) tecla8=1;  // Verifica se tecla está pressionada
   			if (!input(COL3)) tecla9=1;  // Verifica se tecla está pressionada
            break;

         case 4:                         // Caso seja 4...
            indice=0;                    // Reinicia indice
   			output_d(SEL_LINHA4);        // Seleciona no barramento a linha 4
   			teclaC=0;				        // Limpa a tecla pressionada
   			tecla0=0;				        // Limpa a tecla pressionada
   			teclaE=0;			           // Limpa a tecla pressionada
   			if (!input(COL1)) teclaC=1;  // Verifica se tecla está pressionada
   			if (!input(COL2)) tecla0=1;  // Verifica se tecla está pressionada
   			if (!input(COL3)) teclaE=1;  // Verifica se tecla está pressionada
            break;
      }
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *         Rotina para Atualizar a Temperatura medida no Display	   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

void Atualiza_Temperatura(int dado)
{
	Lcd_Inst(0xCD);
   printf(lcd_dado,"%02u",dado*2);
}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *        					 Fim do Programa						   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

