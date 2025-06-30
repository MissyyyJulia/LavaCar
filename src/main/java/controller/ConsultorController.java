package controller;

import java.util.List;

import model.entities.Consultor;
import model.services.ConsultorService;
import view.ConsultorDTO;


public class ConsultorController {

    public ConsultorService consultorService;

    public ConsultorController(ConsultorService consultorService) {
        this.consultorService = consultorService;
    }

    public Consultor adicionarConsultor(ConsultorDTO consultorDTO) {
        Consultor novoConsultor = new Consultor();
        novoConsultor.setNome(consultorDTO.getNome());
        return consultorService.adicionarConsultor(novoConsultor);
    }

    public Consultor atualizarConsultor(ConsultorDTO consultorDTO, Long id) {
        Consultor atualizarConsultor = new Consultor();
        atualizarConsultor.setId(id);
        atualizarConsultor.setNome(consultorDTO.getNome());
        return consultorService.atualizarConsultor(atualizarConsultor);
    }

    public Consultor findConsultorById(Long id) {
        return consultorService.findById(id);
    }

    public List<Consultor> findAll() {
        return consultorService.findAll();
    }

    public void excluirConsultor(Long id) {
        Consultor excluirConsultor = consultorService.findById(id);
        if (excluirConsultor == null) {
            System.out.println("ERRO: consultor não encontrado");
            return;
        }
        consultorService.excluirConsultor(id);
        System.out.println("Consultor excluído com sucesso");
    }
    
    public Consultor findByNome(String nome) {
		return consultorService.findByNome(nome);
	}
	
}
