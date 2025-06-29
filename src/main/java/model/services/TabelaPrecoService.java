package model.services;

import java.util.List;

import model.entities.TabelaPreco;
import model.respositories.TabelaPrecoRepository;

public class TabelaPrecoService {

	private TabelaPrecoRepository tabelaPrecoRepository = new TabelaPrecoRepository();

	public boolean excluirTabelaPrecoById(Long id) {
		TabelaPreco tabelaPrecoToDelete = (TabelaPreco) tabelaPrecoRepository.findById(id);
		if (tabelaPrecoToDelete == null) {
			System.out.println("ERRO: Não foi possível encontrar o item.");
			return false;
		}
		tabelaPrecoRepository.delete(id);
		System.out.println("Item excluído com sucesso!");
		return true;
	}

	public TabelaPreco adicionarTabelaPreco(TabelaPreco tabelaPreco) {
		return (TabelaPreco) tabelaPrecoRepository.create(tabelaPreco);
	}

	public TabelaPreco findById(Long id) {
		return (TabelaPreco) tabelaPrecoRepository.findById(id);
	}

	public TabelaPreco atualizarTabelaPreco(TabelaPreco tabelaPreco) {
		return (TabelaPreco) tabelaPrecoRepository.updateById(tabelaPreco);
	}

	public List<TabelaPreco> findAll() {
		return tabelaPrecoRepository.findAll();
	}

	public TabelaPreco findByModelo(String modelo) {
		return tabelaPrecoRepository.findByModelo(modelo);
	}

}
