/*************************************************************************\
 * Nome: Bios.h                                                          *
 * Versão: 1.0                                                           *
 * Data: Setembro de 2003                                                *
 * Autor: Marcos Perez Mokarzel                                          *
 * Função: Declarações de funções e variáveis da Bios.                   *
 * Histórico:                                                            *
\*************************************************************************/



//Definição das constantes da BIOS.
#define IOR             0x40  //Pinos de IOR e IOW do barramento ISA.
#define IOW             0x80

#define W_HARDWARE      TRUE


#define BUS_ADD_VAL     LATB  //Valor do barramento de endereço.

#define BUS_DATA_DIR    TRISD //Direção do barramento de dados.
#define BUS_DATA_OUT    LATD  //Valor do barramento de dados.
#define BUS_DATA_IN     LATD  //Valor do barramento de dados.


//Definição de macros
#define SWAPB(Word)  ((WORD)((Word)<<8)|((Word)>>8)) //Troca bytes da word.
#define SWAPW(DWord) ((DWORD)((DWord)<<16)|((DWord)>>16)) //Troca words
                                                          //da dword.

//Funções públicas da classe Rede.
void Bios_Init(void);     //Construtor da Bios, inicializa as 
                          // interfaces físicas do sistema.
void Bios_Escreve(_IN_ BYTE bAdd, _IN_ WORD iData); //Escreve uma Word no 
                                                    // barramento ISA.
void Bios_EscreveSw(_IN_ BYTE bAdd,    //Escreve uma Word invertendo os
                     _IN_ WORD iData); // bytes no barramento ISA.
WORD Bios_Le(_IN_ BYTE bAdd);       //Lê uma Word do barramento ISA
WORD Bios_LeFrame(void);  //Lê uma Word da porta frame da interface PHY 
                          // e executa Byte-swap.
WORD Bios_LeHB1St(_IN_ BYTE bAdd);  //Lê uma Word da interface PHY, com o
                                    // byte de ordem mais alta primeiro.
WORD Bios_GetTemp(void);  //Toma a amostra do temperatura.
void ligaOK(void);
void ligaOK1(void); 
void delay(void);

