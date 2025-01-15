package facul.boares.trabalhofac.api.model.output;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewRestauranteDTO {
    
    @NotBlank
    private String nomeRestaurante;

    @NotBlank
    private Integer capacidadeAlunos;
    
    private Integer qtdAlunos;

    
}
