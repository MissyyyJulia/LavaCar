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

	public Carro atualizarCarro(CarroDTO carroDTO, Long id) {
			Carro carroExistente =(Carro) carroRepository.findById(id);

			if (carroExistente == null) {
				System.out.println("ERRO: Carro não encontrado.");
				return null;
			}

			carroExistente.setModelo(carroDTO.getModelo());
			carroExistente.setCor(carroDTO.getCor());

			if ("NOVO".equalsIgnoreCase(carroDTO.getTipo()) && carroExistente instanceof CarroNovo) {
				((CarroNovo) carroExistente).setChassi(carroDTO.getChassi());
			} else if ("SEMINOVO".equalsIgnoreCase(carroDTO.getTipo()) && carroExistente instanceof CarroSemiNovo) {
				((CarroSemiNovo) carroExistente).setPlaca(carroDTO.getPlaca());
			} else {
				System.out.println("ERRO: O tipo informado não corresponde ao tipo real do carro.");
				return null;
			}

			return (Carro) carroRepository.updateById(carroExistente);
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
