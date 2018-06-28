;  Assembly code generated by mikroVirtualMachine - V. 5.0.0.3
;  Date/Time: 4/3/2008 13:21:52
;  Info: http://www.mikroe.com


; ADDRESS	OPCODE	ASM
; ----------------------------------------------
$0000	$283D			GOTO	_main
$0004	$	_usart_write:
;USART_c67.ppas,40 :: 		
;USART_c67.ppas,42 :: 		
$0004	$	USART_c67_L_14:
$0004	$3000			MOVLW	0
$0005	$1303			BCF	STATUS, RP1
$0006	$1683			BSF	STATUS, RP0
$0007	$1898			BTFSC	TXSTA, 1
$0008	$3001			MOVLW	1
$0009	$00F1			MOVWF	STACK_1
$000A	$0871			MOVF	STACK_1, 0
$000B	$3A00			XORLW	0
$000C	$1D03			BTFSS	STATUS, Z
$000D	$2810			GOTO	USART_c67_L_15
;USART_c67.ppas,43 :: 		
$000E	$0000			NOP
$000F	$2804			GOTO	USART_c67_L_14
$0010	$	USART_c67_L_15:
;USART_c67.ppas,44 :: 		
$0010	$1283			BCF	STATUS, RP0
$0011	$0835			MOVF	FARG_USART_Write, 0
$0012	$0099			MOVWF	TXREG
$0013	$	USART_c67_L_12:
;USART_c67.ppas,45 :: 		
$0013	$0008			RETURN
$0014	$	_usart_write_text:
;USART_c67.ppas,121 :: 		
;USART_c67.ppas,122 :: 		
$0014	$1303			BCF	STATUS, RP1
$0015	$1283			BCF	STATUS, RP0
$0016	$01B2			CLRF	_usart_write_text_local_i, 1
;USART_c67.ppas,123 :: 		
$0017	$0831			MOVF	FARG_Usart_Write_Text, 0
$0018	$0084			MOVWF	FSR
$0019	$0800			MOVF	INDF, 0
$001A	$00B3			MOVWF	_usart_write_text_local_data
;USART_c67.ppas,124 :: 		
$001B	$	USART_c67_L_47:
$001B	$0833			MOVF	_usart_write_text_local_data, 0
$001C	$3A00			XORLW	0
$001D	$1903			BTFSC	STATUS, Z
$001E	$2829			GOTO	USART_c67_L_48
;USART_c67.ppas,126 :: 		
$001F	$0833			MOVF	_usart_write_text_local_data, 0
$0020	$00B5			MOVWF	FARG_USART_Write
$0021	$2004			CALL	_usart_write
;USART_c67.ppas,127 :: 		
$0022	$0AB2			INCF	_usart_write_text_local_i, 1
;USART_c67.ppas,128 :: 		
$0023	$0832			MOVF	_usart_write_text_local_i, 0
$0024	$0731			ADDWF	FARG_Usart_Write_Text, 0
$0025	$0084			MOVWF	FSR
$0026	$0800			MOVF	INDF, 0
$0027	$00B3			MOVWF	_usart_write_text_local_data
;USART_c67.ppas,129 :: 		
$0028	$281B			GOTO	USART_c67_L_47
$0029	$	USART_c67_L_48:
$0029	$	USART_c67_L_45:
;USART_c67.ppas,130 :: 		
$0029	$0008			RETURN
$002A	$	_usart_init:
;USART_c67.ppas,22 :: 		
;USART_c67.ppas,24 :: 		
$002A	$	USART_c67_L_1:
$002A	$1303			BCF	STATUS, RP1
$002B	$1683			BSF	STATUS, RP0
$002C	$1698			BSF	TXSTA, 5
$002D	$	USART_c67_L_2:
;USART_c67.ppas,25 :: 		
$002D	$3090			MOVLW	144
$002E	$1283			BCF	STATUS, RP0
$002F	$0098			MOVWF	RCSTA
;USART_c67.ppas,31 :: 		
$0030	$	USART_c67_L_3:
$0030	$1683			BSF	STATUS, RP0
$0031	$1787			BSF	TRISC, 7
$0032	$	USART_c67_L_4:
;USART_c67.ppas,32 :: 		
$0032	$1307			BCF	TRISC, 6
$0033	$	USART_c67_L_6:
;USART_c67.ppas,35 :: 		
$0033	$	USART_c67_L_8:
$0033	$3000			MOVLW	0
$0034	$1283			BCF	STATUS, RP0
$0035	$1A8C			BTFSC	PIR1, 5
$0036	$3001			MOVLW	1
$0037	$00F1			MOVWF	STACK_1
$0038	$0871			MOVF	STACK_1, 0
$0039	$3A01			XORLW	1
$003A	$1903			BTFSC	STATUS, Z
$003B	$2833			GOTO	USART_c67_L_8
;USART_c67.ppas,36 :: 		
$003C	$	USART_c67_L_9:
$003C	$	USART_c67_L_0:
;USART_c67.ppas,37 :: 		
$003C	$0008			RETURN
$003D	$	_main:
;USART.ppas,3 :: 		begin
;USART.ppas,5 :: 		usart_init(9600);                      //Inicializa em 9600 bps
$003D	$3019			MOVLW	25
$003E	$1303			BCF	STATUS, RP1
$003F	$1683			BSF	STATUS, RP0
$0040	$0099			MOVWF	SPBRG
$0041	$1518			BSF	TXSTA, BRGH
$0042	$202A			CALL	_usart_init
;USART.ppas,6 :: 		usart_write_text('Cerne Tecnologia');  //Envia o texto Cerne Tecnologia
$0043	$3043			MOVLW	67
$0044	$00A0			MOVWF	?main_Local_Text+0
$0045	$3065			MOVLW	101
$0046	$00A1			MOVWF	?main_Local_Text+1
$0047	$3072			MOVLW	114
$0048	$00A2			MOVWF	?main_Local_Text+2
$0049	$306E			MOVLW	110
$004A	$00A3			MOVWF	?main_Local_Text+3
$004B	$3065			MOVLW	101
$004C	$00A4			MOVWF	?main_Local_Text+4
$004D	$3020			MOVLW	32
$004E	$00A5			MOVWF	?main_Local_Text+5
$004F	$3054			MOVLW	84
$0050	$00A6			MOVWF	?main_Local_Text+6
$0051	$3065			MOVLW	101
$0052	$00A7			MOVWF	?main_Local_Text+7
$0053	$3063			MOVLW	99
$0054	$00A8			MOVWF	?main_Local_Text+8
$0055	$306E			MOVLW	110
$0056	$00A9			MOVWF	?main_Local_Text+9
$0057	$306F			MOVLW	111
$0058	$00AA			MOVWF	?main_Local_Text+10
$0059	$306C			MOVLW	108
$005A	$00AB			MOVWF	?main_Local_Text+11
$005B	$306F			MOVLW	111
$005C	$00AC			MOVWF	?main_Local_Text+12
$005D	$3067			MOVLW	103
$005E	$00AD			MOVWF	?main_Local_Text+13
$005F	$3069			MOVLW	105
$0060	$00AE			MOVWF	?main_Local_Text+14
$0061	$3061			MOVLW	97
$0062	$00AF			MOVWF	?main_Local_Text+15
$0063	$01B0			CLRF	?main_Local_Text+16
$0064	$3020			MOVLW	?main_Local_Text
$0065	$00B1			MOVWF	FARG_Usart_Write_Text
$0066	$2014			CALL	_usart_write_text
$0067	$	USART_L_0:
;USART.ppas,7 :: 		end.
$0067	$2867			GOTO	$
