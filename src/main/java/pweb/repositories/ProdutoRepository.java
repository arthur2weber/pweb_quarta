package pweb.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pweb.domain.Categoria;
import pweb.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	
	List<Produto> findDistinctByNomeContainingAndCategoriasIn(
			String nome,
			List<Categoria> categorias
	);

}