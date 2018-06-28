;*	*	*	*	*	*	*	*	*	*
;*			  Programa��o em Assembly			*
;*          	 EXEMPLO4: UTILIZANDO O AD INTERNO DO PIC 		*
;*		     APOSTILA M�DULO B  -  PIC16F877A			*
;*		       CERNE TECNOLOGIA E TREINAMENTO			*
;*	    VERS�O 1.0				DATA:03/05/2005		*
;*									*
;*	*	*	*	*	*	*	*	*	*

;*	*	*	*	*	*	*	*	*	*
;*			 OBJETIVO DO ARQUIVO FONTE			*
;*									*
;*  DEMONSTRAR A UTILIZA��O DO A/D INTERNO DO PIC. O VALOR LIDO DO A/D  *
;*  SER� MOSTRADO NO DISPLAY EM FORMA DECIMAL E EM VOLTS. AL�M DISSO, O	*
;*  O VALOR CONVERTIDO IR� ACIONAR A SA�DA DE LEDS EM FORMA PROPORCIONAL*
;* 			  A TENS�O DE ENTRADA.				*
;*	*	*	*	*	*	*	*	*	*

 #INCLUDE <P16F877.INC> 	;ARQUIVO PADR�O PARA PIC16F877A
 __CONFIG _CP_OFF & _XT_OSC & _PWRTE_ON & _LVP_OFF & _WDT_ON & _BODEN_OFF & _CPD_OFF & _DEBUG_OFF
 	
 	;NESTE PONTO � INFORMADO A CONFIGURA��O DA M�QUINA, OU SEJA, SE TER�
 	;C�DIGO DE PROTE��O OU O TIPO DE CRISTAL QUE SER� UTILIZADO	

 	;CONFIGURA��O DA M�QUINA
 	; CODE PROTECT		        -> DESLIGADO
 	; OSCILADOR    		        -> CRISTAL OU RESSONADOR
 	; POWER-UP     		        -> LIGADO
 	; DEBUF 		        -> DESLIGADO		
 	; PROGRAMA��O EM BAIXA VOLTAGEM -> DESLIGADO
	; WATCH DOG			-> LIGADO
	; BROWN-OUT RESET		-> DESLIGADO
	; PROTE��O DE EEPROM		-> DESLIGADO
	 	
;*	*	*	*	*	*	*	*	*	*
;*			   PAGINA��O DE MEM�RIA				*
;*	*	*	*	*	*	*	*	*	*

; AQUI CRIAREMOS UM PSEUD�NIMO PARA UM COMANDO. POR EXEMPLO, O COMANDO
; "BCF STATUS,RP0" PODE SER SUBSTITU�DO SEM PROBLEMAS POR "BANK0". O 
; COMPILADOR IR� SUBSTITUIR INTERNAMENTE "BANK0" POR "BCF STATUS,RP0".
; ESTA APLICA��O � V�LIDA PARA OUTROS TIPOS DE COMANDOS

#DEFINE	BANK0	BCF	STATUS,RP0	; ESCOLHE BANCO DE MEM�RIA 0
#DEFINE	BANK1	BSF	STATUS,RP0	; ESCOLHE BANCO DE MEM�RIA 1

;*	*	*	*	*	*	*	*	*	*
;*			     DEFINICAO DE RAM				*
;*	*	*	*	*	*	*	*	*	*

