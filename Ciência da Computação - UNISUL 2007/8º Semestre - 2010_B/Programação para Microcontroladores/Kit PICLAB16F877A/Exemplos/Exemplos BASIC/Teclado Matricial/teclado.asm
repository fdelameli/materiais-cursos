;//  ASM code generated by mikroVirtualMachine for PIC - V. 3.0.0.0
;  Date/Time: 28/03/05 23:56:55
;  Info: http://www.mikroelektronika.co.yu


;// ADDRESS	OPCODE	ASM
; ----------------------------------------------
$0000	$29C0	GOTO	teclado_main
$0004	$	teclado_interrupt:
$0004	$00F1	MOVWF	STACK_i_1
$0005	$0E03	SWAPF	STATUS, W
$0006	$0183	CLRF	STATUS
$0007	$00F2	MOVWF	STACK_i_2
$0008	$0804	MOVF	FSR, W
$0009	$00F0	MOVWF	STACK_i_0
$000A	$080A	MOVF	PCLATH, W
$000B	$00F3	MOVWF	STACK_i_3
$000C	$018A	CLRF	PCLATH
$000D	$110B	BCF	INTCON, 2
$000E	$0AA0	INCF	main_global_indice, F
$000F	$3001	MOVLW	1
$0010	$0220	SUBWF	main_global_indice, W
$0011	$1D03	BTFSS	STATUS, Z
$0012	$2816	GOTO	teclado_L_50
$0013	$	teclado_L_49:
$0013	$30FF	MOVLW	255
$0014	$00F6	MOVWF	STACK_i_6
$0015	$2817	GOTO	teclado_L_52
$0016	$	teclado_L_50:
$0016	$01F6	CLRF	STACK_i_6
$0017	$	teclado_L_52:
$0017	$30FF	MOVLW	255
$0018	$0276	SUBWF	STACK_i_6, W
$0019	$1D03	BTFSS	STATUS, Z
$001A	$285C	GOTO	teclado_L_54
$001B	$	teclado_L_53:
$001B	$1206	BCF	PORTB, 4
$001C	$3001	MOVLW	1
$001D	$00F5	MOVWF	STACK_I_5
$001E	$	teclado_L_55:
$001E	$0BF5	DECFSZ	STACK_I_5, F
$001F	$281E	GOTO	teclado_L_55
$0020	$0000	nop
$0021	$300E	MOVLW	14
$0022	$0088	MOVWF	PORTD
$0023	$10A1	BCF	main_global_teclado0, 1
$0024	$1121	BCF	main_global_teclado0, 2
$0025	$11A1	BCF	main_global_teclado0, 3
$0026	$3000	MOVLW	0
$0027	$1A05	BTFSC	PORTA, 4
$0028	$3001	MOVLW	1
$0029	$00F6	MOVWF	STACK_i_6
$002A	$3000	MOVLW	0
$002B	$0276	SUBWF	STACK_i_6, W
$002C	$1D03	BTFSS	STATUS, Z
$002D	$2831	GOTO	teclado_L_57
$002E	$	teclado_L_56:
$002E	$30FF	MOVLW	255
$002F	$00F7	MOVWF	STACK_i_7
$0030	$2832	GOTO	teclado_L_59
$0031	$	teclado_L_57:
$0031	$01F7	CLRF	STACK_i_7
$0032	$	teclado_L_59:
$0032	$30FF	MOVLW	255
$0033	$0277	SUBWF	STACK_i_7, W
$0034	$1D03	BTFSS	STATUS, Z
$0035	$2837	GOTO	teclado_L_61
$0036	$	teclado_L_60:
$0036	$14A1	BSF	main_global_teclado0, 1
$0037	$	teclado_L_61:
$0037	$	teclado_L_58:
$0037	$3000	MOVLW	0
$0038	$1A85	BTFSC	PORTA, 5
$0039	$3001	MOVLW	1
$003A	$00F6	MOVWF	STACK_i_6
$003B	$3000	MOVLW	0
$003C	$0276	SUBWF	STACK_i_6, W
$003D	$1D03	BTFSS	STATUS, Z
$003E	$2842	GOTO	teclado_L_63
$003F	$	teclado_L_62:
$003F	$30FF	MOVLW	255
$0040	$00F7	MOVWF	STACK_i_7
$0041	$2843	GOTO	teclado_L_65
$0042	$	teclado_L_63:
$0042	$01F7	CLRF	STACK_i_7
$0043	$	teclado_L_65:
$0043	$30FF	MOVLW	255
$0044	$0277	SUBWF	STACK_i_7, W
$0045	$1D03	BTFSS	STATUS, Z
$0046	$2848	GOTO	teclado_L_67
$0047	$	teclado_L_66:
$0047	$1521	BSF	main_global_teclado0, 2
$0048	$	teclado_L_67:
$0048	$	teclado_L_64:
$0048	$3000	MOVLW	0
$0049	$1809	BTFSC	PORTE, 0
$004A	$3001	MOVLW	1
$004B	$00F6	MOVWF	STACK_i_6
$004C	$3000	MOVLW	0
$004D	$0276	SUBWF	STACK_i_6, W
$004E	$1D03	BTFSS	STATUS, Z
$004F	$2853	GOTO	teclado_L_69
$0050	$	teclado_L_68:
$0050	$30FF	MOVLW	255
$0051	$00F7	MOVWF	STACK_i_7
$0052	$2854	GOTO	teclado_L_71
$0053	$	teclado_L_69:
$0053	$01F7	CLRF	STACK_i_7
$0054	$	teclado_L_71:
$0054	$30FF	MOVLW	255
$0055	$0277	SUBWF	STACK_i_7, W
$0056	$1D03	BTFSS	STATUS, Z
$0057	$2859	GOTO	teclado_L_73
$0058	$	teclado_L_72:
$0058	$15A1	BSF	main_global_teclado0, 3
$0059	$	teclado_L_73:
$0059	$	teclado_L_70:
$0059	$0822	MOVF	main_global_vetor_display_1, W
$005A	$0088	MOVWF	PORTD
$005B	$1486	BSF	PORTB, 1
$005C	$	teclado_L_54:
$005C	$	teclado_L_51:
$005C	$3002	MOVLW	2
$005D	$0220	SUBWF	main_global_indice, W
$005E	$1D03	BTFSS	STATUS, Z
$005F	$2863	GOTO	teclado_L_75
$0060	$	teclado_L_74:
$0060	$30FF	MOVLW	255
$0061	$00F6	MOVWF	STACK_i_6
$0062	$2864	GOTO	teclado_L_77
$0063	$	teclado_L_75:
$0063	$01F6	CLRF	STACK_i_6
$0064	$	teclado_L_77:
$0064	$30FF	MOVLW	255
$0065	$0276	SUBWF	STACK_i_6, W
$0066	$1D03	BTFSS	STATUS, Z
$0067	$28A9	GOTO	teclado_L_79
$0068	$	teclado_L_78:
$0068	$1086	BCF	PORTB, 1
$0069	$3001	MOVLW	1
$006A	$00F5	MOVWF	STACK_I_5
$006B	$	teclado_L_80:
$006B	$0BF5	DECFSZ	STACK_I_5, F
$006C	$286B	GOTO	teclado_L_80
$006D	$0000	nop
$006E	$300D	MOVLW	13
$006F	$0088	MOVWF	PORTD
$0070	$1221	BCF	main_global_teclado0, 4
$0071	$12A1	BCF	main_global_teclado0, 5
$0072	$1321	BCF	main_global_teclado0, 6
$0073	$3000	MOVLW	0
$0074	$1A05	BTFSC	PORTA, 4
$0075	$3001	MOVLW	1
$0076	$00F6	MOVWF	STACK_i_6
$0077	$3000	MOVLW	0
$0078	$0276	SUBWF	STACK_i_6, W
$0079	$1D03	BTFSS	STATUS, Z
$007A	$287E	GOTO	teclado_L_82
$007B	$	teclado_L_81:
$007B	$30FF	MOVLW	255
$007C	$00F7	MOVWF	STACK_i_7
$007D	$287F	GOTO	teclado_L_84
$007E	$	teclado_L_82:
$007E	$01F7	CLRF	STACK_i_7
$007F	$	teclado_L_84:
$007F	$30FF	MOVLW	255
$0080	$0277	SUBWF	STACK_i_7, W
$0081	$1D03	BTFSS	STATUS, Z
$0082	$2884	GOTO	teclado_L_86
$0083	$	teclado_L_85:
$0083	$1621	BSF	main_global_teclado0, 4
$0084	$	teclado_L_86:
$0084	$	teclado_L_83:
$0084	$3000	MOVLW	0
$0085	$1A85	BTFSC	PORTA, 5
$0086	$3001	MOVLW	1
$0087	$00F6	MOVWF	STACK_i_6
$0088	$3000	MOVLW	0
$0089	$0276	SUBWF	STACK_i_6, W
$008A	$1D03	BTFSS	STATUS, Z
$008B	$288F	GOTO	teclado_L_88
$008C	$	teclado_L_87:
$008C	$30FF	MOVLW	255
$008D	$00F7	MOVWF	STACK_i_7
$008E	$2890	GOTO	teclado_L_90
$008F	$	teclado_L_88:
$008F	$01F7	CLRF	STACK_i_7
$0090	$	teclado_L_90:
$0090	$30FF	MOVLW	255
$0091	$0277	SUBWF	STACK_i_7, W
$0092	$1D03	BTFSS	STATUS, Z
$0093	$2895	GOTO	teclado_L_92
$0094	$	teclado_L_91:
$0094	$16A1	BSF	main_global_teclado0, 5
$0095	$	teclado_L_92:
$0095	$	teclado_L_89:
$0095	$3000	MOVLW	0
$0096	$1809	BTFSC	PORTE, 0
$0097	$3001	MOVLW	1
$0098	$00F6	MOVWF	STACK_i_6
$0099	$3000	MOVLW	0
$009A	$0276	SUBWF	STACK_i_6, W
$009B	$1D03	BTFSS	STATUS, Z
$009C	$28A0	GOTO	teclado_L_94
$009D	$	teclado_L_93:
$009D	$30FF	MOVLW	255
$009E	$00F7	MOVWF	STACK_i_7
$009F	$28A1	GOTO	teclado_L_96
$00A0	$	teclado_L_94:
$00A0	$01F7	CLRF	STACK_i_7
$00A1	$	teclado_L_96:
$00A1	$30FF	MOVLW	255
$00A2	$0277	SUBWF	STACK_i_7, W
$00A3	$1D03	BTFSS	STATUS, Z
$00A4	$28A6	GOTO	teclado_L_98
$00A5	$	teclado_L_97:
$00A5	$1721	BSF	main_global_teclado0, 6
$00A6	$	teclado_L_98:
$00A6	$	teclado_L_95:
$00A6	$0823	MOVF	main_global_vetor_display_2, W
$00A7	$0088	MOVWF	PORTD
$00A8	$1506	BSF	PORTB, 2
$00A9	$	teclado_L_79:
$00A9	$	teclado_L_76:
$00A9	$3003	MOVLW	3
$00AA	$0220	SUBWF	main_global_indice, W
$00AB	$1D03	BTFSS	STATUS, Z
$00AC	$28B0	GOTO	teclado_L_100
$00AD	$	teclado_L_99:
$00AD	$30FF	MOVLW	255
$00AE	$00F6	MOVWF	STACK_i_6
$00AF	$28B1	GOTO	teclado_L_102
$00B0	$	teclado_L_100:
$00B0	$01F6	CLRF	STACK_i_6
$00B1	$	teclado_L_102:
$00B1	$30FF	MOVLW	255
$00B2	$0276	SUBWF	STACK_i_6, W
$00B3	$1D03	BTFSS	STATUS, Z
$00B4	$28F6	GOTO	teclado_L_104
$00B5	$	teclado_L_103:
$00B5	$1106	BCF	PORTB, 2
$00B6	$3001	MOVLW	1
$00B7	$00F5	MOVWF	STACK_I_5
$00B8	$	teclado_L_105:
$00B8	$0BF5	DECFSZ	STACK_I_5, F
$00B9	$28B8	GOTO	teclado_L_105
$00BA	$0000	nop
$00BB	$300B	MOVLW	11
$00BC	$0088	MOVWF	PORTD
$00BD	$13A1	BCF	main_global_teclado0, 7
$00BE	$1026	BCF	main_global_teclado1, 0
$00BF	$10A6	BCF	main_global_teclado1, 1
$00C0	$3000	MOVLW	0
$00C1	$1A05	BTFSC	PORTA, 4
$00C2	$3001	MOVLW	1
$00C3	$00F6	MOVWF	STACK_i_6
$00C4	$3000	MOVLW	0
$00C5	$0276	SUBWF	STACK_i_6, W
$00C6	$1D03	BTFSS	STATUS, Z
$00C7	$28CB	GOTO	teclado_L_107
$00C8	$	teclado_L_106:
$00C8	$30FF	MOVLW	255
$00C9	$00F7	MOVWF	STACK_i_7
$00CA	$28CC	GOTO	teclado_L_109
$00CB	$	teclado_L_107:
$00CB	$01F7	CLRF	STACK_i_7
$00CC	$	teclado_L_109:
$00CC	$30FF	MOVLW	255
$00CD	$0277	SUBWF	STACK_i_7, W
$00CE	$1D03	BTFSS	STATUS, Z
$00CF	$28D1	GOTO	teclado_L_111
$00D0	$	teclado_L_110:
$00D0	$17A1	BSF	main_global_teclado0, 7
$00D1	$	teclado_L_111:
$00D1	$	teclado_L_108:
$00D1	$3000	MOVLW	0
$00D2	$1A85	BTFSC	PORTA, 5
$00D3	$3001	MOVLW	1
$00D4	$00F6	MOVWF	STACK_i_6
$00D5	$3000	MOVLW	0
$00D6	$0276	SUBWF	STACK_i_6, W
$00D7	$1D03	BTFSS	STATUS, Z
$00D8	$28DC	GOTO	teclado_L_113
$00D9	$	teclado_L_112:
$00D9	$30FF	MOVLW	255
$00DA	$00F7	MOVWF	STACK_i_7
$00DB	$28DD	GOTO	teclado_L_115
$00DC	$	teclado_L_113:
$00DC	$01F7	CLRF	STACK_i_7
$00DD	$	teclado_L_115:
$00DD	$30FF	MOVLW	255
$00DE	$0277	SUBWF	STACK_i_7, W
$00DF	$1D03	BTFSS	STATUS, Z
$00E0	$28E2	GOTO	teclado_L_117
$00E1	$	teclado_L_116:
$00E1	$1426	BSF	main_global_teclado1, 0
$00E2	$	teclado_L_117:
$00E2	$	teclado_L_114:
$00E2	$3000	MOVLW	0
$00E3	$1809	BTFSC	PORTE, 0
$00E4	$3001	MOVLW	1
$00E5	$00F6	MOVWF	STACK_i_6
$00E6	$3000	MOVLW	0
$00E7	$0276	SUBWF	STACK_i_6, W
$00E8	$1D03	BTFSS	STATUS, Z
$00E9	$28ED	GOTO	teclado_L_119
$00EA	$	teclado_L_118:
$00EA	$30FF	MOVLW	255
$00EB	$00F7	MOVWF	STACK_i_7
$00EC	$28EE	GOTO	teclado_L_121
$00ED	$	teclado_L_119:
$00ED	$01F7	CLRF	STACK_i_7
$00EE	$	teclado_L_121:
$00EE	$30FF	MOVLW	255
$00EF	$0277	SUBWF	STACK_i_7, W
$00F0	$1D03	BTFSS	STATUS, Z
$00F1	$28F3	GOTO	teclado_L_123
$00F2	$	teclado_L_122:
$00F2	$14A6	BSF	main_global_teclado1, 1
$00F3	$	teclado_L_123:
$00F3	$	teclado_L_120:
$00F3	$0824	MOVF	main_global_vetor_display_3, W
$00F4	$0088	MOVWF	PORTD
$00F5	$1586	BSF	PORTB, 3
$00F6	$	teclado_L_104:
$00F6	$	teclado_L_101:
$00F6	$3004	MOVLW	4
$00F7	$0220	SUBWF	main_global_indice, W
$00F8	$1D03	BTFSS	STATUS, Z
$00F9	$28FD	GOTO	teclado_L_125
$00FA	$	teclado_L_124:
$00FA	$30FF	MOVLW	255
$00FB	$00F6	MOVWF	STACK_i_6
$00FC	$28FE	GOTO	teclado_L_127
$00FD	$	teclado_L_125:
$00FD	$01F6	CLRF	STACK_i_6
$00FE	$	teclado_L_127:
$00FE	$30FF	MOVLW	255
$00FF	$0276	SUBWF	STACK_i_6, W
$0100	$1D03	BTFSS	STATUS, Z
$0101	$2944	GOTO	teclado_L_129
$0102	$	teclado_L_128:
$0102	$1186	BCF	PORTB, 3
$0103	$3001	MOVLW	1
$0104	$00F5	MOVWF	STACK_I_5
$0105	$	teclado_L_130:
$0105	$0BF5	DECFSZ	STACK_I_5, F
$0106	$2905	GOTO	teclado_L_130
$0107	$0000	nop
$0108	$3007	MOVLW	7
$0109	$0088	MOVWF	PORTD
$010A	$1126	BCF	main_global_teclado1, 2
$010B	$1021	BCF	main_global_teclado0, 0
$010C	$11A6	BCF	main_global_teclado1, 3
$010D	$3000	MOVLW	0
$010E	$1A05	BTFSC	PORTA, 4
$010F	$3001	MOVLW	1
$0110	$00F6	MOVWF	STACK_i_6
$0111	$3000	MOVLW	0
$0112	$0276	SUBWF	STACK_i_6, W
$0113	$1D03	BTFSS	STATUS, Z
$0114	$2918	GOTO	teclado_L_132
$0115	$	teclado_L_131:
$0115	$30FF	MOVLW	255
$0116	$00F7	MOVWF	STACK_i_7
$0117	$2919	GOTO	teclado_L_134
$0118	$	teclado_L_132:
$0118	$01F7	CLRF	STACK_i_7
$0119	$	teclado_L_134:
$0119	$30FF	MOVLW	255
$011A	$0277	SUBWF	STACK_i_7, W
$011B	$1D03	BTFSS	STATUS, Z
$011C	$291E	GOTO	teclado_L_136
$011D	$	teclado_L_135:
$011D	$1526	BSF	main_global_teclado1, 2
$011E	$	teclado_L_136:
$011E	$	teclado_L_133:
$011E	$3000	MOVLW	0
$011F	$1A85	BTFSC	PORTA, 5
$0120	$3001	MOVLW	1
$0121	$00F6	MOVWF	STACK_i_6
$0122	$3000	MOVLW	0
$0123	$0276	SUBWF	STACK_i_6, W
$0124	$1D03	BTFSS	STATUS, Z
$0125	$2929	GOTO	teclado_L_138
$0126	$	teclado_L_137:
$0126	$30FF	MOVLW	255
$0127	$00F7	MOVWF	STACK_i_7
$0128	$292A	GOTO	teclado_L_140
$0129	$	teclado_L_138:
$0129	$01F7	CLRF	STACK_i_7
$012A	$	teclado_L_140:
$012A	$30FF	MOVLW	255
$012B	$0277	SUBWF	STACK_i_7, W
$012C	$1D03	BTFSS	STATUS, Z
$012D	$292F	GOTO	teclado_L_142
$012E	$	teclado_L_141:
$012E	$1421	BSF	main_global_teclado0, 0
$012F	$	teclado_L_142:
$012F	$	teclado_L_139:
$012F	$3000	MOVLW	0
$0130	$1809	BTFSC	PORTE, 0
$0131	$3001	MOVLW	1
$0132	$00F6	MOVWF	STACK_i_6
$0133	$3000	MOVLW	0
$0134	$0276	SUBWF	STACK_i_6, W
$0135	$1D03	BTFSS	STATUS, Z
$0136	$293A	GOTO	teclado_L_144
$0137	$	teclado_L_143:
$0137	$30FF	MOVLW	255
$0138	$00F7	MOVWF	STACK_i_7
$0139	$293B	GOTO	teclado_L_146
$013A	$	teclado_L_144:
$013A	$01F7	CLRF	STACK_i_7
$013B	$	teclado_L_146:
$013B	$30FF	MOVLW	255
$013C	$0277	SUBWF	STACK_i_7, W
$013D	$1D03	BTFSS	STATUS, Z
$013E	$2940	GOTO	teclado_L_148
$013F	$	teclado_L_147:
$013F	$15A6	BSF	main_global_teclado1, 3
$0140	$	teclado_L_148:
$0140	$	teclado_L_145:
$0140	$0825	MOVF	main_global_vetor_display_4, W
$0141	$0088	MOVWF	PORTD
$0142	$1606	BSF	PORTB, 4
$0143	$01A0	CLRF	main_global_indice
$0144	$	teclado_L_129:
$0144	$	teclado_L_126:
$0144	$0873	MOVF	STACK_i_3, W
$0145	$008A	MOVWF	PCLATH
$0146	$0870	MOVF	STACK_i_0, W
$0147	$0084	MOVWF	FSR
$0148	$0E72	SWAPF	STACK_i_2, W
$0149	$0083	MOVWF	STATUS
$014A	$0EF1	SWAPF	STACK_i_1, F
$014B	$0E71	SWAPF	STACK_i_1, W
$014C	$0009	RETFIE
$014D	$	teclado_converte_to_7seg:
$014D	$	teclado_L_2:
$014D	$3000	MOVLW	0
$014E	$1303	BCF	STATUS,RP1
$014F	$1283	BCF	STATUS,RP0
$0150	$0228	SUBWF	teclado_converte_to_7seg_param_dado, W
$0151	$1D03	BTFSS	STATUS, Z
$0152	$2956	GOTO	teclado_L_3
$0153	$	teclado_L_1:
$0153	$303F	MOVLW	63
$0154	$00A7	MOVWF	teclado_converte_to_7seg_local_result
$0155	$29BF	GOTO	teclado_L_0
$0156	$	teclado_L_3:
$0156	$	teclado_L_5:
$0156	$3001	MOVLW	1
$0157	$0228	SUBWF	teclado_converte_to_7seg_param_dado, W
$0158	$1D03	BTFSS	STATUS, Z
$0159	$295D	GOTO	teclado_L_6
$015A	$	teclado_L_4:
$015A	$3006	MOVLW	6
$015B	$00A7	MOVWF	teclado_converte_to_7seg_local_result
$015C	$29BF	GOTO	teclado_L_0
$015D	$	teclado_L_6:
$015D	$	teclado_L_8:
$015D	$3002	MOVLW	2
$015E	$0228	SUBWF	teclado_converte_to_7seg_param_dado, W
$015F	$1D03	BTFSS	STATUS, Z
$0160	$2964	GOTO	teclado_L_9
$0161	$	teclado_L_7:
$0161	$305B	MOVLW	91
$0162	$00A7	MOVWF	teclado_converte_to_7seg_local_result
$0163	$29BF	GOTO	teclado_L_0
$0164	$	teclado_L_9:
$0164	$	teclado_L_11:
$0164	$3003	MOVLW	3
$0165	$0228	SUBWF	teclado_converte_to_7seg_param_dado, W
$0166	$1D03	BTFSS	STATUS, Z
$0167	$296B	GOTO	teclado_L_12
$0168	$	teclado_L_10:
$0168	$304F	MOVLW	79
$0169	$00A7	MOVWF	teclado_converte_to_7seg_local_result
$016A	$29BF	GOTO	teclado_L_0
$016B	$	teclado_L_12:
$016B	$	teclado_L_14:
$016B	$3004	MOVLW	4
$016C	$0228	SUBWF	teclado_converte_to_7seg_param_dado, W
$016D	$1D03	BTFSS	STATUS, Z
$016E	$2972	GOTO	teclado_L_15
$016F	$	teclado_L_13:
$016F	$3066	MOVLW	102
$0170	$00A7	MOVWF	teclado_converte_to_7seg_local_result
$0171	$29BF	GOTO	teclado_L_0
$0172	$	teclado_L_15:
$0172	$	teclado_L_17:
$0172	$3005	MOVLW	5
$0173	$0228	SUBWF	teclado_converte_to_7seg_param_dado, W
$0174	$1D03	BTFSS	STATUS, Z
$0175	$2979	GOTO	teclado_L_18
$0176	$	teclado_L_16:
$0176	$306D	MOVLW	109
$0177	$00A7	MOVWF	teclado_converte_to_7seg_local_result
$0178	$29BF	GOTO	teclado_L_0
$0179	$	teclado_L_18:
$0179	$	teclado_L_20:
$0179	$3006	MOVLW	6
$017A	$0228	SUBWF	teclado_converte_to_7seg_param_dado, W
$017B	$1D03	BTFSS	STATUS, Z
$017C	$2980	GOTO	teclado_L_21
$017D	$	teclado_L_19:
$017D	$307D	MOVLW	125
$017E	$00A7	MOVWF	teclado_converte_to_7seg_local_result
$017F	$29BF	GOTO	teclado_L_0
$0180	$	teclado_L_21:
$0180	$	teclado_L_23:
$0180	$3007	MOVLW	7
$0181	$0228	SUBWF	teclado_converte_to_7seg_param_dado, W
$0182	$1D03	BTFSS	STATUS, Z
$0183	$2987	GOTO	teclado_L_24
$0184	$	teclado_L_22:
$0184	$3007	MOVLW	7
$0185	$00A7	MOVWF	teclado_converte_to_7seg_local_result
$0186	$29BF	GOTO	teclado_L_0
$0187	$	teclado_L_24:
$0187	$	teclado_L_26:
$0187	$3008	MOVLW	8
$0188	$0228	SUBWF	teclado_converte_to_7seg_param_dado, W
$0189	$1D03	BTFSS	STATUS, Z
$018A	$298E	GOTO	teclado_L_27
$018B	$	teclado_L_25:
$018B	$307F	MOVLW	127
$018C	$00A7	MOVWF	teclado_converte_to_7seg_local_result
$018D	$29BF	GOTO	teclado_L_0
$018E	$	teclado_L_27:
$018E	$	teclado_L_29:
$018E	$3009	MOVLW	9
$018F	$0228	SUBWF	teclado_converte_to_7seg_param_dado, W
$0190	$1D03	BTFSS	STATUS, Z
$0191	$2995	GOTO	teclado_L_30
$0192	$	teclado_L_28:
$0192	$306F	MOVLW	111
$0193	$00A7	MOVWF	teclado_converte_to_7seg_local_result
$0194	$29BF	GOTO	teclado_L_0
$0195	$	teclado_L_30:
$0195	$	teclado_L_32:
$0195	$300A	MOVLW	10
$0196	$0228	SUBWF	teclado_converte_to_7seg_param_dado, W
$0197	$1D03	BTFSS	STATUS, Z
$0198	$299C	GOTO	teclado_L_33
$0199	$	teclado_L_31:
$0199	$3077	MOVLW	119
$019A	$00A7	MOVWF	teclado_converte_to_7seg_local_result
$019B	$29BF	GOTO	teclado_L_0
$019C	$	teclado_L_33:
$019C	$	teclado_L_35:
$019C	$300B	MOVLW	11
$019D	$0228	SUBWF	teclado_converte_to_7seg_param_dado, W
$019E	$1D03	BTFSS	STATUS, Z
$019F	$29A3	GOTO	teclado_L_36
$01A0	$	teclado_L_34:
$01A0	$307C	MOVLW	124
$01A1	$00A7	MOVWF	teclado_converte_to_7seg_local_result
$01A2	$29BF	GOTO	teclado_L_0
$01A3	$	teclado_L_36:
$01A3	$	teclado_L_38:
$01A3	$300C	MOVLW	12
$01A4	$0228	SUBWF	teclado_converte_to_7seg_param_dado, W
$01A5	$1D03	BTFSS	STATUS, Z
$01A6	$29AA	GOTO	teclado_L_39
$01A7	$	teclado_L_37:
$01A7	$3039	MOVLW	57
$01A8	$00A7	MOVWF	teclado_converte_to_7seg_local_result
$01A9	$29BF	GOTO	teclado_L_0
$01AA	$	teclado_L_39:
$01AA	$	teclado_L_41:
$01AA	$300D	MOVLW	13
$01AB	$0228	SUBWF	teclado_converte_to_7seg_param_dado, W
$01AC	$1D03	BTFSS	STATUS, Z
$01AD	$29B1	GOTO	teclado_L_42
$01AE	$	teclado_L_40:
$01AE	$305E	MOVLW	94
$01AF	$00A7	MOVWF	teclado_converte_to_7seg_local_result
$01B0	$29BF	GOTO	teclado_L_0
$01B1	$	teclado_L_42:
$01B1	$	teclado_L_44:
$01B1	$300E	MOVLW	14
$01B2	$0228	SUBWF	teclado_converte_to_7seg_param_dado, W
$01B3	$1D03	BTFSS	STATUS, Z
$01B4	$29B8	GOTO	teclado_L_45
$01B5	$	teclado_L_43:
$01B5	$3079	MOVLW	121
$01B6	$00A7	MOVWF	teclado_converte_to_7seg_local_result
$01B7	$29BF	GOTO	teclado_L_0
$01B8	$	teclado_L_45:
$01B8	$	teclado_L_47:
$01B8	$300F	MOVLW	15
$01B9	$0228	SUBWF	teclado_converte_to_7seg_param_dado, W
$01BA	$1D03	BTFSS	STATUS, Z
$01BB	$29BF	GOTO	teclado_L_48
$01BC	$	teclado_L_46:
$01BC	$3071	MOVLW	113
$01BD	$00A7	MOVWF	teclado_converte_to_7seg_local_result
$01BE	$29BF	GOTO	teclado_L_0
$01BF	$	teclado_L_48:
$01BF	$	teclado_L_0:
$01BF	$0008	RETURN
$01C0	$	teclado_main:
$01C0	$3030	MOVLW	48
$01C1	$1303	BCF	STATUS,RP1
$01C2	$1683	BSF	STATUS,RP0
$01C3	$0085	MOVWF	TRISA
$01C4	$0186	CLRF	TRISB
$01C5	$0188	CLRF	TRISD
$01C6	$3001	MOVLW	1
$01C7	$0089	MOVWF	TRISE
$01C8	$3080	MOVLW	128
$01C9	$0081	MOVWF	OPTION_REG
$01CA	$1283	BCF	STATUS,RP0
$01CB	$01A0	CLRF	main_global_indice
$01CC	$01A1	CLRF	main_global_teclado0
$01CD	$01A6	CLRF	main_global_teclado1
$01CE	$3007	MOVLW	7
$01CF	$1683	BSF	STATUS,RP0
$01D0	$009F	MOVWF	ADCON1
$01D1	$30A0	MOVLW	160
$01D2	$008B	MOVWF	INTCON
$01D3	$3000	MOVLW	0
$01D4	$1283	BCF	STATUS,RP0
$01D5	$00A2	MOVWF	main_global_vetor_display_1
$01D6	$3000	MOVLW	0
$01D7	$00A3	MOVWF	main_global_vetor_display_2
$01D8	$3000	MOVLW	0
$01D9	$00A4	MOVWF	main_global_vetor_display_3
$01DA	$3000	MOVLW	0
$01DB	$00A5	MOVWF	main_global_vetor_display_4
$01DC	$	teclado_L_149:
$01DC	$	teclado_L_150:
$01DC	$3000	MOVLW	0
$01DD	$18A1	BTFSC	main_global_teclado0, 1
$01DE	$3001	MOVLW	1
$01DF	$00FB	MOVWF	STACK_2
$01E0	$3001	MOVLW	1
$01E1	$027B	SUBWF	STACK_2, W
$01E2	$1D03	BTFSS	STATUS, Z
$01E3	$29E7	GOTO	teclado_L_153
$01E4	$	teclado_L_152:
$01E4	$30FF	MOVLW	255
$01E5	$00FC	MOVWF	STACK_3
$01E6	$29E8	GOTO	teclado_L_155
$01E7	$	teclado_L_153:
$01E7	$01FC	CLRF	STACK_3
$01E8	$	teclado_L_155:
$01E8	$30FF	MOVLW	255
$01E9	$027C	SUBWF	STACK_3, W
$01EA	$1D03	BTFSS	STATUS, Z
$01EB	$29F3	GOTO	teclado_L_157
$01EC	$	teclado_L_156:
$01EC	$3001	MOVLW	1
$01ED	$00A8	MOVWF	teclado_converte_to_7seg_param_dado
$01EE	$214D	CALL	teclado_converte_to_7seg
$01EF	$1303	BCF	STATUS,RP1
$01F0	$1283	BCF	STATUS,RP0
$01F1	$0827	MOVF	teclado_converte_to_7seg_local_result, W
$01F2	$00A2	MOVWF	main_global_vetor_display_1
$01F3	$	teclado_L_157:
$01F3	$	teclado_L_154:
$01F3	$3000	MOVLW	0
$01F4	$1303	BCF	STATUS,RP1
$01F5	$1283	BCF	STATUS,RP0
$01F6	$1921	BTFSC	main_global_teclado0, 2
$01F7	$3001	MOVLW	1
$01F8	$00FB	MOVWF	STACK_2
$01F9	$3001	MOVLW	1
$01FA	$027B	SUBWF	STACK_2, W
$01FB	$1D03	BTFSS	STATUS, Z
$01FC	$2A02	GOTO	teclado_L_159
$01FD	$	teclado_L_158:
$01FD	$30FF	MOVLW	255
$01FE	$1303	BCF	STATUS,RP1
$01FF	$1283	BCF	STATUS,RP0
$0200	$00FC	MOVWF	STACK_3
$0201	$2A05	GOTO	teclado_L_161
$0202	$	teclado_L_159:
$0202	$1303	BCF	STATUS,RP1
$0203	$1283	BCF	STATUS,RP0
$0204	$01FC	CLRF	STACK_3
$0205	$	teclado_L_161:
$0205	$30FF	MOVLW	255
$0206	$1303	BCF	STATUS,RP1
$0207	$1283	BCF	STATUS,RP0
$0208	$027C	SUBWF	STACK_3, W
$0209	$1D03	BTFSS	STATUS, Z
$020A	$2A14	GOTO	teclado_L_163
$020B	$	teclado_L_162:
$020B	$3002	MOVLW	2
$020C	$1303	BCF	STATUS,RP1
$020D	$1283	BCF	STATUS,RP0
$020E	$00A8	MOVWF	teclado_converte_to_7seg_param_dado
$020F	$214D	CALL	teclado_converte_to_7seg
$0210	$1303	BCF	STATUS,RP1
$0211	$1283	BCF	STATUS,RP0
$0212	$0827	MOVF	teclado_converte_to_7seg_local_result, W
$0213	$00A2	MOVWF	main_global_vetor_display_1
$0214	$	teclado_L_163:
$0214	$	teclado_L_160:
$0214	$3000	MOVLW	0
$0215	$1303	BCF	STATUS,RP1
$0216	$1283	BCF	STATUS,RP0
$0217	$19A1	BTFSC	main_global_teclado0, 3
$0218	$3001	MOVLW	1
$0219	$00FB	MOVWF	STACK_2
$021A	$3001	MOVLW	1
$021B	$027B	SUBWF	STACK_2, W
$021C	$1D03	BTFSS	STATUS, Z
$021D	$2A23	GOTO	teclado_L_165
$021E	$	teclado_L_164:
$021E	$30FF	MOVLW	255
$021F	$1303	BCF	STATUS,RP1
$0220	$1283	BCF	STATUS,RP0
$0221	$00FC	MOVWF	STACK_3
$0222	$2A26	GOTO	teclado_L_167
$0223	$	teclado_L_165:
$0223	$1303	BCF	STATUS,RP1
$0224	$1283	BCF	STATUS,RP0
$0225	$01FC	CLRF	STACK_3
$0226	$	teclado_L_167:
$0226	$30FF	MOVLW	255
$0227	$1303	BCF	STATUS,RP1
$0228	$1283	BCF	STATUS,RP0
$0229	$027C	SUBWF	STACK_3, W
$022A	$1D03	BTFSS	STATUS, Z
$022B	$2A35	GOTO	teclado_L_169
$022C	$	teclado_L_168:
$022C	$3003	MOVLW	3
$022D	$1303	BCF	STATUS,RP1
$022E	$1283	BCF	STATUS,RP0
$022F	$00A8	MOVWF	teclado_converte_to_7seg_param_dado
$0230	$214D	CALL	teclado_converte_to_7seg
$0231	$1303	BCF	STATUS,RP1
$0232	$1283	BCF	STATUS,RP0
$0233	$0827	MOVF	teclado_converte_to_7seg_local_result, W
$0234	$00A2	MOVWF	main_global_vetor_display_1
$0235	$	teclado_L_169:
$0235	$	teclado_L_166:
$0235	$3000	MOVLW	0
$0236	$1303	BCF	STATUS,RP1
$0237	$1283	BCF	STATUS,RP0
$0238	$1A21	BTFSC	main_global_teclado0, 4
$0239	$3001	MOVLW	1
$023A	$00FB	MOVWF	STACK_2
$023B	$3001	MOVLW	1
$023C	$027B	SUBWF	STACK_2, W
$023D	$1D03	BTFSS	STATUS, Z
$023E	$2A44	GOTO	teclado_L_171
$023F	$	teclado_L_170:
$023F	$30FF	MOVLW	255
$0240	$1303	BCF	STATUS,RP1
$0241	$1283	BCF	STATUS,RP0
$0242	$00FC	MOVWF	STACK_3
$0243	$2A47	GOTO	teclado_L_173
$0244	$	teclado_L_171:
$0244	$1303	BCF	STATUS,RP1
$0245	$1283	BCF	STATUS,RP0
$0246	$01FC	CLRF	STACK_3
$0247	$	teclado_L_173:
$0247	$30FF	MOVLW	255
$0248	$1303	BCF	STATUS,RP1
$0249	$1283	BCF	STATUS,RP0
$024A	$027C	SUBWF	STACK_3, W
$024B	$1D03	BTFSS	STATUS, Z
$024C	$2A56	GOTO	teclado_L_175
$024D	$	teclado_L_174:
$024D	$3004	MOVLW	4
$024E	$1303	BCF	STATUS,RP1
$024F	$1283	BCF	STATUS,RP0
$0250	$00A8	MOVWF	teclado_converte_to_7seg_param_dado
$0251	$214D	CALL	teclado_converte_to_7seg
$0252	$1303	BCF	STATUS,RP1
$0253	$1283	BCF	STATUS,RP0
$0254	$0827	MOVF	teclado_converte_to_7seg_local_result, W
$0255	$00A3	MOVWF	main_global_vetor_display_2
$0256	$	teclado_L_175:
$0256	$	teclado_L_172:
$0256	$3000	MOVLW	0
$0257	$1303	BCF	STATUS,RP1
$0258	$1283	BCF	STATUS,RP0
$0259	$1AA1	BTFSC	main_global_teclado0, 5
$025A	$3001	MOVLW	1
$025B	$00FB	MOVWF	STACK_2
$025C	$3001	MOVLW	1
$025D	$027B	SUBWF	STACK_2, W
$025E	$1D03	BTFSS	STATUS, Z
$025F	$2A65	GOTO	teclado_L_177
$0260	$	teclado_L_176:
$0260	$30FF	MOVLW	255
$0261	$1303	BCF	STATUS,RP1
$0262	$1283	BCF	STATUS,RP0
$0263	$00FC	MOVWF	STACK_3
$0264	$2A68	GOTO	teclado_L_179
$0265	$	teclado_L_177:
$0265	$1303	BCF	STATUS,RP1
$0266	$1283	BCF	STATUS,RP0
$0267	$01FC	CLRF	STACK_3
$0268	$	teclado_L_179:
$0268	$30FF	MOVLW	255
$0269	$1303	BCF	STATUS,RP1
$026A	$1283	BCF	STATUS,RP0
$026B	$027C	SUBWF	STACK_3, W
$026C	$1D03	BTFSS	STATUS, Z
$026D	$2A77	GOTO	teclado_L_181
$026E	$	teclado_L_180:
$026E	$3005	MOVLW	5
$026F	$1303	BCF	STATUS,RP1
$0270	$1283	BCF	STATUS,RP0
$0271	$00A8	MOVWF	teclado_converte_to_7seg_param_dado
$0272	$214D	CALL	teclado_converte_to_7seg
$0273	$1303	BCF	STATUS,RP1
$0274	$1283	BCF	STATUS,RP0
$0275	$0827	MOVF	teclado_converte_to_7seg_local_result, W
$0276	$00A3	MOVWF	main_global_vetor_display_2
$0277	$	teclado_L_181:
$0277	$	teclado_L_178:
$0277	$3000	MOVLW	0
$0278	$1303	BCF	STATUS,RP1
$0279	$1283	BCF	STATUS,RP0
$027A	$1B21	BTFSC	main_global_teclado0, 6
$027B	$3001	MOVLW	1
$027C	$00FB	MOVWF	STACK_2
$027D	$3001	MOVLW	1
$027E	$027B	SUBWF	STACK_2, W
$027F	$1D03	BTFSS	STATUS, Z
$0280	$2A86	GOTO	teclado_L_183
$0281	$	teclado_L_182:
$0281	$30FF	MOVLW	255
$0282	$1303	BCF	STATUS,RP1
$0283	$1283	BCF	STATUS,RP0
$0284	$00FC	MOVWF	STACK_3
$0285	$2A89	GOTO	teclado_L_185
$0286	$	teclado_L_183:
$0286	$1303	BCF	STATUS,RP1
$0287	$1283	BCF	STATUS,RP0
$0288	$01FC	CLRF	STACK_3
$0289	$	teclado_L_185:
$0289	$30FF	MOVLW	255
$028A	$1303	BCF	STATUS,RP1
$028B	$1283	BCF	STATUS,RP0
$028C	$027C	SUBWF	STACK_3, W
$028D	$1D03	BTFSS	STATUS, Z
$028E	$2A98	GOTO	teclado_L_187
$028F	$	teclado_L_186:
$028F	$3006	MOVLW	6
$0290	$1303	BCF	STATUS,RP1
$0291	$1283	BCF	STATUS,RP0
$0292	$00A8	MOVWF	teclado_converte_to_7seg_param_dado
$0293	$214D	CALL	teclado_converte_to_7seg
$0294	$1303	BCF	STATUS,RP1
$0295	$1283	BCF	STATUS,RP0
$0296	$0827	MOVF	teclado_converte_to_7seg_local_result, W
$0297	$00A3	MOVWF	main_global_vetor_display_2
$0298	$	teclado_L_187:
$0298	$	teclado_L_184:
$0298	$3000	MOVLW	0
$0299	$1303	BCF	STATUS,RP1
$029A	$1283	BCF	STATUS,RP0
$029B	$1BA1	BTFSC	main_global_teclado0, 7
$029C	$3001	MOVLW	1
$029D	$00FB	MOVWF	STACK_2
$029E	$3001	MOVLW	1
$029F	$027B	SUBWF	STACK_2, W
$02A0	$1D03	BTFSS	STATUS, Z
$02A1	$2AA7	GOTO	teclado_L_189
$02A2	$	teclado_L_188:
$02A2	$30FF	MOVLW	255
$02A3	$1303	BCF	STATUS,RP1
$02A4	$1283	BCF	STATUS,RP0
$02A5	$00FC	MOVWF	STACK_3
$02A6	$2AAA	GOTO	teclado_L_191
$02A7	$	teclado_L_189:
$02A7	$1303	BCF	STATUS,RP1
$02A8	$1283	BCF	STATUS,RP0
$02A9	$01FC	CLRF	STACK_3
$02AA	$	teclado_L_191:
$02AA	$30FF	MOVLW	255
$02AB	$1303	BCF	STATUS,RP1
$02AC	$1283	BCF	STATUS,RP0
$02AD	$027C	SUBWF	STACK_3, W
$02AE	$1D03	BTFSS	STATUS, Z
$02AF	$2AB9	GOTO	teclado_L_193
$02B0	$	teclado_L_192:
$02B0	$3007	MOVLW	7
$02B1	$1303	BCF	STATUS,RP1
$02B2	$1283	BCF	STATUS,RP0
$02B3	$00A8	MOVWF	teclado_converte_to_7seg_param_dado
$02B4	$214D	CALL	teclado_converte_to_7seg
$02B5	$1303	BCF	STATUS,RP1
$02B6	$1283	BCF	STATUS,RP0
$02B7	$0827	MOVF	teclado_converte_to_7seg_local_result, W
$02B8	$00A4	MOVWF	main_global_vetor_display_3
$02B9	$	teclado_L_193:
$02B9	$	teclado_L_190:
$02B9	$3000	MOVLW	0
$02BA	$1303	BCF	STATUS,RP1
$02BB	$1283	BCF	STATUS,RP0
$02BC	$1826	BTFSC	main_global_teclado1, 0
$02BD	$3001	MOVLW	1
$02BE	$00FB	MOVWF	STACK_2
$02BF	$3001	MOVLW	1
$02C0	$027B	SUBWF	STACK_2, W
$02C1	$1D03	BTFSS	STATUS, Z
$02C2	$2AC8	GOTO	teclado_L_195
$02C3	$	teclado_L_194:
$02C3	$30FF	MOVLW	255
$02C4	$1303	BCF	STATUS,RP1
$02C5	$1283	BCF	STATUS,RP0
$02C6	$00FC	MOVWF	STACK_3
$02C7	$2ACB	GOTO	teclado_L_197
$02C8	$	teclado_L_195:
$02C8	$1303	BCF	STATUS,RP1
$02C9	$1283	BCF	STATUS,RP0
$02CA	$01FC	CLRF	STACK_3
$02CB	$	teclado_L_197:
$02CB	$30FF	MOVLW	255
$02CC	$1303	BCF	STATUS,RP1
$02CD	$1283	BCF	STATUS,RP0
$02CE	$027C	SUBWF	STACK_3, W
$02CF	$1D03	BTFSS	STATUS, Z
$02D0	$2ADA	GOTO	teclado_L_199
$02D1	$	teclado_L_198:
$02D1	$3008	MOVLW	8
$02D2	$1303	BCF	STATUS,RP1
$02D3	$1283	BCF	STATUS,RP0
$02D4	$00A8	MOVWF	teclado_converte_to_7seg_param_dado
$02D5	$214D	CALL	teclado_converte_to_7seg
$02D6	$1303	BCF	STATUS,RP1
$02D7	$1283	BCF	STATUS,RP0
$02D8	$0827	MOVF	teclado_converte_to_7seg_local_result, W
$02D9	$00A4	MOVWF	main_global_vetor_display_3
$02DA	$	teclado_L_199:
$02DA	$	teclado_L_196:
$02DA	$3000	MOVLW	0
$02DB	$1303	BCF	STATUS,RP1
$02DC	$1283	BCF	STATUS,RP0
$02DD	$18A6	BTFSC	main_global_teclado1, 1
$02DE	$3001	MOVLW	1
$02DF	$00FB	MOVWF	STACK_2
$02E0	$3001	MOVLW	1
$02E1	$027B	SUBWF	STACK_2, W
$02E2	$1D03	BTFSS	STATUS, Z
$02E3	$2AE9	GOTO	teclado_L_201
$02E4	$	teclado_L_200:
$02E4	$30FF	MOVLW	255
$02E5	$1303	BCF	STATUS,RP1
$02E6	$1283	BCF	STATUS,RP0
$02E7	$00FC	MOVWF	STACK_3
$02E8	$2AEC	GOTO	teclado_L_203
$02E9	$	teclado_L_201:
$02E9	$1303	BCF	STATUS,RP1
$02EA	$1283	BCF	STATUS,RP0
$02EB	$01FC	CLRF	STACK_3
$02EC	$	teclado_L_203:
$02EC	$30FF	MOVLW	255
$02ED	$1303	BCF	STATUS,RP1
$02EE	$1283	BCF	STATUS,RP0
$02EF	$027C	SUBWF	STACK_3, W
$02F0	$1D03	BTFSS	STATUS, Z
$02F1	$2AFB	GOTO	teclado_L_205
$02F2	$	teclado_L_204:
$02F2	$3009	MOVLW	9
$02F3	$1303	BCF	STATUS,RP1
$02F4	$1283	BCF	STATUS,RP0
$02F5	$00A8	MOVWF	teclado_converte_to_7seg_param_dado
$02F6	$214D	CALL	teclado_converte_to_7seg
$02F7	$1303	BCF	STATUS,RP1
$02F8	$1283	BCF	STATUS,RP0
$02F9	$0827	MOVF	teclado_converte_to_7seg_local_result, W
$02FA	$00A4	MOVWF	main_global_vetor_display_3
$02FB	$	teclado_L_205:
$02FB	$	teclado_L_202:
$02FB	$3000	MOVLW	0
$02FC	$1303	BCF	STATUS,RP1
$02FD	$1283	BCF	STATUS,RP0
$02FE	$1926	BTFSC	main_global_teclado1, 2
$02FF	$3001	MOVLW	1
$0300	$00FB	MOVWF	STACK_2
$0301	$3001	MOVLW	1
$0302	$027B	SUBWF	STACK_2, W
$0303	$1D03	BTFSS	STATUS, Z
$0304	$2B0A	GOTO	teclado_L_207
$0305	$	teclado_L_206:
$0305	$30FF	MOVLW	255
$0306	$1303	BCF	STATUS,RP1
$0307	$1283	BCF	STATUS,RP0
$0308	$00FC	MOVWF	STACK_3
$0309	$2B0D	GOTO	teclado_L_209
$030A	$	teclado_L_207:
$030A	$1303	BCF	STATUS,RP1
$030B	$1283	BCF	STATUS,RP0
$030C	$01FC	CLRF	STACK_3
$030D	$	teclado_L_209:
$030D	$30FF	MOVLW	255
$030E	$1303	BCF	STATUS,RP1
$030F	$1283	BCF	STATUS,RP0
$0310	$027C	SUBWF	STACK_3, W
$0311	$1D03	BTFSS	STATUS, Z
$0312	$2B1C	GOTO	teclado_L_211
$0313	$	teclado_L_210:
$0313	$300C	MOVLW	12
$0314	$1303	BCF	STATUS,RP1
$0315	$1283	BCF	STATUS,RP0
$0316	$00A8	MOVWF	teclado_converte_to_7seg_param_dado
$0317	$214D	CALL	teclado_converte_to_7seg
$0318	$1303	BCF	STATUS,RP1
$0319	$1283	BCF	STATUS,RP0
$031A	$0827	MOVF	teclado_converte_to_7seg_local_result, W
$031B	$00A5	MOVWF	main_global_vetor_display_4
$031C	$	teclado_L_211:
$031C	$	teclado_L_208:
$031C	$3000	MOVLW	0
$031D	$1303	BCF	STATUS,RP1
$031E	$1283	BCF	STATUS,RP0
$031F	$1821	BTFSC	main_global_teclado0, 0
$0320	$3001	MOVLW	1
$0321	$00FB	MOVWF	STACK_2
$0322	$3001	MOVLW	1
$0323	$027B	SUBWF	STACK_2, W
$0324	$1D03	BTFSS	STATUS, Z
$0325	$2B2B	GOTO	teclado_L_213
$0326	$	teclado_L_212:
$0326	$30FF	MOVLW	255
$0327	$1303	BCF	STATUS,RP1
$0328	$1283	BCF	STATUS,RP0
$0329	$00FC	MOVWF	STACK_3
$032A	$2B2E	GOTO	teclado_L_215
$032B	$	teclado_L_213:
$032B	$1303	BCF	STATUS,RP1
$032C	$1283	BCF	STATUS,RP0
$032D	$01FC	CLRF	STACK_3
$032E	$	teclado_L_215:
$032E	$30FF	MOVLW	255
$032F	$1303	BCF	STATUS,RP1
$0330	$1283	BCF	STATUS,RP0
$0331	$027C	SUBWF	STACK_3, W
$0332	$1D03	BTFSS	STATUS, Z
$0333	$2B3C	GOTO	teclado_L_217
$0334	$	teclado_L_216:
$0334	$1303	BCF	STATUS,RP1
$0335	$1283	BCF	STATUS,RP0
$0336	$01A8	CLRF	teclado_converte_to_7seg_param_dado
$0337	$214D	CALL	teclado_converte_to_7seg
$0338	$1303	BCF	STATUS,RP1
$0339	$1283	BCF	STATUS,RP0
$033A	$0827	MOVF	teclado_converte_to_7seg_local_result, W
$033B	$00A5	MOVWF	main_global_vetor_display_4
$033C	$	teclado_L_217:
$033C	$	teclado_L_214:
$033C	$3000	MOVLW	0
$033D	$1303	BCF	STATUS,RP1
$033E	$1283	BCF	STATUS,RP0
$033F	$19A6	BTFSC	main_global_teclado1, 3
$0340	$3001	MOVLW	1
$0341	$00FB	MOVWF	STACK_2
$0342	$3001	MOVLW	1
$0343	$027B	SUBWF	STACK_2, W
$0344	$1D03	BTFSS	STATUS, Z
$0345	$2B4B	GOTO	teclado_L_219
$0346	$	teclado_L_218:
$0346	$30FF	MOVLW	255
$0347	$1303	BCF	STATUS,RP1
$0348	$1283	BCF	STATUS,RP0
$0349	$00FC	MOVWF	STACK_3
$034A	$2B4E	GOTO	teclado_L_221
$034B	$	teclado_L_219:
$034B	$1303	BCF	STATUS,RP1
$034C	$1283	BCF	STATUS,RP0
$034D	$01FC	CLRF	STACK_3
$034E	$	teclado_L_221:
$034E	$30FF	MOVLW	255
$034F	$1303	BCF	STATUS,RP1
$0350	$1283	BCF	STATUS,RP0
$0351	$027C	SUBWF	STACK_3, W
$0352	$1D03	BTFSS	STATUS, Z
$0353	$2B5D	GOTO	teclado_L_223
$0354	$	teclado_L_222:
$0354	$300E	MOVLW	14
$0355	$1303	BCF	STATUS,RP1
$0356	$1283	BCF	STATUS,RP0
$0357	$00A8	MOVWF	teclado_converte_to_7seg_param_dado
$0358	$214D	CALL	teclado_converte_to_7seg
$0359	$1303	BCF	STATUS,RP1
$035A	$1283	BCF	STATUS,RP0
$035B	$0827	MOVF	teclado_converte_to_7seg_local_result, W
$035C	$00A5	MOVWF	main_global_vetor_display_4
$035D	$	teclado_L_223:
$035D	$	teclado_L_220:
$035D	$29DC	GOTO	teclado_L_149
$035E	$	teclado_L_151:
$035E	$	teclado_L_224:
$035E	$2B5E	GOTO	teclado_L_224
