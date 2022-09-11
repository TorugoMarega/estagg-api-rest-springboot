package br.com.estagginc.estagg_api.controller;

import br.com.estagginc.estagg_api.dto.PersonDTO;
import br.com.estagginc.estagg_api.exception.ResourceNotFoundException;
import br.com.estagginc.estagg_api.model.Person;
import br.com.estagginc.estagg_api.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    private PersonService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<PersonDTO>> findAllDeletedFalse(){
        return new ResponseEntity<>(
                service.findAllDeletedFalse()
                        .stream()
                        .map(this::toPersonDTO)
                        .collect(Collectors.toList()) , HttpStatus.OK);
    }

    @GetMapping("{id}")
    public PersonDTO findById(@PathVariable(value = "id") Long id){
        return toPersonDTO(service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Person not found with id: " + id)
                ));
    }
    @PostMapping
    public PersonDTO create(@RequestBody PersonDTO personDTO){
        return toPersonDTO(service.create(toPersonEntity(personDTO)));
    }

    @GetMapping("search")
    public List<PersonDTO> findByNameContaining(@RequestParam String name){
        return service.findByNameContaining(name)
                .stream()
                .map(this::toPersonDTO)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public PersonDTO update(@PathVariable Long id,@RequestBody Person person){
        return toPersonDTO(service.update(id, person)
        );
    }

    @DeleteMapping("/{id}")
    public PersonDTO delete(@PathVariable Long id){
        return toPersonDTO(service.delete(id));
    }

    //---------------------------------ENTITY---------------------------------------------
    @GetMapping("entity")
    public List<Person> findAllPersonData(){
        return (List<Person>) service.findAll();
    }

    @GetMapping("entity/{id}")
    public Person findEntityById(@PathVariable(value = "id") Long id){
        return service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Person not found with id: " + id)
                );
    }

    private PersonDTO toPersonDTO(Person person){
        return modelMapper.map(person, PersonDTO.class);
    }

    private Person toPersonEntity(PersonDTO personDTO){
        return modelMapper.map(personDTO, Person.class);
    }
}
