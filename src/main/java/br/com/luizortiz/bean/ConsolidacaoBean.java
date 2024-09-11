package br.com.luizortiz.bean;

import br.com.luizortiz.model.PessoaSalarioConsolidado;
import br.com.luizortiz.service.ConsolidacaoService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class ConsolidacaoBean {
    private ConsolidacaoService consolidacaoService = new ConsolidacaoService();
    private List<PessoaSalarioConsolidado> resultados;

    public void consolidarSalarios() {
        resultados = consolidacaoService.consolidarSalarios();
    }

    public List<PessoaSalarioConsolidado> getResultados() {
        return resultados;
    }
}
