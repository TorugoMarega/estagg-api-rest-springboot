package br.com.estagginc.estagg_api.service;


import br.com.estagginc.estagg_api.model.Occupation;
import br.com.estagginc.estagg_api.repository.OccupationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OccupationService {
    @Autowired
    private OccupationRepository repository;

    public List<Occupation> findAllDeletedFalse(){
        return (List<Occupation>) repository.findByDeletedFalse();
    }

    public List<Occupation> findAll(){
        return (List<Occupation>) repository.findAll();
    }

    public Occupation create(Occupation occupation){
        return repository.save(occupation);
    }

    public Occupation findById(Long id){
        return  repository.findById(id).get();
    }

    public List<Occupation> findByName(String name){
        return repository.findByName(name);
    }

    public Occupation update(Long id,Occupation occupation){
       Occupation updateOccupation = repository.findById(id).get();
        BeanUtils.copyProperties(occupation, updateOccupation);
       return repository.save(updateOccupation);
    }

    public Occupation delete(Long id){
        Occupation deletedOccupation = repository.findById(id).get();
        deletedOccupation.setDeleted(true);
        return deletedOccupation;
    }
}
