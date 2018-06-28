import java.util.ArrayList;

/**
 * Classe que controla a eleição.
 * @author Fabio Dela Bruna
 * @created 31-mai-2008 16:29:21
 */
public class Eleicao {

	//atributos
	
	private ArrayList<Eleitor> eleitores;
	private ArrayList<Candidato> candidatos;
	private ArrayList<Partido> partidos;

	
	//construtores
	
	public Eleicao(){
		this(new ArrayList<Eleitor>(), new ArrayList<Candidato>(), new ArrayList<Partido>());
	}

	public Eleicao(ArrayList<Eleitor> eleitores, ArrayList<Candidato> candidatos, ArrayList<Partido> partidos) {
		super();
		this.eleitores = new ArrayList<Eleitor>();
		this.candidatos = new ArrayList<Candidato>();
		this.partidos = new ArrayList<Partido>();
	}


	//métodos principais

	public Candidato candidatoMaisVotado(){
		Candidato temp = new Candidato();
		int quantidade = 0;
		
		for (Candidato c : this.candidatos) {
			if(c.getQuantidadeVotos() > quantidade)
				temp = c;
		}
		return temp;
	}

	
	public Partido partidoMaisVotado(){
		Partido temp = new Partido();
		int quantidade = 0;
		
		for (Partido p : this.partidos) {
			if(p.getQuantidadeVotos() > quantidade)
				temp = p;
		}
		return temp;
	}

	
	public int numeroTotalVotos(){
		int tempQtd = 0;
		
		for (Partido p : this.partidos) {
			tempQtd += p.getQuantidadeVotos();
		}
		return tempQtd;
	}


	public boolean incluiPartido(Partido partido){
		this.partidos.add(partido);
		return true;
	}


	public boolean incluiCandidato(Candidato candidato){
		this.candidatos.add(candidato);
		return true;
	}


	public boolean incluiEleitor(Eleitor eleitor){
		this.eleitores.add(eleitor);
		return true;
	}
	
	
	//getters e setters

	public ArrayList<Eleitor> getEleitores() {
		return eleitores;
	}

	public void setEleitores(ArrayList<Eleitor> eleitores) {
		this.eleitores = eleitores;
	}

	public ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(ArrayList<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public ArrayList<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(ArrayList<Partido> partidos) {
		this.partidos = partidos;
	}

}