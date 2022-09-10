    package br.com.estagginc.estagg_api.controller;

    import br.com.estagginc.estagg_api.dto.OccupationDTO;
    import br.com.estagginc.estagg_api.model.Occupation;
    import br.com.estagginc.estagg_api.service.OccupationService;
    import org.modelmapper.ModelMapper;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.stream.Collectors;

    @RestController
    @RequestMapping("api/occupation")
    public class OccupationController {
        @Autowired
        private OccupationService service;

        @Autowired
        private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<OccupationDTO>> findAllDeletedFalse(){
         return new ResponseEntity<>(
                 service.findAllDeletedFalse()
                         .stream()
                         .map(this::toOccupationDTO)
                         .collect(Collectors.toList()) , HttpStatus.OK);
    }

        @GetMapping("{id}")
        public ResponseEntity<OccupationDTO> findById(@PathVariable(value = "id") Long id){
            return new ResponseEntity<>(toOccupationDTO(service.findById(id)), HttpStatus.OK);
        }
        @PostMapping
        public OccupationDTO create(@RequestBody OccupationDTO occupationDTO){
            return toOccupationDTO(service.create(toOccupationEntity(occupationDTO)));
        }

        @GetMapping("search")
        public List<OccupationDTO> findByName(@RequestParam String name){
            return service.findByName(name)
                    .stream()
                    .map(this::toOccupationDTO)
                    .collect(Collectors.toList());
        }

        @PutMapping("/{id}")
        public OccupationDTO update(@PathVariable Long id,@RequestBody Occupation occupation){
            return toOccupationDTO(service.update(id, occupation));
        }

        @DeleteMapping("/{id}")
        public OccupationDTO delete(@PathVariable Long id){
        return toOccupationDTO(service.delete(id));
        }

    //---------------------------------ENTITY---------------------------------------------
        @GetMapping("entity")
        public List<Occupation> findAllOccupationData(){
           return (List<Occupation>) service.findAll();
        }

        @GetMapping("entity/{id}")
        public Occupation findEntityById(@PathVariable(value = "id") Long id){
            return service.findById(id);
        }

        private OccupationDTO toOccupationDTO(Occupation occupation){
            return modelMapper.map(occupation, OccupationDTO.class);
        }

        private Occupation toOccupationEntity(OccupationDTO occupationDTO){
            return modelMapper.map(occupationDTO, Occupation.class);
        }

    }
