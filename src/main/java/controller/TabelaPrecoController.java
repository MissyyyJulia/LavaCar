package controller;

import java.util.List;

import model.entities.TabelaPreco;
import model.services.TabelaPrecoService;
import view.TabelaPrecoDTO;


public class TabelaPrecoController {

    public TabelaPrecoService tabelaService;

    public TabelaPrecoController(TabelaPrecoService tabelaService) {
        this.tabelaService = tabelaService;
    }

    public TabelaPreco adicionarTabelaPreco(TabelaPrecoDTO tabelaPrecoDTO) {
        TabelaPreco novoTabelaPreco = new TabelaPreco();
        novoTabelaPreco.setModelo(tabelaPrecoDTO.getModelo());
        novoTabelaPreco.setPreco(tabelaPrecoDTO.getPreco());
        return tabelaService.adicionarTabelaPreco(novoTabelaPreco);
    }

    public TabelaPreco atualizarTabelaPreco(TabelaPrecoDTO tabelaPrecoDTO, Long id) {
    	TabelaPreco novoTabelaPreco = new TabelaPreco();
    	novoTabelaPreco.setId(id);
        novoTabelaPreco.setModelo(tabelaPrecoDTO.getModelo());
        novoTabelaPreco.setPreco(tabelaPrecoDTO.getPreco());
        return tabelaService.atualizarTabelaPreco(novoTabelaPreco);
    }

    public TabelaPreco findById(Long id) {
        return tabelaService.findById(id);
    }

    public List<TabelaPreco> findAll() {
        return tabelaService.findAll();
    }

    public void excluirTabelaPreco(Long id) {
        TabelaPreco tabelaPreco = tabelaService.findById(id);
        if (tabelaPreco == null) {
            System.out.println("ERRO: item da tabela de preço não encontrado");
            return;
        }
        tabelaService.excluirTabelaPreco(id);
    }
    
    public TabelaPreco findByModelo(String modelo) {
        return tabelaService.findByModelo(modelo);
    }

}
