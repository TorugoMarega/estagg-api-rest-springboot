package br.com.estagginc.estagg_api.controller;

import br.com.estagginc.estagg_api.dto.PersonDTO;
import br.com.estagginc.estagg_api.exception.ResourceNotFoundException;
import br.com.estagginc.estagg_api.model.Message;
import br.com.estagginc.estagg_api.model.Person;
import br.com.estagginc.estagg_api.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    private PersonService service;

    @Autowired
    private ModelMapper modelMapper;


    //-----------------------------CRUD-----------------------------------------------
/*     @GetMapping
    public ResponseEntity<List<PersonDTO>> findAllDeletedFalse() {
        return new ResponseEntity<>(
                service.findAllDeletedFalse()
                        .stream()
                        .map(this::toPersonDTO)
                        .collect(Collectors.toList()), HttpStatus.OK);
    } */
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Person person){
        this.service.create(person);
        ResponseEntity<?> responseEntity;
        String description = "uri:/api/person/"+person.getId();
        Message message = new Message(new Date(), "Person "+ person.getFirst_name()+" created!!!", description);
        if(service.existsById(person.getId())){
            responseEntity = new ResponseEntity<>(message, HttpStatus.CREATED);
        }else{
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
    @PutMapping("/{id}")
    public PersonDTO update(@PathVariable Long id, @RequestBody Person person) {
        return toPersonDTO(service.update(id, person)
        );
    }

    @DeleteMapping("/{id}")
    public PersonDTO delete(@PathVariable Long id) {
        return toPersonDTO(service.delete(id));
    }

//-----------------------------QUERY WITH FILTERS-------------------------------------
    @GetMapping("{id}")
    public PersonDTO findById(@PathVariable(value = "id") Long id) {
        return toPersonDTO(service.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Person not found with id: " + id)
        ));
    }
/*     @GetMapping(value = "search", params = "name")
    public List<PersonDTO> findByNameContaining(@RequestParam String name) {
        return service.findByNameContaining(name)
                .stream()
                .map(this::toPersonDTO)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/search", params = "occupation_name")
    public List<PersonDTO> findByOccupationNameContaining (@RequestParam String occupation_name){
        return service.findByOccupationNameContaining(occupation_name)
                .stream()
                .map(this::toPersonDTO)
                .collect(Collectors.toList());
    } */
    //---------------------------------ENTITY---------------------------------------------
    @GetMapping("entity")
    public List<Person> findAllPersonData() {
        return (List<Person>) service.findAll();
    }

    @GetMapping("entity/{id}")
    public Person findEntityById(@PathVariable(value = "id") Long id) {
        return service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Person not found with id: " + id)
                );
    }

    @DeleteMapping("entity/{id}")
    public Person deleteEntity(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("entity/{id}")
    public Person activateEntity(@PathVariable Long id) {
        return service.activate(id);
    }

    //---------------------------------CONVERSION---------------------------------------------
    //Entity to DTO
    private PersonDTO toPersonDTO(Person person) {
        return modelMapper.map(person, PersonDTO.class);
    }

    //DTO to Entity
    private Person toPersonEntity(PersonDTO personDTO) {
        return modelMapper.map(personDTO, Person.class);
    }
}
