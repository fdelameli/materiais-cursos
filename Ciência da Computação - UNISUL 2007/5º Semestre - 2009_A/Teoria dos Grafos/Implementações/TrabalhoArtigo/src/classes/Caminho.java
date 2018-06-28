package classes;
import java.util.*;

/**
 * Classe responsável por representar o caminho mínimo do grafo.
 * 
 * @author Fabio Dela Bruna, Márcio Ozório Teixeira.
 */
public class Caminho {

	public static double valorInfinito = Double.MAX_VALUE;

	private Cidade[] cidades;
	// Vetor de Caminho mínimo reconhecidos.
	private Cidade[] cidadesReconhecidas;
	double distanciaTotal = 0.0;

	//Construtor com parametros
	public Caminho(Cidade[] cidades) {
		this.setCidades(cidades);
	}

	//Getters e Setters

	public void setCidades(Cidade[] cidades) {
		this.cidades = cidades;
	}

	public Cidade[] getCidades() {
		return this.cidades;
	}
	
	public void setDistanciaTotal(double valor) {
		this.distanciaTotal = valor;
	}

	public double getDistanciaTotal() {
		return this.distanciaTotal;
	}

	//Métodos
	
	/**
	 * Método responsavel por verificar se determinada cidade está em cidadesReconhecidas
	 * @param cidade, cidade a ser verificada
	 * @return true caso a cidade esteja incluida no vetor cidadesReconhecidas, caso conrario retorna false.
	 */
	public boolean existeEmCidadesReconhecidas(Cidade cidade) {
		for (int i = 0; i < cidadesReconhecidas.length; i++) {
			if (cidade.compareTo(cidadesReconhecidas[i]) == 0)
				return true;
		}
		return false;
	}

	/**
	 * Método responsável por determinar o menor caminho entre duas cidades.
	 * @param cidadeOrigem, cidade origem a ser verificada.
	 * @param cidadeDestino, cidade destino a ser verificada.
	 * @return null caso nao existam cidades vizinhas, ou retorno, contendo uma lista das cidades que formam o menor caminho. 
	 */
	public Cidade[] menorCaminho(Cidade cidadeOrigem, Cidade cidadeDestino) {
		int i = 0;
		int j = 0;
		Cidade menorCidade = null;
		// Ultima cidade adicionada a cidadesReconhecidas.
		Cidade cidadeAtual = null;

		cidadesReconhecidas = new Cidade[cidades.length];
		cidadesReconhecidas[j++] = cidadeOrigem;

		for (i = 0; i < cidades.length; i++) {
			cidades[i].setDistancia(valorInfinito);
			cidades[i].setCidadeAnterior(null);
		}

		cidadeAtual = cidadeOrigem;

		// Distancia de uma cidade para ela mesmo é inexistente.
		cidadeAtual.setDistancia(0);

		Cidade[] cidadesVizinhas = cidadeAtual.getVizinhas();

		if (cidadesVizinhas == null)
			return null;

		for (i = 0; i < cidadesVizinhas.length; i++)
			cidadesVizinhas[i].setCidadeAnterior(cidadeAtual);

		while (cidadeAtual.compareTo(cidadeDestino) != 0) {
			menorCidade = null;

			for (i = 0; i < cidades.length; i++) {
				if (!existeEmCidadesReconhecidas(cidades[i])) {
					if (menorCidade == null)
						menorCidade = cidades[i];

					if (cidadeAtual.getDistancia() + cidadeAtual.getDistancia(cidades[i]) < cidades[i].getDistancia()) {
						if (cidadeAtual.getDistancia(cidades[i]) < valorInfinito) {
							cidades[i].setDistancia((cidadeAtual.getDistancia() + cidadeAtual.getDistancia(cidades[i])));			
															
							if (cidadeAtual.getDistancia(cidades[i]) < valorInfinito) {
								cidades[i].setCidadeAnterior(cidadeAtual);
							}
						}
					}

					if (cidades[i].getDistancia() < menorCidade.getDistancia()) {
						menorCidade = cidades[i];
					}
				}
			}

			cidadeAtual = menorCidade;
			cidadesReconhecidas[j++] = cidadeAtual;
		}
		
		Stack<Cidade> pilhaCidades = new Stack<Cidade>();
		Cidade[] retorna = new Cidade[cidadesReconhecidas.length];
		cidadeAtual = cidadesReconhecidas[j - 1];
		i = 0;
		
		while (cidadeAtual != null) {
			pilhaCidades.push(cidadeAtual);
			cidadeAtual = cidadeAtual.getCidadeAnterior();
		}

		j = pilhaCidades.size();
		for (i = 0; i < j; i++)
			retorna[i] = (Cidade) pilhaCidades.pop();
		
		return retorna;
	}
}
