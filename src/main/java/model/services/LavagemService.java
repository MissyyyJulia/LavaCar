package model.services;

import java.util.List;

import model.entities.Carro;
import model.entities.CarroNovo;
import model.entities.CarroSemiNovo;
import model.entities.Consultor;
import model.entities.Lavagem;
import model.entities.TabelaPreco;
import model.respositories.LavagemRepository;

public class LavagemService {


	private LavagemRepository lavagemRepository = new LavagemRepository();
	private CarroService carroService = new CarroService();
	private ConsultorService consultorService = new ConsultorService();
	private TabelaPrecoService tabelaPrecoService = new TabelaPrecoService();

	public boolean excluirLavagem(Long id) {
		Lavagem lavagem = (Lavagem) lavagemRepository.findById(id);
		if (lavagem == null) {
			System.out.println("ERRO: Consultor não encontrado.");
			return false;
		}
		lavagemRepository.delete(id);
		System.out.println("Consultor excluído com sucesso.");
		return true;
	}
	
	public Lavagem adicionarLavagem(Lavagem lavagem) {
		Carro carro = null;

		// distinção entre CarroNovo e CarroSemiNovo
		if (lavagem.getCarro() instanceof CarroNovo) {
			String chassi = ((CarroNovo) lavagem.getCarro()).getChassi();
			carro = carroService.findByChassi(chassi);
		} else if (lavagem.getCarro() instanceof CarroSemiNovo) {
			String placa = ((CarroSemiNovo) lavagem.getCarro()).getPlaca();
			carro = carroService.findByPlaca(placa);
		}

		if (carro == null) {
			System.out.println("ERRO: Carro não encontrado.");
			return null;
		}

		Consultor consultor = consultorService.findById(lavagem.getConsultor().getId());
		if (consultor == null) {
			System.out.println("ERRO: Consultor não encontrado.");
			return null;
		}

		TabelaPreco valor = tabelaPrecoService.findByModelo(carro.getModelo());
		if (valor == null) {
			System.out.println("ERRO: Modelo não cadastrado na tabela de preços.");
			return null;
		}

		lavagem.setCarro(carro);
		lavagem.setConsultor(consultor);
		lavagem.setValor(valor.getPreco());

		return (Lavagem) lavagemRepository.create(lavagem);
	}

	public Lavagem findById(Long id) {
		return (Lavagem) lavagemRepository.findById(id);
	}

	public Lavagem atualizarLavagem(Lavagem lavagem) {
		return (Lavagem) lavagemRepository.updateById(lavagem);
	}

	public List<Lavagem> findAll() {
		return lavagemRepository.findAll();
	}

	public List<Lavagem> findByConsultorId(Long id) {
		return lavagemRepository.findByConsultorId(id);
	}
}
