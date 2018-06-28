//import java.io.Serializable;

public class Atleta /*implements Serializable*/ {
	
	private int codigo;
	private String nome;
	private double altura;
	
	public static final int TAM_REGISTRO = 52;
	public static final int TAM_NOME = 20;
	
	public Atleta() {
		this(0, "", 0.0);
	}
	
	public Atleta(int codigo, String nome, double altura) {
		this.codigo = codigo;
		this.nome = nome;
		this.altura = altura;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return codigo + "\t" + nome + "\t" + altura;
	}
}