package com.pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodPessoaRepository extends JpaRepository<CodPessoaEntity, Long> {

}
