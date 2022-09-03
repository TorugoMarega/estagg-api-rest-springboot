package br.com.estagginc.estagg_api.repository;

import br.com.estagginc.estagg_api.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository <Pessoa, Long>{}
