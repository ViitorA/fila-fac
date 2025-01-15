package facul.boares.trabalhofac.domain.model;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Senha {
    
    @Id
    @Column(name = "id")
    private Integer numero;

    @Column(name = "hora_criacao")
    private LocalDateTime horaCriado;

    @Column(name = "hora_expiracao")
    private LocalDateTime horaExpiracao;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;

    private Integer alunoId;

}
