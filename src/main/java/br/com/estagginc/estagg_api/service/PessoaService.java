package br.com.estagginc.estagg_api.service;

import br.com.estagginc.estagg_api.dto.CargoDTO;
import br.com.estagginc.estagg_api.dto.PessoaDTO;
import br.com.estagginc.estagg_api.model.Cargo;
import br.com.estagginc.estagg_api.model.Pessoa;
import br.com.estagginc.estagg_api.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public List<PessoaDTO> findAll(){
        List<Pessoa> entityList = repository.findByDeletedFalse();
        List<PessoaDTO> dtoList = new ArrayList<>();
        for(int i =0; i<entityList.size(); i++){
            PessoaDTO dto = new PessoaDTO(
                    entityList.get(i).getId(),
                    entityList.get(i).getNome(),
                    entityList.get(i).getCpf(),
                    entityList.get(i).getData_nasc(),
                    entityList.get(i).getFoto_perfil(),
                    entityList.get(i).getCargo()
            );
            dtoList.add(dto);
        }
        return dtoList;
    }

//    public Pessoa save(Pessoa pessoa){
//        return repository.save(pessoa);
//    }
    public PessoaDTO save(PessoaDTO dto){
        Pessoa entity = new Pessoa(dto);
        repository.save(entity);
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<Pessoa> findAllAdmin(){
        return repository.findAll();
    }
}
