package view;

import java.time.LocalDate;

public class LavagemDTO {

	private LocalDate data;
	private String ordemServico;
	private double valor;

	private String modeloCarro;
	private String tipoCarro; // NOVO ou SEMINOVO
	private String identificador; // chassi ou placa

	private String nomeConsultor;

	public LavagemDTO() {
	}

	public LavagemDTO(LocalDate data, String ordemServico, double valor, String modeloCarro, String tipoCarro,
			String identificador, String nomeConsultor) {
		this.data = data;
		this.ordemServico = ordemServico;
		this.valor = valor;
		this.modeloCarro = modeloCarro;
		this.tipoCarro = tipoCarro;
		this.identificador = identificador;
		this.nomeConsultor = nomeConsultor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(String ordemServico) {
		this.ordemServico = ordemServico;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public String getTipoCarro() {
		return tipoCarro;
	}

	public void setTipoCarro(String tipoCarro) {
		this.tipoCarro = tipoCarro;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNomeConsultor() {
		return nomeConsultor;
	}

	public void setNomeConsultor(String nomeConsultor) {
		this.nomeConsultor = nomeConsultor;
	}

}
