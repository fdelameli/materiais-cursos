public class ContaBancaria {

	// variáveis de instância (atributos)
	private long numero;
	private String nome;
	private double saldo;

	// variáveis de classe
	private static double taxaJuros = 2.0;

	// construtor padrão
	public ContaBancaria() {
		this(0, "", 0.0);
	}
	
	// construtor no qual se passam dois parâmetros
	public ContaBancaria(long numero, String nome) {
		this(numero, nome, 0.0);
	}	
	
	// construtor no qual se passam três parâmetros
	public ContaBancaria(long numero, String nome, double saldo) {
		this.numero = numero;
		this.nome = nome;
		this.saldo = saldo;
	}

	// método para realizar um depósito
	public double depositar(double valor) {
		if (valor < 0) // valor do depósito é negativo
			throw new ExcecaoValorInvalido("Erro: Valor do depósito é inválido!");
		saldo = saldo + valor;
		return saldo;
	}

	// método para realizar uma retirada
	public double retirar(double valor) {
		if (valor < 0) // valor do saque é negativo
			throw new ExcecaoValorInvalido("Erro: Valor do saque é inválido!");
		if (valor > saldo) // valor do saque é maior do que o saldo
			throw new ExcecaoValorInvalido("Erro: saldo insuficiente!");
		saldo = saldo - valor;
		return saldo;
	}
	
	// método para realizar uma transferência
	public double transferir(ContaBancaria contaDestino, double valor) throws ExcecaoSaldoInsuficiente{
		if (valor < 0) // valor da tranferência é negativo
			throw new ExcecaoValorInvalido("Erro: Valor da transferência é inválido!");
		if (valor > saldo) // valor da transferência é maior do que o saldo
			throw new ExcecaoSaldoInsuficiente("Erro: saldo insuficiente!");
		saldo = saldo - valor;
		return saldo;
	}	
	
	//método sobrecarregado para adicionar os juros
	public double adicionaJuros(double taxa) {
		saldo = saldo + (saldo * (taxa/100) );
		return saldo;
	}
	
	//método sobrecarregado para adicionar os juros
	public double adicionaJuros() {
		saldo = saldo + (saldo * (taxaJuros/100) );
		return saldo;
	}	

	//método para obter o número da conta
	public long getNumero() {
		return this.numero;
	}

	//método para atualizar o número da conta
	public void setNumero(long numero) {
		this.numero = numero;
	}
	
	//método para obter o nome do cliente
	public String getNome() {
		return this.nome;
	}

	//método para atualizar o nome do cliente
	public void setNome(String nome) {
		this.nome = nome;
	}	
	
	//método para obter o saldo da conta
	public double getSaldo() {
		return this.saldo;
	}

	// método estático para atualizar a taxa de juros
	public static void setTaxaJuros(double taxa) {
		taxaJuros = taxa;
	}
	
	// método estático para retornar a taxa de juros
	public static double getTaxaJutos() {
		return taxaJuros;
	}
	
	//método para criar uma representação literal da conta
	public String toString() {
		return ("Conta Bancaria: " + numero + "\t" + nome + "\t" + saldo);
	}

	//método para verificar se duas contas bancárias são iguais
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof ContaBancaria) {
			ContaBancaria conta = (ContaBancaria) obj;
			return this.numero == conta.numero
				&& this.nome.equals(conta.nome)
				&& this.saldo == conta.saldo;
		}
		return false;
	}
}