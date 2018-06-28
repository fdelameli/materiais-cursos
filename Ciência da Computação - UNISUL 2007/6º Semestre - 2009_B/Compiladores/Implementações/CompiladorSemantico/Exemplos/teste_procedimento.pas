programa teste17;
variavel x,y: inteiro;

procedimento p1(b: inteiro);
variavel a: inteiro;
inicio
 a:=2;
 x:=b+a;
fim;

inicio
 lerlinha(y);
 chamada p1(y+1);
 escrevelinha(x,y);
fim.