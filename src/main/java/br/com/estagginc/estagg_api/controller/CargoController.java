package br.com.estagginc.estagg_api.controller;

import br.com.estagginc.estagg_api.model.Cargo;
import br.com.estagginc.estagg_api.repository.CargoRepository;
import br.com.estagginc.estagg_api.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cargo")
public class CargoController {
    @Autowired
    private CargoRepository cargoRepository;
    @Autowired
    private CargoService service;

//    @PostMapping
//    public Cargo createCargo(@RequestBody Cargo newCargo){
//        return service.save(newCargo);
//    }

    @GetMapping()
    public List<Cargo> findAll(){
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Cargo> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/search/")
    public List<Cargo> findByName(@RequestParam String name){
        return (List<Cargo>) service.findByName(name);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cargo> update(@PathVariable("id") Long id, @RequestBody Cargo updatedCargo) {
        if(cargoRepository.existsById(id)){
            Optional<Cargo> cargoData = cargoRepository.findById(id);

            Cargo _cargo = cargoData.get();
            if(_cargo.getNome() != updatedCargo.getNome() & updatedCargo.getNome()!= null){
                _cargo.setNome(updatedCargo.getNome());
            }
            if(_cargo.getPessoas() != updatedCargo.getPessoas() & updatedCargo.getPessoas()!= null){
                _cargo.setPessoas(updatedCargo.getPessoas());
            }
            if(_cargo.getDeleted() != updatedCargo.getDeleted() && updatedCargo.getDeleted()!= null){
                _cargo.setDeleted(updatedCargo.getDeleted());
            }
            return new ResponseEntity<>(cargoRepository.save(_cargo), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cargo> delete(@PathVariable("id") Long id){
        if(cargoRepository.existsById(id)){
            Optional<Cargo> cargoData = cargoRepository.findById(id);

            Cargo _cargo = cargoData.get();
            if(_cargo.getDeleted() == false){
                _cargo.setDeleted(true);
            }
            return new ResponseEntity<>(cargoRepository.save(_cargo), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
