package model.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//Não será uma tabela no banco, a coluna vai ir pra tabela Carro
@Entity
@DiscriminatorValue("NOVO")
public class CarroNovo extends Carro {
	
	private String chassi;

    public CarroNovo() {}

    public CarroNovo(String modelo, String cor, String chassi) {
        super(modelo, cor); //ta vindo da classe pai Carro
        this.chassi = chassi;
    }

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}


}