; AQUI IREMOS CRIAR AS VARI�VEIS DO NOSSO SISTEMA

	CBLOCK 0x20	 ; IN�CIO DO BLOCO DE RAM(GPR)
		TEMPO1   ; VARI�VEL DA ROTINA DE TEMPO		
		TEMPO2   ; VARI�VEL DA ROTINA DE TEMPO				
		TEMP	 ; VARI�VEL DE USO GERAL
		CENTENA  ; CENTENA DA VARI�VEL CONVERTIDA
		DEZENA	 ; DEZENA DA VARI�VEL CONVERTIDA
		UNIDADE	 ; UNIDADE DA VARI�VEL CONVERTIDA
		CONVERSAO_4 ; RESULTADO DA CONVERS�O BIN�RIO PARA DECIMAL
		CONVERSAO_3 ; RESULTADO DA CONVERS�O BIN�RIO PARA DECIMAL
		CONVERSAO_2 ; RESULTADO DA CONVERS�O BIN�RIO PARA DECIMAL
		CONVERSAO_1 ; RESULTADO DA CONVERS�O BIN�RIO PARA DECIMAL
		CONVERSAO_0 ; RESULTADO DA CONVERS�O BIN�RIO PARA DECIMAL
		MSB	    ; VARI�VEIS DE ENTRADA DA CONVERS�O BIN�RIO	
		LSB         ; PARA DECIMAL
		ARG0	    ; ARGUMENTO LSB PARA ROTINA DE MULTIPLICA��O	
		ARG1	    ; ARGUMENTO MSB PARA ROTINA DE MULTIPLICA��O		
		MUL0	    ; VARI�VEL AUXILIAR PARA A ROTINA DE MULTIPLICA��O	
		MUL1	    ; VARI�VEL AUXILIAR PARA A ROTINA DE MULTIPLICA��O			
		BYTE_LED    ; SA�DA PARA OS LEDS
	ENDC		 ; FIM DO BLOCO DE RAM(GPR)
		
;*	*	*	*	*	*	*	*	*	*
;*		          DEFINICAO DE FLAGS				*
;*	*	*	*	*	*	*	*	*	*

; AQUI S�O DEFINIDOS OS FLAGS QUE SER�O UTILIZADOS PELO SISTEMA
	
;*	*	*	*	*	*	*	*	*	*
;*		        DEFINICAO DE CONSTANTES				*
;*	*	*	*	*	*	*	*	*	*

; AQUI S�O DEFINIDOS AS CONSTANTES QUE SER�O UTILIZADOS PELO SISTEMA

#DEFINE LINHA_SUP	0x80	; CONSTANTE PARA LINHA SUPERIOR
#DEFINE LINHA_INF	0xC0	; CONSTANTE PARA LINHA INFERIOR

#DEFINE LIMITE_1	(.256/.8)*1-1 ; DEFINE LIMITES PARA OS LEDS
#DEFINE LIMITE_2	(.256/.8)*2-1
#DEFINE LIMITE_3	(.256/.8)*3-1
#DEFINE LIMITE_4	(.256/.8)*4-1
#DEFINE LIMITE_5	(.256/.8)*5-1
#DEFINE LIMITE_6	(.256/.8)*6-1
#DEFINE LIMITE_7	(.256/.8)*7-1
#DEFINE LIMITE_8	(.256/.8)*8-1

;*	*	*	*	*	*	*	*	*	*
;*			  ENTRADAS DO SISTEMA				*
;*	*	*	*	*	*	*	*	*	*

;*	*	*	*	*	*	*	*	*	*
;*			  SA�DAS DO SISTEMA				*
;*	*	*	*	*	*	*	*	*	*

; AQUI S�O DEFINIDAS AS SA�DAS QUE SER�O UTILIZADOS PELO SISTEMA

#DEFINE BUS		PORTD	; DEFINE O BARRAMENTO COMO O PORTD 
#DEFINE RS		PORTE,2	; RS DO DISPLAY
#DEFINE EN		PORTE,1 ; EN DO DISPLAY
#DEFINE SEL_LEDS	PORTB,5 ; SELE��O DOS LEDS

;*	*	*	*	*	*	*	*	*	*
;*			    VETOR DE RESET				*
;*	*	*	*	*	*	*	*	*	*

	ORG 	0x0000		; ENDERE�O INICIAL DA M�QUINA
	GOTO	CONFIG_		; SALTA PARA CONFIGURAR A M�QUINA

