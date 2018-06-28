package entitys;

public class Curriculo {
	private int codigo;
	private String nome;
	private String endereco;
	private int telefone;
	private int idade;
	private int quantidadeFilhos;
	private char sexo;

	private char ensinoMedio;
	private String cursoSuperior;
	private String cursos;

	private String empresa;
	private String cargo;
	private double salario;
	private String motivoSaida;
	
	
	private int areaPretendida;
	private double salarioPretendido;

	
	/*
	 * O Método toString() irá retornar o candidato e seu currículo após ser pesquisado.
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		
		return "Código: " + this.codigo + "\nNome: " + this.nome +"\nEndereco: " + this.endereco+"\nTelefone: "
		+ this.telefone+"\nIdade: " + this.idade+"\nQuantidade de filhos: " + this.quantidadeFilhos
		+"\nSexo: " + this.sexo+"\nEnsinoMedio: " + this.ensinoMedio+"\nCurso superior: " + this.cursoSuperior
		+"\nCursos: " + this.cursos+"\nEmpresa anterior: " + this.empresa+"\nCargo na empres anterior: " + this.cargo
		+"\nSalário anterior recebido: " + this.salario+"\nMotivo da saída: " + this.motivoSaida
		+"\nAreaPretendida: " + converteAreaPretendida() + "\nSalario Pretendido: " + this.salarioPretendido;
	}
	
	private String converteAreaPretendida() {
		if(this.areaPretendida == 1){
			return "Adminitrativo";
		}else if(areaPretendida == 2){
			return "Contabilidade";
		}else if(areaPretendida == 3){
			return "Programador";
		}else if(areaPretendida == 4){
			return "Banco de datos";
		}else if(areaPretendida == 5){
			return "Suporte";
		}else{
			return "";
		}
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getQuantidadeFilhos() {
		return quantidadeFilhos;
	}

	public void setQuantidadeFilhos(int quantidadeFilhos) {
		this.quantidadeFilhos = quantidadeFilhos;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public char getEnsinoMedio() {
		return ensinoMedio;
	}

	public void setEnsinoMedio(char ensinoMedio) {
		this.ensinoMedio = ensinoMedio;
	}

	public String getCursoSuperior() {
		return cursoSuperior;
	}

	public void setCursoSuperior(String cursoSuperior) {
		this.cursoSuperior = cursoSuperior;
	}

	public String getCursos() {
		return cursos;
	}

	public void setCursos(String cursos) {
		this.cursos = cursos;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getMotivoSaida() {
		return motivoSaida;
	}

	public void setMotivoSaida(String motivoSaida) {
		this.motivoSaida = motivoSaida;
	}
	
	public void setAreaPretendida(int areaPretendida) {
		this.areaPretendida = areaPretendida;
	}
	
	public int getAreaPretendida() {
		return areaPretendida;
	}
	
	public void setSalarioPretendido(double salarioPretendido) {
		this.salarioPretendido = salarioPretendido;
	}
	
	public double getSalarioPretendido() {
		return salarioPretendido;
	}
	
	/*
	 * Construtor Currículo:
	 */
	public Curriculo(int codigo, String nome, String endereco, int telefone,
			int idade, int quantidadeFilhos, char sexo, char ensinoMedio,
			String cursoSuperior, String cursos, String empresa, String cargo,
			double salario, String motivoSaida, int areaPretendida, double salarioPretendido) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.idade = idade;
		this.quantidadeFilhos = quantidadeFilhos;
		this.sexo = sexo;
		this.ensinoMedio = ensinoMedio;
		this.cursoSuperior = cursoSuperior;
		this.cursos = cursos;
		this.empresa = empresa;
		this.cargo = cargo;
		this.salario = salario;
		this.motivoSaida = motivoSaida;
		this.areaPretendida = areaPretendida;
		this.salarioPretendido = salarioPretendido;
	}
	/*
	 *Construtor Currículo: 
	 */
	
	public Curriculo(String nome, String endereco, int telefone,
			int idade, int quantidadeFilhos, char sexo, char ensinoMedio,
			String cursoSuperior, String cursos, String empresa, String cargo,
			double salario, String motivoSaida, int areaPretendida, double salarioPretendido) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.idade = idade;
		this.quantidadeFilhos = quantidadeFilhos;
		this.sexo = sexo;
		this.ensinoMedio = ensinoMedio;
		this.cursoSuperior = cursoSuperior;
		this.cursos = cursos;
		this.empresa = empresa;
		this.cargo = cargo;
		this.salario = salario;
		this.motivoSaida = motivoSaida;
		this.areaPretendida = areaPretendida;
		this.salarioPretendido = salarioPretendido;
	}
	
	
	/*
	 * Construtor vazio de Currículo:
	 */
	public Curriculo() {
		this(0, "", "", 0, 0, 0, ' ', ' ', "", "", "", "", 0.0, "", 0, 0.0);
	}

}
