package revenda.gui;

import revenda.domain.Montadora;
import revenda.service.MontadoraService;
import framework.gui.CadastrarEditarBase;
import framework.gui.components.TextFieldBase;
import framework.service.ServiceBase;

/**
 * Classe que serve para efetuar tanto um cadastro de uma montadora,
 * Como também serve para editar o cadastro da mesma. Por isso o
 * Título da Janela é passado por parâmetro.
 * 
 * @author Fabio Dela Bruna
 *
 */
public class CadastrarEditarMontadora extends CadastrarEditarBase {

	private static final long serialVersionUID = 1L;
	

	/**
	 * Construtor com parâmetros.
	 * @param m Objeto do tipo Montadora.
	 * @param title Título do jDialog.
	 */
	public CadastrarEditarMontadora(Montadora m, String title) {
		super(m, title);
	}
	
	/**
	 * Construtor default.
	 * @param title Título do jDialog.
	 */
	public CadastrarEditarMontadora(String title) {
		super(title);
	}



	@Override
	protected ServiceBase createServiceBase() throws Exception {
		return new MontadoraService();
	}

	@Override
	protected Object getAtributosTextFields(TextFieldBase[] textFieldVector, String[] labels) {
		Montadora m = new Montadora();
		for (int i = 0; i < textFieldVector.length; i++) {
			if (labels[i].equalsIgnoreCase("Código"))
				m.setCdMontadora(Integer.parseInt(textFieldVector[i].getText()));
			if (labels[i].equalsIgnoreCase("Descrição"))
				m.setDsMontadora(textFieldVector[i].getText());
		}
		return m;
	}

	@Override
	protected String getLabels() {
		return "Código,Descrição";
	}

	@Override
	protected String setaAtributosTextFields(Object obj, String label) {
		Montadora m = (Montadora) obj;
		
		if (label.equalsIgnoreCase("Código"))
			return String.valueOf(m.getCdMontadora());
		if (label.equalsIgnoreCase("Descrição"))
			return m.getDsMontadora();
		
		return "";
	}
	
	
}