;*	*	*	*	*	*	*	*	*	*
;*		         VETOR DE INTERRUP��O				*
;*	*	*	*	*	*	*	*	*	*

	ORG 	0x0004		; ENDERE�O INICIAL DO VETOR DE INTERRUP��O
	RETFIE			; RETORNA DA INTERRUP��O

;*	*	*	*	*	*	*	*	*	*
;*	              ROTINA DE MULTIPLICA��O 8x8			*
;*			  ENTRADAS: ARG1:ARG0				*	
;*			   SA�DA: ARG1:ARG0				*
;*		    VARI�VEIS AUXILIARES: MUL1:MUL0			*
;*	*	*	*	*	*	*	*	*	*

MULTIPLICACAO

	MOVF	ARG0,F		; VERIFICA SE ALGUMA DAS VARI�VEIS
	BTFSC	STATUS,Z	; � NULA	
	GOTO	SAI_EM_0
	
	MOVF	ARG1,F
	BTFSC	STATUS,Z
	GOTO	SAI_EM_0
	
	CLRF	MUL1
	CLRF	MUL0
	
MULT
	MOVF	ARG0,W		; FAZ A SOMA SUCESSIVA, OU SEJA
	ADDWF	MUL0,F		; A MULTIPLICA��O
	BTFSC	STATUS,C
	INCF	MUL1,F
	
	DECFSZ	ARG1,F
	GOTO	MULT
	
	MOVF	MUL1,W		; RETORNA O VALOR DA MULTIPLICA��O
	MOVWF	ARG1
	MOVF	MUL0,W
	MOVWF	ARG0
	RETURN
		
SAI_EM_0
	
	CLRF	ARG0
	CLRF	ARG1
	RETURN	
	
;*	*	*	*	*	*	*	*	*	*
;*	              ROTINA DE DELAY DE 1ms A 256ms			*
;*	*	*	*	*	*	*	*	*	*

DELAY_MS
	
	CLRWDT
	
	MOVWF	TEMPO2		; SALVA O VALOR MULTIPLICADOR
	CLRF	TEMPO1		; LIMPA REGISTRADOR

DELAY_A
	
	NOP			; PERDE 1 CICLO DE M�QUINA
	DECFSZ	TEMPO1,F	; DECREMENTA REGISTRADOR, ACABOU?
	GOTO	$-2		; N�O, ENT�O RETORNA DUAS POSI��ES 
	DECFSZ	TEMPO2,F
	GOTO	DELAY_A
	
	RETURN			; RETORNA DA INTERRUP��O

;*	*	*	*	*	*	*	*	*	*
;*	          ROTINA PARA ESCREVER DADOS NO DISPLAY			*
;*	*	*	*	*	*	*	*	*	*

ENVIA_COMANDO
	
	BCF	RS		; P�E EM MODO DE COMANDO
	
ENVIA_DADO
	
	BCF	SEL_LEDS	; DESLIGA A SA�DA DOS LEDS
	MOVWF	BUS		; MOVE DADO PARA O PORTD
		
	GOTO	$+1		; DE�AY PARA ACOMODA��O
	GOTO	$+1		
	
	BSF	EN		; GERA PULSO DE CLOCK
	GOTO	$+1
	BCF	EN
	
	BSF	RS		; VOLTA PARA O MODO DADOS
	
	MOVF	BYTE_LED,W
	MOVWF	BUS		; ATUALIZA A SA�DA DE LEDS
	BSF	SEL_LEDS	; LIGA A SA�DA DE LEDS
	
	MOVLW	.1
	CALL	DELAY_MS
	RETURN			; RETORNA DA INTERRUP��O

;*	*	*	*	*	*	*	*	*	*
;*	          ROTINA DE CONVERS�O BIN�RIO PARA DECIMAL 		*
;*		             ENTRADAS: MSB:LSB				*
;*  SA�DA: CONVERSAO_4:CONVERSAO_3:CONVERSAO_2:CONVERSAO_1:CONVERSAO_0  *
;*	*	*	*	*	*	*	*	*	*

