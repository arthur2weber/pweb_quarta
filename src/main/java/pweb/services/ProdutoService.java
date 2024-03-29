package  pweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pweb.domain.Categoria;
import pweb.domain.Produto;
import pweb.repositories.CategoriaRepository;
import pweb.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository rep;

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	public List<Produto> search(String nome, List<Integer> ids) {
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return rep.findDistinctByNomeContainingAndCategoriasIn(nome, categorias);
	}
}