package model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Consultor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nome;

	@OneToMany(mappedBy = "consultor", cascade = CascadeType.ALL, orphanRemoval = true) //orphanRemoval faz com que a lavagem seja 
	private List<Lavagem> lavagens = new ArrayList<>();                                 //excluida do banco quando desvinculado a um consultor
																						//(ja que n pode ter lavagens sem consultor)
	public Consultor() {
	}

	public Consultor(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Lavagem> getLavagens() {
		return lavagens;
	}

	public void setLavagens(List<Lavagem> lavagens) {
		this.lavagens = lavagens;
	}

}