BIN_TO_DEC
	
	CLRF	CONVERSAO_0	; INICIALIZA VARI�VEIS DE CONVERS�O
	CLRF	CONVERSAO_1
	CLRF	CONVERSAO_2
	CLRF	CONVERSAO_3
	CLRF	CONVERSAO_4
		
	MOVF	LSB,F		; VERIFICA SE ALGUMA DAS VARI�VEIS � NULA
	BTFSS	STATUS,Z
	GOTO	INC_MSB
	
	MOVF	MSB,F
	BTFSC	STATUS,Z
	RETURN
	
	MOVF	LSB,F
	BTFSC	STATUS,Z
	GOTO	CONVERSAO_A
	
INC_MSB	

	INCF	MSB,F
		
CONVERSAO_A

	CLRWDT	
	INCF	CONVERSAO_0,F		; FAZ A CONVERS�O DO
	MOVLW	.10			; RESULTADO PASSADO COMO ARGUMENTO
	XORWF	CONVERSAO_0,W
	BTFSS	STATUS,Z
	GOTO	CONVERSAO_B
	
	CLRF	CONVERSAO_0
	INCF	CONVERSAO_1,F
	MOVLW	.10
	XORWF	CONVERSAO_1,W
	BTFSS	STATUS,Z
	GOTO	CONVERSAO_B
	
	CLRF	CONVERSAO_1
	INCF	CONVERSAO_2,F
	MOVLW	.10
	XORWF	CONVERSAO_2,W
	BTFSS	STATUS,Z
	GOTO	CONVERSAO_B
	
	CLRF	CONVERSAO_2
	INCF	CONVERSAO_3,F
	MOVLW	.10
	XORWF	CONVERSAO_3,W
	BTFSS	STATUS,Z
	GOTO	CONVERSAO_B
	
	CLRF	CONVERSAO_3
	INCF	CONVERSAO_4,F
	
CONVERSAO_B	

	DECFSZ	LSB,F
	GOTO	CONVERSAO_A
	
	DECFSZ	MSB,F
	GOTO	CONVERSAO_A
		
	RETURN	

;*	*	*	*	*	*	*	*	*	*
;*		     ROTINA DE ATUALIZA��O DA TELA DO LCD 		*
;*	*	*	*	*	*	*	*	*	*

