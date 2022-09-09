package br.com.estagginc.estagg_api.controller;

import br.com.estagginc.estagg_api.dto.CargoDTO;
import br.com.estagginc.estagg_api.dto.PessoaDTO;
import br.com.estagginc.estagg_api.model.Pessoa;
import br.com.estagginc.estagg_api.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value = "/api/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @GetMapping
    public  List<PessoaDTO> findAll(){
        return service.findAll();
    }
    @GetMapping("admin")
    public List<Pessoa> findAllAdmin(){
        return service.findAllAdmin();
    }

    @PostMapping
    public PessoaDTO create(@RequestBody PessoaDTO newPessoa) {
        return service.save(newPessoa);
    }
}
