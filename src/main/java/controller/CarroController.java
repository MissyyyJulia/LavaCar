package controller;

import java.util.List;

import model.entities.Carro;
import model.services.CarroService;
import view.CarroDTO;


public class CarroController {

    public CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }
    
    public Carro adicionarCarro(CarroDTO carroDTO) {
        return carroService.adicionarCarro(carroDTO); //a service que faz o trabalho de instancia carroNovo ou carroSemiNovo
    }

    public Carro atualizarCarro(CarroDTO carroDTO, Long id) {
        return carroService.atualizarCarro(carroDTO, id);
    }

    public Carro findCarroById(Long id) {
        return carroService.findById(id);
    }

    public List<Carro> findAll() {
        return carroService.findAll();
    }

    public void excluirCarro(Long id) {
        Carro c = carroService.findById(id);
        if (c == null) {
            System.out.println("ERRO: carro não encontrado");
            return;
        }
        carroService.excluirCarro(id);
        System.out.println("Carro excluído com sucesso");
    }
    
	public Carro findByPlaca(String placa) {
		return carroService.findByPlaca(placa);
	}
	
	public Carro findByChassi(String chassi) {
		return carroService.findByChassi(chassi);
	}
	
}