ATUALIZA_TELA
	
	MOVWF	TEMP		; SALVA O DADO EM TEMP
	
	MOVLW	0x81
	CALL	ENVIA_COMANDO	; COMANDO PARA POSICIONAR O DISPLAY
	
	MOVLW	'V'
	CALL	ENVIA_DADO	; ENVIA CARACTER ASCII	
	
	MOVLW	'a'
	CALL	ENVIA_DADO	; ENVIA CARACTER ASCII	
	
	MOVLW	'l'
	CALL	ENVIA_DADO	; ENVIA CARACTER ASCII	
	
	MOVLW	'o'
	CALL	ENVIA_DADO	; ENVIA CARACTER ASCII	
	
	MOVLW	'r'
	CALL	ENVIA_DADO	; ENVIA CARACTER ASCII	
	
	MOVLW	' '
	CALL	ENVIA_DADO	; ENVIA CARACTER ASCII	
	
	MOVLW	'A'
	CALL	ENVIA_DADO	; ENVIA CARACTER ASCII	
	
	MOVLW	'/'
	CALL	ENVIA_DADO	; ENVIA CARACTER ASCII	
	
	MOVLW	'D'
	CALL	ENVIA_DADO	; ENVIA CARACTER ASCII	
	
	MOVLW	' '
	CALL	ENVIA_DADO	; ENVIA CARACTER ASCII	
	
	MOVF	TEMP,W		; FAZ CONVERS�O DA PARA
	MOVWF	LSB		; DECIMAL DA LEITURA DO A/D
	CLRF	MSB
	CALL	BIN_TO_DEC
	
	MOVF	CONVERSAO_2,W	; APRESENTA VALOR NO DISPLAY
	ADDLW	0x30
	CALL	ENVIA_DADO
	
	MOVF	CONVERSAO_1,W
	ADDLW	0x30
	CALL	ENVIA_DADO
	
	MOVF	CONVERSAO_0,W
	ADDLW	0x30
	CALL	ENVIA_DADO
		
	MOVLW	0xC1
	CALL	ENVIA_COMANDO	; COMANDO PARA POSICIONAR O DISPLAY

	MOVLW	'T'
	CALL	ENVIA_DADO	; ENVIA CARACTER ASCII	
	 
	MOVLW	'e'
	CALL	ENVIA_DADO	; ENVIA CARACTER ASCII	
	 
	MOVLW	'n'
	CALL	ENVIA_DADO	; ENVIA CARACTER ASCII	
		
	MOVLW	's'
	CALL	ENVIA_DADO	; ENVIA CARACTER ASCII	
	 
	MOVLW	'a'
	CALL	ENVIA_DADO	; ENVIA CARACTER ASCII	
	 
	MOVLW	'o'
	CALL	ENVIA_DADO	; ENVIA CARACTER ASCII	
	
	MOVLW	' '
	CALL	ENVIA_DADO	; ENVIA CARACTER ASCII	
	
	MOVF	TEMP,W		; FAZ CONVERS�O PARA VOLTS
	MOVWF	ARG0
	MOVLW	.20 
	MOVWF	ARG1
	CALL	MULTIPLICACAO
	
	MOVF	ARG1,W
	MOVWF	MSB
	MOVF	ARG0,W
	MOVWF	LSB
	CALL	BIN_TO_DEC
	
	MOVF	CONVERSAO_3,W	; APRESENTA O RESULTADO NO DISPLAY
	ADDLW	0x30
	CALL	ENVIA_DADO
	
	MOVLW	','
	CALL	ENVIA_DADO
	
	MOVF	CONVERSAO_2,W
	ADDLW	0x30
	CALL	ENVIA_DADO
	
	MOVF	CONVERSAO_1,W
	ADDLW	0x30
	CALL	ENVIA_DADO
	
	MOVLW	' '
	CALL	ENVIA_DADO	; ENVIA CARACTER ASCII	
		 
	MOVLW	'V'
	CALL	ENVIA_DADO	; ENVIA CARACTER ASCII	
	
	CLRF	BYTE_LED
	
	CALL	ATUALIZA_LEDS	; CHAMA ROTINA PARA ATUALIZAR OS LEDS
	
	MOVLW	.100		; AGUARDA 100ms
	CALL	DELAY_MS
			
	RETURN			; RETORNA DA ROTINA	

;*	*	*	*	*	*	*	*	*	*
;*         	          ROTINA DE ATUALIZA��O DOS LEDS		*
;*	*	*	*	*	*	*	*	*	*

