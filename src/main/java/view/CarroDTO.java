package view;

public class CarroDTO {

	private String modelo;
	private String cor;
	private String tipo; // "NOVO" ou "SEMINOVO"
	private String chassi; // apenas se tipo = NOVO
	private String placa; // apenas se tipo = SEMINOVO

	public CarroDTO() {
	}

	public CarroDTO(String modelo, String cor, String tipo, String chassi, String placa) {
		this.modelo = modelo;
		this.cor = cor;
		this.tipo = tipo;
		this.chassi = chassi;
		this.placa = placa;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
}
