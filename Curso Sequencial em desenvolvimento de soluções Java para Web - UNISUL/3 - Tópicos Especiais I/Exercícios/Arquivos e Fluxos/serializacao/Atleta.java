package serializacao;
import java.io.Serializable;

public class Atleta implements Serializable {
	

	private static final long serialVersionUID = 0;
	private int code;
	private String nome;
	private double altura;
	
	
	public Atleta() {
		this(0, "", 0.0);
	}
	
	public Atleta(int code, String nome, double altura) {
		this.code = code;
		this.nome = nome;
		this.altura = altura;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return this.code + "\t" + this.nome + "\t" + this.altura;
	}
}