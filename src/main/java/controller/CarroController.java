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
    	  Carro novoCarro = new Carro();
    	  novoCarro.setCor(carroDTO.getCor());
    	  novoCarro.setModelo(carroDTO.getModelo());
        return carroService.adicionarCarro(carroDTO); //a service que faz o trabalho de instancia carroNovo ou carroSemiNovo
    }

    public Carro atualizarCarro(CarroDTO carroDTO, Long id) {
    	Carro attCarro = new Carro();
    	attCarro.setId(id);
    	attCarro.setCor(carroDTO.getCor());
    	attCarro.setModelo(carroDTO.getModelo());
        return carroService.atualizarCarro(carroDTO, id);
    }

    public Carro findCarroById(Long id) {
        return carroService.findById(id);
    }

    public List<Carro> findAll() {
        return carroService.findAll();
    }

    public void excluirCarro(Long id) {
        Carro carro = carroService.findById(id);
        if (carro == null) {
            System.out.println("ERRO: carro não encontrado");
            return;
        }
        carroService.excluirCarro(id);
    }
    
	public Carro findByPlaca(String placa) {
		return carroService.findByPlaca(placa);
	}
	
	public Carro findByChassi(String chassi) {
		return carroService.findByChassi(chassi);
	}
	
}
