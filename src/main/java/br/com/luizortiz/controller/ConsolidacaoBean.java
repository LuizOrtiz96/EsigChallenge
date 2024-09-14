package br.com.luizortiz.controller;

import br.com.luizortiz.model.PessoaSalarioConsolidado;
import br.com.luizortiz.service.ConsolidacaoService;
import lombok.Getter;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ConsolidacaoBean implements Serializable {

    @EJB
    private ConsolidacaoService consolidacaoService;

    @Getter
    private List<PessoaSalarioConsolidado> resultados;

    public void consolidarSalarios() {
        resultados = consolidacaoService.consolidarSalarios();
    }

}