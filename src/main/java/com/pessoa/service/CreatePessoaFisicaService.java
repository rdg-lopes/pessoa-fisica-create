package com.pessoa.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pessoa.repository.CodPessoaEntity;
import com.pessoa.repository.CodPessoaRepository;
import com.pessoa.repository.PessoaFisicaEntity;
import com.pessoa.repository.PessoaFisicaRepository;

@Service
public class CreatePessoaFisicaService {

	@Autowired
	private PessoaFisicaRepository pessoaFisicaRepository;
	
	@Autowired
	private CodPessoaRepository codigoPessoaRepository;
	
	public PessoaFisicaModel criarPessoaFisica(PessoaFisicaInputModel pessoa) {
		Optional<PessoaFisicaEntity> entity = this.pessoaFisicaRepository.findByCpf(pessoa.getCpf());
		if(entity.isPresent()) {
			throw new ModelJaExisteException(pessoa);
		}
		PessoaFisicaEntity newEntity = new PessoaMapper().toEntity(pessoa);
		newEntity.setTpPessoa(TipoPessoa.FISICA.getCodigo());
		newEntity.setCodPessoa(newCodigoPessoa());
		this.pessoaFisicaRepository.save(newEntity);
		return new PessoaMapper().map(newEntity);
	}
	
	private Integer newCodigoPessoa() {
		CodPessoaEntity newCodigo = new CodPessoaEntity();
		newCodigo.setDtCriacao(new Date());
		codigoPessoaRepository.save(newCodigo).getCod();
		return newCodigo.getCod();
	}
	
}
