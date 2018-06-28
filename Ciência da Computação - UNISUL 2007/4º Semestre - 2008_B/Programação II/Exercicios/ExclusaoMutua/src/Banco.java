	
	/**
	 * Classe interna para simular as operações de um caixa eletrônico.
	 */
	public class Banco {
		
		/**
		 * Variável que guarda o valor do saldo.
		 */
		private double saldo;
		
		
		
		/**
		 * Construtor default.
		 */
		public Banco() {
			this.saldo = 0;
		}
		
		
		
		/**
		 * Método que retorna o saldo disponível.
		 */
		public double verificaSaldo() {
			return this.saldo;
		}
		
		/**
		 * Método para efetuar um saque.
		 */
		public boolean saque(double valor) {
			
			boolean efetuado = false;
			
			if (valor <= 0) {

			} else {
				
				if (this.saldo >= valor) {
					this.saldo -= valor;
					efetuado = true;
				} else {
				}
			}
				
			return efetuado;
		}
		
		/**
		 * Método para efetuar um depósito.
		 */
		public boolean deposito(double valor) {
			
			boolean efetuado = false;
			
			if (valor > 0) {
				this.saldo += valor;
				efetuado = true;				
			}
			
			return efetuado;
		}
		
}
	