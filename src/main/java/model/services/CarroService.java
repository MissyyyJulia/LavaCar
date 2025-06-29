package model.services;

import java.util.List;

import model.entities.Carro;
import model.entities.CarroNovo;
import model.entities.CarroSemiNovo;
import model.respositories.CarroRepository;
import view.CarroDTO;

public class CarroService {

	private CarroRepository carroRepository = new CarroRepository();

	public boolean excluirCarro(Long id) {
		Carro carro = (Carro) carroRepository.findById(id);
		if (carro == null) {
			System.out.println("ERRO: Carro não encontrado.");
			return false;
		}
		carroRepository.delete(id);
		System.out.println("Carro excluído com sucesso.");
		return true;
	}

	//Trata a decisão pra saber que classe instanciar
	public Carro adicionarCarro(CarroDTO dto) {
		Carro carro;

		if ("NOVO".equalsIgnoreCase(dto.getTipo())) {
			CarroNovo novo = new CarroNovo();
			novo.setChassi(dto.getChassi());
			carro = novo;
		} else if ("SEMINOVO".equalsIgnoreCase(dto.getTipo())) {
			CarroSemiNovo semiNovo = new CarroSemiNovo();
			semiNovo.setPlaca(dto.getPlaca());
			carro = semiNovo;
		} else {
			System.out.println("ERRO: Tipo de carro inválido. Use NOVO ou SEMINOVO.");
			return null;
		}

		carro.setCor(dto.getCor());
		carro.setModelo(dto.getModelo());

		return (Carro) carroRepository.create(carro);
	}

	public Carro atualizarCarro(Carro carro) {
		return (Carro) carroRepository.updateById(carro);
	}

	public Carro findById(Long id) {
		return (Carro) carroRepository.findById(id);
	}

	public List<Carro> findAll() {
		return carroRepository.findAll();
	}

	public Carro findByPlaca(String placa) {
		return carroRepository.findByPlaca(placa);
	}

	public Carro findByChassi(String chassi) {
		return carroRepository.findByChassi(chassi);
	}
}
