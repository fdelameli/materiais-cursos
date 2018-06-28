;//  ASM code generated by mikroVirtualMachine for PIC - V. 3.0.0.0
;  Date/Time: 26/03/05 10:24:50
;  Info: http://www.mikroelektronika.co.yu


;// ADDRESS	OPCODE	ASM
; ----------------------------------------------
$0000	$29BC	GOTO	TecladoMatricial_main
$0004	$	TecladoMatricial_interrupt:
$0004	$00F1	MOVWF	STACK_i_1
$0005	$0E03	SWAPF	STATUS, W
$0006	$0183	CLRF	STATUS
$0007	$00F2	MOVWF	STACK_i_2
$0008	$0804	MOVF	FSR, W
$0009	$00F0	MOVWF	STACK_i_0
$000A	$080A	MOVF	PCLATH, W
$000B	$00F3	MOVWF	STACK_i_3
$000C	$018A	CLRF	PCLATH
$000D	$3000	MOVLW	0
$000E	$190B	BTFSC	INTCON, 2
$000F	$3001	MOVLW	1
$0010	$00F5	MOVWF	STACK_i_5
$0011	$3001	MOVLW	1
$0012	$0275	SUBWF	STACK_i_5, W
$0013	$1D03	BTFSS	STATUS, Z
$0014	$2818	GOTO	TecladoMatricial_L_50
$0015	$	TecladoMatricial_L_49:
$0015	$30FF	MOVLW	255
$0016	$00F6	MOVWF	STACK_i_6
$0017	$2819	GOTO	TecladoMatricial_L_52
$0018	$	TecladoMatricial_L_50:
$0018	$01F6	CLRF	STACK_i_6
$0019	$	TecladoMatricial_L_52:
$0019	$30FF	MOVLW	255
$001A	$0276	SUBWF	STACK_i_6, W
$001B	$1D03	BTFSS	STATUS, Z
$001C	$2940	GOTO	TecladoMatricial_L_54
$001D	$	TecladoMatricial_L_53:
$001D	$110B	BCF	INTCON, 2
$001E	$0AA0	INCF	main_global_indice, F
$001F	$	TecladoMatricial_L_57:
$001F	$3001	MOVLW	1
$0020	$0220	SUBWF	main_global_indice, W
$0021	$1D03	BTFSS	STATUS, Z
$0022	$2867	GOTO	TecladoMatricial_L_58
$0023	$	TecladoMatricial_L_56:
$0023	$1206	BCF	PORTB, 4
$0024	$300E	MOVLW	14
$0025	$0088	MOVWF	PORTD
$0026	$10A1	BCF	main_global_teclado0, 1
$0027	$1121	BCF	main_global_teclado0, 2
$0028	$11A1	BCF	main_global_teclado0, 3
$0029	$3000	MOVLW	0
$002A	$1A05	BTFSC	PORTA, 4
$002B	$3001	MOVLW	1
$002C	$00FB	MOVWF	STACK_i_11
$002D	$3000	MOVLW	0
$002E	$027B	SUBWF	STACK_i_11, W
$002F	$1D03	BTFSS	STATUS, Z
$0030	$2834	GOTO	TecladoMatricial_L_60
$0031	$	TecladoMatricial_L_59:
$0031	$30FF	MOVLW	255
$0032	$00FC	MOVWF	STACK_i_12
$0033	$2835	GOTO	TecladoMatricial_L_62
$0034	$	TecladoMatricial_L_60:
$0034	$01FC	CLRF	STACK_i_12
$0035	$	TecladoMatricial_L_62:
$0035	$30FF	MOVLW	255
$0036	$027C	SUBWF	STACK_i_12, W
$0037	$1D03	BTFSS	STATUS, Z
$0038	$283A	GOTO	TecladoMatricial_L_64
$0039	$	TecladoMatricial_L_63:
$0039	$14A1	BSF	main_global_teclado0, 1
$003A	$	TecladoMatricial_L_64:
$003A	$	TecladoMatricial_L_61:
$003A	$3000	MOVLW	0
$003B	$1A85	BTFSC	PORTA, 5
$003C	$3001	MOVLW	1
$003D	$00FC	MOVWF	STACK_i_12
$003E	$3000	MOVLW	0
$003F	$027C	SUBWF	STACK_i_12, W
$0040	$1D03	BTFSS	STATUS, Z
$0041	$2845	GOTO	TecladoMatricial_L_66
$0042	$	TecladoMatricial_L_65:
$0042	$30FF	MOVLW	255
$0043	$00FD	MOVWF	STACK_i_13
$0044	$2846	GOTO	TecladoMatricial_L_68
$0045	$	TecladoMatricial_L_66:
$0045	$01FD	CLRF	STACK_i_13
$0046	$	TecladoMatricial_L_68:
$0046	$30FF	MOVLW	255
$0047	$027D	SUBWF	STACK_i_13, W
$0048	$1D03	BTFSS	STATUS, Z
$0049	$284B	GOTO	TecladoMatricial_L_70
$004A	$	TecladoMatricial_L_69:
$004A	$1521	BSF	main_global_teclado0, 2
$004B	$	TecladoMatricial_L_70:
$004B	$	TecladoMatricial_L_67:
$004B	$3000	MOVLW	0
$004C	$1809	BTFSC	PORTE, 0
$004D	$3001	MOVLW	1
$004E	$00FD	MOVWF	STACK_i_13
$004F	$3000	MOVLW	0
$0050	$027D	SUBWF	STACK_i_13, W
$0051	$1D03	BTFSS	STATUS, Z
$0052	$2856	GOTO	TecladoMatricial_L_72
$0053	$	TecladoMatricial_L_71:
$0053	$30FF	MOVLW	255
$0054	$00FE	MOVWF	STACK_i_14
$0055	$2857	GOTO	TecladoMatricial_L_74
$0056	$	TecladoMatricial_L_72:
$0056	$01FE	CLRF	STACK_i_14
$0057	$	TecladoMatricial_L_74:
$0057	$30FF	MOVLW	255
$0058	$027E	SUBWF	STACK_i_14, W
$0059	$1D03	BTFSS	STATUS, Z
$005A	$285C	GOTO	TecladoMatricial_L_76
$005B	$	TecladoMatricial_L_75:
$005B	$15A1	BSF	main_global_teclado0, 3
$005C	$	TecladoMatricial_L_76:
$005C	$	TecladoMatricial_L_73:
$005C	$0820	MOVF	main_global_indice, W
$005D	$00FD	MOVWF	STACK_i_13
$005E	$03FD	DECF	STACK_i_13, F
$005F	$3022	MOVLW	main_global_vetor_display_1
$0060	$0084	MOVWF	FSR
$0061	$087D	MOVF	STACK_i_13, W
$0062	$0784	ADDWF	FSR, F
$0063	$	TecladoMatricial_L_77:
$0063	$0800	MOVF	INDF, W
$0064	$0088	MOVWF	PORTD
$0065	$1486	BSF	PORTB, 1
$0066	$2940	GOTO	TecladoMatricial_L_55
$0067	$	TecladoMatricial_L_58:
$0067	$	TecladoMatricial_L_79:
$0067	$3002	MOVLW	2
$0068	$0220	SUBWF	main_global_indice, W
$0069	$1D03	BTFSS	STATUS, Z
$006A	$28AF	GOTO	TecladoMatricial_L_80
$006B	$	TecladoMatricial_L_78:
$006B	$1086	BCF	PORTB, 1
$006C	$300D	MOVLW	13
$006D	$0088	MOVWF	PORTD
$006E	$1221	BCF	main_global_teclado0, 4
$006F	$12A1	BCF	main_global_teclado0, 5
$0070	$1321	BCF	main_global_teclado0, 6
$0071	$3000	MOVLW	0
$0072	$1A05	BTFSC	PORTA, 4
$0073	$3001	MOVLW	1
$0074	$00FB	MOVWF	STACK_i_11
$0075	$3000	MOVLW	0
$0076	$027B	SUBWF	STACK_i_11, W
$0077	$1D03	BTFSS	STATUS, Z
$0078	$287C	GOTO	TecladoMatricial_L_82
$0079	$	TecladoMatricial_L_81:
$0079	$30FF	MOVLW	255
$007A	$00FC	MOVWF	STACK_i_12
$007B	$287D	GOTO	TecladoMatricial_L_84
$007C	$	TecladoMatricial_L_82:
$007C	$01FC	CLRF	STACK_i_12
$007D	$	TecladoMatricial_L_84:
$007D	$30FF	MOVLW	255
$007E	$027C	SUBWF	STACK_i_12, W
$007F	$1D03	BTFSS	STATUS, Z
$0080	$2882	GOTO	TecladoMatricial_L_86
$0081	$	TecladoMatricial_L_85:
$0081	$1621	BSF	main_global_teclado0, 4
$0082	$	TecladoMatricial_L_86:
$0082	$	TecladoMatricial_L_83:
$0082	$3000	MOVLW	0
$0083	$1A85	BTFSC	PORTA, 5
$0084	$3001	MOVLW	1
$0085	$00FC	MOVWF	STACK_i_12
$0086	$3000	MOVLW	0
$0087	$027C	SUBWF	STACK_i_12, W
$0088	$1D03	BTFSS	STATUS, Z
$0089	$288D	GOTO	TecladoMatricial_L_88
$008A	$	TecladoMatricial_L_87:
$008A	$30FF	MOVLW	255
$008B	$00FD	MOVWF	STACK_i_13
$008C	$288E	GOTO	TecladoMatricial_L_90
$008D	$	TecladoMatricial_L_88:
$008D	$01FD	CLRF	STACK_i_13
$008E	$	TecladoMatricial_L_90:
$008E	$30FF	MOVLW	255
$008F	$027D	SUBWF	STACK_i_13, W
$0090	$1D03	BTFSS	STATUS, Z
$0091	$2893	GOTO	TecladoMatricial_L_92
$0092	$	TecladoMatricial_L_91:
$0092	$16A1	BSF	main_global_teclado0, 5
$0093	$	TecladoMatricial_L_92:
$0093	$	TecladoMatricial_L_89:
$0093	$3000	MOVLW	0
$0094	$1809	BTFSC	PORTE, 0
$0095	$3001	MOVLW	1
$0096	$00FD	MOVWF	STACK_i_13
$0097	$3000	MOVLW	0
$0098	$027D	SUBWF	STACK_i_13, W
$0099	$1D03	BTFSS	STATUS, Z
$009A	$289E	GOTO	TecladoMatricial_L_94
$009B	$	TecladoMatricial_L_93:
$009B	$30FF	MOVLW	255
$009C	$00FE	MOVWF	STACK_i_14
$009D	$289F	GOTO	TecladoMatricial_L_96
$009E	$	TecladoMatricial_L_94:
$009E	$01FE	CLRF	STACK_i_14
$009F	$	TecladoMatricial_L_96:
$009F	$30FF	MOVLW	255
$00A0	$027E	SUBWF	STACK_i_14, W
$00A1	$1D03	BTFSS	STATUS, Z
$00A2	$28A4	GOTO	TecladoMatricial_L_98
$00A3	$	TecladoMatricial_L_97:
$00A3	$1721	BSF	main_global_teclado0, 6
$00A4	$	TecladoMatricial_L_98:
$00A4	$	TecladoMatricial_L_95:
$00A4	$0820	MOVF	main_global_indice, W
$00A5	$00FD	MOVWF	STACK_i_13
$00A6	$03FD	DECF	STACK_i_13, F
$00A7	$3022	MOVLW	main_global_vetor_display_1
$00A8	$0084	MOVWF	FSR
$00A9	$087D	MOVF	STACK_i_13, W
$00AA	$0784	ADDWF	FSR, F
$00AB	$	TecladoMatricial_L_99:
$00AB	$0800	MOVF	INDF, W
$00AC	$0088	MOVWF	PORTD
$00AD	$1506	BSF	PORTB, 2
$00AE	$2940	GOTO	TecladoMatricial_L_55
$00AF	$	TecladoMatricial_L_80:
$00AF	$	TecladoMatricial_L_101:
$00AF	$3003	MOVLW	3
$00B0	$0220	SUBWF	main_global_indice, W
$00B1	$1D03	BTFSS	STATUS, Z
$00B2	$28F7	GOTO	TecladoMatricial_L_102
$00B3	$	TecladoMatricial_L_100:
$00B3	$1106	BCF	PORTB, 2
$00B4	$300B	MOVLW	11
$00B5	$0088	MOVWF	PORTD
$00B6	$13A1	BCF	main_global_teclado0, 7
$00B7	$1026	BCF	main_global_teclado1, 0
$00B8	$10A6	BCF	main_global_teclado1, 1
$00B9	$3000	MOVLW	0
$00BA	$1A05	BTFSC	PORTA, 4
$00BB	$3001	MOVLW	1
$00BC	$00FB	MOVWF	STACK_i_11
$00BD	$3000	MOVLW	0
$00BE	$027B	SUBWF	STACK_i_11, W
$00BF	$1D03	BTFSS	STATUS, Z
$00C0	$28C4	GOTO	TecladoMatricial_L_104
$00C1	$	TecladoMatricial_L_103:
$00C1	$30FF	MOVLW	255
$00C2	$00FC	MOVWF	STACK_i_12
$00C3	$28C5	GOTO	TecladoMatricial_L_106
$00C4	$	TecladoMatricial_L_104:
$00C4	$01FC	CLRF	STACK_i_12
$00C5	$	TecladoMatricial_L_106:
$00C5	$30FF	MOVLW	255
$00C6	$027C	SUBWF	STACK_i_12, W
$00C7	$1D03	BTFSS	STATUS, Z
$00C8	$28CA	GOTO	TecladoMatricial_L_108
$00C9	$	TecladoMatricial_L_107:
$00C9	$17A1	BSF	main_global_teclado0, 7
$00CA	$	TecladoMatricial_L_108:
$00CA	$	TecladoMatricial_L_105:
$00CA	$3000	MOVLW	0
$00CB	$1A85	BTFSC	PORTA, 5
$00CC	$3001	MOVLW	1
$00CD	$00FC	MOVWF	STACK_i_12
$00CE	$3000	MOVLW	0
$00CF	$027C	SUBWF	STACK_i_12, W
$00D0	$1D03	BTFSS	STATUS, Z
$00D1	$28D5	GOTO	TecladoMatricial_L_110
$00D2	$	TecladoMatricial_L_109:
$00D2	$30FF	MOVLW	255
$00D3	$00FD	MOVWF	STACK_i_13
$00D4	$28D6	GOTO	TecladoMatricial_L_112
$00D5	$	TecladoMatricial_L_110:
$00D5	$01FD	CLRF	STACK_i_13
$00D6	$	TecladoMatricial_L_112:
$00D6	$30FF	MOVLW	255
$00D7	$027D	SUBWF	STACK_i_13, W
$00D8	$1D03	BTFSS	STATUS, Z
$00D9	$28DB	GOTO	TecladoMatricial_L_114
$00DA	$	TecladoMatricial_L_113:
$00DA	$1426	BSF	main_global_teclado1, 0
$00DB	$	TecladoMatricial_L_114:
$00DB	$	TecladoMatricial_L_111:
$00DB	$3000	MOVLW	0
$00DC	$1809	BTFSC	PORTE, 0
$00DD	$3001	MOVLW	1
$00DE	$00FD	MOVWF	STACK_i_13
$00DF	$3000	MOVLW	0
$00E0	$027D	SUBWF	STACK_i_13, W
$00E1	$1D03	BTFSS	STATUS, Z
$00E2	$28E6	GOTO	TecladoMatricial_L_116
$00E3	$	TecladoMatricial_L_115:
$00E3	$30FF	MOVLW	255
$00E4	$00FE	MOVWF	STACK_i_14
$00E5	$28E7	GOTO	TecladoMatricial_L_118
$00E6	$	TecladoMatricial_L_116:
$00E6	$01FE	CLRF	STACK_i_14
$00E7	$	TecladoMatricial_L_118:
$00E7	$30FF	MOVLW	255
$00E8	$027E	SUBWF	STACK_i_14, W
$00E9	$1D03	BTFSS	STATUS, Z
$00EA	$28EC	GOTO	TecladoMatricial_L_120
$00EB	$	TecladoMatricial_L_119:
$00EB	$14A6	BSF	main_global_teclado1, 1
$00EC	$	TecladoMatricial_L_120:
$00EC	$	TecladoMatricial_L_117:
$00EC	$0820	MOVF	main_global_indice, W
$00ED	$00FD	MOVWF	STACK_i_13
$00EE	$03FD	DECF	STACK_i_13, F
$00EF	$3022	MOVLW	main_global_vetor_display_1
$00F0	$0084	MOVWF	FSR
$00F1	$087D	MOVF	STACK_i_13, W
$00F2	$0784	ADDWF	FSR, F
$00F3	$	TecladoMatricial_L_121:
$00F3	$0800	MOVF	INDF, W
$00F4	$0088	MOVWF	PORTD
$00F5	$1586	BSF	PORTB, 3
$00F6	$2940	GOTO	TecladoMatricial_L_55
$00F7	$	TecladoMatricial_L_102:
$00F7	$	TecladoMatricial_L_123:
$00F7	$3004	MOVLW	4
$00F8	$0220	SUBWF	main_global_indice, W
$00F9	$1D03	BTFSS	STATUS, Z
$00FA	$2940	GOTO	TecladoMatricial_L_124
$00FB	$	TecladoMatricial_L_122:
$00FB	$1186	BCF	PORTB, 3
$00FC	$3007	MOVLW	7
$00FD	$0088	MOVWF	PORTD
$00FE	$1126	BCF	main_global_teclado1, 2
$00FF	$1021	BCF	main_global_teclado0, 0
$0100	$11A6	BCF	main_global_teclado1, 3
$0101	$3000	MOVLW	0
$0102	$1A05	BTFSC	PORTA, 4
$0103	$3001	MOVLW	1
$0104	$00FB	MOVWF	STACK_i_11
$0105	$3000	MOVLW	0
$0106	$027B	SUBWF	STACK_i_11, W
$0107	$1D03	BTFSS	STATUS, Z
$0108	$290C	GOTO	TecladoMatricial_L_126
$0109	$	TecladoMatricial_L_125:
$0109	$30FF	MOVLW	255
$010A	$00FC	MOVWF	STACK_i_12
$010B	$290D	GOTO	TecladoMatricial_L_128
$010C	$	TecladoMatricial_L_126:
$010C	$01FC	CLRF	STACK_i_12
$010D	$	TecladoMatricial_L_128:
$010D	$30FF	MOVLW	255
$010E	$027C	SUBWF	STACK_i_12, W
$010F	$1D03	BTFSS	STATUS, Z
$0110	$2912	GOTO	TecladoMatricial_L_130
$0111	$	TecladoMatricial_L_129:
$0111	$1526	BSF	main_global_teclado1, 2
$0112	$	TecladoMatricial_L_130:
$0112	$	TecladoMatricial_L_127:
$0112	$3000	MOVLW	0
$0113	$1A85	BTFSC	PORTA, 5
$0114	$3001	MOVLW	1
$0115	$00FC	MOVWF	STACK_i_12
$0116	$3000	MOVLW	0
$0117	$027C	SUBWF	STACK_i_12, W
$0118	$1D03	BTFSS	STATUS, Z
$0119	$291D	GOTO	TecladoMatricial_L_132
$011A	$	TecladoMatricial_L_131:
$011A	$30FF	MOVLW	255
$011B	$00FD	MOVWF	STACK_i_13
$011C	$291E	GOTO	TecladoMatricial_L_134
$011D	$	TecladoMatricial_L_132:
$011D	$01FD	CLRF	STACK_i_13
$011E	$	TecladoMatricial_L_134:
$011E	$30FF	MOVLW	255
$011F	$027D	SUBWF	STACK_i_13, W
$0120	$1D03	BTFSS	STATUS, Z
$0121	$2923	GOTO	TecladoMatricial_L_136
$0122	$	TecladoMatricial_L_135:
$0122	$1421	BSF	main_global_teclado0, 0
$0123	$	TecladoMatricial_L_136:
$0123	$	TecladoMatricial_L_133:
$0123	$3000	MOVLW	0
$0124	$1809	BTFSC	PORTE, 0
$0125	$3001	MOVLW	1
$0126	$00FD	MOVWF	STACK_i_13
$0127	$3000	MOVLW	0
$0128	$027D	SUBWF	STACK_i_13, W
$0129	$1D03	BTFSS	STATUS, Z
$012A	$292E	GOTO	TecladoMatricial_L_138
$012B	$	TecladoMatricial_L_137:
$012B	$30FF	MOVLW	255
$012C	$00FE	MOVWF	STACK_i_14
$012D	$292F	GOTO	TecladoMatricial_L_140
$012E	$	TecladoMatricial_L_138:
$012E	$01FE	CLRF	STACK_i_14
$012F	$	TecladoMatricial_L_140:
$012F	$30FF	MOVLW	255
$0130	$027E	SUBWF	STACK_i_14, W
$0131	$1D03	BTFSS	STATUS, Z
$0132	$2934	GOTO	TecladoMatricial_L_142
$0133	$	TecladoMatricial_L_141:
$0133	$15A6	BSF	main_global_teclado1, 3
$0134	$	TecladoMatricial_L_142:
$0134	$	TecladoMatricial_L_139:
$0134	$0820	MOVF	main_global_indice, W
$0135	$00FD	MOVWF	STACK_i_13
$0136	$03FD	DECF	STACK_i_13, F
$0137	$3022	MOVLW	main_global_vetor_display_1
$0138	$0084	MOVWF	FSR
$0139	$087D	MOVF	STACK_i_13, W
$013A	$0784	ADDWF	FSR, F
$013B	$	TecladoMatricial_L_143:
$013B	$0800	MOVF	INDF, W
$013C	$0088	MOVWF	PORTD
$013D	$1606	BSF	PORTB, 4
$013E	$01A0	CLRF	main_global_indice
$013F	$2940	GOTO	TecladoMatricial_L_55
$0140	$	TecladoMatricial_L_124:
$0140	$	TecladoMatricial_L_55:
$0140	$	TecladoMatricial_L_54:
$0140	$	TecladoMatricial_L_51:
$0140	$0873	MOVF	STACK_i_3, W
$0141	$008A	MOVWF	PCLATH
$0142	$0870	MOVF	STACK_i_0, W
$0143	$0084	MOVWF	FSR
$0144	$0E72	SWAPF	STACK_i_2, W
$0145	$0083	MOVWF	STATUS
$0146	$0EF1	SWAPF	STACK_i_1, F
$0147	$0E71	SWAPF	STACK_i_1, W
$0148	$0009	RETFIE
$0149	$	TecladoMatricial_converte_to_7seg:
$0149	$	TecladoMatricial_L_2:
$0149	$3000	MOVLW	0
$014A	$1303	BCF	STATUS,RP1
$014B	$1283	BCF	STATUS,RP0
$014C	$0228	SUBWF	tecladomatricial_converte_to_7seg_param_dado, W
$014D	$1D03	BTFSS	STATUS, Z
$014E	$2952	GOTO	TecladoMatricial_L_3
$014F	$	TecladoMatricial_L_1:
$014F	$303F	MOVLW	63
$0150	$00A7	MOVWF	tecladomatricial_converte_to_7seg_local_result
$0151	$29BB	GOTO	TecladoMatricial_L_0
$0152	$	TecladoMatricial_L_3:
$0152	$	TecladoMatricial_L_5:
$0152	$3001	MOVLW	1
$0153	$0228	SUBWF	tecladomatricial_converte_to_7seg_param_dado, W
$0154	$1D03	BTFSS	STATUS, Z
$0155	$2959	GOTO	TecladoMatricial_L_6
$0156	$	TecladoMatricial_L_4:
$0156	$3006	MOVLW	6
$0157	$00A7	MOVWF	tecladomatricial_converte_to_7seg_local_result
$0158	$29BB	GOTO	TecladoMatricial_L_0
$0159	$	TecladoMatricial_L_6:
$0159	$	TecladoMatricial_L_8:
$0159	$3002	MOVLW	2
$015A	$0228	SUBWF	tecladomatricial_converte_to_7seg_param_dado, W
$015B	$1D03	BTFSS	STATUS, Z
$015C	$2960	GOTO	TecladoMatricial_L_9
$015D	$	TecladoMatricial_L_7:
$015D	$305B	MOVLW	91
$015E	$00A7	MOVWF	tecladomatricial_converte_to_7seg_local_result
$015F	$29BB	GOTO	TecladoMatricial_L_0
$0160	$	TecladoMatricial_L_9:
$0160	$	TecladoMatricial_L_11:
$0160	$3003	MOVLW	3
$0161	$0228	SUBWF	tecladomatricial_converte_to_7seg_param_dado, W
$0162	$1D03	BTFSS	STATUS, Z
$0163	$2967	GOTO	TecladoMatricial_L_12
$0164	$	TecladoMatricial_L_10:
$0164	$304F	MOVLW	79
$0165	$00A7	MOVWF	tecladomatricial_converte_to_7seg_local_result
$0166	$29BB	GOTO	TecladoMatricial_L_0
$0167	$	TecladoMatricial_L_12:
$0167	$	TecladoMatricial_L_14:
$0167	$3004	MOVLW	4
$0168	$0228	SUBWF	tecladomatricial_converte_to_7seg_param_dado, W
$0169	$1D03	BTFSS	STATUS, Z
$016A	$296E	GOTO	TecladoMatricial_L_15
$016B	$	TecladoMatricial_L_13:
$016B	$3066	MOVLW	102
$016C	$00A7	MOVWF	tecladomatricial_converte_to_7seg_local_result
$016D	$29BB	GOTO	TecladoMatricial_L_0
$016E	$	TecladoMatricial_L_15:
$016E	$	TecladoMatricial_L_17:
$016E	$3005	MOVLW	5
$016F	$0228	SUBWF	tecladomatricial_converte_to_7seg_param_dado, W
$0170	$1D03	BTFSS	STATUS, Z
$0171	$2975	GOTO	TecladoMatricial_L_18
$0172	$	TecladoMatricial_L_16:
$0172	$306D	MOVLW	109
$0173	$00A7	MOVWF	tecladomatricial_converte_to_7seg_local_result
$0174	$29BB	GOTO	TecladoMatricial_L_0
$0175	$	TecladoMatricial_L_18:
$0175	$	TecladoMatricial_L_20:
$0175	$3006	MOVLW	6
$0176	$0228	SUBWF	tecladomatricial_converte_to_7seg_param_dado, W
$0177	$1D03	BTFSS	STATUS, Z
$0178	$297C	GOTO	TecladoMatricial_L_21
$0179	$	TecladoMatricial_L_19:
$0179	$307D	MOVLW	125
$017A	$00A7	MOVWF	tecladomatricial_converte_to_7seg_local_result
$017B	$29BB	GOTO	TecladoMatricial_L_0
$017C	$	TecladoMatricial_L_21:
$017C	$	TecladoMatricial_L_23:
$017C	$3007	MOVLW	7
$017D	$0228	SUBWF	tecladomatricial_converte_to_7seg_param_dado, W
$017E	$1D03	BTFSS	STATUS, Z
$017F	$2983	GOTO	TecladoMatricial_L_24
$0180	$	TecladoMatricial_L_22:
$0180	$3007	MOVLW	7
$0181	$00A7	MOVWF	tecladomatricial_converte_to_7seg_local_result
$0182	$29BB	GOTO	TecladoMatricial_L_0
$0183	$	TecladoMatricial_L_24:
$0183	$	TecladoMatricial_L_26:
$0183	$3008	MOVLW	8
$0184	$0228	SUBWF	tecladomatricial_converte_to_7seg_param_dado, W
$0185	$1D03	BTFSS	STATUS, Z
$0186	$298A	GOTO	TecladoMatricial_L_27
$0187	$	TecladoMatricial_L_25:
$0187	$307F	MOVLW	127
$0188	$00A7	MOVWF	tecladomatricial_converte_to_7seg_local_result
$0189	$29BB	GOTO	TecladoMatricial_L_0
$018A	$	TecladoMatricial_L_27:
$018A	$	TecladoMatricial_L_29:
$018A	$3009	MOVLW	9
$018B	$0228	SUBWF	tecladomatricial_converte_to_7seg_param_dado, W
$018C	$1D03	BTFSS	STATUS, Z
$018D	$2991	GOTO	TecladoMatricial_L_30
$018E	$	TecladoMatricial_L_28:
$018E	$306F	MOVLW	111
$018F	$00A7	MOVWF	tecladomatricial_converte_to_7seg_local_result
$0190	$29BB	GOTO	TecladoMatricial_L_0
$0191	$	TecladoMatricial_L_30:
$0191	$	TecladoMatricial_L_32:
$0191	$300A	MOVLW	10
$0192	$0228	SUBWF	tecladomatricial_converte_to_7seg_param_dado, W
$0193	$1D03	BTFSS	STATUS, Z
$0194	$2998	GOTO	TecladoMatricial_L_33
$0195	$	TecladoMatricial_L_31:
$0195	$3077	MOVLW	119
$0196	$00A7	MOVWF	tecladomatricial_converte_to_7seg_local_result
$0197	$29BB	GOTO	TecladoMatricial_L_0
$0198	$	TecladoMatricial_L_33:
$0198	$	TecladoMatricial_L_35:
$0198	$300B	MOVLW	11
$0199	$0228	SUBWF	tecladomatricial_converte_to_7seg_param_dado, W
$019A	$1D03	BTFSS	STATUS, Z
$019B	$299F	GOTO	TecladoMatricial_L_36
$019C	$	TecladoMatricial_L_34:
$019C	$307C	MOVLW	124
$019D	$00A7	MOVWF	tecladomatricial_converte_to_7seg_local_result
$019E	$29BB	GOTO	TecladoMatricial_L_0
$019F	$	TecladoMatricial_L_36:
$019F	$	TecladoMatricial_L_38:
$019F	$300C	MOVLW	12
$01A0	$0228	SUBWF	tecladomatricial_converte_to_7seg_param_dado, W
$01A1	$1D03	BTFSS	STATUS, Z
$01A2	$29A6	GOTO	TecladoMatricial_L_39
$01A3	$	TecladoMatricial_L_37:
$01A3	$3039	MOVLW	57
$01A4	$00A7	MOVWF	tecladomatricial_converte_to_7seg_local_result
$01A5	$29BB	GOTO	TecladoMatricial_L_0
$01A6	$	TecladoMatricial_L_39:
$01A6	$	TecladoMatricial_L_41:
$01A6	$300D	MOVLW	13
$01A7	$0228	SUBWF	tecladomatricial_converte_to_7seg_param_dado, W
$01A8	$1D03	BTFSS	STATUS, Z
$01A9	$29AD	GOTO	TecladoMatricial_L_42
$01AA	$	TecladoMatricial_L_40:
$01AA	$305E	MOVLW	94
$01AB	$00A7	MOVWF	tecladomatricial_converte_to_7seg_local_result
$01AC	$29BB	GOTO	TecladoMatricial_L_0
$01AD	$	TecladoMatricial_L_42:
$01AD	$	TecladoMatricial_L_44:
$01AD	$300E	MOVLW	14
$01AE	$0228	SUBWF	tecladomatricial_converte_to_7seg_param_dado, W
$01AF	$1D03	BTFSS	STATUS, Z
$01B0	$29B4	GOTO	TecladoMatricial_L_45
$01B1	$	TecladoMatricial_L_43:
$01B1	$3079	MOVLW	121
$01B2	$00A7	MOVWF	tecladomatricial_converte_to_7seg_local_result
$01B3	$29BB	GOTO	TecladoMatricial_L_0
$01B4	$	TecladoMatricial_L_45:
$01B4	$	TecladoMatricial_L_47:
$01B4	$300F	MOVLW	15
$01B5	$0228	SUBWF	tecladomatricial_converte_to_7seg_param_dado, W
$01B6	$1D03	BTFSS	STATUS, Z
$01B7	$29BB	GOTO	TecladoMatricial_L_48
$01B8	$	TecladoMatricial_L_46:
$01B8	$3071	MOVLW	113
$01B9	$00A7	MOVWF	tecladomatricial_converte_to_7seg_local_result
$01BA	$29BB	GOTO	TecladoMatricial_L_0
$01BB	$	TecladoMatricial_L_48:
$01BB	$	TecladoMatricial_L_0:
$01BB	$0008	RETURN
$01BC	$	TecladoMatricial_main:
$01BC	$	TecladoMatricial_main_main:
$01BC	$3030	MOVLW	48
$01BD	$1303	BCF	STATUS,RP1
$01BE	$1683	BSF	STATUS,RP0
$01BF	$0085	MOVWF	TRISA
$01C0	$0186	CLRF	TRISB
$01C1	$0188	CLRF	TRISD
$01C2	$3001	MOVLW	1
$01C3	$0089	MOVWF	TRISE
$01C4	$3080	MOVLW	128
$01C5	$0081	MOVWF	OPTION_REG
$01C6	$1283	BCF	STATUS,RP0
$01C7	$01A0	CLRF	main_global_indice
$01C8	$01A1	CLRF	main_global_teclado0
$01C9	$01A6	CLRF	main_global_teclado1
$01CA	$3007	MOVLW	7
$01CB	$1683	BSF	STATUS,RP0
$01CC	$009F	MOVWF	ADCON1
$01CD	$30A0	MOVLW	160
$01CE	$008B	MOVWF	INTCON
$01CF	$3000	MOVLW	0
$01D0	$1283	BCF	STATUS,RP0
$01D1	$00A2	MOVWF	main_global_vetor_display_1
$01D2	$3000	MOVLW	0
$01D3	$00A3	MOVWF	main_global_vetor_display_2
$01D4	$3000	MOVLW	0
$01D5	$00A4	MOVWF	main_global_vetor_display_3
$01D6	$3000	MOVLW	0
$01D7	$00A5	MOVWF	main_global_vetor_display_4
$01D8	$	TecladoMatricial_main_loop_principal:
$01D8	$	TecladoMatricial_L_144:
$01D8	$	TecladoMatricial_L_145:
$01D8	$3000	MOVLW	0
$01D9	$18A1	BTFSC	main_global_teclado0, 1
$01DA	$3001	MOVLW	1
$01DB	$00AB	MOVWF	STACK_2
$01DC	$3001	MOVLW	1
$01DD	$022B	SUBWF	STACK_2, W
$01DE	$1D03	BTFSS	STATUS, Z
$01DF	$29E3	GOTO	TecladoMatricial_L_148
$01E0	$	TecladoMatricial_L_147:
$01E0	$30FF	MOVLW	255
$01E1	$00AC	MOVWF	STACK_3
$01E2	$29E4	GOTO	TecladoMatricial_L_150
$01E3	$	TecladoMatricial_L_148:
$01E3	$01AC	CLRF	STACK_3
$01E4	$	TecladoMatricial_L_150:
$01E4	$30FF	MOVLW	255
$01E5	$022C	SUBWF	STACK_3, W
$01E6	$1D03	BTFSS	STATUS, Z
$01E7	$29EF	GOTO	TecladoMatricial_L_152
$01E8	$	TecladoMatricial_L_151:
$01E8	$3001	MOVLW	1
$01E9	$00A8	MOVWF	tecladomatricial_converte_to_7seg_param_dado
$01EA	$2149	CALL	TecladoMatricial_converte_to_7seg
$01EB	$1303	BCF	STATUS,RP1
$01EC	$1283	BCF	STATUS,RP0
$01ED	$0827	MOVF	tecladomatricial_converte_to_7seg_local_result, W
$01EE	$00A2	MOVWF	main_global_vetor_display_1
$01EF	$	TecladoMatricial_L_152:
$01EF	$	TecladoMatricial_L_149:
$01EF	$3000	MOVLW	0
$01F0	$1303	BCF	STATUS,RP1
$01F1	$1283	BCF	STATUS,RP0
$01F2	$1921	BTFSC	main_global_teclado0, 2
$01F3	$3001	MOVLW	1
$01F4	$00AB	MOVWF	STACK_2
$01F5	$3001	MOVLW	1
$01F6	$022B	SUBWF	STACK_2, W
$01F7	$1D03	BTFSS	STATUS, Z
$01F8	$29FE	GOTO	TecladoMatricial_L_154
$01F9	$	TecladoMatricial_L_153:
$01F9	$30FF	MOVLW	255
$01FA	$1303	BCF	STATUS,RP1
$01FB	$1283	BCF	STATUS,RP0
$01FC	$00AC	MOVWF	STACK_3
$01FD	$2A01	GOTO	TecladoMatricial_L_156
$01FE	$	TecladoMatricial_L_154:
$01FE	$1303	BCF	STATUS,RP1
$01FF	$1283	BCF	STATUS,RP0
$0200	$01AC	CLRF	STACK_3
$0201	$	TecladoMatricial_L_156:
$0201	$30FF	MOVLW	255
$0202	$1303	BCF	STATUS,RP1
$0203	$1283	BCF	STATUS,RP0
$0204	$022C	SUBWF	STACK_3, W
$0205	$1D03	BTFSS	STATUS, Z
$0206	$2A10	GOTO	TecladoMatricial_L_158
$0207	$	TecladoMatricial_L_157:
$0207	$3002	MOVLW	2
$0208	$1303	BCF	STATUS,RP1
$0209	$1283	BCF	STATUS,RP0
$020A	$00A8	MOVWF	tecladomatricial_converte_to_7seg_param_dado
$020B	$2149	CALL	TecladoMatricial_converte_to_7seg
$020C	$1303	BCF	STATUS,RP1
$020D	$1283	BCF	STATUS,RP0
$020E	$0827	MOVF	tecladomatricial_converte_to_7seg_local_result, W
$020F	$00A2	MOVWF	main_global_vetor_display_1
$0210	$	TecladoMatricial_L_158:
$0210	$	TecladoMatricial_L_155:
$0210	$3000	MOVLW	0
$0211	$1303	BCF	STATUS,RP1
$0212	$1283	BCF	STATUS,RP0
$0213	$19A1	BTFSC	main_global_teclado0, 3
$0214	$3001	MOVLW	1
$0215	$00AB	MOVWF	STACK_2
$0216	$3001	MOVLW	1
$0217	$022B	SUBWF	STACK_2, W
$0218	$1D03	BTFSS	STATUS, Z
$0219	$2A1F	GOTO	TecladoMatricial_L_160
$021A	$	TecladoMatricial_L_159:
$021A	$30FF	MOVLW	255
$021B	$1303	BCF	STATUS,RP1
$021C	$1283	BCF	STATUS,RP0
$021D	$00AC	MOVWF	STACK_3
$021E	$2A22	GOTO	TecladoMatricial_L_162
$021F	$	TecladoMatricial_L_160:
$021F	$1303	BCF	STATUS,RP1
$0220	$1283	BCF	STATUS,RP0
$0221	$01AC	CLRF	STACK_3
$0222	$	TecladoMatricial_L_162:
$0222	$30FF	MOVLW	255
$0223	$1303	BCF	STATUS,RP1
$0224	$1283	BCF	STATUS,RP0
$0225	$022C	SUBWF	STACK_3, W
$0226	$1D03	BTFSS	STATUS, Z
$0227	$2A31	GOTO	TecladoMatricial_L_164
$0228	$	TecladoMatricial_L_163:
$0228	$3003	MOVLW	3
$0229	$1303	BCF	STATUS,RP1
$022A	$1283	BCF	STATUS,RP0
$022B	$00A8	MOVWF	tecladomatricial_converte_to_7seg_param_dado
$022C	$2149	CALL	TecladoMatricial_converte_to_7seg
$022D	$1303	BCF	STATUS,RP1
$022E	$1283	BCF	STATUS,RP0
$022F	$0827	MOVF	tecladomatricial_converte_to_7seg_local_result, W
$0230	$00A2	MOVWF	main_global_vetor_display_1
$0231	$	TecladoMatricial_L_164:
$0231	$	TecladoMatricial_L_161:
$0231	$3000	MOVLW	0
$0232	$1303	BCF	STATUS,RP1
$0233	$1283	BCF	STATUS,RP0
$0234	$1A21	BTFSC	main_global_teclado0, 4
$0235	$3001	MOVLW	1
$0236	$00AB	MOVWF	STACK_2
$0237	$3001	MOVLW	1
$0238	$022B	SUBWF	STACK_2, W
$0239	$1D03	BTFSS	STATUS, Z
$023A	$2A40	GOTO	TecladoMatricial_L_166
$023B	$	TecladoMatricial_L_165:
$023B	$30FF	MOVLW	255
$023C	$1303	BCF	STATUS,RP1
$023D	$1283	BCF	STATUS,RP0
$023E	$00AC	MOVWF	STACK_3
$023F	$2A43	GOTO	TecladoMatricial_L_168
$0240	$	TecladoMatricial_L_166:
$0240	$1303	BCF	STATUS,RP1
$0241	$1283	BCF	STATUS,RP0
$0242	$01AC	CLRF	STACK_3
$0243	$	TecladoMatricial_L_168:
$0243	$30FF	MOVLW	255
$0244	$1303	BCF	STATUS,RP1
$0245	$1283	BCF	STATUS,RP0
$0246	$022C	SUBWF	STACK_3, W
$0247	$1D03	BTFSS	STATUS, Z
$0248	$2A52	GOTO	TecladoMatricial_L_170
$0249	$	TecladoMatricial_L_169:
$0249	$3004	MOVLW	4
$024A	$1303	BCF	STATUS,RP1
$024B	$1283	BCF	STATUS,RP0
$024C	$00A8	MOVWF	tecladomatricial_converte_to_7seg_param_dado
$024D	$2149	CALL	TecladoMatricial_converte_to_7seg
$024E	$1303	BCF	STATUS,RP1
$024F	$1283	BCF	STATUS,RP0
$0250	$0827	MOVF	tecladomatricial_converte_to_7seg_local_result, W
$0251	$00A3	MOVWF	main_global_vetor_display_2
$0252	$	TecladoMatricial_L_170:
$0252	$	TecladoMatricial_L_167:
$0252	$3000	MOVLW	0
$0253	$1303	BCF	STATUS,RP1
$0254	$1283	BCF	STATUS,RP0
$0255	$1AA1	BTFSC	main_global_teclado0, 5
$0256	$3001	MOVLW	1
$0257	$00AB	MOVWF	STACK_2
$0258	$3001	MOVLW	1
$0259	$022B	SUBWF	STACK_2, W
$025A	$1D03	BTFSS	STATUS, Z
$025B	$2A61	GOTO	TecladoMatricial_L_172
$025C	$	TecladoMatricial_L_171:
$025C	$30FF	MOVLW	255
$025D	$1303	BCF	STATUS,RP1
$025E	$1283	BCF	STATUS,RP0
$025F	$00AC	MOVWF	STACK_3
$0260	$2A64	GOTO	TecladoMatricial_L_174
$0261	$	TecladoMatricial_L_172:
$0261	$1303	BCF	STATUS,RP1
$0262	$1283	BCF	STATUS,RP0
$0263	$01AC	CLRF	STACK_3
$0264	$	TecladoMatricial_L_174:
$0264	$30FF	MOVLW	255
$0265	$1303	BCF	STATUS,RP1
$0266	$1283	BCF	STATUS,RP0
$0267	$022C	SUBWF	STACK_3, W
$0268	$1D03	BTFSS	STATUS, Z
$0269	$2A73	GOTO	TecladoMatricial_L_176
$026A	$	TecladoMatricial_L_175:
$026A	$3005	MOVLW	5
$026B	$1303	BCF	STATUS,RP1
$026C	$1283	BCF	STATUS,RP0
$026D	$00A8	MOVWF	tecladomatricial_converte_to_7seg_param_dado
$026E	$2149	CALL	TecladoMatricial_converte_to_7seg
$026F	$1303	BCF	STATUS,RP1
$0270	$1283	BCF	STATUS,RP0
$0271	$0827	MOVF	tecladomatricial_converte_to_7seg_local_result, W
$0272	$00A3	MOVWF	main_global_vetor_display_2
$0273	$	TecladoMatricial_L_176:
$0273	$	TecladoMatricial_L_173:
$0273	$3000	MOVLW	0
$0274	$1303	BCF	STATUS,RP1
$0275	$1283	BCF	STATUS,RP0
$0276	$1B21	BTFSC	main_global_teclado0, 6
$0277	$3001	MOVLW	1
$0278	$00AB	MOVWF	STACK_2
$0279	$3001	MOVLW	1
$027A	$022B	SUBWF	STACK_2, W
$027B	$1D03	BTFSS	STATUS, Z
$027C	$2A82	GOTO	TecladoMatricial_L_178
$027D	$	TecladoMatricial_L_177:
$027D	$30FF	MOVLW	255
$027E	$1303	BCF	STATUS,RP1
$027F	$1283	BCF	STATUS,RP0
$0280	$00AC	MOVWF	STACK_3
$0281	$2A85	GOTO	TecladoMatricial_L_180
$0282	$	TecladoMatricial_L_178:
$0282	$1303	BCF	STATUS,RP1
$0283	$1283	BCF	STATUS,RP0
$0284	$01AC	CLRF	STACK_3
$0285	$	TecladoMatricial_L_180:
$0285	$30FF	MOVLW	255
$0286	$1303	BCF	STATUS,RP1
$0287	$1283	BCF	STATUS,RP0
$0288	$022C	SUBWF	STACK_3, W
$0289	$1D03	BTFSS	STATUS, Z
$028A	$2A94	GOTO	TecladoMatricial_L_182
$028B	$	TecladoMatricial_L_181:
$028B	$3006	MOVLW	6
$028C	$1303	BCF	STATUS,RP1
$028D	$1283	BCF	STATUS,RP0
$028E	$00A8	MOVWF	tecladomatricial_converte_to_7seg_param_dado
$028F	$2149	CALL	TecladoMatricial_converte_to_7seg
$0290	$1303	BCF	STATUS,RP1
$0291	$1283	BCF	STATUS,RP0
$0292	$0827	MOVF	tecladomatricial_converte_to_7seg_local_result, W
$0293	$00A3	MOVWF	main_global_vetor_display_2
$0294	$	TecladoMatricial_L_182:
$0294	$	TecladoMatricial_L_179:
$0294	$3000	MOVLW	0
$0295	$1303	BCF	STATUS,RP1
$0296	$1283	BCF	STATUS,RP0
$0297	$1BA1	BTFSC	main_global_teclado0, 7
$0298	$3001	MOVLW	1
$0299	$00AB	MOVWF	STACK_2
$029A	$3001	MOVLW	1
$029B	$022B	SUBWF	STACK_2, W
$029C	$1D03	BTFSS	STATUS, Z
$029D	$2AA3	GOTO	TecladoMatricial_L_184
$029E	$	TecladoMatricial_L_183:
$029E	$30FF	MOVLW	255
$029F	$1303	BCF	STATUS,RP1
$02A0	$1283	BCF	STATUS,RP0
$02A1	$00AC	MOVWF	STACK_3
$02A2	$2AA6	GOTO	TecladoMatricial_L_186
$02A3	$	TecladoMatricial_L_184:
$02A3	$1303	BCF	STATUS,RP1
$02A4	$1283	BCF	STATUS,RP0
$02A5	$01AC	CLRF	STACK_3
$02A6	$	TecladoMatricial_L_186:
$02A6	$30FF	MOVLW	255
$02A7	$1303	BCF	STATUS,RP1
$02A8	$1283	BCF	STATUS,RP0
$02A9	$022C	SUBWF	STACK_3, W
$02AA	$1D03	BTFSS	STATUS, Z
$02AB	$2AB5	GOTO	TecladoMatricial_L_188
$02AC	$	TecladoMatricial_L_187:
$02AC	$3007	MOVLW	7
$02AD	$1303	BCF	STATUS,RP1
$02AE	$1283	BCF	STATUS,RP0
$02AF	$00A8	MOVWF	tecladomatricial_converte_to_7seg_param_dado
$02B0	$2149	CALL	TecladoMatricial_converte_to_7seg
$02B1	$1303	BCF	STATUS,RP1
$02B2	$1283	BCF	STATUS,RP0
$02B3	$0827	MOVF	tecladomatricial_converte_to_7seg_local_result, W
$02B4	$00A4	MOVWF	main_global_vetor_display_3
$02B5	$	TecladoMatricial_L_188:
$02B5	$	TecladoMatricial_L_185:
$02B5	$3000	MOVLW	0
$02B6	$1303	BCF	STATUS,RP1
$02B7	$1283	BCF	STATUS,RP0
$02B8	$1826	BTFSC	main_global_teclado1, 0
$02B9	$3001	MOVLW	1
$02BA	$00AB	MOVWF	STACK_2
$02BB	$3001	MOVLW	1
$02BC	$022B	SUBWF	STACK_2, W
$02BD	$1D03	BTFSS	STATUS, Z
$02BE	$2AC4	GOTO	TecladoMatricial_L_190
$02BF	$	TecladoMatricial_L_189:
$02BF	$30FF	MOVLW	255
$02C0	$1303	BCF	STATUS,RP1
$02C1	$1283	BCF	STATUS,RP0
$02C2	$00AC	MOVWF	STACK_3
$02C3	$2AC7	GOTO	TecladoMatricial_L_192
$02C4	$	TecladoMatricial_L_190:
$02C4	$1303	BCF	STATUS,RP1
$02C5	$1283	BCF	STATUS,RP0
$02C6	$01AC	CLRF	STACK_3
$02C7	$	TecladoMatricial_L_192:
$02C7	$30FF	MOVLW	255
$02C8	$1303	BCF	STATUS,RP1
$02C9	$1283	BCF	STATUS,RP0
$02CA	$022C	SUBWF	STACK_3, W
$02CB	$1D03	BTFSS	STATUS, Z
$02CC	$2AD6	GOTO	TecladoMatricial_L_194
$02CD	$	TecladoMatricial_L_193:
$02CD	$3008	MOVLW	8
$02CE	$1303	BCF	STATUS,RP1
$02CF	$1283	BCF	STATUS,RP0
$02D0	$00A8	MOVWF	tecladomatricial_converte_to_7seg_param_dado
$02D1	$2149	CALL	TecladoMatricial_converte_to_7seg
$02D2	$1303	BCF	STATUS,RP1
$02D3	$1283	BCF	STATUS,RP0
$02D4	$0827	MOVF	tecladomatricial_converte_to_7seg_local_result, W
$02D5	$00A4	MOVWF	main_global_vetor_display_3
$02D6	$	TecladoMatricial_L_194:
$02D6	$	TecladoMatricial_L_191:
$02D6	$3000	MOVLW	0
$02D7	$1303	BCF	STATUS,RP1
$02D8	$1283	BCF	STATUS,RP0
$02D9	$18A6	BTFSC	main_global_teclado1, 1
$02DA	$3001	MOVLW	1
$02DB	$00AB	MOVWF	STACK_2
$02DC	$3001	MOVLW	1
$02DD	$022B	SUBWF	STACK_2, W
$02DE	$1D03	BTFSS	STATUS, Z
$02DF	$2AE5	GOTO	TecladoMatricial_L_196
$02E0	$	TecladoMatricial_L_195:
$02E0	$30FF	MOVLW	255
$02E1	$1303	BCF	STATUS,RP1
$02E2	$1283	BCF	STATUS,RP0
$02E3	$00AC	MOVWF	STACK_3
$02E4	$2AE8	GOTO	TecladoMatricial_L_198
$02E5	$	TecladoMatricial_L_196:
$02E5	$1303	BCF	STATUS,RP1
$02E6	$1283	BCF	STATUS,RP0
$02E7	$01AC	CLRF	STACK_3
$02E8	$	TecladoMatricial_L_198:
$02E8	$30FF	MOVLW	255
$02E9	$1303	BCF	STATUS,RP1
$02EA	$1283	BCF	STATUS,RP0
$02EB	$022C	SUBWF	STACK_3, W
$02EC	$1D03	BTFSS	STATUS, Z
$02ED	$2AF7	GOTO	TecladoMatricial_L_200
$02EE	$	TecladoMatricial_L_199:
$02EE	$3009	MOVLW	9
$02EF	$1303	BCF	STATUS,RP1
$02F0	$1283	BCF	STATUS,RP0
$02F1	$00A8	MOVWF	tecladomatricial_converte_to_7seg_param_dado
$02F2	$2149	CALL	TecladoMatricial_converte_to_7seg
$02F3	$1303	BCF	STATUS,RP1
$02F4	$1283	BCF	STATUS,RP0
$02F5	$0827	MOVF	tecladomatricial_converte_to_7seg_local_result, W
$02F6	$00A4	MOVWF	main_global_vetor_display_3
$02F7	$	TecladoMatricial_L_200:
$02F7	$	TecladoMatricial_L_197:
$02F7	$3000	MOVLW	0
$02F8	$1303	BCF	STATUS,RP1
$02F9	$1283	BCF	STATUS,RP0
$02FA	$1926	BTFSC	main_global_teclado1, 2
$02FB	$3001	MOVLW	1
$02FC	$00AB	MOVWF	STACK_2
$02FD	$3001	MOVLW	1
$02FE	$022B	SUBWF	STACK_2, W
$02FF	$1D03	BTFSS	STATUS, Z
$0300	$2B06	GOTO	TecladoMatricial_L_202
$0301	$	TecladoMatricial_L_201:
$0301	$30FF	MOVLW	255
$0302	$1303	BCF	STATUS,RP1
$0303	$1283	BCF	STATUS,RP0
$0304	$00AC	MOVWF	STACK_3
$0305	$2B09	GOTO	TecladoMatricial_L_204
$0306	$	TecladoMatricial_L_202:
$0306	$1303	BCF	STATUS,RP1
$0307	$1283	BCF	STATUS,RP0
$0308	$01AC	CLRF	STACK_3
$0309	$	TecladoMatricial_L_204:
$0309	$30FF	MOVLW	255
$030A	$1303	BCF	STATUS,RP1
$030B	$1283	BCF	STATUS,RP0
$030C	$022C	SUBWF	STACK_3, W
$030D	$1D03	BTFSS	STATUS, Z
$030E	$2B18	GOTO	TecladoMatricial_L_206
$030F	$	TecladoMatricial_L_205:
$030F	$300C	MOVLW	12
$0310	$1303	BCF	STATUS,RP1
$0311	$1283	BCF	STATUS,RP0
$0312	$00A8	MOVWF	tecladomatricial_converte_to_7seg_param_dado
$0313	$2149	CALL	TecladoMatricial_converte_to_7seg
$0314	$1303	BCF	STATUS,RP1
$0315	$1283	BCF	STATUS,RP0
$0316	$0827	MOVF	tecladomatricial_converte_to_7seg_local_result, W
$0317	$00A5	MOVWF	main_global_vetor_display_4
$0318	$	TecladoMatricial_L_206:
$0318	$	TecladoMatricial_L_203:
$0318	$3000	MOVLW	0
$0319	$1303	BCF	STATUS,RP1
$031A	$1283	BCF	STATUS,RP0
$031B	$1821	BTFSC	main_global_teclado0, 0
$031C	$3001	MOVLW	1
$031D	$00AB	MOVWF	STACK_2
$031E	$3001	MOVLW	1
$031F	$022B	SUBWF	STACK_2, W
$0320	$1D03	BTFSS	STATUS, Z
$0321	$2B27	GOTO	TecladoMatricial_L_208
$0322	$	TecladoMatricial_L_207:
$0322	$30FF	MOVLW	255
$0323	$1303	BCF	STATUS,RP1
$0324	$1283	BCF	STATUS,RP0
$0325	$00AC	MOVWF	STACK_3
$0326	$2B2A	GOTO	TecladoMatricial_L_210
$0327	$	TecladoMatricial_L_208:
$0327	$1303	BCF	STATUS,RP1
$0328	$1283	BCF	STATUS,RP0
$0329	$01AC	CLRF	STACK_3
$032A	$	TecladoMatricial_L_210:
$032A	$30FF	MOVLW	255
$032B	$1303	BCF	STATUS,RP1
$032C	$1283	BCF	STATUS,RP0
$032D	$022C	SUBWF	STACK_3, W
$032E	$1D03	BTFSS	STATUS, Z
$032F	$2B38	GOTO	TecladoMatricial_L_212
$0330	$	TecladoMatricial_L_211:
$0330	$1303	BCF	STATUS,RP1
$0331	$1283	BCF	STATUS,RP0
$0332	$01A8	CLRF	tecladomatricial_converte_to_7seg_param_dado
$0333	$2149	CALL	TecladoMatricial_converte_to_7seg
$0334	$1303	BCF	STATUS,RP1
$0335	$1283	BCF	STATUS,RP0
$0336	$0827	MOVF	tecladomatricial_converte_to_7seg_local_result, W
$0337	$00A5	MOVWF	main_global_vetor_display_4
$0338	$	TecladoMatricial_L_212:
$0338	$	TecladoMatricial_L_209:
$0338	$3000	MOVLW	0
$0339	$1303	BCF	STATUS,RP1
$033A	$1283	BCF	STATUS,RP0
$033B	$19A6	BTFSC	main_global_teclado1, 3
$033C	$3001	MOVLW	1
$033D	$00AB	MOVWF	STACK_2
$033E	$3001	MOVLW	1
$033F	$022B	SUBWF	STACK_2, W
$0340	$1D03	BTFSS	STATUS, Z
$0341	$2B47	GOTO	TecladoMatricial_L_214
$0342	$	TecladoMatricial_L_213:
$0342	$30FF	MOVLW	255
$0343	$1303	BCF	STATUS,RP1
$0344	$1283	BCF	STATUS,RP0
$0345	$00AC	MOVWF	STACK_3
$0346	$2B4A	GOTO	TecladoMatricial_L_216
$0347	$	TecladoMatricial_L_214:
$0347	$1303	BCF	STATUS,RP1
$0348	$1283	BCF	STATUS,RP0
$0349	$01AC	CLRF	STACK_3
$034A	$	TecladoMatricial_L_216:
$034A	$30FF	MOVLW	255
$034B	$1303	BCF	STATUS,RP1
$034C	$1283	BCF	STATUS,RP0
$034D	$022C	SUBWF	STACK_3, W
$034E	$1D03	BTFSS	STATUS, Z
$034F	$2B59	GOTO	TecladoMatricial_L_218
$0350	$	TecladoMatricial_L_217:
$0350	$300E	MOVLW	14
$0351	$1303	BCF	STATUS,RP1
$0352	$1283	BCF	STATUS,RP0
$0353	$00A8	MOVWF	tecladomatricial_converte_to_7seg_param_dado
$0354	$2149	CALL	TecladoMatricial_converte_to_7seg
$0355	$1303	BCF	STATUS,RP1
$0356	$1283	BCF	STATUS,RP0
$0357	$0827	MOVF	tecladomatricial_converte_to_7seg_local_result, W
$0358	$00A5	MOVWF	main_global_vetor_display_4
$0359	$	TecladoMatricial_L_218:
$0359	$	TecladoMatricial_L_215:
$0359	$29D8	GOTO	TecladoMatricial_L_144
$035A	$	TecladoMatricial_L_146:
$035A	$	TecladoMatricial_L_219:
$035A	$2B5A	GOTO	TecladoMatricial_L_219
