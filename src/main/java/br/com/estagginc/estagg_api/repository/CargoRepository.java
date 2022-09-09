package br.com.estagginc.estagg_api.repository;

import br.com.estagginc.estagg_api.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
    List<Cargo> findByNome(String nome) ;
    List<Cargo> findByDeletedTrue();
    List<Cargo> findByDeletedFalse();
}
