package com.pessoa.repository;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COD_PESSOA")
public class CodPessoaEntity {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_PESSOA")
	private Integer codProduto;
	
	@Column(name = "DT_CREATE")
	private Date dtCriacao;

	public Integer getCod() {
		return codProduto;
	}

	public void setCod(Integer cod) {
		this.codProduto = cod;
	}

	public Date getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}
	
}