ATUALIZA_LEDS
	
	MOVLW	LIMITE_1	; VERIFICA SE O VALOR DA CONVERS�O
	SUBWF	TEMP,W		; � MAIOR QUE A PRIMEIRA CONSTANTE
	BTFSC	STATUS,Z	
	BSF	BYTE_LED,0	; CASO SEJA, SETA O PRIMEIRO BIT
	BTFSC	STATUS,C	; NO RESULTADO QUE SER� APRESENTADO
	BSF	BYTE_LED,0	; NOS LEDS

	MOVLW	LIMITE_2	; VERIFICA SE O VALOR DA CONVERS�O
	SUBWF	TEMP,W		; � MAIOR QUE A SEGUNDA CONSTANTE
	BTFSC	STATUS,Z	
	BSF	BYTE_LED,1	; CASO SEJA, SETA O SEGUNDO BIT
	BTFSC	STATUS,C	; NO RESULTADO QUE SER� APRESENTADO
	BSF	BYTE_LED,1	; NOS LEDS
	
	MOVLW	LIMITE_3	; VERIFICA SE O VALOR DA CONVERS�O
	SUBWF	TEMP,W		; � MAIOR QUE A TERCEIRA CONSTANTE
	BTFSC	STATUS,Z	
	BSF	BYTE_LED,2	; CASO SEJA, SETA O TERCEIRO BIT
	BTFSC	STATUS,C	; NO RESULTADO QUE SER� APRESENTADO
	BSF	BYTE_LED,2	; NOS LEDS

	MOVLW	LIMITE_4	; VERIFICA SE O VALOR DA CONVERS�O
	SUBWF	TEMP,W		; � MAIOR QUE A QUARTA CONSTANTE
	BTFSC	STATUS,Z	
	BSF	BYTE_LED,3	; CASO SEJA, SETA O QUARTO BIT
	BTFSC	STATUS,C	; NO RESULTADO QUE SER� APRESENTADO
	BSF	BYTE_LED,3	; NOS LEDS
	
	MOVLW	LIMITE_5	; VERIFICA SE O VALOR DA CONVERS�O
	SUBWF	TEMP,W		; � MAIOR QUE A QUINTA CONSTANTE
	BTFSC	STATUS,Z	
	BSF	BYTE_LED,4	; CASO SEJA, SETA O QUINTO BIT
	BTFSC	STATUS,C	; NO RESULTADO QUE SER� APRESENTADO
	BSF	BYTE_LED,4	; NOS LEDS

	MOVLW	LIMITE_6	; VERIFICA SE O VALOR DA CONVERS�O
	SUBWF	TEMP,W		; � MAIOR QUE A SEXTA CONSTANTE
	BTFSC	STATUS,Z	
	BSF	BYTE_LED,5	; CASO SEJA, SETA O SEXTO BIT
	BTFSC	STATUS,C	; NO RESULTADO QUE SER� APRESENTADO
	BSF	BYTE_LED,5	; NOS LEDS
	
	MOVLW	LIMITE_7	; VERIFICA SE O VALOR DA CONVERS�O
	SUBWF	TEMP,W		; � MAIOR QUE A S�TIMA CONSTANTE
	BTFSC	STATUS,Z	
	BSF	BYTE_LED,6	; CASO SEJA, SETA O S�TIMO BIT
	BTFSC	STATUS,C	; NO RESULTADO QUE SER� APRESENTADO
	BSF	BYTE_LED,6	; NOS LEDS

	MOVLW	LIMITE_8	; VERIFICA SE O VALOR DA CONVERS�O
	SUBWF	TEMP,W		; � MAIOR QUE A OITAVA CONSTANTE
	BTFSC	STATUS,Z	
	BSF	BYTE_LED,7	; CASO SEJA, SETA O OITAVO BIT
	BTFSC	STATUS,C	; NO RESULTADO QUE SER� APRESENTADO
	BSF	BYTE_LED,7	; NOS LEDS
	
	MOVF	BYTE_LED,W
	MOVWF	BUS		; ATUALIZA O BARRAMENTO
	
	RETURN			; RETORNA DA ROTINA
			
;*	*	*	*	*	*	*	*	*	*
;*		          CONFIGURACOES INICIAIS			*
;*	*	*	*	*	*	*	*	*	*

