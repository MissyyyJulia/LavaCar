package model.services;

import java.util.List;

import model.entities.Carro;
import model.entities.Consultor;
import model.entities.Lavagem;
import model.entities.TabelaPreco;
import model.respositories.LavagemRepository;
import view.LavagemDTO;

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
		System.out.println("Lavagem excluída com sucesso.");
		return true;
	}
	
	public Lavagem adicionarLavagem(LavagemDTO lavagemDTO) {
		Carro carro = null;

		if (lavagemDTO.getTipoCarro().equalsIgnoreCase("NOVO")) {
			carro = carroService.findByChassi(lavagemDTO.getIdentificador());
		} else if (lavagemDTO.getTipoCarro().equalsIgnoreCase("SEMINOVO")) {
			carro = carroService.findByPlaca(lavagemDTO.getIdentificador());
		}

		if (carro == null) {
			System.out.println("ERRO: Carro não encontrado.");
			return null;
		}

		Consultor consultor = consultorService.findByNome(lavagemDTO.getNomeConsultor());
		if (consultor == null) {
			System.out.println("ERRO: Consultor não encontrado.");
			return null;
		}

		TabelaPreco preco = tabelaPrecoService.findByModelo(carro.getModelo());
		if (preco == null) {
			System.out.println("ERRO: Modelo não cadastrado na tabela de preços.");
			return null;
		}

		Lavagem nova = new Lavagem();
		nova.setData(lavagemDTO.getData());
		nova.setOrdemServico(lavagemDTO.getOrdemServico());
		nova.setConsultor(consultor);
		nova.setCarro(carro);
		nova.setValor(preco.getPreco());

		System.out.println("Lavagem cadastrada com sucesso.");
		return (Lavagem) lavagemRepository.create(nova);
	}

	public Lavagem atualizarLavagem(LavagemDTO dto, Long id) {
		Lavagem existente = findById(id);
		if (existente == null) {
			System.out.println("ERRO: Lavagem não encontrada.");
			return null;
		}

		Carro carro = null;
		if (dto.getTipoCarro().equalsIgnoreCase("NOVO")) {
			carro = carroService.findByChassi(dto.getIdentificador());
		} else if (dto.getTipoCarro().equalsIgnoreCase("SEMINOVO")) {
			carro = carroService.findByPlaca(dto.getIdentificador());
		}

		if (carro == null) {
			System.out.println("ERRO: Carro não encontrado.");
			return null;
		}

		Consultor consultor = consultorService.findByNome(dto.getNomeConsultor());
		if (consultor == null) {
			System.out.println("ERRO: Consultor não encontrado.");
			return null;
		}

		TabelaPreco preco = tabelaPrecoService.findByModelo(carro.getModelo());
		if (preco == null) {
			System.out.println("ERRO: Modelo não cadastrado na tabela de preços.");
			return null;
		}

		existente.setData(dto.getData());
		existente.setOrdemServico(dto.getOrdemServico());
		existente.setConsultor(consultor);
		existente.setCarro(carro);
		existente.setValor(preco.getPreco());

		System.out.println("Lavagem atualizada com sucesso.");
		return (Lavagem) lavagemRepository.updateById(existente);
	}

	public Lavagem findById(Long id) {
		return (Lavagem) lavagemRepository.findById(id);
	}

	public List<Lavagem> findAll() {
		return lavagemRepository.findAll();
	}

	public List<Lavagem> findByConsultorId(Long id) {
		return lavagemRepository.findByConsultorId(id);
	}
}
