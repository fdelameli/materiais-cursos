;  ASM code generated by mikroVirtualMachine for PIC - V. 6.2.1.0
;  Date/Time: 27/10/2007 19:49:19
;  Info: http://www.mikroelektronika.co.yu


; ADDRESS	OPCODE	ASM
; ----------------------------------------------
$0000	$28C8			GOTO	_main
$0004	$	_Delay_1us:
;delays.c,2 :: 		void Delay_1us() {
;delays.c,3 :: 		Delay_us(1);
$0004	$0000			NOP
;delays.c,4 :: 		}
$0005	$0008			RETURN
$0006	$	_Delay_5500us:
;delays.c,26 :: 		void Delay_5500us() {
;delays.c,27 :: 		Delay_us(5500);
$0006	$3008			MOVLW	8
$0007	$1303			BCF	STATUS, RP1
$0008	$1283			BCF	STATUS, RP0
$0009	$00FB			MOVWF	STACK_11
$000A	$30FF			MOVLW	255
$000B	$00FA			MOVWF	STACK_10
$000C	$0BFB			DECFSZ	STACK_11, F
$000D	$280F			GOTO	$+2
$000E	$2812			GOTO	$+4
$000F	$0BFA			DECFSZ	STACK_10, F
$0010	$280F			GOTO	$-1
$0011	$280C			GOTO	$-5
$0012	$301E			MOVLW	30
$0013	$00FA			MOVWF	STACK_10
$0014	$0BFA			DECFSZ	STACK_10, F
$0015	$2814			GOTO	$-1
;delays.c,28 :: 		}
$0016	$0008			RETURN
$0017	$	_Delay_50us:
;delays.c,14 :: 		void Delay_50us() {
;delays.c,15 :: 		Delay_us(50);
$0017	$3010			MOVLW	16
$0018	$1303			BCF	STATUS, RP1
$0019	$1283			BCF	STATUS, RP0
$001A	$00FA			MOVWF	STACK_10
$001B	$0BFA			DECFSZ	STACK_10, F
$001C	$281B			GOTO	$-1
$001D	$0000			NOP
;delays.c,16 :: 		}
$001E	$0008			RETURN
$001F	$	_Lcd8_Cmd:
$001F	$1303			BCF	STATUS, RP1
$0020	$1283			BCF	STATUS, RP0
$0021	$0820			MOVF	lcd8bit_DataAddress, 0
$0022	$0084			MOVWF	FSR
$0023	$0180			CLRF	INDF, 1
$0024	$0855			MOVF	FARG_Lcd8_Cmd+0, 0
$0025	$1903			BTFSC	STATUS, Z
$0026	$2827			GOTO	L_Lcd8_Cmd_0
$0027	$	L_Lcd8_Cmd_0:
$0027	$1BD5			BTFSC	FARG_Lcd8_Cmd+0, 7
$0028	$1780			BSF	INDF, __LCD8_DB7
$0029	$1B55			BTFSC	FARG_Lcd8_Cmd+0, 6
$002A	$1700			BSF	INDF, __LCD8_DB6
$002B	$1AD5			BTFSC	FARG_Lcd8_Cmd+0, 5
$002C	$1680			BSF	INDF, __LCD8_DB5
$002D	$1A55			BTFSC	FARG_Lcd8_Cmd+0, 4
$002E	$1600			BSF	INDF, __LCD8_DB4
$002F	$19D5			BTFSC	FARG_Lcd8_Cmd+0, 3
$0030	$1580			BSF	INDF, __LCD8_DB3
$0031	$1955			BTFSC	FARG_Lcd8_Cmd+0, 2
$0032	$1500			BSF	INDF, __LCD8_DB2
$0033	$18D5			BTFSC	FARG_Lcd8_Cmd+0, 1
$0034	$1480			BSF	INDF, __LCD8_DB1
$0035	$1855			BTFSC	FARG_Lcd8_Cmd+0, 0
$0036	$1400			BSF	INDF, __LCD8_DB0
$0037	$0821			MOVF	lcd8bit_CtrlAddress, 0
$0038	$0084			MOVWF	FSR
$0039	$1500			BSF	INDF, __LCD8_RS
$003A	$0822			MOVF	_com, 0
$003B	$1903			BTFSC	STATUS, Z
$003C	$283E			GOTO	L_Lcd8_Cmd_1
$003D	$1100			BCF	INDF, __LCD8_RS
$003E	$	L_Lcd8_Cmd_1:
$003E	$1480			BSF	INDF, __LCD8_ENABLE
$003F	$2004			CALL	_Delay_1us
$0040	$1080			BCF	INDF, __LCD8_ENABLE
$0041	$0822			MOVF	_com, 0
$0042	$1903			BTFSC	STATUS, Z
$0043	$2846			GOTO	L_Lcd8_Cmd_2
$0044	$2006			CALL	_Delay_5500us
$0045	$2847			GOTO	L_Lcd8_Cmd_3
$0046	$	L_Lcd8_Cmd_2:
$0046	$2017			CALL	_Delay_50us
$0047	$	L_Lcd8_Cmd_3:
$0047	$0008			RETURN
$0048	$	_Lcd8_Chr:
$0048	$285A			GOTO	L_Lcd8_Chr_4
$0049	$	L_Lcd8_Chr_6:
$0049	$3080			MOVLW	128
$004A	$1303			BCF	STATUS, RP1
$004B	$1283			BCF	STATUS, RP0
$004C	$00D2			MOVWF	FARG_Lcd8_Chr+0
$004D	$286D			GOTO	L_Lcd8_Chr_5
$004E	$	L_Lcd8_Chr_7:
$004E	$30C0			MOVLW	192
$004F	$00D2			MOVWF	FARG_Lcd8_Chr+0
$0050	$286D			GOTO	L_Lcd8_Chr_5
$0051	$	L_Lcd8_Chr_8:
$0051	$3094			MOVLW	148
$0052	$00D2			MOVWF	FARG_Lcd8_Chr+0
$0053	$286D			GOTO	L_Lcd8_Chr_5
$0054	$	L_Lcd8_Chr_9:
$0054	$30D4			MOVLW	212
$0055	$00D2			MOVWF	FARG_Lcd8_Chr+0
$0056	$286D			GOTO	L_Lcd8_Chr_5
$0057	$	L_Lcd8_Chr_10:
$0057	$3080			MOVLW	128
$0058	$00D2			MOVWF	FARG_Lcd8_Chr+0
$0059	$286D			GOTO	L_Lcd8_Chr_5
$005A	$	L_Lcd8_Chr_4:
$005A	$1303			BCF	STATUS, RP1
$005B	$1283			BCF	STATUS, RP0
$005C	$0852			MOVF	FARG_Lcd8_Chr+0, 0
$005D	$3A01			XORLW	1
$005E	$1903			BTFSC	STATUS, Z
$005F	$2849			GOTO	L_Lcd8_Chr_6
$0060	$0852			MOVF	FARG_Lcd8_Chr+0, 0
$0061	$3A02			XORLW	2
$0062	$1903			BTFSC	STATUS, Z
$0063	$284E			GOTO	L_Lcd8_Chr_7
$0064	$0852			MOVF	FARG_Lcd8_Chr+0, 0
$0065	$3A03			XORLW	3
$0066	$1903			BTFSC	STATUS, Z
$0067	$2851			GOTO	L_Lcd8_Chr_8
$0068	$0852			MOVF	FARG_Lcd8_Chr+0, 0
$0069	$3A04			XORLW	4
$006A	$1903			BTFSC	STATUS, Z
$006B	$2854			GOTO	L_Lcd8_Chr_9
$006C	$2857			GOTO	L_Lcd8_Chr_10
$006D	$	L_Lcd8_Chr_5:
$006D	$0353			DECF	FARG_Lcd8_Chr+1, 0
$006E	$00F0			MOVWF	STACK_0
$006F	$0852			MOVF	FARG_Lcd8_Chr+0, 0
$0070	$07F0			ADDWF	STACK_0, 1
$0071	$0870			MOVF	STACK_0, 0
$0072	$00D2			MOVWF	FARG_Lcd8_Chr+0
$0073	$0870			MOVF	STACK_0, 0
$0074	$00D5			MOVWF	FARG_Lcd8_Cmd+0
$0075	$201F			CALL	_Lcd8_Cmd
$0076	$01A2			CLRF	_com, 1
$0077	$0854			MOVF	FARG_Lcd8_Chr+2, 0
$0078	$00D5			MOVWF	FARG_Lcd8_Cmd+0
$0079	$201F			CALL	_Lcd8_Cmd
$007A	$3001			MOVLW	1
$007B	$00A2			MOVWF	_com
$007C	$0008			RETURN
$007D	$	_Lcd8_Init:
$007D	$2006			CALL	_Delay_5500us
$007E	$2006			CALL	_Delay_5500us
$007F	$2006			CALL	_Delay_5500us
$0080	$084E			MOVF	FARG_Lcd8_Init+1, 0
$0081	$00A0			MOVWF	lcd8bit_DataAddress
$0082	$084E			MOVF	FARG_Lcd8_Init+1, 0
$0083	$0084			MOVWF	FSR
$0084	$1784			BSF	FSR, 7
$0085	$0180			CLRF	INDF, 1
$0086	$084D			MOVF	FARG_Lcd8_Init+0, 0
$0087	$00A1			MOVWF	lcd8bit_CtrlAddress
$0088	$084D			MOVF	FARG_Lcd8_Init+0, 0
$0089	$0084			MOVWF	FSR
$008A	$1000			BCF	INDF, __LCD8_RW
$008B	$1784			BSF	FSR, 7
$008C	$1100			BCF	INDF, __LCD8_RS
$008D	$1000			BCF	INDF, __LCD8_RW
$008E	$1080			BCF	INDF, __LCD8_ENABLE
$008F	$1384			BCF	FSR, 7
$0090	$3001			MOVLW	1
$0091	$00A2			MOVWF	_com
$0092	$3030			MOVLW	48
$0093	$00D5			MOVWF	FARG_Lcd8_Cmd+0
$0094	$201F			CALL	_Lcd8_Cmd
$0095	$3030			MOVLW	48
$0096	$00D5			MOVWF	FARG_Lcd8_Cmd+0
$0097	$201F			CALL	_Lcd8_Cmd
$0098	$3030			MOVLW	48
$0099	$00D5			MOVWF	FARG_Lcd8_Cmd+0
$009A	$201F			CALL	_Lcd8_Cmd
$009B	$3038			MOVLW	56
$009C	$00D5			MOVWF	FARG_Lcd8_Cmd+0
$009D	$201F			CALL	_Lcd8_Cmd
$009E	$3008			MOVLW	8
$009F	$00D5			MOVWF	FARG_Lcd8_Cmd+0
$00A0	$201F			CALL	_Lcd8_Cmd
$00A1	$3001			MOVLW	1
$00A2	$00D5			MOVWF	FARG_Lcd8_Cmd+0
$00A3	$201F			CALL	_Lcd8_Cmd
$00A4	$3006			MOVLW	6
$00A5	$00D5			MOVWF	FARG_Lcd8_Cmd+0
$00A6	$201F			CALL	_Lcd8_Cmd
$00A7	$300C			MOVLW	12
$00A8	$00D5			MOVWF	FARG_Lcd8_Cmd+0
$00A9	$201F			CALL	_Lcd8_Cmd
$00AA	$0008			RETURN
$00AB	$	_Lcd8_Out:
$00AB	$1303			BCF	STATUS, RP1
$00AC	$1283			BCF	STATUS, RP0
$00AD	$01D0			CLRF	Lcd8_Out_i_L0, 1
$00AE	$084F			MOVF	FARG_Lcd8_Out+2, 0
$00AF	$0084			MOVWF	FSR
$00B0	$0800			MOVF	INDF, 0
$00B1	$00D1			MOVWF	Lcd8_Out_j_L0
$00B2	$	L_Lcd8_Out_11:
$00B2	$0851			MOVF	Lcd8_Out_j_L0, 0
$00B3	$1903			BTFSC	STATUS, Z
$00B4	$28C7			GOTO	L_Lcd8_Out_12
$00B5	$084D			MOVF	FARG_Lcd8_Out+0, 0
$00B6	$00D2			MOVWF	FARG_Lcd8_Chr+0
$00B7	$0850			MOVF	Lcd8_Out_i_L0, 0
$00B8	$074E			ADDWF	FARG_Lcd8_Out+1, 0
$00B9	$00D3			MOVWF	FARG_Lcd8_Chr+1
$00BA	$0850			MOVF	Lcd8_Out_i_L0, 0
$00BB	$074F			ADDWF	FARG_Lcd8_Out+2, 0
$00BC	$0084			MOVWF	FSR
$00BD	$0800			MOVF	INDF, 0
$00BE	$00D4			MOVWF	FARG_Lcd8_Chr+2
$00BF	$2048			CALL	_Lcd8_Chr
$00C0	$0AD0			INCF	Lcd8_Out_i_L0, 1
$00C1	$0850			MOVF	Lcd8_Out_i_L0, 0
$00C2	$074F			ADDWF	FARG_Lcd8_Out+2, 0
$00C3	$0084			MOVWF	FSR
$00C4	$0800			MOVF	INDF, 0
$00C5	$00D1			MOVWF	Lcd8_Out_j_L0
$00C6	$28B2			GOTO	L_Lcd8_Out_11
$00C7	$	L_Lcd8_Out_12:
$00C7	$0008			RETURN
$00C8	$	_main:
$00C8	$3043			MOVLW	67
$00C9	$1303			BCF	STATUS, RP1
$00CA	$1283			BCF	STATUS, RP0
$00CB	$00A3			MOVWF	lstr1_displaylcd+0
$00CC	$3069			MOVLW	105
$00CD	$00A4			MOVWF	lstr1_displaylcd+1
$00CE	$3064			MOVLW	100
$00CF	$00A5			MOVWF	lstr1_displaylcd+2
$00D0	$3061			MOVLW	97
$00D1	$00A6			MOVWF	lstr1_displaylcd+3
$00D2	$3064			MOVLW	100
$00D3	$00A7			MOVWF	lstr1_displaylcd+4
$00D4	$3065			MOVLW	101
$00D5	$00A8			MOVWF	lstr1_displaylcd+5
$00D6	$303A			MOVLW	58
$00D7	$00A9			MOVWF	lstr1_displaylcd+6
$00D8	$3020			MOVLW	32
$00D9	$00AA			MOVWF	lstr1_displaylcd+7
$00DA	$3052			MOVLW	82
$00DB	$00AB			MOVWF	lstr1_displaylcd+8
$00DC	$306F			MOVLW	111
$00DD	$00AC			MOVWF	lstr1_displaylcd+9
$00DE	$306D			MOVLW	109
$00DF	$00AD			MOVWF	lstr1_displaylcd+10
$00E0	$3061			MOVLW	97
$00E1	$00AE			MOVWF	lstr1_displaylcd+11
$00E2	$01AF			CLRF	lstr1_displaylcd+12
$00E3	$3043			MOVLW	67
$00E4	$00B0			MOVWF	lstr2_displaylcd+0
$00E5	$3069			MOVLW	105
$00E6	$00B1			MOVWF	lstr2_displaylcd+1
$00E7	$3064			MOVLW	100
$00E8	$00B2			MOVWF	lstr2_displaylcd+2
$00E9	$3061			MOVLW	97
$00EA	$00B3			MOVWF	lstr2_displaylcd+3
$00EB	$3064			MOVLW	100
$00EC	$00B4			MOVWF	lstr2_displaylcd+4
$00ED	$3065			MOVLW	101
$00EE	$00B5			MOVWF	lstr2_displaylcd+5
$00EF	$303A			MOVLW	58
$00F0	$00B6			MOVWF	lstr2_displaylcd+6
$00F1	$3020			MOVLW	32
$00F2	$00B7			MOVWF	lstr2_displaylcd+7
$00F3	$3050			MOVLW	80
$00F4	$00B8			MOVWF	lstr2_displaylcd+8
$00F5	$3061			MOVLW	97
$00F6	$00B9			MOVWF	lstr2_displaylcd+9
$00F7	$3072			MOVLW	114
$00F8	$00BA			MOVWF	lstr2_displaylcd+10
$00F9	$3069			MOVLW	105
$00FA	$00BB			MOVWF	lstr2_displaylcd+11
$00FB	$3073			MOVLW	115
$00FC	$00BC			MOVWF	lstr2_displaylcd+12
$00FD	$01BD			CLRF	lstr2_displaylcd+13
$00FE	$3043			MOVLW	67
$00FF	$00BE			MOVWF	lstr3_displaylcd+0
$0100	$3069			MOVLW	105
$0101	$00BF			MOVWF	lstr3_displaylcd+1
$0102	$3064			MOVLW	100
$0103	$00C0			MOVWF	lstr3_displaylcd+2
$0104	$3061			MOVLW	97
$0105	$00C1			MOVWF	lstr3_displaylcd+3
$0106	$3064			MOVLW	100
$0107	$00C2			MOVWF	lstr3_displaylcd+4
$0108	$3065			MOVLW	101
$0109	$00C3			MOVWF	lstr3_displaylcd+5
$010A	$303A			MOVLW	58
$010B	$00C4			MOVWF	lstr3_displaylcd+6
$010C	$3020			MOVLW	32
$010D	$00C5			MOVWF	lstr3_displaylcd+7
$010E	$3042			MOVLW	66
$010F	$00C6			MOVWF	lstr3_displaylcd+8
$0110	$3065			MOVLW	101
$0111	$00C7			MOVWF	lstr3_displaylcd+9
$0112	$3072			MOVLW	114
$0113	$00C8			MOVWF	lstr3_displaylcd+10
$0114	$306C			MOVLW	108
$0115	$00C9			MOVWF	lstr3_displaylcd+11
$0116	$3069			MOVLW	105
$0117	$00CA			MOVWF	lstr3_displaylcd+12
$0118	$306E			MOVLW	110
$0119	$00CB			MOVWF	lstr3_displaylcd+13
$011A	$01CC			CLRF	lstr3_displaylcd+14
;displaylcd.c,17 :: 		void main(void)
;displaylcd.c,19 :: 		delay_ms(2000);
$011B	$300B			MOVLW	11
$011C	$00FC			MOVWF	STACK_12
$011D	$30FF			MOVLW	255
$011E	$00FB			MOVWF	STACK_11
$011F	$30FF			MOVLW	255
$0120	$00FA			MOVWF	STACK_10
$0121	$0BFC			DECFSZ	STACK_12, F
$0122	$2924			GOTO	$+2
$0123	$292B			GOTO	$+8
$0124	$0BFB			DECFSZ	STACK_11, F
$0125	$2927			GOTO	$+2
$0126	$292A			GOTO	$+4
$0127	$0BFA			DECFSZ	STACK_10, F
$0128	$2927			GOTO	$-1
$0129	$2924			GOTO	$-5
$012A	$2921			GOTO	$-9
$012B	$3033			MOVLW	51
$012C	$00FB			MOVWF	STACK_11
$012D	$30FF			MOVLW	255
$012E	$00FA			MOVWF	STACK_10
$012F	$0BFB			DECFSZ	STACK_11, F
$0130	$2932			GOTO	$+2
$0131	$2935			GOTO	$+4
$0132	$0BFA			DECFSZ	STACK_10, F
$0133	$2932			GOTO	$-1
$0134	$292F			GOTO	$-5
$0135	$3088			MOVLW	136
$0136	$00FA			MOVWF	STACK_10
$0137	$0BFA			DECFSZ	STACK_10, F
$0138	$2937			GOTO	$-1
;displaylcd.c,21 :: 		trisd=0b00000000;
$0139	$1683			BSF	STATUS, RP0
$013A	$0188			CLRF	TRISD, 1
;displaylcd.c,22 :: 		trise=0b00000000;            //configura i/os
$013B	$0189			CLRF	TRISE, 1
;displaylcd.c,23 :: 		adcon1=0b00000111;           //desliga os a/ds
$013C	$3007			MOVLW	7
$013D	$009F			MOVWF	ADCON1
;displaylcd.c,25 :: 		Lcd8_Config(&PORTE, &PORTD, 2, 1, 0, 7, 6, 5, 4, 3, 2, 1, 0);
$013E	$3009			MOVLW	PORTE
$013F	$1283			BCF	STATUS, RP0
$0140	$00CD			MOVWF	FARG_Lcd8_Init+0
$0141	$3008			MOVLW	PORTD
$0142	$00CE			MOVWF	FARG_Lcd8_Init+1
$0143	$207D			CALL	_Lcd8_Init
;displaylcd.c,26 :: 		Lcd8_Init(&PORTE,&PORTD);
$0144	$3009			MOVLW	PORTE
$0145	$00CD			MOVWF	FARG_Lcd8_Init+0
$0146	$3008			MOVLW	PORTD
$0147	$00CE			MOVWF	FARG_Lcd8_Init+1
$0148	$207D			CALL	_Lcd8_Init
;displaylcd.c,27 :: 		Lcd8_Cmd(LCD_CLEAR);          //limpa o display
$0149	$3001			MOVLW	1
$014A	$00D5			MOVWF	FARG_Lcd8_Cmd+0
$014B	$201F			CALL	_Lcd8_Cmd
;displaylcd.c,28 :: 		Lcd8_Cmd(LCD_CURSOR_OFF);     //Desliga o cursor
$014C	$300C			MOVLW	12
$014D	$00D5			MOVWF	FARG_Lcd8_Cmd+0
$014E	$201F			CALL	_Lcd8_Cmd
;displaylcd.c,30 :: 		while(1)
$014F	$	L_main_0:
;displaylcd.c,32 :: 		lcd8_cmd(lcd_clear);  //Envia comando para apagar lcd
$014F	$3001			MOVLW	1
$0150	$00D5			MOVWF	FARG_Lcd8_Cmd+0
$0151	$201F			CALL	_Lcd8_Cmd
;displaylcd.c,33 :: 		lcd8_out(2,1,"Cidade: Roma");
$0152	$3002			MOVLW	2
$0153	$00CD			MOVWF	FARG_Lcd8_Out+0
$0154	$3001			MOVLW	1
$0155	$00CE			MOVWF	FARG_Lcd8_Out+1
$0156	$3023			MOVLW	lstr1_displaylcd
$0157	$00CF			MOVWF	FARG_Lcd8_Out+2
$0158	$20AB			CALL	_Lcd8_Out
;displaylcd.c,34 :: 		delay_ms(1000);
$0159	$3006			MOVLW	6
$015A	$00FC			MOVWF	STACK_12
$015B	$30FF			MOVLW	255
$015C	$00FB			MOVWF	STACK_11
$015D	$30FF			MOVLW	255
$015E	$00FA			MOVWF	STACK_10
$015F	$0BFC			DECFSZ	STACK_12, F
$0160	$2962			GOTO	$+2
$0161	$2969			GOTO	$+8
$0162	$0BFB			DECFSZ	STACK_11, F
$0163	$2965			GOTO	$+2
$0164	$2968			GOTO	$+4
$0165	$0BFA			DECFSZ	STACK_10, F
$0166	$2965			GOTO	$-1
$0167	$2962			GOTO	$-5
$0168	$295F			GOTO	$-9
$0169	$301A			MOVLW	26
$016A	$00FB			MOVWF	STACK_11
$016B	$30FF			MOVLW	255
$016C	$00FA			MOVWF	STACK_10
$016D	$0BFB			DECFSZ	STACK_11, F
$016E	$2970			GOTO	$+2
$016F	$2973			GOTO	$+4
$0170	$0BFA			DECFSZ	STACK_10, F
$0171	$2970			GOTO	$-1
$0172	$296D			GOTO	$-5
$0173	$3042			MOVLW	66
$0174	$00FA			MOVWF	STACK_10
$0175	$0BFA			DECFSZ	STACK_10, F
$0176	$2975			GOTO	$-1
;displaylcd.c,36 :: 		lcd8_cmd(lcd_clear);  //Envia comando para apagar lcd
$0177	$3001			MOVLW	1
$0178	$00D5			MOVWF	FARG_Lcd8_Cmd+0
$0179	$201F			CALL	_Lcd8_Cmd
;displaylcd.c,37 :: 		lcd8_out(2,1,"Cidade: Paris");
$017A	$3002			MOVLW	2
$017B	$00CD			MOVWF	FARG_Lcd8_Out+0
$017C	$3001			MOVLW	1
$017D	$00CE			MOVWF	FARG_Lcd8_Out+1
$017E	$3030			MOVLW	lstr2_displaylcd
$017F	$00CF			MOVWF	FARG_Lcd8_Out+2
$0180	$20AB			CALL	_Lcd8_Out
;displaylcd.c,38 :: 		delay_ms(1000);
$0181	$3006			MOVLW	6
$0182	$00FC			MOVWF	STACK_12
$0183	$30FF			MOVLW	255
$0184	$00FB			MOVWF	STACK_11
$0185	$30FF			MOVLW	255
$0186	$00FA			MOVWF	STACK_10
$0187	$0BFC			DECFSZ	STACK_12, F
$0188	$298A			GOTO	$+2
$0189	$2991			GOTO	$+8
$018A	$0BFB			DECFSZ	STACK_11, F
$018B	$298D			GOTO	$+2
$018C	$2990			GOTO	$+4
$018D	$0BFA			DECFSZ	STACK_10, F
$018E	$298D			GOTO	$-1
$018F	$298A			GOTO	$-5
$0190	$2987			GOTO	$-9
$0191	$301A			MOVLW	26
$0192	$00FB			MOVWF	STACK_11
$0193	$30FF			MOVLW	255
$0194	$00FA			MOVWF	STACK_10
$0195	$0BFB			DECFSZ	STACK_11, F
$0196	$2998			GOTO	$+2
$0197	$299B			GOTO	$+4
$0198	$0BFA			DECFSZ	STACK_10, F
$0199	$2998			GOTO	$-1
$019A	$2995			GOTO	$-5
$019B	$3042			MOVLW	66
$019C	$00FA			MOVWF	STACK_10
$019D	$0BFA			DECFSZ	STACK_10, F
$019E	$299D			GOTO	$-1
;displaylcd.c,40 :: 		lcd8_cmd(lcd_clear);  //Envia comando para apagar lcd
$019F	$3001			MOVLW	1
$01A0	$00D5			MOVWF	FARG_Lcd8_Cmd+0
$01A1	$201F			CALL	_Lcd8_Cmd
;displaylcd.c,41 :: 		lcd8_out(2,1,"Cidade: Berlin");
$01A2	$3002			MOVLW	2
$01A3	$00CD			MOVWF	FARG_Lcd8_Out+0
$01A4	$3001			MOVLW	1
$01A5	$00CE			MOVWF	FARG_Lcd8_Out+1
$01A6	$303E			MOVLW	lstr3_displaylcd
$01A7	$00CF			MOVWF	FARG_Lcd8_Out+2
$01A8	$20AB			CALL	_Lcd8_Out
;displaylcd.c,42 :: 		delay_ms(1000);
$01A9	$3006			MOVLW	6
$01AA	$00FC			MOVWF	STACK_12
$01AB	$30FF			MOVLW	255
$01AC	$00FB			MOVWF	STACK_11
$01AD	$30FF			MOVLW	255
$01AE	$00FA			MOVWF	STACK_10
$01AF	$0BFC			DECFSZ	STACK_12, F
$01B0	$29B2			GOTO	$+2
$01B1	$29B9			GOTO	$+8
$01B2	$0BFB			DECFSZ	STACK_11, F
$01B3	$29B5			GOTO	$+2
$01B4	$29B8			GOTO	$+4
$01B5	$0BFA			DECFSZ	STACK_10, F
$01B6	$29B5			GOTO	$-1
$01B7	$29B2			GOTO	$-5
$01B8	$29AF			GOTO	$-9
$01B9	$301A			MOVLW	26
$01BA	$00FB			MOVWF	STACK_11
$01BB	$30FF			MOVLW	255
$01BC	$00FA			MOVWF	STACK_10
$01BD	$0BFB			DECFSZ	STACK_11, F
$01BE	$29C0			GOTO	$+2
$01BF	$29C3			GOTO	$+4
$01C0	$0BFA			DECFSZ	STACK_10, F
$01C1	$29C0			GOTO	$-1
$01C2	$29BD			GOTO	$-5
$01C3	$3042			MOVLW	66
$01C4	$00FA			MOVWF	STACK_10
$01C5	$0BFA			DECFSZ	STACK_10, F
$01C6	$29C5			GOTO	$-1
;displaylcd.c,43 :: 		}
$01C7	$294F			GOTO	L_main_0
;displaylcd.c,45 :: 		}
$01C8	$29C8			GOTO	$
