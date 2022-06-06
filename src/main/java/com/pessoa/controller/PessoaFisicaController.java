package com.pessoa.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pessoa.service.CreatePessoaFisicaService;
import com.pessoa.service.PessoaFisicaInputModel;
import com.pessoa.service.PessoaFisicaModel;

@RestController
@RequestMapping("/v1/PessoaFisica")
public class PessoaFisicaController {

	@Autowired
	private CreatePessoaFisicaService createPessoaService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
				 produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PessoaFisicaDTO> create(@RequestBody PessoaFisicaInputDTO dto, HttpRequest request){
		PessoaFisicaInputModel model = new PessoaMapper().map(dto);
		PessoaFisicaModel modelCriado = this.createPessoaService.criarPessoaFisica(model);
		PessoaFisicaDTO dtoResult = new PessoaMapper().map(modelCriado);
		return ResponseEntity.created(newUri(request, dtoResult)).body(dtoResult);
	}

	private URI newUri(HttpRequest request, PessoaFisicaDTO dtoResult) {
		return UriComponentsBuilder.fromHttpRequest(request)
								   .path("/")
								   .path(dtoResult.getCodigo().toString())
								   .build().toUri();
	}

}