CONFIG_

	CLRF	PORTA		; LIMPA O PORTA
	CLRF	PORTB		; LIMPA O PORTB
	CLRF	PORTC		; LIMPA O PORTC
	CLRF	PORTD		; LIMPA O PORTD
	CLRF	PORTE		; LIMPA O PORTE
	
	BANK1			; SELECIONA BANCO1 DE MEM�RIA
	
	MOVLW	B'11111111'	
	MOVWF	TRISA		; CONFIGURA I/O DO PORTB
	
	MOVLW	B'11000000'
	MOVWF	TRISB		; CONFIGURA I/O DO PORTB
	
	MOVLW	B'11011111'
	MOVWF	TRISC		; CONFIGURA I/O DO PORTB
	
	MOVLW	B'00000000'	; CONFIGURA TODOS OS PINOS DESTE
	MOVWF	TRISD		; PORTB COMO SA�DA
	
	MOVLW	B'00000001'
	MOVWF	TRISE		; CONFIGURA I/O DO PORTE
	
	MOVLW	B'10001111'	; DESLIGA PULL-UPS
	MOVWF	OPTION_REG	; WDT 1:128
	
	MOVLW	B'00000000'	
	MOVWF	INTCON		; HABILITA A INTERRUP��O DE TIMER 0
				; LIGA A CHAVE GERAL DE INTERRUP��O
	
	MOVLW	B'00000110'	; CONFIGURA RA0, RA1 E RA3 COMO ENTRADA DO
	MOVWF	ADCON1		; A/D
	
	BANK0
	
	MOVLW	B'01000001'
	MOVWF	ADCON0		; CLOCK DO CONVERSOR-> 1:8
				; CANAL 0 EST� SELECIONADO
				; AD EST� LIGADO		
	
	BTFSC	STATUS,NOT_TO	; ESTOURO POR WDT?
	GOTO	$		; N�O, ENT�O AGUARDA
		
LIMPEZA_DA_RAM
				; ROTINA DE LIMPEZA DA RAM
				
	MOVLW	0x20
	MOVWF	FSR
	CLRF	INDF
	INCF	FSR,F
	MOVLW	0x80
	XORWF	FSR,W
	BTFSS	STATUS,Z
	GOTO	$-5

;*	*	*	*	*	*	*	*	*	*
;*         	         INICIALIZA��O DO DISPLAY			*
;*	*	*	*	*	*	*	*	*	*
	


	MOVLW	0x30			
	CALL	ENVIA_COMANDO		; COMANDO DE INICIALIZA��O
	
	MOVLW	.3			
	CALL	DELAY_MS		; DELAY DE 3ms
	
	MOVLW	0x30			
	CALL	ENVIA_COMANDO		; COMANDO DE INICIALIZA��O	
	
	MOVLW	0x30			
	CALL	ENVIA_COMANDO		; COMANDO DE INICIALIZA��O
	
	MOVLW	0x38			
	CALL	ENVIA_COMANDO		; INTERFACE DE 8 VIAS
	
	MOVLW	0x01			
	CALL	ENVIA_COMANDO		; LIMPA O DISPLAY
	
	MOVLW	.1
	CALL	DELAY_MS		; CHAMA DELAY DE 3ms
	
	MOVLW	0x0C			
	CALL	ENVIA_COMANDO		; LIGAR O DISPLAY SEM CURSOR
	
	MOVLW	0x06			
	CALL	ENVIA_COMANDO		; LIGAR O DISPLAY SEM CURSOR
	
								
;*	*	*	*	*	*	*	*	*	*
;*         	         INICIALIZA��O DAS VARI�VEIS			*
;*	*	*	*	*	*	*	*	*	*
	
;*	*	*	*	*	*	*	*	*	*
;*		            ROTINA PRINCIPAL				*
;*	*	*	*	*	*	*	*	*	*

LOOP
	CLRWDT			; LIMPA O WATCHDOG
	
	BSF	ADCON0,GO	; INICIA A CONVERS�O
	
	BTFSC	ADCON0,GO
	GOTO	$-1		; AGUARDA O FIM DA CONVERS�O
	
	MOVF	ADRESH,W  	
	CALL	ATUALIZA_TELA 	; CHAMA ROTINA PARA ATUALIZAR O DISPLAY
	
	GOTO	LOOP		; SALTA PARA O LOOP PRINCIPAL
		
;*	*	*	*	*	*	*	*	*	*
;*		             FIM DO PROGRAMA				*
;*	*	*	*	*	*	*	*	*	*


	END			; FIM DO PROGRAMA


