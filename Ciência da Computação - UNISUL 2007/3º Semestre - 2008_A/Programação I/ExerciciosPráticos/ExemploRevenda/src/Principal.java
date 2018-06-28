import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.unisul.aula.exemplorevenda.controller.Revenda;
import br.unisul.aula.exemplorevenda.entidade.*;

/**
 * Classe principal para manipular o programa.
 * @author Fabio Dela Bruna
 * @since 11/05/2008
 */
public class Principal {
	
	public static void main(String[] args) {
		
		//cadastrando cidades
		Cidade cidRevenda = new Cidade();
		cidRevenda.setEstado("Santa Catarina");
		cidRevenda.setNome("Tubarão");
		
		Cidade cidFuncionario = new Cidade();
		cidFuncionario.setEstado("Santa Catarina");
		cidFuncionario.setNome("Pedras Grandes");
		
		Cidade cidCliente = new Cidade();
		cidCliente.setEstado("Santa Catarina");
		cidCliente.setNome("Criciúma");
				
		//cadastrando a revenda
		Revenda rev = new Revenda();
		rev.setCidade(cidRevenda);
		rev.setEndereco("Rua Pio X");
		rev.setNome("Revenda Lata Velha");
		rev.setSite("http://www.prejuizo.com");
		rev.setTelefone("(48)3632-5555");
		
		//inserindo as cidades no arrayList de cidades
		rev.cadastraCidade(cidRevenda);
		rev.cadastraCidade(cidFuncionario);
		rev.cadastraCidade(cidCliente);
		
		//mostrando as cidades cadastradas
		//considerando que só há uma cadastrada
		//caso contrário seria necessário um 'for'
		System.out.println(".:| CIDADES CADASTRADAS |:.\n");
		System.out.println(rev.mostraCidades());
		System.out.println("=========================================================\n\n");
		
		//cadastrando um funcionário
		Funcionario f1 = new Funcionario();
		f1.setCodigo(100);
		f1.setNome("José Almeida");
		f1.setCpf("4349843793");
		
		Date dataAdmissao = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dataAdmissao = sdf.parse("23/04/1989");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String dataAux = sdf.format(dataAdmissao);
		f1.setDataAdmissao(dataAux);
		
		f1.setSexo('M');
		f1.setEndereco("Rua dos trovões");
		f1.setCidade(cidFuncionario);
		f1.setFone1("(48)3847-9283");
		rev.cadastraFuncionario(f1);
		
		//mostrando os funcionários cadastrados
		//considerando que só há um cadastrado
		//caso contrário seria necessário um 'for'
		System.out.println(".:| FUNCIONÁRIOS CADASTRADOS |:.");
		System.out.println(rev.mostraFuncionarios());
		System.out.println("=========================================================\n\n");
		
		//cadastrando um carro
		Carro c1 = new Carro();
		c1.setCodigo(500);
		c1.setAirbag(true);
		c1.setAnoFabricacao(2007);
		c1.setAnoModelo(2008);
		c1.setCor("Azul");
		c1.setFreioDisco(true);
		c1.setMarca("Fiat");
		c1.setModelo("UNO");
		c1.setQtdPortas(4);
		c1.setTipoCombustivel("Flex");
		c1.setNumeroChassi("242342342412234");
		c1.setNumeroMotor("23884573993");
		c1.setNumeroRenavam("234523445");
		c1.setPlaca("FDB-2008");
		c1.setValorCompra(20000);
		rev.insereCarro(c1);
		
		//mostrando carros cadastrados
		//considerando que só há um cadastrado
		//caso contrário seria necessário um 'for'
		System.out.println(".:| CARROS CADASTRADOS |:.");
		System.out.println(rev.mostraCarros());
		System.out.println("=========================================================\n\n");
		
		//cadastrando uma moto
		Moto m1 = new Moto();
		m1.setCodigo(700);
		m1.setMarca("Yamaha");
		m1.setModelo("XTZ 125 ED");
		m1.setCor("Vermelha");
		m1.setPartidaEletrica(true);
		m1.setPlaca("FDB-2007");
		m1.setNumeroChassi("834738473834");
		m1.setAnoFabricacao(2006);
		m1.setAnoModelo(2007);
		m1.setTipoCombustivel("Gasolina");
		m1.setValorCompra(8300);
		rev.insereMoto(m1);
		
		//mostrando motos cadastradas
		//considerando que só há uma cadastrada
		//caso contrário seria necessário um 'for'
		System.out.println(".:| MOTOS CADASTRADAS |:.");
		System.out.println(rev.mostraMotos());
		System.out.println("=========================================================\n\n");
		
		//cadastrando um cliente
		Cliente c = new Cliente();
		c.setCodigo(300);
		c.setNome("Maria das Dores");
		c.setCpf("234523464");
		c.setSexo('F');
		c.setEndereco("Avenida das Flores");
		c.setCidade(cidCliente);
		c.setFone1("(48)3659-3421");
		c.setFone2("(48)9966-7109");
		c.setClassificacao('C');
		rev.cadastraCliente(c);
		
		//cadastrando outro cliente
		Cliente c3 = new Cliente();
		c3.setCodigo(300);
		c3.setNome("Maria das Dores");
		c3.setCpf("234523464");
		c3.setSexo('F');
		c3.setEndereco("Rua Alameda");
		c3.setCidade(cidCliente);
		c3.setFone1("(48)3659-2345");
		c3.setFone2("(48)9966-7109");
		c3.setClassificacao('B');
		
		//mostra os clientes cadastrados
		//considerando que só há um cadastrado
		//caso contrário seria necessário um 'for'
		System.out.println(".:| CLIENTES CADASTRADOS |:.");		
		System.out.println(rev.mostraClientes());
		System.out.println("=========================================================\n\n");
		
		//efetuando uma venda
		Venda v = new Venda();
		v.setCodigo(1);
		v.setCliente("Maria das Dores");
		
		Date dataSistema = new Date();
		v.setDataVenda(dataSistema);
		
		v.setValorVenda(15000);
		v.setObservacoes("É preciso tomar cuidado com essa velhinha!");
		rev.efetuaVenda(v);
		
		//mostra as vendas efetuadas 
		//considerando que só há uma cadastrada
		//caso contrário seria necessário um 'for'
		System.out.println(".:| VENDAS EFETUADAS |:.");
		System.out.println(rev.mostraVendas());
		System.out.println("=========================================================\n\n");
		
		
		//buscando um cliente específico
		System.out.println(".:| BUSCANDO UM CLIENTE ESPECÍFICO |:.");
		System.out.println(rev.buscaCliente("Maria das Dores", "234523464"));
		System.out.println("=========================================================\n\n");
	
		//atualizando os dados de um cliente
		rev.atualizaCliente(c3, c);
		
		//mostrando o cliente depois de seus dados serem atualizados
		//considerando que só há um cliente cadastrado
		//caso contrário seria necessário um 'for'.
		System.out.println(".:| CLIENTES CADASTRADOS |:.");
		System.out.println(rev.mostraClientes());
		System.out.println("=========================================================\n\n");
		
		//removendo um carro da revenda
		rev.removeCarro(c1);
		
		//mostrando os carros da revenda
		//sendo que desta vez não há nenhum cadastrado.
		System.out.println(".:| CARROS CADASTRADOS |:.");
		if(rev.getCarros().size() > 0)
			System.out.println(rev.mostraCarros());
		else
			System.out.println("NÃO HÁ CARROS CADASTRADOS");
				
		System.out.println("=========================================================");
		
		
	}

}
