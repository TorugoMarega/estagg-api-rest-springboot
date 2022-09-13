package br.com.estagginc.estagg_api.service;


import br.com.estagginc.estagg_api.model.Occupation;
import br.com.estagginc.estagg_api.repository.OccupationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OccupationService {
    @Autowired
    private OccupationRepository repository;

    public List<Occupation> findAllDeletedFalse() {
        return (List<Occupation>) repository.findByDeletedFalse();
    }

    public List<Occupation> findAll() {
        return (List<Occupation>) repository.findAll();
    }

    public Occupation create(Occupation occupation) {
        return repository.save(occupation);
    }

    public Optional<Occupation> update(Long id, Occupation occupation) {
        Occupation updateOccupation = repository.findById(id).get();
        Occupation auxOccupation = updateOccupation;
        BeanUtils.copyProperties(occupation, updateOccupation);
        repository.save(updateOccupation);
        return Optional.of(auxOccupation);
    }

    public Occupation delete(Long id) {
        Occupation deletedOccupation = repository.findById(id).get();
        deletedOccupation.setDeleted(true);
        return deletedOccupation;
    }

    //-----------------------------QUERY WITH FILTERS-------------------------------------
    public Optional<Occupation> findById(Long id) {
        return repository.findById(id);
    }

    public Boolean existsById(Long id) {
        return repository.existsById(id);
    }
    public List<Occupation> findByNameContaining(String name) {
        return repository.findByNameContaining(name);
    }
}
