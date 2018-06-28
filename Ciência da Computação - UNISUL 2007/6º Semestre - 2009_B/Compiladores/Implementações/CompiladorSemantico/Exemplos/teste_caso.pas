programa TesteCase;
variavel dado,a,b,c: inteiro;

inicio
 a:=20;
 b:=30;
 c:=0;
 escrevelinha("Informe o dado: ");
 lerlinha(dado);
   caso dado de
        1,2,3: c:=a+b;
        4,5,6,7: caso a de 
                        10: escrevelinha("a vale 10 mesmo?");
                        20: caso b de 
				10: c:=b;
				20: c:=a*b;
				30: escrevelinha("b vale 30!");
			    fim
			30: escrevelinha("problemas")
                 fim
   fim;
 escrevelinha(c);
fim.