package facul.boares.trabalhofac.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import facul.boares.trabalhofac.domain.model.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{
    
    Optional<Restaurante> findByNomeRestaurante(String nomeRestaurante);

}
