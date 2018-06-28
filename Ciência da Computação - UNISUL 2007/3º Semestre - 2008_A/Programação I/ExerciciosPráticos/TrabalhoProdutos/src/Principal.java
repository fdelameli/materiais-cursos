import javax.swing.JOptionPane;

import br.unisul.trabalho.listas.ListProducts;
import br.unisul.trabalho.listas.ListVenda;
import br.unisul.trabalho.listas.Product;

/**
 * Classe principal do programa.
 * @author Fabio Dela Bruna.
 * @since 15/03/2008.
 */
public class Principal {

	static ListProducts list = new ListProducts();
	public static void main(String[] args) {
		
		double total = 0.0;
		int op2 = 0;
		int op1 = 0;
		
		do{
			op1 = Integer.parseInt(JOptionPane.showInputDialog("MENU DO SISTEMA" +
					"\n     |1|  CADASTRAR UM NOVO PRODUTO" +
					"\n     |2|  LISTAR PRODUTOS CADASTRADOS" +
					"\n     |3|  EFETUAR VENDA DE UM PRODUTO" +
					"\n\n     |0|  SAIR"));
			
			switch (op1){
			
			case 1:{
				insertProduct();
				break;
			}
			
			case 2:{
				list.showAll();
				break;
			}
			
			case 3:{
				ListVenda venda = new ListVenda();
				do{
					op2 = Integer.parseInt(JOptionPane.showInputDialog("O QUE VOCÊ DESEJA FAZER?" +
											"\n     |1|  VENDER UM PRODUTO" +
											"\n     |2|  LISTAR PRODUTOS COMPRADOS" +
											"\n     |3|  LISTAR O TOTAL DA COMPRA" +
											"\n     |4|  DEVOLVER UM PRODUTO (ESTORNO)" +
											"\n     |5|  EFETUAR DESCONTO" +
											"\n\n     |0|  FINALIZAR COMPRA"));
					switch (op2){
				
					case 1:{
						if(venda.size() == -1)
							JOptionPane.showMessageDialog(null, "CADASTRE UM PRODUTO PRIMEIRAMENTE!");
		
						String nome = JOptionPane.showInputDialog("NOME DO PRODUTO:").toUpperCase();
						Product prod = list.productAt(nome);
		
						if(prod != null){
							venda.insert(prod);
							total = venda.total();
							JOptionPane.showMessageDialog(null, "VENDA EFETUADA COM SUCESSO!");
						}else{
							JOptionPane.showMessageDialog(null, "PRODUTO NÃO CADASTRADO!");
						}
						break;
					}
		
					case 2:{
						venda.showAll();
						break;
					}
		
					case 3:{
						JOptionPane.showMessageDialog(null, "TOTAL DA COMPRA: R$ " + venda.total());
						break;
					}
		
					case 4:{
						String nome = JOptionPane.showInputDialog(null, "PRODUTO A SER DEVOLVIDO:");
						Product prod = list.productAt(nome);
		
						if(prod != null){
							venda.remove(nome);
							JOptionPane.showMessageDialog(null, "PRODUTO DEVOLVIDO COM SUCESSO!");
						}else{
							JOptionPane.showMessageDialog(null, "PRODUTO NÃO ENCONTRADO NA LISTA DE VENDAS!");
						}
						break;
					}
		
					case 5:{
						total = venda.totalCompra();
						double desconto = Double.parseDouble(JOptionPane.showInputDialog("QUANTIDADE -(%)- DO DESCONTO"));
						double valorFinal = (1 - desconto / 100)* total;
						JOptionPane.showMessageDialog(null, "VALOR FINAL DA COMPRA: R$" + valorFinal);
						break;
					}
					}
				}
				while(op2 != 0);
				break;
			}
			}	
		}
		while(op1!=0);
	}
	
	/**
	 * Lê um produto e cadastra em ListProducts
	 */
	private static void insertProduct() {
		Product prod = new Product();
		String msg = "#CADASTRANDO UM NOVO PRODUTO#";
		
		String nome = JOptionPane.showInputDialog(msg + "\n\nPRODUTO:").toUpperCase();
		prod.setNomeProduto(nome);
		
				
				double valor = Double.parseDouble(JOptionPane.showInputDialog(msg + "\n\nVALOR:"));
				prod.setValor(valor);
				
				double peso = Double.parseDouble(JOptionPane.showInputDialog(msg + "\n\nPESO:"));
				prod.setPeso(peso);
		
				String dataValidade = JOptionPane.showInputDialog(msg + "\n\nDATA DE VALIDADE (__/__/__):");
				prod.setDataValidade(dataValidade);
		
				list.insert(prod);
				
				JOptionPane.showMessageDialog(null, "PRODUTO CADASTRADO COM SUCESSO!");
			
	}
}