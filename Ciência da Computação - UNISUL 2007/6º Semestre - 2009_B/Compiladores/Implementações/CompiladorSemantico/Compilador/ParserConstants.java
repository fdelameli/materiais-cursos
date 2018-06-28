public interface ParserConstants
{
    int START_SYMBOL = 52;

    int FIRST_NON_TERMINAL    = 52;
    int FIRST_SEMANTIC_ACTION = 87;

    int[][] PARSER_TABLE =
    {
        {  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1,  1,  1,  1,  1,  1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1,  2,  6,  6,  6,  6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  4, -1, -1, -1, -1, -1, -1,  5,  4, -1, -1, -1 },
        { -1, -1,  7, 10, 10, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1,  8,  8,  8, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  9, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, 11, 14, 14, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, 12, 12, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, 15, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, 17, 18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, -1, -1, -1 },
        { -1, -1, -1, -1, -1, 21, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 23, -1, -1, -1 },
        { -1, -1, -1, -1, -1, 29, 30, -1, -1, -1, 31, 36, 37, -1, 30, 40, -1, 41, 30, 42, 48, -1, -1, -1, 24, -1, 59, -1, 53, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 30, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, -1, -1, -1, 26, 25, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 28, -1, -1, -1, 27, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 32, -1, -1, -1, -1, -1, -1, -1, 32, -1, -1, -1, 32, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 32, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 34, -1, -1, -1, -1, -1, -1, -1, -1, 35, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, 39, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 43, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 44, -1, -1, 44, -1, -1, -1, 44, 44, -1, 44, -1, 44, -1, -1, 44, 44, -1, -1, -1, -1, 44, -1, 44, 44, 44, 44, 45, 44, -1, 44, -1, -1, 44, 44, 44, 44, 44, 44, 44, 44, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 46, -1, -1, -1, -1, -1, -1, -1, -1, 47, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 50, 50, 50, -1, -1, -1, 50, 50, -1, -1, -1, -1, 50, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 49, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 51, -1, -1, -1, -1, -1, -1, -1, -1, 52, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 60, 60, 60, -1, -1, -1, 60, 60, -1, -1, -1, -1, 60, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 61, -1, -1, 61, -1, -1, -1, 61, 61, -1, 61, -1, 61, -1, -1, -1, -1, -1, -1, -1, -1, 61, -1, -1, -1, -1, -1, -1, 61, -1, 61, -1, -1, 62, 64, 65, 63, 66, 67, 61, 61, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 70, 70, 70, -1, -1, -1, 68, 69, -1, -1, -1, -1, 70, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 74, -1, -1, 74, -1, -1, -1, 74, 74, -1, 74, -1, 74, -1, -1, 73, -1, -1, -1, -1, -1, 74, -1, 71, 72, -1, -1, -1, 74, -1, 74, -1, -1, 74, 74, 74, 74, 74, 74, 74, 74, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 75, 75, 75, -1, -1, -1, -1, -1, -1, -1, -1, -1, 75, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 76, -1, -1, 76, -1, -1, -1, 76, 76, -1, 76, -1, 76, -1, -1, 76, 79, -1, -1, -1, -1, 76, -1, 76, 76, 77, 78, -1, 76, -1, 76, -1, -1, 76, 76, 76, 76, 76, 76, 76, 76, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 82, 83, 80, -1, -1, -1, -1, -1, -1, -1, -1, -1, 81, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 54, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 57, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 58, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 56, -1, -1, -1, -1, -1, -1, 55, -1, -1, -1, -1 }
    };

	int[][] PRODUCTIONS = 
    {
/*  1 */{   2,  26, 187,  48,  53,  50, 188 },
/*  2 */{  54,  57, 59, 189,  62,  64 },
/*  3 */{   3, 190,  55,  48 },
/*  4 */{  26, 191,  56 },
/*  5 */{   0 },
/*  6 */{  47,  26, 191,  56 },
/*  7 */{   0 },
/*  8 */{   4,  26, 192,  41,  27, 193,  48,  58 },
/*  9 */{   0 },
/* 10 */{  26, 192,  41,  27, 193,  48,  58 },
/* 11 */{   0 },
/* 12 */{   5, 194,  55,  40,  61,  48,  60 },
/* 13 */{   0 },
/* 14 */{  55,  40,  61,  48,  60 },
/* 15 */{   0 },
/* 16 */{   9 },
/* 17 */{  10,  35,  27,  51,  27,  36,  11,   9 },
/* 18 */{   6,  26, 195,  63,  48, 196,  53,  48, 197,  62 },
/* 19 */{   0 },
/* 20 */{   0 },
/* 21 */{  37, 198,  55,  40,   9,  38 },
/* 22 */{   7,  66,  65,   8 },
/* 23 */{   0 },
/* 24 */{  48,  66,  65 },
/* 25 */{  26, 199,  67 },
/* 26 */{ 200,  40,  66 },
/* 27 */{  68, 201,  39,  77, 202 },
/* 28 */{   0 },
/* 29 */{  35,  77,  36 },
/* 30 */{  64 },
/* 31 */{   0 },
/* 32 */{  12,  26, 203,  69, 204 },
/* 33 */{   0 },
/* 34 */{  37,  77, 205,  70,  38 },
/* 35 */{   0 },
/* 36 */{  47,  77, 205,  70 },
/* 37 */{  13,  26, 206 },
/* 38 */{  14,  77, 207,  15,  66,  71, 208 },
/* 39 */{   0 },
/* 40 */{ 209,  16,  66 },
/* 41 */{  17, 210,  77, 211,  18,  66, 212 },
/* 42 */{  19, 213,  66,  20,  77, 214 },
/* 43 */{  21, 215,  37,  72,  74,  38 },
/* 44 */{  26, 216,  73 },
/* 45 */{   0 },
/* 46 */{  35,  77,  36 },
/* 47 */{   0 },
/* 48 */{  47,  72,  74 },
/* 49 */{  22,  37,  75,  76,  38 },
/* 50 */{  49, 217 },
/* 51 */{  77, 218 },
/* 52 */{   0 },
/* 53 */{  47,  75,  76 },
/* 54 */{  30, 219,  77,  11,  84,   8, 220 },
/* 55 */{  27,  86,  221, 40,  66, 222,  85 },
/* 56 */{  223, 47,  27,  86 },
/* 57 */{   0 },
/* 58 */{   0 },
/* 59 */{  48,  84 },
/* 60 */{  28,  26, 224,  39,  77, 225,  29,  77, 226,  18,  66, 227 },
/* 61 */{  79,  78 },
/* 62 */{   0 },
/* 63 */{  41,  79, 228 },
/* 64 */{  44,  79, 229 },
/* 65 */{  42,  79, 230 },
/* 66 */{  43,  79, 231 },
/* 67 */{  45,  79, 232 },
/* 68 */{  46,  79, 233 },
/* 69 */{  31,  81,  80 },
/* 70 */{  32,  81, 234,  80 },
/* 71 */{  81,  80 },
/* 72 */{  31,  81, 235,  80 },
/* 73 */{  32,  81, 236,  80 },
/* 74 */{  23,  81, 237,  80 },
/* 75 */{   0 },
/* 76 */{  83,  82 },
/* 77 */{   0 },
/* 78 */{  33,  83, 238,  82 },
/* 79 */{  34,  83, 239,  82 },
/* 80 */{  24,  83, 240,  82 },
/* 81 */{  27, 241 },
/* 82 */{  37,  77,  38 },
/* 83 */{  25,  83, 242 },
/* 84 */{ 243,  72 }
    };


    String[] PARSER_ERROR =
    {
        "",
        "Era esperado fim de programa",
        "Era esperado \"PROGRAMA\"",
        "Era esperado \"ROTULO\"",
        "Era esperado \"CONSTANTE\"",
        "Era esperado \"VARIAVEL\"",
        "Era esperado \"PROCEDIMENTO\"",
        "Era esperado \"INICIO\"",
        "Era esperado \"FIM\"",
        "Era esperado \"INTEIRO\"",
        "Era esperado \"VETOR\"",
        "Era esperado \"DE\"",
        "Era esperado \"CHAMADA\"",
        "Era esperado \"VAIPARA\"",
        "Era esperado \"SE\"",
        "Era esperado \"ENTAO\"",
        "Era esperado \"SENAO\"",
        "Era esperado \"ENQUANTO\"",
        "Era esperado \"FACA\"",
        "Era esperado \"REPITA\"",
        "Era esperado \"ATEQUE\"",
        "Era esperado \"LERLINHA\"",
        "Era esperado \"ESCREVELINHA\"",
        "Era esperado \"OU\"",
        "Era esperado \"E\"",
        "Era esperado \"NAO\"",
        "Era esperado IDENTIFICADOR",
        "Era esperado INTEIRO",
        "Era esperado \"PARA\"",
        "Era esperado \"ATE\"",
        "Era esperado \"CASO\"",
        "Era esperado \"+\"",
        "Era esperado \"-\"",
        "Era esperado \"*\"",
        "Era esperado \"/\"",
        "Era esperado \"[\"",
        "Era esperado \"]\"",
        "Era esperado \"(\"",
        "Era esperado \")\"",
        "Era esperado \":=\"",
        "Era esperado \":\"",
        "Era esperado \"=\"",
        "Era esperado \">\"",
        "Era esperado \">=\"",
        "Era esperado \"<\"",
        "Era esperado \"<=\"",
        "Era esperado \"<>\"",
        "Era esperado \",\"",
        "Era esperado \";\"",
        "Era esperado LITERAL",
        "Era esperado \".\"",
        "Era esperado \"..\"",
        "<PROGRAMA> inv�lido",
        "<BLOCO> inv�lido",
        "<DCLROT> inv�lido",
        "<LID> inv�lido",
        "<REPIDENT> inv�lido",
        "<DCLCONST> inv�lido",
        "<LDCONST> inv�lido",
        "<DCLVAR> inv�lido",
        "<LDVAR> inv�lido",
        "<TIPO> inv�lido",
        "<DCLPROC> inv�lido",
        "<DEFPAR> inv�lido",
        "<CORPO> inv�lido",
        "<REPCOMANDO> inv�lido",
        "<COMANDO> inv�lido",
        "<RCOMID> inv�lido",
        "<RVAR> inv�lido",
        "<PARAMETROS> inv�lido",
        "<REPPAR> inv�lido",
        "<ELSEPARTE> inv�lido",
        "<VARIAVEL> inv�lido",
        "<VARIAVEL1> inv�lido",
        "<REPVARIAVEL> inv�lido",
        "<ITEMSAIDA> inv�lido",
        "<REPITEM> inv�lido",
        "<EXPRESSAO> inv�lido",
        "<REPEXPSIMP> inv�lido",
        "<EXPSIMP> inv�lido",
        "<REPEXP> inv�lido",
        "<TERMO> inv�lido",
        "<REPTERMO> inv�lido",
        "<FATOR> inv�lido",
        "<CONDCASE> inv�lido",
        "<CONTCASE> inv�lido",
        "<RPINTEIRO> inv�lido"
    };
}
