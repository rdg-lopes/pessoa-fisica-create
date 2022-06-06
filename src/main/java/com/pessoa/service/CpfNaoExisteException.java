package com.pessoa.service;

public class CpfNaoExisteException extends ApplicationException {

	private static final long serialVersionUID = 1L;
	
	private String cpf;
	
	public CpfNaoExisteException(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String getMessage() {
		return "CPF "+this.cpf+" não existe no sistema.";
	}

}
