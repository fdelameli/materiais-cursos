public class PrincipalContaBancaria {
	
	public static void main(String[] args) {
		
		ContaBancaria conta = new ContaBancaria();
		ContaBancaria contaDestino = new ContaBancaria();
		
		conta.depositar(1000);
		
		//conta.depositar(-200);
		//conta.retirar(-100);
		try {
			conta.transferir(contaDestino, 1020);
		} catch (ExcecaoSaldoInsuficiente esi) {
			System.out.println(esi.getMessage());
		}
	}

}