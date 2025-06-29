package model.services;

import java.util.List;

import model.entities.Carro;
import model.respositories.CarroRepository;

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
	
	public Carro adicionarCarro(Carro carro) {
		return (Carro) carroRepository.create(carro);
	}

	public Carro findById(Long id) {
		return (Carro) carroRepository.findById(id);
	}

	public Carro atualizarCarro(Carro carro) {
		return (Carro) carroRepository.updateById(carro);
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
