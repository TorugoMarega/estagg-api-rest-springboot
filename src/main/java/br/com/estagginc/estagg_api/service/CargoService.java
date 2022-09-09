package br.com.estagginc.estagg_api.service;

import br.com.estagginc.estagg_api.dto.CargoDTO;
import br.com.estagginc.estagg_api.model.Cargo;
import br.com.estagginc.estagg_api.repository.CargoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CargoService {
    @Autowired
    private CargoRepository repository;

    public CargoDTO save(CargoDTO dto){
        Cargo entity = new Cargo();
        BeanUtils.copyProperties(dto, entity);
        CargoDTO newDTO = new CargoDTO(repository.save(entity));
        return newDTO;
    }

    public CargoDTO update(Long id, CargoDTO updatedCargoDTO){
            Cargo cargoData = repository.findById(id).get();
            if(cargoData.getNome() != updatedCargoDTO.getNome() && updatedCargoDTO.getNome()!= null){
                cargoData.setNome(updatedCargoDTO.getNome());
            }
            CargoDTO response = new CargoDTO(cargoData);
            return response;
    }

    public List<CargoDTO> findAll(){
        List <Cargo> entityList = this.repository.findByDeletedFalse();
        List <CargoDTO> dtoList = new ArrayList<>();
        for(int i =0; i<entityList.size(); i++){
            CargoDTO dto = new CargoDTO(entityList.get(i));
            dtoList.add(dto);
        }
        return dtoList;
    }
    public CargoDTO findById(Long id){
        CargoDTO dto = new CargoDTO(this.repository.findById(id).get());
        return dto;
    }
    public List<CargoDTO> findByName(String name){
        List <Cargo> entityList = this.repository.findByNome(name);
        List <CargoDTO> dtoList = new ArrayList<>();
        for(int i =0; i<entityList.size(); i++){
            CargoDTO dto = new CargoDTO(entityList.get(i).getId(), entityList.get(i).getNome());
            dtoList.add(dto);
        }
        return dtoList;
    }

        public List<CargoDTO> findByDeleted(Boolean deleted){
            List <Cargo> entityList;
            List <CargoDTO> dtoList = new ArrayList<>();

        if(deleted == true){
            entityList = this.repository.findByDeletedTrue();

        }else{
            entityList = this.repository.findByDeletedFalse();
        }

            for(int i =0; i<entityList.size(); i++){
                CargoDTO dto = new CargoDTO(entityList.get(i).getId(), entityList.get(i).getNome());
                dtoList.add(dto);
            }
            return  dtoList;
    }
    public Boolean existsById(Long id){
        return repository.existsById(id);
    }

    public CargoDTO delete(Long id){
        Cargo cargoData = repository.findById(id).get();
            if(cargoData.getDeleted() == false){
                cargoData.setDeleted(true);
                repository.save(cargoData);
            }
        CargoDTO response = new CargoDTO(cargoData);
        return response;
    }

    public List<Cargo> findAllAdmin(){
        return repository.findAll();
    }
}
