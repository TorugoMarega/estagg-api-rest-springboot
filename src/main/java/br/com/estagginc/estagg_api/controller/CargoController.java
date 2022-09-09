package br.com.estagginc.estagg_api.controller;

import br.com.estagginc.estagg_api.dto.CargoDTO;
import br.com.estagginc.estagg_api.model.Cargo;
import br.com.estagginc.estagg_api.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargo")
public class CargoController {

    @Autowired
    private CargoService service;

    @PostMapping
    public CargoDTO create(@RequestBody CargoDTO newCargo) {
        return service.save(newCargo);
    }

    @PutMapping("{id}")
    public ResponseEntity<CargoDTO> update(@PathVariable("id") Long id, @RequestBody CargoDTO updatedCargo) {
        if(service.existsById(id)){
            return new ResponseEntity<>(service.update(id, updatedCargo), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public List<CargoDTO> findAll(){
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public CargoDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping(value = "search/", params = "name")
    public List<CargoDTO> findByName(@RequestParam String name){
        return service.findByName(name);
    }

    @GetMapping(value = "search/", params = "deleted")
    public List<CargoDTO> findByDeleted(@RequestParam Boolean deleted){
        return service.findByDeleted(deleted);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CargoDTO> delete(@PathVariable("id") Long id){
        if(service.existsById(id)){
            return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/admin")
    public List<Cargo> findAllAdmin(){
        return this.service.findAllAdmin();
    }
}
