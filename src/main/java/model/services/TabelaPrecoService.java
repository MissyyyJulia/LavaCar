package model.services;

import java.util.List;
import model.entities.TabelaPreco;
import model.respositories.TabelaPrecoRepository;

public class TabelaPrecoService {

	private TabelaPrecoRepository tabelaPrecoRepository = new TabelaPrecoRepository();

	public TabelaPreco adicionarTabelaPreco(TabelaPreco tabelaPreco) {
		TabelaPreco created = (TabelaPreco) tabelaPrecoRepository.create(tabelaPreco);
		System.out.println("Item cadastrado com sucesso!");
		return created;
	}

	public TabelaPreco atualizarTabelaPreco(TabelaPreco tabelaPreco) {
		TabelaPreco updated =(TabelaPreco) tabelaPrecoRepository.updateById(tabelaPreco);
		System.out.println("Item atualizado com sucesso!");
		return updated;
	}

	public TabelaPreco findById(Long id) {
		return (TabelaPreco) tabelaPrecoRepository.findById(id);
	}

	// Busca item por modelo (usado na lavagem para buscar valor)
	public TabelaPreco findByModelo(String modelo) {
		return tabelaPrecoRepository.findByModelo(modelo);
	}

	public List<TabelaPreco> findAll() {
		return tabelaPrecoRepository.findAll();
	}

	public boolean excluirTabelaPreco(Long id) {
		TabelaPreco tabelaPreco = (TabelaPreco)tabelaPrecoRepository.findById(id);
		if (tabelaPreco == null) {
			System.out.println("ERRO: Não foi possível encontrar o item.");
			return false;
		}
		tabelaPrecoRepository.delete(id);
		System.out.println("Item excluído com sucesso!");
		return true;
	}
}
