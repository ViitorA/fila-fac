package facul.boares.trabalhofac.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import facul.boares.trabalhofac.domain.model.Senha;

@Repository
public interface SenhaRepository extends JpaRepository<Senha, Integer>{
    
}
