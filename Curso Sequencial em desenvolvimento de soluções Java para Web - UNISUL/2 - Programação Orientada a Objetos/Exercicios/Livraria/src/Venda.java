import java.util.ArrayList;




/**
 * Classe que representa uma venda.
 * @created 31-mai-2008 11:25:42
 * @author Fabio Dela Bruna
 */
public class Venda {
	
	//atributos

	private int codigo;
	private Cliente cliente;
	private String data;
	private ArrayList<ItemVenda> itens;

	
	//construtores
	
	public Venda(){
		this(0, "", new Cliente());
	}
	
	public Venda(int codigo, String data, Cliente cliente) {
		super();
		this.codigo = codigo;
		this.data = data;
		this.cliente = cliente;
		this.itens = new ArrayList<ItemVenda>();
	}


	//métodos do modelo

	public double totalComDesconto(){
		double total = 0.0;
		for (int i = 0; i < this.itens.size(); i++){
			total += itens.get(i).totalItemComDesconto();
		}
		return total;
	}

	public double totalSemDesconto(){
		double total = 0.0;
		for (int i = 0; i < this.itens.size(); i++){
			total += itens.get(i).totalItemSemDesconto();
		}
		return total;
	}

	public boolean incluiItem(ItemVenda item){
		for (int i = 0; i < this.itens.size(); i++) {
			if(this.itens.get(i).equals(item)){
				this.itens.get(i).incrementaQuantidade(item.getQuantidade());
				item.decrementaEstoque();
				return true;
			}
		}
		this.itens.add(item);
		item.decrementaEstoque();
		return false;
	}

	public boolean excluiItem(ItemVenda item){
		if(this.itens.contains(item)){
			item.incrementaEstoque();
		}
		return itens.remove(item);
	}

	public void imprimirVenda(){
		String temp = "Venda: " + this.codigo;
		temp += "\nNome do Cliente: " + this.cliente.getNome();
		temp += "\n     DESCRIÇÃO DOS ÍTENS DA VENDA";
		for (int i = 0; i < this.itens.size(); i++) {
			temp += ("\n" + this.itens.get(i).toString());
		}
		temp += "\nTotal sem Desconto: " + this.totalSemDesconto();
		temp += "\nTotal com Desconto: " + this.totalComDesconto();
		System.out.println(temp);
	}
	
	
	//getters e setters

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public ArrayList<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(ArrayList<ItemVenda> itens) {
		this.itens = itens;
	}

}