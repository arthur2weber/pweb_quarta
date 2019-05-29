package pweb.dtos;

import java.io.Serializable;

import pweb.domain.Cidade;
import pweb.domain.Estado;


public class CidadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private Estado estado;
	
	public CidadeDTO(Cidade obj) {
		id = obj.getId();
		nome = obj.getNome();
		estado = obj.getEstado();
	}
	
	public CidadeDTO() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}