package exercicio1;


public class Principal {
	
	public static void main(String[] args) {
		
		Produto p1 = new Produto(10001, "A", 5, 10, 100.0);
		Produto p2 = new Produto(10002, "B", 10, 20, 250.0);
		

		System.out.println(p1);
		
		System.out.println();
		
		p1.aumentaQtdEstoque();
		System.out.println(p1);
		
		System.out.println();
		
		p1.aumentaQtdEstoque(5);
		System.out.println(p1);
		
		System.out.println();
		
		p1.diminuiQdtEstoque();
		System.out.println(p1);
		
		System.out.println();
		
		p1.diminuiQdtEstoque(20);
		System.out.println(p1);
		
		System.out.println();
		
		p1.aumentaValor();
		System.out.println(p1);
		
		System.out.println();
		
		p1.aumentaValor(50.0);
		System.out.println(p1);
		
		System.out.println();
		
		p1.diminuiValor();
		System.out.println(p1);
		
		System.out.println();
		
		p1.diminuiValor(500.0);
		System.out.println(p1);
		
		System.out.println();
	
		if(p1.qtdAbaixoMin())
			System.out.println("Está abaixo");
		else
			System.out.println("Não está abaixo");
	}

}
