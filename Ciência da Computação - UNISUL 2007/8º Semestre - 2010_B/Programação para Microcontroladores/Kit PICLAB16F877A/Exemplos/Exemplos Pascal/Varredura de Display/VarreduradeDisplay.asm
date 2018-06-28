;  Assembly code generated by mikroVirtualMachine - V. 5.0.0.3
;  Date/Time: 4/3/2008 13:18:33
;  Info: http://www.mikroe.com


; ADDRESS	OPCODE	ASM
; ----------------------------------------------
$0000	$2804			GOTO	_main
$0004	$	_main:
;VarreduradeDisplay.ppas,3 :: 		begin
;VarreduradeDisplay.ppas,4 :: 		trisd:=%00000000;       //Configura todo o PORTD como sa�da
$0004	$1303			BCF	STATUS, RP1
$0005	$1683			BSF	STATUS, RP0
$0006	$0188			CLRF	TRISD, 1
;VarreduradeDisplay.ppas,5 :: 		trisb:=%00000000;       //Configura todo o PORTB como sa�da
$0007	$0186			CLRF	TRISB, 1
;VarreduradeDisplay.ppas,7 :: 		while true do
$0008	$	VarreduradeDisplay_L_2:
;VarreduradeDisplay.ppas,9 :: 		portd:=79;              //Carrega no barramento o valor referente ao digito 3
$0008	$304F			MOVLW	79
$0009	$1283			BCF	STATUS, RP0
$000A	$0088			MOVWF	PORTD
;VarreduradeDisplay.ppas,10 :: 		portb:=%00010000;       //Liga um display do barramento
$000B	$3010			MOVLW	16
$000C	$0086			MOVWF	PORTB
;VarreduradeDisplay.ppas,11 :: 		delay_ms(10);           //Aguarda 10 ms
$000D	$300D			MOVLW	13
$000E	$00FB			MOVWF	STACK_11
$000F	$30FF			MOVLW	255
$0010	$00FA			MOVWF	STACK_10
$0011	$0BFB			DECFSZ	STACK_11, F
$0012	$2814			GOTO	$+2
$0013	$2817			GOTO	$+4
$0014	$0BFA			DECFSZ	STACK_10, F
$0015	$2814			GOTO	$-1
$0016	$2811			GOTO	$-5
$0017	$30F3			MOVLW	243
$0018	$00FA			MOVWF	STACK_10
$0019	$0BFA			DECFSZ	STACK_10, F
$001A	$2819			GOTO	$-1
$001B	$0000			NOP
;VarreduradeDisplay.ppas,12 :: 		portb:=%00000000;       //Desliga o display
$001C	$0186			CLRF	PORTB, 1
;VarreduradeDisplay.ppas,14 :: 		portd:=6;               //Carrega no barramento o valor referente ao digito 1
$001D	$3006			MOVLW	6
$001E	$0088			MOVWF	PORTD
;VarreduradeDisplay.ppas,15 :: 		portb:=%00001000;       //Liga um display do barramento
$001F	$3008			MOVLW	8
$0020	$0086			MOVWF	PORTB
;VarreduradeDisplay.ppas,16 :: 		delay_ms(10);           //Aguarda 10 ms
$0021	$300D			MOVLW	13
$0022	$00FB			MOVWF	STACK_11
$0023	$30FF			MOVLW	255
$0024	$00FA			MOVWF	STACK_10
$0025	$0BFB			DECFSZ	STACK_11, F
$0026	$2828			GOTO	$+2
$0027	$282B			GOTO	$+4
$0028	$0BFA			DECFSZ	STACK_10, F
$0029	$2828			GOTO	$-1
$002A	$2825			GOTO	$-5
$002B	$30F3			MOVLW	243
$002C	$00FA			MOVWF	STACK_10
$002D	$0BFA			DECFSZ	STACK_10, F
$002E	$282D			GOTO	$-1
$002F	$0000			NOP
;VarreduradeDisplay.ppas,17 :: 		portb:=%00000000;       //Desliga o display
$0030	$0186			CLRF	PORTB, 1
;VarreduradeDisplay.ppas,19 :: 		end;
$0031	$2808			GOTO	VarreduradeDisplay_L_2
;VarreduradeDisplay.ppas,20 :: 		end.
$0032	$2832			GOTO	$
