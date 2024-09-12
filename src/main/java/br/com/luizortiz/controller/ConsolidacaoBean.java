package br.com.luizortiz.controller;

import br.com.luizortiz.model.Pessoa;
import br.com.luizortiz.model.PessoaSalarioConsolidado;
import br.com.luizortiz.service.ConsolidacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class ConsolidacaoBean implements Serializable {

    @Autowired
    private ConsolidacaoService consolidacaoService;

    private List<PessoaSalarioConsolidado> resultados;

    public void consolidarSalarios() {
        resultados = consolidacaoService.consolidarSalarios();
    }

    public List<PessoaSalarioConsolidado> getResultados() {
        return resultados;
    }
}