package br.com.luizortiz.controller;

import br.com.luizortiz.model.Pessoa;
import br.com.luizortiz.model.PessoaSalarioConsolidado;
import br.com.luizortiz.service.ConsolidacaoService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ConsolidacaoBean implements Serializable {

    @EJB
    private ConsolidacaoService consolidacaoService;

    private List<PessoaSalarioConsolidado> resultados;

    @PostConstruct
    public void init() {
        consolidarSalarios();
    }

    public void consolidarSalarios() {
        resultados = consolidacaoService.consolidarSalarios();
    }

    public List<PessoaSalarioConsolidado> getResultados() {
        return resultados;
    }
}