package br.com.estagginc.estagg_api.repository;

import br.com.estagginc.estagg_api.model.Cargo;
import br.com.estagginc.estagg_api.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository <Pessoa, Long>{
    List<Pessoa> findByNome(String nome);
    List<Pessoa> findByDeletedTrue();
    List<Pessoa> findByDeletedFalse();
}
