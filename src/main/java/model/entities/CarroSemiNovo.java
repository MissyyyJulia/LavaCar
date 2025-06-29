package model.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SEMINOVO")
public class CarroSemiNovo extends Carro{

	private String placa;

	public CarroSemiNovo() {}
	
	public CarroSemiNovo(String modelo, String cor, String placa) {
		super(modelo, cor);
		this.placa = placa;
		
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
}
