package facul.boares.trabalhofac.api.assembler;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import facul.boares.trabalhofac.api.model.input.CreateSenhaDTO;
import facul.boares.trabalhofac.api.model.output.ViewSenhaDTO;
import facul.boares.trabalhofac.domain.model.Senha;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class SenhaAssembler {
    
    private final ModelMapper modelMapper;

    public Senha createSenhaToEntity(CreateSenhaDTO senhaDTO){
 
        var senha = modelMapper.map(senhaDTO, Senha.class);
        senha.setHoraCriado(LocalDateTime.now());
        senha.setHoraExpiracao(senha.getHoraCriado().plusHours(6));

        return senha;
    }

    public ViewSenhaDTO entityToViewSenhaDTO(Senha senha){
        return modelMapper.map(senha, ViewSenhaDTO.class);
    }
}
