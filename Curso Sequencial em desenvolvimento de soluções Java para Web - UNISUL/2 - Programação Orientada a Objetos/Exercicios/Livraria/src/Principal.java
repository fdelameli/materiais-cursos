
public class Principal {

	public static void main(String[] args) {
		
		Produto prod1 = new Cd (1, "CD Ira    ", 10, 10.0, 60, 12);
		Produto prod2 = new Livro (2, "Livro Java", 5, 200.0, "Deitel", "123456");
		
		ItemVenda item1 = new ItemVenda(prod1, 3, 10.0);
		ItemVenda item2 = new ItemVenda(prod2, 5, 5.0);
		
		Cliente c1 = new PessoaFisica(1, "Fabio", "(48) 3659-0274", new Endereco(), new Endereco(), "", "");
		
		Venda venda = new Venda(1, "31/05/2008", c1);
		
		venda.incluiItem(item1);
		venda.incluiItem(item2);
		
		venda.imprimirVenda();
		
		System.out.println("------------------------------");
		
		venda.excluiItem(item1);
		
		venda.imprimirVenda();
	}
}
