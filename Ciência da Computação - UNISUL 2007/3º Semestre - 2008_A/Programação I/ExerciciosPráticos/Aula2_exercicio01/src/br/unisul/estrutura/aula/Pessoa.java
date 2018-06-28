package br.unisul.estrutura.aula;

/**
 * Esta classe representa uma pessoa dentro do contexto bancário.
 * @author Fabio Dela Bruna
 * @since 26/02/2008
 */
public class Pessoa extends Humano{
	
	private String nome;
	private char sexo;
	private int idade;
	private String cpf;
	private String rg;
	
	
		/**
		 * Construtor default.
		 */
		public Pessoa(){
			super();
		}
	
		
		/**
		 * Construtor com parametros.
		 * 
		 * @param nome Nome
		 * @param sexo Sexo
		 * @param idade Idade
		 * @param cpf Cpf
		 * @param rg RG
		 */
		public Pessoa (String nome, char sexo, int idade, String cpf, String rg){
			super();
			this.nome = nome;
			this.sexo = sexo;
			this.idade = idade;
			this.cpf = cpf;
			this.rg = rg;
		}
		
		
		/**
		 * Verifica o tipo da respiracao.
		 * @return the aux
		 */
		public String verificaRespiracao()
		{
			String aux = super.getTipoRespiracao();
			return aux;
		}
		
		/**
		 * @return the cpf
		 */
		public String getCpf() {
			return cpf;
		}

		
		/**
		 * @param cpf the cpf to set
		 */
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		
		/**
		 * @return the idade
		 */
		public int getIdade() {
			return idade;
		}

		
		/**
		 * @param idade the idade to set
		 */
		public void setIdade(int idade) {
			this.idade = idade;
		}

		
		/**
		 * @return the nome
		 */
		public String getNome() {
			return nome;
		}

		
		/**
		 * @param nome the nome to set
		 */
		public void setNome(String nome) {
			this.nome = nome;
		}

		
		/**
		 * @return the rg
		 */
		public String getRg() {
			return rg;
		}

		
		/**
		 * @param rg the rg to set
		 */
		public void setRg(String rg) {
			this.rg = rg;
		}

		
		/**
		 * @return the sexo
		 */
		public char getSexo() {
			return sexo;
		}

		
		/**
		 * @param sexo the sexo to set
		 */
		public void setSexo(char sexo) {
			this.sexo = sexo;
		}
		
}
