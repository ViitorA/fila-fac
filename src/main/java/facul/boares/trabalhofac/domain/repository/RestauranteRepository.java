package facul.boares.trabalhofac.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import facul.boares.trabalhofac.domain.model.Restaurante;
import facul.boares.trabalhofac.domain.model.Senha;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{
    
    Optional<Restaurante> findByNomeRestaurante(String nomeRestaurante);

    @Query("SELECT s FROM Senha s WHERE s.restaurante.id = :restauranteId ORDER BY s.dataCriacao DESC")
    List<Senha> findSenhasByRestauranteOrderByDataCriacaoDesc(@Param("restauranteId") Long restauranteId);

    @Query("SELECT COUNT(s) FROM Restaurante r JOIN r.senhas s WHERE r.id = :restauranteId AND s IS NOT NULL")
    Integer countSenhasByRestaurante(@Param("restauranteId") Long restauranteId);

}
