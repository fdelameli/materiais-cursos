package br.com.napoleao.teste.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class VendaItemId implements Serializable{

	@ManyToOne
	@JoinColumn(name = "id_venda", referencedColumnName = "id")
	private VendaEntity venda;
	
	@ManyToOne
	@JoinColumn(name = "id_produto", referencedColumnName = "id")
	private ProdutoEntity produto;

	public VendaEntity getVenda() {
		return venda;
	}

	public void setVenda(VendaEntity venda) {
		this.venda = venda;
	}

	public ProdutoEntity getProduto() {
		return produto;
	}

	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((venda == null) ? 0 : venda.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendaItemId other = (VendaItemId) obj;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (venda == null) {
			if (other.venda != null)
				return false;
		} else if (!venda.equals(other.venda))
			return false;
		return true;
	}
}
