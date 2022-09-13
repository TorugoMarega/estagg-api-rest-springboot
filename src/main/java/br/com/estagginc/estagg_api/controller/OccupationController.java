package br.com.estagginc.estagg_api.controller;

import br.com.estagginc.estagg_api.dto.OccupationDTO;
import br.com.estagginc.estagg_api.exception.ResourceNotFoundException;
import br.com.estagginc.estagg_api.model.Message;
import br.com.estagginc.estagg_api.model.Occupation;
import br.com.estagginc.estagg_api.service.OccupationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/occupation")
public class OccupationController {
    @Autowired
    private OccupationService service;

    @Autowired
    private ModelMapper modelMapper;

    //-----------------------------CRUD-----------------------------------------------
    @GetMapping
    public ResponseEntity<List<OccupationDTO>> findAllDeletedFalse() {
        return new ResponseEntity<>(
                service.findAllDeletedFalse()
                        .stream()
                        .map(this::toOccupationDTO)
                        .collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody OccupationDTO occupationDTO){
        Occupation occupationEntity = toOccupationEntity(occupationDTO);
        this.service.create(occupationEntity);
        ResponseEntity<?> responseEntity;
        String description = "uri:/api/occupation/"+occupationEntity.getId();
        Message message = new Message(new Date(), "Occupation "+ occupationEntity.getName()+" created!!!", description);
        if(service.existsById(occupationEntity.getId())){
            responseEntity = new ResponseEntity<>(message, HttpStatus.CREATED);
        }else{
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PutMapping("/{id}")
    public OccupationDTO update(@PathVariable Long id, @RequestBody Occupation occupation) {
        return toOccupationDTO(service.update(id, occupation).get());
    }

    @DeleteMapping("/{id}")
    public OccupationDTO delete(@PathVariable Long id) {
        return toOccupationDTO(service.delete(id));
    }

    //-----------------------------QUERY WITH FILTERS-------------------------------------
    @GetMapping("{id}")
    public OccupationDTO findById(@PathVariable(value = "id") Long id) {
        return toOccupationDTO(service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Occupation not found with id: " + id)
                ));
    }

    @GetMapping("search")
    public List<OccupationDTO> findByNameContaining(@RequestParam String name) {
        return service.findByNameContaining(name)
                .stream()
                .map(this::toOccupationDTO)
                .collect(Collectors.toList());
    }

    //---------------------------------ENTITY---------------------------------------------
    @GetMapping("entity")
    public List<Occupation> findAllOccupationData() {
        return (List<Occupation>) service.findAll();
    }

    @GetMapping("entity/{id}")
    public Occupation findEntityById(@PathVariable(value = "id") Long id) {
        return service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Occupation not found with id: " + id)
                );
    }

    //---------------------------------CONVERSION---------------------------------------------
    //Entity to DTO
    private OccupationDTO toOccupationDTO(Occupation occupation) {
        return modelMapper.map(occupation, OccupationDTO.class);
    }

    //DTO to Entity
    private Occupation toOccupationEntity(OccupationDTO occupationDTO) {
        return modelMapper.map(occupationDTO, Occupation.class);
    }

}
