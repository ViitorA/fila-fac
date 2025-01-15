package facul.boares.trabalhofac.domain.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Restaurante {
    

    @Id
    @Column(name = "id")
    private Long restauranteId;

    @NotBlank
    private String nomeRestaurante;

    @NotBlank
    private Integer capacidadeAlunos;
    
    @OneToMany(mappedBy = "restaurante")
    private List<Senha> senhas;

}
