package br.unisul.projeto.view.backbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean(name = "exemploCombo")
@ViewScoped
public class ExemploComboBack {

	private String estado;
	
	private String cidade;
	
	private List<SelectItem> listCidade;

	//Metodo executado qndo um item e selecionado
	public void consultaCidade(){
		//Estas listas seriam buscadas do banco conforme o parametro selecionado
		if(estado.equals("SC")){
			listCidade = new ArrayList<SelectItem>();
			listCidade.add(new SelectItem("Tubarão", "Tubarão"));
			listCidade.add(new SelectItem("Florianópolis", "Florianópolis"));
		}else if(estado.equals("RS")){
			listCidade = new ArrayList<SelectItem>();
			listCidade.add(new SelectItem("Porto Alegre", "Porto Alegre"));
			listCidade.add(new SelectItem("Alegrete", "Alegrete"));
		}else if(estado.equals("PR")){
			listCidade = new ArrayList<SelectItem>();
			listCidade.add(new SelectItem("Curitiba", "Curitiba"));
			listCidade.add(new SelectItem("Foz do Iguaçu", "Foz do Iguaçu"));
		}
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public List<SelectItem> getListCidade() {
		return listCidade;
	}

	public void setListCidade(List<SelectItem> listCidade) {
		this.listCidade = listCidade;
	}
}
