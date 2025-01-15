package facul.boares.trabalhofac.domain.service;

import org.springframework.stereotype.Service;

import facul.boares.trabalhofac.api.assembler.SenhaAssembler;
import facul.boares.trabalhofac.api.model.input.CreateSenhaDTO;
import facul.boares.trabalhofac.api.model.output.ViewSenhaDTO;
import facul.boares.trabalhofac.domain.model.Senha;
import facul.boares.trabalhofac.domain.repository.SenhaRepository;
import jakarta.el.PropertyNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SenhaService {
    
    private final SenhaAssembler senhaAssembler;
    private final SenhaRepository senhaRepository;

    public ViewSenhaDTO viewSenha(Integer senhaId){
        var requestSenha = senhaRepository.findById(senhaId).orElseThrow(() -> new PropertyNotFoundException("Repository com esse id não existe"));
        
        return senhaAssembler.entityToViewSenhaDTO(requestSenha);
    }

    public Senha createSenha(CreateSenhaDTO senhaDTO){
        var senha = senhaAssembler.createSenhaToEntity(senhaDTO);

        return senhaRepository.save(senha);
    }
    
    public void deleteSenha(Integer id){
        senhaRepository.deleteById(id);
    }
}
