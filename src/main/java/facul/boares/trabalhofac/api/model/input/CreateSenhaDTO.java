package facul.boares.trabalhofac.api.model.input;

import facul.boares.trabalhofac.domain.model.Restaurante;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSenhaDTO {
    
    private Restaurante restaurante;
    
    private Integer alunoId;

}
