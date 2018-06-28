;  ASM code generated by mikroVirtualMachine for PIC - V. 5.0.0.2
;  Date/Time: 29/05/06 19:12:29
;  Info: http://www.mikroelektronika.co.yu


; ADDRESS	OPCODE	ASM
; ----------------------------------------------
$0000	$298A			GOTO	TecladoMatricial_main
$0004	$	TecladoMatricial_interrupt:
$0004	$00FF			MOVWF	STACK_15
$0005	$0E03			SWAPF	STATUS, 0
$0006	$0183			CLRF	STATUS
$0007	$00A8			MOVWF	?saveSTATUS
$0008	$0804			MOVF	FSR, 0
$0009	$00A7			MOVWF	?saveFSR
$000A	$080A			MOVF	PCLATH, 0
$000B	$00A9			MOVWF	?savePCLATH
$000C	$018A			CLRF	PCLATH
$000D	$0871			MOVF	STACK_1, 0
$000E	$00AD			MOVWF	STSAVED_1
$000F	$0870			MOVF	STACK_0, 0
$0010	$00AC			MOVWF	STSAVED_0
^TecladoMatricial.pbas, 145 :: 		sub procedure interrupt
^TecladoMatricial.pbas, 147 :: 		if  testbit(intcon,t0if) = 1 then 'Tratamento da interrup��o
$0011	$3000			MOVLW	0
$0012	$190B			BTFSC	INTCON, 2
$0013	$3001			MOVLW	1
$0014	$00F1			MOVWF	STACK_1
$0015	$0871			MOVF	STACK_1, 0
$0016	$3A01			XORLW	1
$0017	$1D03			BTFSS	STATUS, Z
$0018	$2908			GOTO	TecladoMatricial_L_52
$0019	$	TecladoMatricial_L_51:
^TecladoMatricial.pbas, 148 :: 		clearbit(intcon,t0if)         'de timer 0
$0019	$110B			BCF	INTCON, 2
^TecladoMatricial.pbas, 149 :: 		inc(indice)
$001A	$0AA0			INCF	main_global_indice, 1
^TecladoMatricial.pbas, 151 :: 		case 1
$001B	$	TecladoMatricial_L_56:
$001B	$0820			MOVF	main_global_indice, 0
$001C	$3A01			XORLW	1
$001D	$1D03			BTFSS	STATUS, Z
$001E	$2857			GOTO	TecladoMatricial_L_57
$001F	$	TecladoMatricial_L_55:
^TecladoMatricial.pbas, 152 :: 		clearbit(SEL4)
$001F	$1206			BCF	PORTB, 4
^TecladoMatricial.pbas, 153 :: 		delay_us(10)
$0020	$3003			MOVLW	3
$0021	$00FA			MOVWF	STACK_10
$0022	$0BFA			DECFSZ	STACK_10, F
$0023	$2822			GOTO	$-1
^TecladoMatricial.pbas, 154 :: 		portd=SEL_LINHA1
$0024	$300E			MOVLW	14
$0025	$0088			MOVWF	PORTD
^TecladoMatricial.pbas, 155 :: 		clearbit(teclado0,tecla_1)
$0026	$30FD			MOVLW	253
$0027	$0521			ANDWF	main_global_teclado0, 0
$0028	$00F0			MOVWF	STACK_0
$0029	$0870			MOVF	STACK_0, 0
$002A	$00A1			MOVWF	main_global_teclado0
^TecladoMatricial.pbas, 156 :: 		clearbit(teclado0,tecla_2)
$002B	$1170			BCF	STACK_0, 2
$002C	$0870			MOVF	STACK_0, 0
$002D	$00A1			MOVWF	main_global_teclado0
^TecladoMatricial.pbas, 157 :: 		clearbit(teclado0,tecla_3)
$002E	$30F7			MOVLW	247
$002F	$0570			ANDWF	STACK_0, 0
$0030	$00A1			MOVWF	main_global_teclado0
^TecladoMatricial.pbas, 158 :: 		if testbit(COL1) = 0 then
$0031	$3000			MOVLW	0
$0032	$1A05			BTFSC	PORTA, 4
$0033	$3001			MOVLW	1
$0034	$00F1			MOVWF	STACK_1
$0035	$0871			MOVF	STACK_1, 0
$0036	$3A00			XORLW	0
$0037	$1D03			BTFSS	STATUS, Z
$0038	$283A			GOTO	TecladoMatricial_L_59
$0039	$	TecladoMatricial_L_58:
^TecladoMatricial.pbas, 159 :: 		setbit(teclado0,tecla_1)
$0039	$14A1			BSF	main_global_teclado0, 1
$003A	$	TecladoMatricial_L_59:
^TecladoMatricial.pbas, 160 :: 		end if
$003A	$	TecladoMatricial_L_60:
^TecladoMatricial.pbas, 161 :: 		if testbit(COL2) = 0 then
$003A	$3000			MOVLW	0
$003B	$1A85			BTFSC	PORTA, 5
$003C	$3001			MOVLW	1
$003D	$00F1			MOVWF	STACK_1
$003E	$0871			MOVF	STACK_1, 0
$003F	$3A00			XORLW	0
$0040	$1D03			BTFSS	STATUS, Z
$0041	$2843			GOTO	TecladoMatricial_L_62
$0042	$	TecladoMatricial_L_61:
^TecladoMatricial.pbas, 162 :: 		setbit(teclado0,tecla_2)
$0042	$1521			BSF	main_global_teclado0, 2
$0043	$	TecladoMatricial_L_62:
^TecladoMatricial.pbas, 163 :: 		end if
$0043	$	TecladoMatricial_L_63:
^TecladoMatricial.pbas, 164 :: 		if testbit(COL3) = 0 then
$0043	$3001			MOVLW	1
$0044	$0509			ANDWF	PORTE, 0
$0045	$00F1			MOVWF	STACK_1
$0046	$0871			MOVF	STACK_1, 0
$0047	$3A00			XORLW	0
$0048	$1D03			BTFSS	STATUS, Z
$0049	$284B			GOTO	TecladoMatricial_L_65
$004A	$	TecladoMatricial_L_64:
^TecladoMatricial.pbas, 165 :: 		setbit(teclado0,tecla_3)
$004A	$15A1			BSF	main_global_teclado0, 3
$004B	$	TecladoMatricial_L_65:
^TecladoMatricial.pbas, 166 :: 		end if
$004B	$	TecladoMatricial_L_66:
^TecladoMatricial.pbas, 167 :: 		portd=vetor_display[indice-1]
$004B	$3022			MOVLW	main_global_vetor_display
$004C	$00F1			MOVWF	STACK_1
$004D	$0320			DECF	main_global_indice, 0
$004E	$00F0			MOVWF	STACK_0
$004F	$0871			MOVF	STACK_1, 0
$0050	$07F0			ADDWF	STACK_0, 1
$0051	$0870			MOVF	STACK_0, 0
$0052	$0084			MOVWF	FSR
$0053	$0800			MOVF	INDF, 0
$0054	$0088			MOVWF	PORTD
^TecladoMatricial.pbas, 168 :: 		setbit(SEL1)
$0055	$1486			BSF	PORTB, 1
$0056	$2908			GOTO	TecladoMatricial_L_54
$0057	$	TecladoMatricial_L_57:
^TecladoMatricial.pbas, 170 :: 		case 2
$0057	$	TecladoMatricial_L_68:
$0057	$0820			MOVF	main_global_indice, 0
$0058	$3A02			XORLW	2
$0059	$1D03			BTFSS	STATUS, Z
$005A	$2893			GOTO	TecladoMatricial_L_69
$005B	$	TecladoMatricial_L_67:
^TecladoMatricial.pbas, 171 :: 		clearbit(SEL1)
$005B	$1086			BCF	PORTB, 1
^TecladoMatricial.pbas, 172 :: 		delay_us(10)
$005C	$3003			MOVLW	3
$005D	$00FA			MOVWF	STACK_10
$005E	$0BFA			DECFSZ	STACK_10, F
$005F	$285E			GOTO	$-1
^TecladoMatricial.pbas, 173 :: 		portd=SEL_LINHA2
$0060	$300D			MOVLW	13
$0061	$0088			MOVWF	PORTD
^TecladoMatricial.pbas, 174 :: 		clearbit(teclado0,tecla_4)
$0062	$30EF			MOVLW	239
$0063	$0521			ANDWF	main_global_teclado0, 0
$0064	$00F0			MOVWF	STACK_0
$0065	$0870			MOVF	STACK_0, 0
$0066	$00A1			MOVWF	main_global_teclado0
^TecladoMatricial.pbas, 175 :: 		clearbit(teclado0,tecla_5)
$0067	$12F0			BCF	STACK_0, 5
$0068	$0870			MOVF	STACK_0, 0
$0069	$00A1			MOVWF	main_global_teclado0
^TecladoMatricial.pbas, 176 :: 		clearbit(teclado0,tecla_6)
$006A	$30BF			MOVLW	191
$006B	$0570			ANDWF	STACK_0, 0
$006C	$00A1			MOVWF	main_global_teclado0
^TecladoMatricial.pbas, 177 :: 		if testbit(COL1) = 0 then
$006D	$3000			MOVLW	0
$006E	$1A05			BTFSC	PORTA, 4
$006F	$3001			MOVLW	1
$0070	$00F1			MOVWF	STACK_1
$0071	$0871			MOVF	STACK_1, 0
$0072	$3A00			XORLW	0
$0073	$1D03			BTFSS	STATUS, Z
$0074	$2876			GOTO	TecladoMatricial_L_71
$0075	$	TecladoMatricial_L_70:
^TecladoMatricial.pbas, 178 :: 		setbit(teclado0,tecla_4)
$0075	$1621			BSF	main_global_teclado0, 4
$0076	$	TecladoMatricial_L_71:
^TecladoMatricial.pbas, 179 :: 		end if
$0076	$	TecladoMatricial_L_72:
^TecladoMatricial.pbas, 180 :: 		if testbit(COL2) = 0 then
$0076	$3000			MOVLW	0
$0077	$1A85			BTFSC	PORTA, 5
$0078	$3001			MOVLW	1
$0079	$00F1			MOVWF	STACK_1
$007A	$0871			MOVF	STACK_1, 0
$007B	$3A00			XORLW	0
$007C	$1D03			BTFSS	STATUS, Z
$007D	$287F			GOTO	TecladoMatricial_L_74
$007E	$	TecladoMatricial_L_73:
^TecladoMatricial.pbas, 181 :: 		setbit(teclado0,tecla_5)
$007E	$16A1			BSF	main_global_teclado0, 5
$007F	$	TecladoMatricial_L_74:
^TecladoMatricial.pbas, 182 :: 		end if
$007F	$	TecladoMatricial_L_75:
^TecladoMatricial.pbas, 183 :: 		if testbit(COL3) = 0 then
$007F	$3001			MOVLW	1
$0080	$0509			ANDWF	PORTE, 0
$0081	$00F1			MOVWF	STACK_1
$0082	$0871			MOVF	STACK_1, 0
$0083	$3A00			XORLW	0
$0084	$1D03			BTFSS	STATUS, Z
$0085	$2887			GOTO	TecladoMatricial_L_77
$0086	$	TecladoMatricial_L_76:
^TecladoMatricial.pbas, 184 :: 		setbit(teclado0,tecla_6)
$0086	$1721			BSF	main_global_teclado0, 6
$0087	$	TecladoMatricial_L_77:
^TecladoMatricial.pbas, 185 :: 		end if
$0087	$	TecladoMatricial_L_78:
^TecladoMatricial.pbas, 186 :: 		portd=vetor_display[indice-1]
$0087	$3022			MOVLW	main_global_vetor_display
$0088	$00F1			MOVWF	STACK_1
$0089	$0320			DECF	main_global_indice, 0
$008A	$00F0			MOVWF	STACK_0
$008B	$0871			MOVF	STACK_1, 0
$008C	$07F0			ADDWF	STACK_0, 1
$008D	$0870			MOVF	STACK_0, 0
$008E	$0084			MOVWF	FSR
$008F	$0800			MOVF	INDF, 0
$0090	$0088			MOVWF	PORTD
^TecladoMatricial.pbas, 187 :: 		setbit(SEL2)
$0091	$1506			BSF	PORTB, 2
$0092	$2908			GOTO	TecladoMatricial_L_54
$0093	$	TecladoMatricial_L_69:
^TecladoMatricial.pbas, 189 :: 		case 3
$0093	$	TecladoMatricial_L_80:
$0093	$0820			MOVF	main_global_indice, 0
$0094	$3A03			XORLW	3
$0095	$1D03			BTFSS	STATUS, Z
$0096	$28CD			GOTO	TecladoMatricial_L_81
$0097	$	TecladoMatricial_L_79:
^TecladoMatricial.pbas, 190 :: 		clearbit(SEL2)
$0097	$1106			BCF	PORTB, 2
^TecladoMatricial.pbas, 191 :: 		delay_us(10)
$0098	$3003			MOVLW	3
$0099	$00FA			MOVWF	STACK_10
$009A	$0BFA			DECFSZ	STACK_10, F
$009B	$289A			GOTO	$-1
^TecladoMatricial.pbas, 192 :: 		portd=SEL_LINHA3
$009C	$300B			MOVLW	11
$009D	$0088			MOVWF	PORTD
^TecladoMatricial.pbas, 193 :: 		clearbit(teclado0,tecla_7)
$009E	$13A1			BCF	main_global_teclado0, 7
^TecladoMatricial.pbas, 194 :: 		clearbit(teclado1,tecla_8)
$009F	$30FE			MOVLW	254
$00A0	$0526			ANDWF	main_global_teclado1, 0
$00A1	$00F0			MOVWF	STACK_0
$00A2	$0870			MOVF	STACK_0, 0
$00A3	$00A6			MOVWF	main_global_teclado1
^TecladoMatricial.pbas, 195 :: 		clearbit(teclado1,tecla_9)
$00A4	$30FD			MOVLW	253
$00A5	$0570			ANDWF	STACK_0, 0
$00A6	$00A6			MOVWF	main_global_teclado1
^TecladoMatricial.pbas, 197 :: 		if testbit(COL1) = 0 then
$00A7	$3000			MOVLW	0
$00A8	$1A05			BTFSC	PORTA, 4
$00A9	$3001			MOVLW	1
$00AA	$00F1			MOVWF	STACK_1
$00AB	$0871			MOVF	STACK_1, 0
$00AC	$3A00			XORLW	0
$00AD	$1D03			BTFSS	STATUS, Z
$00AE	$28B0			GOTO	TecladoMatricial_L_83
$00AF	$	TecladoMatricial_L_82:
^TecladoMatricial.pbas, 198 :: 		setbit(teclado0,tecla_7)
$00AF	$17A1			BSF	main_global_teclado0, 7
$00B0	$	TecladoMatricial_L_83:
^TecladoMatricial.pbas, 199 :: 		end if
$00B0	$	TecladoMatricial_L_84:
^TecladoMatricial.pbas, 200 :: 		if testbit(COL2) = 0 then
$00B0	$3000			MOVLW	0
$00B1	$1A85			BTFSC	PORTA, 5
$00B2	$3001			MOVLW	1
$00B3	$00F1			MOVWF	STACK_1
$00B4	$0871			MOVF	STACK_1, 0
$00B5	$3A00			XORLW	0
$00B6	$1D03			BTFSS	STATUS, Z
$00B7	$28B9			GOTO	TecladoMatricial_L_86
$00B8	$	TecladoMatricial_L_85:
^TecladoMatricial.pbas, 201 :: 		setbit(teclado1,tecla_8)
$00B8	$1426			BSF	main_global_teclado1, 0
$00B9	$	TecladoMatricial_L_86:
^TecladoMatricial.pbas, 202 :: 		end if
$00B9	$	TecladoMatricial_L_87:
^TecladoMatricial.pbas, 203 :: 		if testbit(COL3) = 0 then
$00B9	$3001			MOVLW	1
$00BA	$0509			ANDWF	PORTE, 0
$00BB	$00F1			MOVWF	STACK_1
$00BC	$0871			MOVF	STACK_1, 0
$00BD	$3A00			XORLW	0
$00BE	$1D03			BTFSS	STATUS, Z
$00BF	$28C1			GOTO	TecladoMatricial_L_89
$00C0	$	TecladoMatricial_L_88:
^TecladoMatricial.pbas, 204 :: 		setbit(teclado1,tecla_9)
$00C0	$14A6			BSF	main_global_teclado1, 1
$00C1	$	TecladoMatricial_L_89:
^TecladoMatricial.pbas, 205 :: 		end if
$00C1	$	TecladoMatricial_L_90:
^TecladoMatricial.pbas, 206 :: 		portd=vetor_display[indice-1]
$00C1	$3022			MOVLW	main_global_vetor_display
$00C2	$00F1			MOVWF	STACK_1
$00C3	$0320			DECF	main_global_indice, 0
$00C4	$00F0			MOVWF	STACK_0
$00C5	$0871			MOVF	STACK_1, 0
$00C6	$07F0			ADDWF	STACK_0, 1
$00C7	$0870			MOVF	STACK_0, 0
$00C8	$0084			MOVWF	FSR
$00C9	$0800			MOVF	INDF, 0
$00CA	$0088			MOVWF	PORTD
^TecladoMatricial.pbas, 207 :: 		setbit(SEL3)
$00CB	$1586			BSF	PORTB, 3
$00CC	$2908			GOTO	TecladoMatricial_L_54
$00CD	$	TecladoMatricial_L_81:
^TecladoMatricial.pbas, 209 :: 		case 4
$00CD	$	TecladoMatricial_L_92:
$00CD	$0820			MOVF	main_global_indice, 0
$00CE	$3A04			XORLW	4
$00CF	$1D03			BTFSS	STATUS, Z
$00D0	$2908			GOTO	TecladoMatricial_L_93
$00D1	$	TecladoMatricial_L_91:
^TecladoMatricial.pbas, 210 :: 		clearbit(SEL3)
$00D1	$1186			BCF	PORTB, 3
^TecladoMatricial.pbas, 211 :: 		delay_us(10)
$00D2	$3003			MOVLW	3
$00D3	$00FA			MOVWF	STACK_10
$00D4	$0BFA			DECFSZ	STACK_10, F
$00D5	$28D4			GOTO	$-1
^TecladoMatricial.pbas, 212 :: 		portd=SEL_LINHA4
$00D6	$3007			MOVLW	7
$00D7	$0088			MOVWF	PORTD
^TecladoMatricial.pbas, 213 :: 		clearbit(teclado1,tecla_C)
$00D8	$30FB			MOVLW	251
$00D9	$0526			ANDWF	main_global_teclado1, 0
$00DA	$00F0			MOVWF	STACK_0
$00DB	$0870			MOVF	STACK_0, 0
$00DC	$00A6			MOVWF	main_global_teclado1
^TecladoMatricial.pbas, 214 :: 		clearbit(teclado0,tecla_0)
$00DD	$1021			BCF	main_global_teclado0, 0
^TecladoMatricial.pbas, 215 :: 		clearbit(teclado1,tecla_E)
$00DE	$30F7			MOVLW	247
$00DF	$0570			ANDWF	STACK_0, 0
$00E0	$00A6			MOVWF	main_global_teclado1
^TecladoMatricial.pbas, 217 :: 		if testbit(COL1) = 0 then
$00E1	$3000			MOVLW	0
$00E2	$1A05			BTFSC	PORTA, 4
$00E3	$3001			MOVLW	1
$00E4	$00F1			MOVWF	STACK_1
$00E5	$0871			MOVF	STACK_1, 0
$00E6	$3A00			XORLW	0
$00E7	$1D03			BTFSS	STATUS, Z
$00E8	$28EA			GOTO	TecladoMatricial_L_95
$00E9	$	TecladoMatricial_L_94:
^TecladoMatricial.pbas, 218 :: 		setbit(teclado1,tecla_C)
$00E9	$1526			BSF	main_global_teclado1, 2
$00EA	$	TecladoMatricial_L_95:
^TecladoMatricial.pbas, 219 :: 		end if
$00EA	$	TecladoMatricial_L_96:
^TecladoMatricial.pbas, 220 :: 		if testbit(COL2) = 0 then
$00EA	$3000			MOVLW	0
$00EB	$1A85			BTFSC	PORTA, 5
$00EC	$3001			MOVLW	1
$00ED	$00F1			MOVWF	STACK_1
$00EE	$0871			MOVF	STACK_1, 0
$00EF	$3A00			XORLW	0
$00F0	$1D03			BTFSS	STATUS, Z
$00F1	$28F3			GOTO	TecladoMatricial_L_98
$00F2	$	TecladoMatricial_L_97:
^TecladoMatricial.pbas, 221 :: 		setbit(teclado0,tecla_0)
$00F2	$1421			BSF	main_global_teclado0, 0
$00F3	$	TecladoMatricial_L_98:
^TecladoMatricial.pbas, 222 :: 		end if
$00F3	$	TecladoMatricial_L_99:
^TecladoMatricial.pbas, 223 :: 		if testbit(COL3) = 0 then
$00F3	$3001			MOVLW	1
$00F4	$0509			ANDWF	PORTE, 0
$00F5	$00F1			MOVWF	STACK_1
$00F6	$0871			MOVF	STACK_1, 0
$00F7	$3A00			XORLW	0
$00F8	$1D03			BTFSS	STATUS, Z
$00F9	$28FB			GOTO	TecladoMatricial_L_101
$00FA	$	TecladoMatricial_L_100:
^TecladoMatricial.pbas, 224 :: 		setbit(teclado1,tecla_E)
$00FA	$15A6			BSF	main_global_teclado1, 3
$00FB	$	TecladoMatricial_L_101:
^TecladoMatricial.pbas, 225 :: 		end if
$00FB	$	TecladoMatricial_L_102:
^TecladoMatricial.pbas, 226 :: 		portd=vetor_display[indice-1]
$00FB	$3022			MOVLW	main_global_vetor_display
$00FC	$00F1			MOVWF	STACK_1
$00FD	$0320			DECF	main_global_indice, 0
$00FE	$00F0			MOVWF	STACK_0
$00FF	$0871			MOVF	STACK_1, 0
$0100	$07F0			ADDWF	STACK_0, 1
$0101	$0870			MOVF	STACK_0, 0
$0102	$0084			MOVWF	FSR
$0103	$0800			MOVF	INDF, 0
$0104	$0088			MOVWF	PORTD
^TecladoMatricial.pbas, 227 :: 		setbit(SEL4)
$0105	$1606			BSF	PORTB, 4
^TecladoMatricial.pbas, 228 :: 		indice=0       'reinicia o indice
$0106	$01A0			CLRF	main_global_indice, 1
$0107	$2908			GOTO	TecladoMatricial_L_54
$0108	$	TecladoMatricial_L_93:
$0108	$	TecladoMatricial_L_54:
^TecladoMatricial.pbas, 229 :: 		end select
$0108	$	TecladoMatricial_L_52:
^TecladoMatricial.pbas, 230 :: 		end if
$0108	$	TecladoMatricial_L_53:
$0108	$	TecladoMatricial_L_50:
$0108	$082D			MOVF	STSAVED_1, 0
$0109	$00F1			MOVWF	STACK_1
$010A	$082C			MOVF	STSAVED_0, 0
$010B	$00F0			MOVWF	STACK_0
$010C	$0829			MOVF	?savePCLATH, 0
$010D	$008A			MOVWF	PCLATH
$010E	$0827			MOVF	?saveFSR, 0
$010F	$0084			MOVWF	FSR
$0110	$0E28			SWAPF	?saveSTATUS, 0
$0111	$0083			MOVWF	STATUS
$0112	$0EFF			SWAPF	STACK_15, 1
$0113	$0E7F			SWAPF	STACK_15, 0
$0114	$0009			RETFIE
$0115	$	TecladoMatricial_converte_to_7seg:
^TecladoMatricial.pbas, 102 :: 		sub function Converte_to_7seg(dim dado as byte) as byte
^TecladoMatricial.pbas, 105 :: 		case 0
$0115	$	TecladoMatricial_L_3:
$0115	$1303			BCF	STATUS, RP1
$0116	$1283			BCF	STATUS, RP0
$0117	$082A			MOVF	FARG_Converte_to_7seg, 0
$0118	$3A00			XORLW	0
$0119	$1D03			BTFSS	STATUS, Z
$011A	$291E			GOTO	TecladoMatricial_L_4
$011B	$	TecladoMatricial_L_2:
^TecladoMatricial.pbas, 106 :: 		result=CHR_0
$011B	$303F			MOVLW	63
$011C	$00AB			MOVWF	tecladomatricial_converte_to_7seg_local_result
$011D	$2987			GOTO	TecladoMatricial_L_1
$011E	$	TecladoMatricial_L_4:
^TecladoMatricial.pbas, 107 :: 		case 1
$011E	$	TecladoMatricial_L_6:
$011E	$082A			MOVF	FARG_Converte_to_7seg, 0
$011F	$3A01			XORLW	1
$0120	$1D03			BTFSS	STATUS, Z
$0121	$2925			GOTO	TecladoMatricial_L_7
$0122	$	TecladoMatricial_L_5:
^TecladoMatricial.pbas, 108 :: 		result=CHR_1
$0122	$3006			MOVLW	6
$0123	$00AB			MOVWF	tecladomatricial_converte_to_7seg_local_result
$0124	$2987			GOTO	TecladoMatricial_L_1
$0125	$	TecladoMatricial_L_7:
^TecladoMatricial.pbas, 109 :: 		case 2
$0125	$	TecladoMatricial_L_9:
$0125	$082A			MOVF	FARG_Converte_to_7seg, 0
$0126	$3A02			XORLW	2
$0127	$1D03			BTFSS	STATUS, Z
$0128	$292C			GOTO	TecladoMatricial_L_10
$0129	$	TecladoMatricial_L_8:
^TecladoMatricial.pbas, 110 :: 		result=CHR_2
$0129	$305B			MOVLW	91
$012A	$00AB			MOVWF	tecladomatricial_converte_to_7seg_local_result
$012B	$2987			GOTO	TecladoMatricial_L_1
$012C	$	TecladoMatricial_L_10:
^TecladoMatricial.pbas, 111 :: 		case 3
$012C	$	TecladoMatricial_L_12:
$012C	$082A			MOVF	FARG_Converte_to_7seg, 0
$012D	$3A03			XORLW	3
$012E	$1D03			BTFSS	STATUS, Z
$012F	$2933			GOTO	TecladoMatricial_L_13
$0130	$	TecladoMatricial_L_11:
^TecladoMatricial.pbas, 112 :: 		result=CHR_3
$0130	$304F			MOVLW	79
$0131	$00AB			MOVWF	tecladomatricial_converte_to_7seg_local_result
$0132	$2987			GOTO	TecladoMatricial_L_1
$0133	$	TecladoMatricial_L_13:
^TecladoMatricial.pbas, 113 :: 		case 4
$0133	$	TecladoMatricial_L_15:
$0133	$082A			MOVF	FARG_Converte_to_7seg, 0
$0134	$3A04			XORLW	4
$0135	$1D03			BTFSS	STATUS, Z
$0136	$293A			GOTO	TecladoMatricial_L_16
$0137	$	TecladoMatricial_L_14:
^TecladoMatricial.pbas, 114 :: 		result=CHR_4
$0137	$3066			MOVLW	102
$0138	$00AB			MOVWF	tecladomatricial_converte_to_7seg_local_result
$0139	$2987			GOTO	TecladoMatricial_L_1
$013A	$	TecladoMatricial_L_16:
^TecladoMatricial.pbas, 115 :: 		case 5
$013A	$	TecladoMatricial_L_18:
$013A	$082A			MOVF	FARG_Converte_to_7seg, 0
$013B	$3A05			XORLW	5
$013C	$1D03			BTFSS	STATUS, Z
$013D	$2941			GOTO	TecladoMatricial_L_19
$013E	$	TecladoMatricial_L_17:
^TecladoMatricial.pbas, 116 :: 		result=CHR_5
$013E	$306D			MOVLW	109
$013F	$00AB			MOVWF	tecladomatricial_converte_to_7seg_local_result
$0140	$2987			GOTO	TecladoMatricial_L_1
$0141	$	TecladoMatricial_L_19:
^TecladoMatricial.pbas, 117 :: 		case 6
$0141	$	TecladoMatricial_L_21:
$0141	$082A			MOVF	FARG_Converte_to_7seg, 0
$0142	$3A06			XORLW	6
$0143	$1D03			BTFSS	STATUS, Z
$0144	$2948			GOTO	TecladoMatricial_L_22
$0145	$	TecladoMatricial_L_20:
^TecladoMatricial.pbas, 118 :: 		result=CHR_6
$0145	$307D			MOVLW	125
$0146	$00AB			MOVWF	tecladomatricial_converte_to_7seg_local_result
$0147	$2987			GOTO	TecladoMatricial_L_1
$0148	$	TecladoMatricial_L_22:
^TecladoMatricial.pbas, 119 :: 		case 7
$0148	$	TecladoMatricial_L_24:
$0148	$082A			MOVF	FARG_Converte_to_7seg, 0
$0149	$3A07			XORLW	7
$014A	$1D03			BTFSS	STATUS, Z
$014B	$294F			GOTO	TecladoMatricial_L_25
$014C	$	TecladoMatricial_L_23:
^TecladoMatricial.pbas, 120 :: 		result=CHR_7
$014C	$3007			MOVLW	7
$014D	$00AB			MOVWF	tecladomatricial_converte_to_7seg_local_result
$014E	$2987			GOTO	TecladoMatricial_L_1
$014F	$	TecladoMatricial_L_25:
^TecladoMatricial.pbas, 121 :: 		case 8
$014F	$	TecladoMatricial_L_27:
$014F	$082A			MOVF	FARG_Converte_to_7seg, 0
$0150	$3A08			XORLW	8
$0151	$1D03			BTFSS	STATUS, Z
$0152	$2956			GOTO	TecladoMatricial_L_28
$0153	$	TecladoMatricial_L_26:
^TecladoMatricial.pbas, 122 :: 		result=CHR_8
$0153	$307F			MOVLW	127
$0154	$00AB			MOVWF	tecladomatricial_converte_to_7seg_local_result
$0155	$2987			GOTO	TecladoMatricial_L_1
$0156	$	TecladoMatricial_L_28:
^TecladoMatricial.pbas, 123 :: 		case 9
$0156	$	TecladoMatricial_L_30:
$0156	$082A			MOVF	FARG_Converte_to_7seg, 0
$0157	$3A09			XORLW	9
$0158	$1D03			BTFSS	STATUS, Z
$0159	$295D			GOTO	TecladoMatricial_L_31
$015A	$	TecladoMatricial_L_29:
^TecladoMatricial.pbas, 124 :: 		result=CHR_9
$015A	$306F			MOVLW	111
$015B	$00AB			MOVWF	tecladomatricial_converte_to_7seg_local_result
$015C	$2987			GOTO	TecladoMatricial_L_1
$015D	$	TecladoMatricial_L_31:
^TecladoMatricial.pbas, 125 :: 		case 10
$015D	$	TecladoMatricial_L_33:
$015D	$082A			MOVF	FARG_Converte_to_7seg, 0
$015E	$3A0A			XORLW	10
$015F	$1D03			BTFSS	STATUS, Z
$0160	$2964			GOTO	TecladoMatricial_L_34
$0161	$	TecladoMatricial_L_32:
^TecladoMatricial.pbas, 126 :: 		result=CHR_A
$0161	$3077			MOVLW	119
$0162	$00AB			MOVWF	tecladomatricial_converte_to_7seg_local_result
$0163	$2987			GOTO	TecladoMatricial_L_1
$0164	$	TecladoMatricial_L_34:
^TecladoMatricial.pbas, 127 :: 		case 11
$0164	$	TecladoMatricial_L_36:
$0164	$082A			MOVF	FARG_Converte_to_7seg, 0
$0165	$3A0B			XORLW	11
$0166	$1D03			BTFSS	STATUS, Z
$0167	$296B			GOTO	TecladoMatricial_L_37
$0168	$	TecladoMatricial_L_35:
^TecladoMatricial.pbas, 128 :: 		result=CHR_B
$0168	$307C			MOVLW	124
$0169	$00AB			MOVWF	tecladomatricial_converte_to_7seg_local_result
$016A	$2987			GOTO	TecladoMatricial_L_1
$016B	$	TecladoMatricial_L_37:
^TecladoMatricial.pbas, 129 :: 		case 12
$016B	$	TecladoMatricial_L_39:
$016B	$082A			MOVF	FARG_Converte_to_7seg, 0
$016C	$3A0C			XORLW	12
$016D	$1D03			BTFSS	STATUS, Z
$016E	$2972			GOTO	TecladoMatricial_L_40
$016F	$	TecladoMatricial_L_38:
^TecladoMatricial.pbas, 130 :: 		result=CHR_C
$016F	$3039			MOVLW	57
$0170	$00AB			MOVWF	tecladomatricial_converte_to_7seg_local_result
$0171	$2987			GOTO	TecladoMatricial_L_1
$0172	$	TecladoMatricial_L_40:
^TecladoMatricial.pbas, 131 :: 		case 13
$0172	$	TecladoMatricial_L_42:
$0172	$082A			MOVF	FARG_Converte_to_7seg, 0
$0173	$3A0D			XORLW	13
$0174	$1D03			BTFSS	STATUS, Z
$0175	$2979			GOTO	TecladoMatricial_L_43
$0176	$	TecladoMatricial_L_41:
^TecladoMatricial.pbas, 132 :: 		result=CHR_D
$0176	$305E			MOVLW	94
$0177	$00AB			MOVWF	tecladomatricial_converte_to_7seg_local_result
$0178	$2987			GOTO	TecladoMatricial_L_1
$0179	$	TecladoMatricial_L_43:
^TecladoMatricial.pbas, 133 :: 		case 14
$0179	$	TecladoMatricial_L_45:
$0179	$082A			MOVF	FARG_Converte_to_7seg, 0
$017A	$3A0E			XORLW	14
$017B	$1D03			BTFSS	STATUS, Z
$017C	$2980			GOTO	TecladoMatricial_L_46
$017D	$	TecladoMatricial_L_44:
^TecladoMatricial.pbas, 134 :: 		result=CHR_E
$017D	$3079			MOVLW	121
$017E	$00AB			MOVWF	tecladomatricial_converte_to_7seg_local_result
$017F	$2987			GOTO	TecladoMatricial_L_1
$0180	$	TecladoMatricial_L_46:
^TecladoMatricial.pbas, 135 :: 		case 15
$0180	$	TecladoMatricial_L_48:
$0180	$082A			MOVF	FARG_Converte_to_7seg, 0
$0181	$3A0F			XORLW	15
$0182	$1D03			BTFSS	STATUS, Z
$0183	$2987			GOTO	TecladoMatricial_L_49
$0184	$	TecladoMatricial_L_47:
^TecladoMatricial.pbas, 136 :: 		result=CHR_F
$0184	$3071			MOVLW	113
$0185	$00AB			MOVWF	tecladomatricial_converte_to_7seg_local_result
$0186	$2987			GOTO	TecladoMatricial_L_1
$0187	$	TecladoMatricial_L_49:
$0187	$	TecladoMatricial_L_1:
^TecladoMatricial.pbas, 137 :: 		end select
$0187	$	TecladoMatricial_L_0:
$0187	$082B			MOVF	tecladomatricial_converte_to_7seg_local_result, 0
$0188	$00F0			MOVWF	STACK_0
$0189	$0008			RETURN
$018A	$	TecladoMatricial_main:
^TecladoMatricial.pbas, 238 :: 		Main:
$018A	$	TecladoMatricial_main_main:
^TecladoMatricial.pbas, 240 :: 		trisa=%00110000
$018A	$3030			MOVLW	48
$018B	$1303			BCF	STATUS, RP1
$018C	$1683			BSF	STATUS, RP0
$018D	$0085			MOVWF	TRISA
^TecladoMatricial.pbas, 241 :: 		trisb=%00000000
$018E	$0186			CLRF	TRISB, 1
^TecladoMatricial.pbas, 242 :: 		trisd=%00000000
$018F	$0188			CLRF	TRISD, 1
^TecladoMatricial.pbas, 243 :: 		trise=%00000001            'configura i/os
$0190	$3001			MOVLW	1
$0191	$0089			MOVWF	TRISE
^TecladoMatricial.pbas, 244 :: 		option_reg=%10000000       'configura prescaler do timer 0
$0192	$3080			MOVLW	128
$0193	$0081			MOVWF	OPTION_REG
^TecladoMatricial.pbas, 245 :: 		indice=0                   'inicializa a vari�vel de �ndice
$0194	$1283			BCF	STATUS, RP0
$0195	$01A0			CLRF	main_global_indice, 1
^TecladoMatricial.pbas, 246 :: 		teclado0=0
$0196	$01A1			CLRF	main_global_teclado0, 1
^TecladoMatricial.pbas, 247 :: 		teclado1=0                 'inicializa vari�veis do teclado
$0197	$01A6			CLRF	main_global_teclado1, 1
^TecladoMatricial.pbas, 248 :: 		adcon1=%00000111           'desliga os a/ds
$0198	$3007			MOVLW	7
$0199	$1683			BSF	STATUS, RP0
$019A	$009F			MOVWF	ADCON1
^TecladoMatricial.pbas, 249 :: 		intcon=%10100000           'configura interrup��o de timer0
$019B	$30A0			MOVLW	160
$019C	$008B			MOVWF	INTCON
^TecladoMatricial.pbas, 250 :: 		vetor_display[0]=0         'inicializa todos os vetores com 0
$019D	$1283			BCF	STATUS, RP0
$019E	$01A2			CLRF	main_global_vetor_display+0, 1
^TecladoMatricial.pbas, 251 :: 		vetor_display[1]=0
$019F	$01A3			CLRF	main_global_vetor_display+1, 1
^TecladoMatricial.pbas, 252 :: 		vetor_display[2]=0
$01A0	$01A4			CLRF	main_global_vetor_display+2, 1
^TecladoMatricial.pbas, 253 :: 		vetor_display[3]=0
$01A1	$01A5			CLRF	main_global_vetor_display+3, 1
^TecladoMatricial.pbas, 259 :: 		loop_principal:
$01A2	$	TecladoMatricial_main_loop_principal:
^TecladoMatricial.pbas, 260 :: 		while true
$01A2	$	TecladoMatricial_L_105:
^TecladoMatricial.pbas, 262 :: 		if testbit(teclado0,tecla_1) = 1 then
$01A2	$3000			MOVLW	0
$01A3	$18A1			BTFSC	main_global_teclado0, 1
$01A4	$3001			MOVLW	1
$01A5	$00F1			MOVWF	STACK_1
$01A6	$0871			MOVF	STACK_1, 0
$01A7	$3A01			XORLW	1
$01A8	$1D03			BTFSS	STATUS, Z
$01A9	$29AF			GOTO	TecladoMatricial_L_110
$01AA	$	TecladoMatricial_L_109:
^TecladoMatricial.pbas, 263 :: 		vetor_display[0]=Converte_to_7seg(1)
$01AA	$3001			MOVLW	1
$01AB	$00AA			MOVWF	FARG_Converte_to_7seg
$01AC	$2115			CALL	TecladoMatricial_converte_to_7seg
$01AD	$0870			MOVF	STACK_0, 0
$01AE	$00A2			MOVWF	main_global_vetor_display+0
$01AF	$	TecladoMatricial_L_110:
^TecladoMatricial.pbas, 264 :: 		end if
$01AF	$	TecladoMatricial_L_111:
^TecladoMatricial.pbas, 265 :: 		if testbit(teclado0,tecla_2) = 1 then
$01AF	$3000			MOVLW	0
$01B0	$1921			BTFSC	main_global_teclado0, 2
$01B1	$3001			MOVLW	1
$01B2	$00F1			MOVWF	STACK_1
$01B3	$0871			MOVF	STACK_1, 0
$01B4	$3A01			XORLW	1
$01B5	$1D03			BTFSS	STATUS, Z
$01B6	$29BC			GOTO	TecladoMatricial_L_113
$01B7	$	TecladoMatricial_L_112:
^TecladoMatricial.pbas, 266 :: 		vetor_display[0]=Converte_to_7seg(2)
$01B7	$3002			MOVLW	2
$01B8	$00AA			MOVWF	FARG_Converte_to_7seg
$01B9	$2115			CALL	TecladoMatricial_converte_to_7seg
$01BA	$0870			MOVF	STACK_0, 0
$01BB	$00A2			MOVWF	main_global_vetor_display+0
$01BC	$	TecladoMatricial_L_113:
^TecladoMatricial.pbas, 267 :: 		end if
$01BC	$	TecladoMatricial_L_114:
^TecladoMatricial.pbas, 268 :: 		if testbit(teclado0,tecla_3) = 1 then
$01BC	$3000			MOVLW	0
$01BD	$19A1			BTFSC	main_global_teclado0, 3
$01BE	$3001			MOVLW	1
$01BF	$00F1			MOVWF	STACK_1
$01C0	$0871			MOVF	STACK_1, 0
$01C1	$3A01			XORLW	1
$01C2	$1D03			BTFSS	STATUS, Z
$01C3	$29C9			GOTO	TecladoMatricial_L_116
$01C4	$	TecladoMatricial_L_115:
^TecladoMatricial.pbas, 269 :: 		vetor_display[0]=Converte_to_7seg(3)
$01C4	$3003			MOVLW	3
$01C5	$00AA			MOVWF	FARG_Converte_to_7seg
$01C6	$2115			CALL	TecladoMatricial_converte_to_7seg
$01C7	$0870			MOVF	STACK_0, 0
$01C8	$00A2			MOVWF	main_global_vetor_display+0
$01C9	$	TecladoMatricial_L_116:
^TecladoMatricial.pbas, 270 :: 		end if
$01C9	$	TecladoMatricial_L_117:
^TecladoMatricial.pbas, 272 :: 		if testbit(teclado0,tecla_4) = 1 then
$01C9	$3000			MOVLW	0
$01CA	$1A21			BTFSC	main_global_teclado0, 4
$01CB	$3001			MOVLW	1
$01CC	$00F1			MOVWF	STACK_1
$01CD	$0871			MOVF	STACK_1, 0
$01CE	$3A01			XORLW	1
$01CF	$1D03			BTFSS	STATUS, Z
$01D0	$29D6			GOTO	TecladoMatricial_L_119
$01D1	$	TecladoMatricial_L_118:
^TecladoMatricial.pbas, 273 :: 		vetor_display[1]=Converte_to_7seg(4)
$01D1	$3004			MOVLW	4
$01D2	$00AA			MOVWF	FARG_Converte_to_7seg
$01D3	$2115			CALL	TecladoMatricial_converte_to_7seg
$01D4	$0870			MOVF	STACK_0, 0
$01D5	$00A3			MOVWF	main_global_vetor_display+1
$01D6	$	TecladoMatricial_L_119:
^TecladoMatricial.pbas, 274 :: 		end if
$01D6	$	TecladoMatricial_L_120:
^TecladoMatricial.pbas, 275 :: 		if testbit(teclado0,tecla_5) = 1 then
$01D6	$3000			MOVLW	0
$01D7	$1AA1			BTFSC	main_global_teclado0, 5
$01D8	$3001			MOVLW	1
$01D9	$00F1			MOVWF	STACK_1
$01DA	$0871			MOVF	STACK_1, 0
$01DB	$3A01			XORLW	1
$01DC	$1D03			BTFSS	STATUS, Z
$01DD	$29E3			GOTO	TecladoMatricial_L_122
$01DE	$	TecladoMatricial_L_121:
^TecladoMatricial.pbas, 276 :: 		vetor_display[1]=Converte_to_7seg(5)
$01DE	$3005			MOVLW	5
$01DF	$00AA			MOVWF	FARG_Converte_to_7seg
$01E0	$2115			CALL	TecladoMatricial_converte_to_7seg
$01E1	$0870			MOVF	STACK_0, 0
$01E2	$00A3			MOVWF	main_global_vetor_display+1
$01E3	$	TecladoMatricial_L_122:
^TecladoMatricial.pbas, 277 :: 		end if
$01E3	$	TecladoMatricial_L_123:
^TecladoMatricial.pbas, 278 :: 		if testbit(teclado0,tecla_6) = 1 then
$01E3	$3000			MOVLW	0
$01E4	$1B21			BTFSC	main_global_teclado0, 6
$01E5	$3001			MOVLW	1
$01E6	$00F1			MOVWF	STACK_1
$01E7	$0871			MOVF	STACK_1, 0
$01E8	$3A01			XORLW	1
$01E9	$1D03			BTFSS	STATUS, Z
$01EA	$29F0			GOTO	TecladoMatricial_L_125
$01EB	$	TecladoMatricial_L_124:
^TecladoMatricial.pbas, 279 :: 		vetor_display[1]=Converte_to_7seg(6)
$01EB	$3006			MOVLW	6
$01EC	$00AA			MOVWF	FARG_Converte_to_7seg
$01ED	$2115			CALL	TecladoMatricial_converte_to_7seg
$01EE	$0870			MOVF	STACK_0, 0
$01EF	$00A3			MOVWF	main_global_vetor_display+1
$01F0	$	TecladoMatricial_L_125:
^TecladoMatricial.pbas, 280 :: 		end if
$01F0	$	TecladoMatricial_L_126:
^TecladoMatricial.pbas, 282 :: 		if testbit(teclado0,tecla_7) = 1 then
$01F0	$3000			MOVLW	0
$01F1	$1BA1			BTFSC	main_global_teclado0, 7
$01F2	$3001			MOVLW	1
$01F3	$00F1			MOVWF	STACK_1
$01F4	$0871			MOVF	STACK_1, 0
$01F5	$3A01			XORLW	1
$01F6	$1D03			BTFSS	STATUS, Z
$01F7	$29FD			GOTO	TecladoMatricial_L_128
$01F8	$	TecladoMatricial_L_127:
^TecladoMatricial.pbas, 283 :: 		vetor_display[2]=Converte_to_7seg(7)
$01F8	$3007			MOVLW	7
$01F9	$00AA			MOVWF	FARG_Converte_to_7seg
$01FA	$2115			CALL	TecladoMatricial_converte_to_7seg
$01FB	$0870			MOVF	STACK_0, 0
$01FC	$00A4			MOVWF	main_global_vetor_display+2
$01FD	$	TecladoMatricial_L_128:
^TecladoMatricial.pbas, 284 :: 		end if
$01FD	$	TecladoMatricial_L_129:
^TecladoMatricial.pbas, 285 :: 		if testbit(teclado1,tecla_8) = 1 then
$01FD	$3001			MOVLW	1
$01FE	$0526			ANDWF	main_global_teclado1, 0
$01FF	$00F1			MOVWF	STACK_1
$0200	$0871			MOVF	STACK_1, 0
$0201	$3A01			XORLW	1
$0202	$1D03			BTFSS	STATUS, Z
$0203	$2A09			GOTO	TecladoMatricial_L_131
$0204	$	TecladoMatricial_L_130:
^TecladoMatricial.pbas, 286 :: 		vetor_display[2]=Converte_to_7seg(8)
$0204	$3008			MOVLW	8
$0205	$00AA			MOVWF	FARG_Converte_to_7seg
$0206	$2115			CALL	TecladoMatricial_converte_to_7seg
$0207	$0870			MOVF	STACK_0, 0
$0208	$00A4			MOVWF	main_global_vetor_display+2
$0209	$	TecladoMatricial_L_131:
^TecladoMatricial.pbas, 287 :: 		end if
$0209	$	TecladoMatricial_L_132:
^TecladoMatricial.pbas, 288 :: 		if testbit(teclado1,tecla_9) = 1 then
$0209	$3000			MOVLW	0
$020A	$18A6			BTFSC	main_global_teclado1, 1
$020B	$3001			MOVLW	1
$020C	$00F1			MOVWF	STACK_1
$020D	$0871			MOVF	STACK_1, 0
$020E	$3A01			XORLW	1
$020F	$1D03			BTFSS	STATUS, Z
$0210	$2A16			GOTO	TecladoMatricial_L_134
$0211	$	TecladoMatricial_L_133:
^TecladoMatricial.pbas, 289 :: 		vetor_display[2]=Converte_to_7seg(9)
$0211	$3009			MOVLW	9
$0212	$00AA			MOVWF	FARG_Converte_to_7seg
$0213	$2115			CALL	TecladoMatricial_converte_to_7seg
$0214	$0870			MOVF	STACK_0, 0
$0215	$00A4			MOVWF	main_global_vetor_display+2
$0216	$	TecladoMatricial_L_134:
^TecladoMatricial.pbas, 290 :: 		end if
$0216	$	TecladoMatricial_L_135:
^TecladoMatricial.pbas, 292 :: 		if testbit(teclado1,tecla_C) = 1 then
$0216	$3000			MOVLW	0
$0217	$1926			BTFSC	main_global_teclado1, 2
$0218	$3001			MOVLW	1
$0219	$00F1			MOVWF	STACK_1
$021A	$0871			MOVF	STACK_1, 0
$021B	$3A01			XORLW	1
$021C	$1D03			BTFSS	STATUS, Z
$021D	$2A23			GOTO	TecladoMatricial_L_137
$021E	$	TecladoMatricial_L_136:
^TecladoMatricial.pbas, 293 :: 		vetor_display[3]=Converte_to_7seg(12)
$021E	$300C			MOVLW	12
$021F	$00AA			MOVWF	FARG_Converte_to_7seg
$0220	$2115			CALL	TecladoMatricial_converte_to_7seg
$0221	$0870			MOVF	STACK_0, 0
$0222	$00A5			MOVWF	main_global_vetor_display+3
$0223	$	TecladoMatricial_L_137:
^TecladoMatricial.pbas, 294 :: 		end if
$0223	$	TecladoMatricial_L_138:
^TecladoMatricial.pbas, 295 :: 		if testbit(teclado0,tecla_0) = 1 then
$0223	$3001			MOVLW	1
$0224	$0521			ANDWF	main_global_teclado0, 0
$0225	$00F1			MOVWF	STACK_1
$0226	$0871			MOVF	STACK_1, 0
$0227	$3A01			XORLW	1
$0228	$1D03			BTFSS	STATUS, Z
$0229	$2A2E			GOTO	TecladoMatricial_L_140
$022A	$	TecladoMatricial_L_139:
^TecladoMatricial.pbas, 296 :: 		vetor_display[3]=Converte_to_7seg(0)
$022A	$01AA			CLRF	FARG_Converte_to_7seg, 1
$022B	$2115			CALL	TecladoMatricial_converte_to_7seg
$022C	$0870			MOVF	STACK_0, 0
$022D	$00A5			MOVWF	main_global_vetor_display+3
$022E	$	TecladoMatricial_L_140:
^TecladoMatricial.pbas, 297 :: 		end if
$022E	$	TecladoMatricial_L_141:
^TecladoMatricial.pbas, 298 :: 		if testbit(teclado1,tecla_E) = 1 then
$022E	$3000			MOVLW	0
$022F	$19A6			BTFSC	main_global_teclado1, 3
$0230	$3001			MOVLW	1
$0231	$00F1			MOVWF	STACK_1
$0232	$0871			MOVF	STACK_1, 0
$0233	$3A01			XORLW	1
$0234	$1D03			BTFSS	STATUS, Z
$0235	$2A3B			GOTO	TecladoMatricial_L_143
$0236	$	TecladoMatricial_L_142:
^TecladoMatricial.pbas, 299 :: 		vetor_display[3]=Converte_to_7seg(14)
$0236	$300E			MOVLW	14
$0237	$00AA			MOVWF	FARG_Converte_to_7seg
$0238	$2115			CALL	TecladoMatricial_converte_to_7seg
$0239	$0870			MOVF	STACK_0, 0
$023A	$00A5			MOVWF	main_global_vetor_display+3
$023B	$	TecladoMatricial_L_143:
^TecladoMatricial.pbas, 300 :: 		end if
$023B	$	TecladoMatricial_L_144:
$023B	$29A2			GOTO	TecladoMatricial_L_105
^TecladoMatricial.pbas, 302 :: 		wend
$023C	$2A3C			GOTO	$
