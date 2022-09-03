package br.com.estagginc.estagg_api.controller;

import br.com.estagginc.estagg_api.model.Pessoa;
import br.com.estagginc.estagg_api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping(value = "/api/pessoa")
public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping
    public Pessoa createPerson(@RequestBody Pessoa newPessoa){
        return pessoaRepository.save(newPessoa);
    }

    @GetMapping()
    public List<Pessoa> findAll(){
        return pessoaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Pessoa> findById(@PathVariable Long id){
        return pessoaRepository.findById(id);
    }
}
