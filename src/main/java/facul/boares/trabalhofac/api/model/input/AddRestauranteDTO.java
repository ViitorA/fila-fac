package facul.boares.trabalhofac.api.model.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddRestauranteDTO {
    
    @NotBlank
    private String nomeRestaurante;

    @NotBlank
    private Integer capacidadeAlunos;
    
}
