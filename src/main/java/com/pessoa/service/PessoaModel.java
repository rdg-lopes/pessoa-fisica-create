package com.pessoa.service;

public abstract class PessoaModel implements Model {

	private Integer codPessoa;
	private TipoPessoa tipoPessoa;

	public Integer getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(Integer codPessoa) {
		this.codPessoa = codPessoa;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
}
