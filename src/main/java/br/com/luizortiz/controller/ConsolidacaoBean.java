package br.com.luizortiz.controller;

import br.com.luizortiz.model.PessoaSalarioConsolidado;
import br.com.luizortiz.service.ConsolidacaoService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class ConsolidacaoBean {
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
