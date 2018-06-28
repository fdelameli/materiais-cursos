programa teste5;
constante x=10;
variavel a,b,c,soma: inteiro;
inicio
   escrevelinha("iniciando programa");
   soma:=0;
   repita inicio
      lerlinha(a,b,c);
      enquanto (a>(b+c)) faca
      inicio
        soma:=soma+a+b*x;
        lerlinha(a,b,c);
      fim;
    escrevelinha("passou pelo enquanto e vai continuar até que a seja maior do que b");
    escrevelinha("valor de a:",a);
    escrevelinha("valor de b:",b);
   fim ateque a>b;
   escrevelinha(soma);
fim.