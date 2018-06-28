package entidades;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Classe que represenra um cliente de classificação especial.
 * @author Fabio Dela Bruna / Carlos Henrique Sá
 */
public class ClienteEspecial extends Cliente {	

	//construtores
	
	public ClienteEspecial() {
		super();
	}

	public ClienteEspecial(int codigo, String nome, String sobrenome, String cpf, Endereco endereco, GregorianCalendar dataNascimento, String fone1, String fone2, ArrayList<Estadia> estadias) {
		super(codigo, nome, sobrenome, cpf, endereco, dataNascimento, fone1, fone2, estadias);
	}


	//métodos principais
	
	@Override
	public double calculaValorEstadia() {
		double valor = 0;
		for (Estadia e : this.getEstadias()) {
			valor += e.getQuantidadeDias() * e.getQuarto().getValorDiaria();
		}
		return valor;		
	}
	
	public void cadastraEstadia(Estadia e){
		this.getEstadias().add(e);
	}
	
	
	//toString
	
	public String toString(){
		return String.format("%sValor a ser pago: %s\n", super.toString(), calculaValorEstadia());
	}
	
}
