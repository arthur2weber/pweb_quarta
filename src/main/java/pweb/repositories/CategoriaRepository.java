package pweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pweb.domain.Categoria;



@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
