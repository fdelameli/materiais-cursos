
public class Livro extends Produto {
	
	//atributos
	
	private String autor;
	private String isbn;
	
	
	//construtores
	
	public Livro() {
		super();
		this.autor = "";
		this.isbn = "";
	}


	public Livro(int codigo, String descricao, int qtdEstoque, double preco, String autor, String isbn) {
		super(codigo, descricao, qtdEstoque, preco);
		this.autor = autor;
		this.isbn = isbn;
	}


	//getters e setters
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	

}
