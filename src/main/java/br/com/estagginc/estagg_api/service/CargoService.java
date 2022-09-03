package br.com.estagginc.estagg_api.service;

import br.com.estagginc.estagg_api.model.Cargo;
import br.com.estagginc.estagg_api.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {
    @Autowired
    private CargoRepository repository;



//    public Cargo save(Cargo newCargo){
//        repository.findBy()
//
//        return repository.save(newCargo);
//    }

    public List<Cargo> findAll(){
        return this.repository.findAll();
    }

    public Optional<Cargo> findById(Long id){
        return this.repository.findById(id);
    }

    public List<Cargo> findByName(String name){
        return (List<Cargo>) this.repository.findByNome(name);
    }
}
