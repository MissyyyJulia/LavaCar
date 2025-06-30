package model.services;

import java.util.List;

import model.entities.Consultor;
import model.respositories.ConsultorRepository;

public class ConsultorService {

	private ConsultorRepository consultorRepository = new ConsultorRepository();

	public boolean excluirConsultor(Long id) {
		Consultor consultor = (Consultor) consultorRepository.findById(id);
		if (consultor == null) {
			System.out.println("ERRO: Consultor não encontrado.");
			return false;
		}
		consultorRepository.delete(id);
		System.out.println("Consultor excluído com sucesso.");
		return true;
	}

	public Consultor adicionarConsultor(Consultor consultor) {
		System.out.println("Consultor adicionado com sucesso.");
		return (Consultor) consultorRepository.create(consultor);
	}

	public Consultor findById(Long id) {
		return (Consultor) consultorRepository.findById(id);
	}

	public Consultor atualizarConsultor(Consultor consultor) {
		System.out.println("Consultor atualizado com sucesso.");
		return (Consultor) consultorRepository.updateById(consultor);
	}

	public List<Consultor> findAll() {
		return consultorRepository.findAll();
	}

	public Consultor findByNome(String nome) {
		return consultorRepository.findByNome(nome);
	}
}
