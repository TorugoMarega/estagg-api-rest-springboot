package br.com.estagginc.estagg_api.controller;

import br.com.estagginc.estagg_api.model.Person;
import br.com.estagginc.estagg_api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping
    public List<Person> findAll(){
        return service.findAll();
    }

    @PostMapping
    public Person create(@RequestBody Person person){
        service.create(person);
        System.out.println("PESSOA CRIADA!");
        return person;
    }
}
