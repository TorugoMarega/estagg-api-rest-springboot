package br.com.estagginc.estagg_api.repository;
import br.com.estagginc.estagg_api.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}