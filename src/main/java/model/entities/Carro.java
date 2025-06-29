package model.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //será uma tabela única que vai ter todos os campos de carro, carroNovo e carroSemiNovo
@DiscriminatorColumn(name = "tipo_carro") //vai ter uma tabela adicional pra diferenciar as subclasses
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String modelo;
    @Column
    private String cor;
    
    public Carro () {}
    
    public Carro (String modelo, String cor) {
    	this.modelo = modelo;
    	this.cor = cor;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}  	
	
}
