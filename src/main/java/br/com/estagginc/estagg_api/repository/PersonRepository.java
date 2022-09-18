package br.com.estagginc.estagg_api.repository;

import br.com.estagginc.estagg_api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByDeletedFalse();

//    List<Person> findByNameContaining(String name);
//    List<Person> findByOccupationNameContaining(String occupation_name);
}
