package br.com.estagginc.estagg_api.service;

import br.com.estagginc.estagg_api.model.Person;
import br.com.estagginc.estagg_api.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public List<Person> findAllDeletedFalse() {
        return (List<Person>) repository.findByDeletedFalse();
    }

    public List<Person> findAll() {
        return (List<Person>) repository.findAll();
    }

    public Optional<Person> create(Person person){
         this.repository.save(person);
        return repository.findById(person.getId());
    }

    public Person update(Long id, Person occupation) {
        Person updatePerson = repository.findById(id).get();
        BeanUtils.copyProperties(occupation, updatePerson);
        return repository.save(updatePerson);
    }

    public Person delete(Long id) {
        Person deletedPerson = repository.findById(id).get();
        deletedPerson.setDeleted(true);
        return deletedPerson;
    }

    //-----------------------------QUERY WITH FILTERS-------------------------------------

    public Optional<Person> findById(Long id) {
        return repository.findById(id);
    }

    public List<Person> findByNameContaining(String name) {
        return repository.findByNameContaining(name);
    }

    public List<Person> findByOccupationNameContaining(String occupation_name){
        return repository.findByOccupationNameContaining(occupation_name);
    }
    //-----------------------------QUERY RETURN BOOLEAN-------------------------------------
    public Boolean existsById(Long id){
        return repository.existsById(id);
    }
}
