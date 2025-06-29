package controller;

import java.util.List;

import model.entities.Carro;
import model.entities.Consultor;
import model.entities.Lavagem;
import model.services.CarroService;
import model.services.ConsultorService;
import model.services.LavagemService;
import view.LavagemDTO;

public class LavagemController {

    private LavagemService lavagemService;
    private CarroService carroService;
    private ConsultorService consultorService;

    public LavagemController(LavagemService lavagemService, CarroService carroService, ConsultorService consultorService) {
        this.lavagemService = lavagemService;
        this.carroService = carroService;
        this.consultorService = consultorService;
    }

    public Lavagem adicionarLavagem(LavagemDTO lavagemDTO) {
        Carro carro = null;

        //procura o carro com base no tipo pra dps atribuir pra lavagem
        if (lavagemDTO.getTipoCarro().equalsIgnoreCase("NOVO")) {
            carro = carroService.findByChassi(lavagemDTO.getIdentificador());
        } else if (lavagemDTO.getTipoCarro().equalsIgnoreCase("SEMINOVO")) {
            carro = carroService.findByPlaca(lavagemDTO.getIdentificador());
        }

        //procura o nome do consultor pra dps atribuir pra lavagem
        Consultor consultor = consultorService.findByNome(lavagemDTO.getNomeConsultor());

        Lavagem novaLavagem = new Lavagem();
        novaLavagem.setData(lavagemDTO.getData());
        novaLavagem.setOrdemServico(lavagemDTO.getOrdemServico());
        novaLavagem.setConsultor(consultor);
        novaLavagem.setCarro(carro);

        return lavagemService.adicionarLavagem(novaLavagem);
    }

    public Lavagem atualizarLavagem(LavagemDTO lavagemDTO, Long id) {
        Carro carro = null;

        if (lavagemDTO.getTipoCarro().equalsIgnoreCase("NOVO")) {
            carro = carroService.findByChassi(lavagemDTO.getIdentificador());
        } else if (lavagemDTO.getTipoCarro().equalsIgnoreCase("SEMINOVO")) {
            carro = carroService.findByPlaca(lavagemDTO.getIdentificador());
        }

        Consultor consultor = consultorService.findByNome(lavagemDTO.getNomeConsultor());

        Lavagem lavagemAtualizada = new Lavagem();
        lavagemAtualizada.setId(id);
        lavagemAtualizada.setData(lavagemDTO.getData());
        lavagemAtualizada.setOrdemServico(lavagemDTO.getOrdemServico());
        lavagemAtualizada.setConsultor(consultor);
        lavagemAtualizada.setCarro(carro);

        return lavagemService.atualizarLavagem(lavagemAtualizada);
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
