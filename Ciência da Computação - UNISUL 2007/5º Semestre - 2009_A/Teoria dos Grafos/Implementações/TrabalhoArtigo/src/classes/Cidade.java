package classes;
import java.util.Iterator;
import java.util.Vector;

	/**
	 * Classe responsável pela representação de uma cidade num grafo.
	 * 
	 * @author Fabio Dela Bruna, Márcio Ozório Teixeira
	 */
	public class Cidade {

	private String nomeCidade = "";
	private Vector<Rota> rotas = new Vector<Rota>();
	private Cidade cidadeAnterior;
	//Variável que armazena o custo atual do caminho partindo da fonte.
	private double distancia = Caminho.valorInfinito;

	//Contrutor com paramâtros
	public Cidade(String nomeCidade) {
		this.setNomeCidade(nomeCidade);
	}

	//Métodos

	
	/**
	 * Método responsável por adicionar uma rota para uma cidade.
	 * @param rota, nova rota na qual a cidade estara sendo atribuída.
	 */
	public void adicionarRota(Rota rota) {
		if (rota == null) throw new IllegalArgumentException("Parâmetro Inválido - Rota Nula");

		if (this.getRotas().indexOf(rota) == -1)
				this.getRotas().add(rota);
	}

	/**
	 * Método responsável por retornar a distancia de um caminho. 
	 * @param cidadeDestino, cidade na qual o caminho termina
	 * @return distancia de um caminho,ou o valor maximo de um tipo primitivo double, representando que nao encontrou.
	 */
	public double getDistancia(Cidade cidadeDestino) {
		Iterator<Rota> i = this.getRotas().iterator();

		while (i.hasNext()) {
			Rota rota = (Rota) i.next();

			if ((rota.getCidadeOrigem().compareTo(this) == 0 && rota.getCidadeDestino().compareTo(cidadeDestino) == 0)
					|| (rota.getCidadeOrigem().compareTo(cidadeDestino) == 0 && rota.getCidadeDestino().compareTo(this) == 0))
				return rota.getDistancia();
		}
		return Double.MAX_VALUE;
	}

	/**
	 * Método responsavel por verificar as cidades vizinhas a uma cidade.
	 * @return null caso nao existam cidades vizinhas, caso contrario retorna as cidades.
	 */
	public Cidade[] getVizinhas() {
		
		Cidade[] cidades = new Cidade[this.getRotas().size()];
		Iterator<Rota> i = this.getRotas().iterator();

		if (this.getRotas().size() == 0)
			return null;

		int count = 0;
		while (i.hasNext()) {
			Rota rota = (Rota) i.next();
			if (rota.getCidadeOrigem().compareTo(this) == 0)
				cidades[count] = rota.getCidadeDestino();
			else
				cidades[count] = rota.getCidadeOrigem();
			count++;
		}
		return cidades;
	}

	//Getters e Setters

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public String getNomeCidade() {
		return this.nomeCidade;
	}

	public void setRotas(Vector<Rota> rotas) {
		this.rotas = rotas;
	}

	public Vector<Rota> getRotas() {
		return this.rotas;
	}

	public void setCidadeAnterior(Cidade cidadeAnterior) {
		this.cidadeAnterior = cidadeAnterior;
	}

	public Cidade getCidadeAnterior() {
		return this.cidadeAnterior;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public double getDistancia() {
		return this.distancia;
	}

	//Equals

	public boolean equals(Object obj) {
		return this.compareTo(obj) == 0;
	}

	//toString

	public String toString() {
		return this.nomeCidade;
	}

	//CompareTo

	public int compareTo(Object obj) {
		if (obj == null)
			return -1;
		if (obj instanceof Cidade) {
			Cidade cidade = (Cidade) obj;
			return this.getNomeCidade().compareToIgnoreCase(cidade.getNomeCidade());
		} else {
			return -1;
		}
	}
}
