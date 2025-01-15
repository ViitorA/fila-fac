package facul.boares.trabalhofac.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import facul.boares.trabalhofac.domain.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
    
}
