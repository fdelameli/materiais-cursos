package br.com.napoleao.teste.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VENDA_ITEM")
public class VendaItemEntity implements Serializable{

//	@EmbeddedId
//	private VendaItemId vendaItId;

	@Id
	@ManyToOne
	@JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID")
	private ProdutoEntity produto;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ID_VENDA", referencedColumnName = "ID")
	private VendaEntity venda;
	
	@Column
	private Integer qtd;

	
	
	
//	public VendaItemId getVendaItId() {
//		return vendaItId;
//	}
//
//	public void setVendaItId(VendaItemId vendaItId) {
//		this.vendaItId = vendaItId;
//	}

	public ProdutoEntity getProduto() {
		return produto;
	}

	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}

	public VendaEntity getVenda() {
		return venda;
	}

	public void setVenda(VendaEntity venda) {
		this.venda = venda;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
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
		VendaItemEntity other = (VendaItemEntity) obj;
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
