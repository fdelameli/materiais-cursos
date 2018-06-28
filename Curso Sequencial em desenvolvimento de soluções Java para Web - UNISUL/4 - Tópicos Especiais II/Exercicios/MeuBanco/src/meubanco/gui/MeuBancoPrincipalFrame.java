package meubanco.gui;

import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;

import meubanco.service.PessoaService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import framework.gui.ListFrameBase;
import framework.gui.PrincipalFrameBase;
import framework.gui.components.MenuBase;
import framework.gui.components.MenuItemBase;
import framework.gui.util.Messages;

public class MeuBancoPrincipalFrame extends PrincipalFrameBase {

	private static final long serialVersionUID = 1L;
	
	private PessoaList pessoaList;

	private MenuItemBase menuItemPessoa;
	private MenuItemBase menuItemRelatorioPessoa;
	Logger log = Logger.getLogger(MeuBancoPrincipalFrame.class);
	
	
	/**
	 * Construtor default.
	 */
	public MeuBancoPrincipalFrame () {
		super("Meu Banco");
	}
	
	
	/**
	 * Este método monta um relatório.
	 */
	private void montaRelatorio() {
		try {
			// Pega o esqueleto do relatório
			JasperReport esqueletoRelatorio = (JasperReport)JRLoader.loadObject(
					getClass().getResourceAsStream("/report/RelPessoa.jasper"));
			
			// Transforma a lista em DataSourse.
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(new PessoaService().findAll());
			
			// Preenche o relatório com os dados.
			JasperPrint relatorioFinal = JasperFillManager.fillReport(esqueletoRelatorio, null, ds);
			
			// Gera o relatório em arquivo PDF
//			JasperExportManager.exportReportToPdfFile(relatorioFinal, "RelPessoa.pdf");
			
			log.info("Relatório montado com sucesso");
			
			// Visualiza o relatório no visualizador padrão do Jasper.
			JasperViewer.viewReport(relatorioFinal, false);
			
		} catch (Exception e) {
			log.error(e);
			Messages.showError("Erro ao montar Relatório");
			e.printStackTrace();
		}
	}
		
	

	@Override
	protected ListFrameBase menuItemClick(Object source) {
		if (source == menuItemPessoa) {
			if (pessoaList != null) {
				pessoaList.dispose();
				pessoaList = null;
			}
			pessoaList = new PessoaList();
			pessoaList.showList();
			return pessoaList;
		}
		if (source == menuItemRelatorioPessoa) {
			montaRelatorio();
		}
		return null;
	}


	@Override
	protected void montaMenuCadastro(MenuBase menuCadastro) {
		menuItemPessoa = new MenuItemBase("Pessoa");
		menuItemPessoa.setMnemonic(KeyEvent.VK_P);
		menuItemPessoa.addActionListener(this);
		menuCadastro.add(menuItemPessoa);
	}
	
	@Override
	protected void montaMenuRelatorio(MenuBase menuRelatorio) {
		menuItemRelatorioPessoa = new MenuItemBase("Relatório de Pessoas");
		menuItemRelatorioPessoa.setMnemonic(KeyEvent.VK_P);
		menuItemRelatorioPessoa.addActionListener(this);
		menuRelatorio.add(menuItemRelatorioPessoa);
		
	}

}
