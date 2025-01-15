package facul.boares.trabalhofac.api.model.output;

import java.time.LocalDateTime;

import facul.boares.trabalhofac.domain.model.Aluno;
import facul.boares.trabalhofac.domain.model.Restaurante;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewSenhaDTO {
    
    private Integer numero;

    private LocalDateTime horaCriado;

    private LocalDateTime horaExpiracao;
    
    private Restaurante restaurante;

    private Aluno aluno;
}
