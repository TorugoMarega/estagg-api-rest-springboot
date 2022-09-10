package br.com.estagginc.estagg_api.service;

import br.com.estagginc.estagg_api.model.Person;
import br.com.estagginc.estagg_api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.OrderBy;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    @OrderBy(value = "id")
    public List<Person> findAll(){
        return (List<Person>) repository.findAll();
    }

    public Person create(Person person){
        return repository.save(person);
    }
}
