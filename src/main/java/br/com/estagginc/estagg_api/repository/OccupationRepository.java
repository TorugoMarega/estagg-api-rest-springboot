package br.com.estagginc.estagg_api.repository;

import br.com.estagginc.estagg_api.model.Occupation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OccupationRepository extends CrudRepository<Occupation, Long> {
    List<Occupation> findByDeletedFalse();

    List<Occupation> findByNameContaining(String name);
}
