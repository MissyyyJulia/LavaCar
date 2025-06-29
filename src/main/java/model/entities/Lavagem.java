package model.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Lavagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate data;
    @Column(name = "ordem_servico")
    private String ordemServico;
    @Column
    private double valor;

    @ManyToOne
    @JoinColumn(name = "carro_fk")
    private Carro carro;

    @ManyToOne
    @JoinColumn(name = "consultor_fk")
    private Consultor consultor;

    public Lavagem() {}

    public Lavagem(LocalDate data, String ordemServico, double valor, Carro carro, Consultor consultor) {
        this.data = data;
        this.ordemServico = ordemServico;
        this.valor = valor;
        this.carro = carro;
        this.consultor = consultor;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Consultor getConsultor() {
		return consultor;
	}

	public void setConsultor(Consultor consultor) {
		this.consultor = consultor;
	}
 
}
