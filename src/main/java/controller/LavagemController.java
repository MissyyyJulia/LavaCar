package controller;

import java.util.List;

import model.entities.Lavagem;
import model.services.LavagemService;
import view.LavagemDTO;

public class LavagemController {

    private LavagemService lavagemService;
    

    public LavagemController(LavagemService lavagemService) {
        this.lavagemService = lavagemService;
    }

    public Lavagem adicionarLavagem(LavagemDTO lavagemDTO) {
        return lavagemService.adicionarLavagem(lavagemDTO);
    }

    public Lavagem atualizarLavagem(LavagemDTO lavagemDTO, Long id) {
        return lavagemService.atualizarLavagem(lavagemDTO, id);
    }

    public Lavagem findById(Long id) {
        return lavagemService.findById(id);
    }

    public List<Lavagem> findAll() {
        return lavagemService.findAll();
    }

    public List<Lavagem> findByConsultorId(Long idConsultor) {
        return lavagemService.findByConsultorId(idConsultor);
    }

    public void excluirLavagem(Long id) {
        lavagemService.excluirLavagem(id);
    }
}
