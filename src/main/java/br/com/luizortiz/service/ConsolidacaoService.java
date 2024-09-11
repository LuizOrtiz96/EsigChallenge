package br.com.luizortiz.service;

import br.com.luizortiz.model.*;
import br.com.luizortiz.repository.CargoRepository;
import br.com.luizortiz.repository.CargoVencimentoRepository;
import br.com.luizortiz.repository.PessoaRepository;
import br.com.luizortiz.repository.VencimentosRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConsolidacaoService {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private CargoRepository cargoRepository;
    @Autowired
    private CargoVencimentoRepository cargoVencimentoRepository;
    @Autowired
    private VencimentosRepository vencimentosRepository;
    @Autowired
    private PessoaSalarioConsolidado pessoaSalarioConsolidado;
    private List<PessoaSalarioConsolidado> dados;

    private void refreshDados() {
        pessoaRepository.deleteAll();
    }

    @Transactional
    public List<PessoaSalarioConsolidado> consolidarSalarios() {
        //refreshDados();
        List<PessoaSalarioConsolidado> dados = new ArrayList<>();
        BigDecimal salario = BigDecimal.ZERO;
        List<Pessoa> pessoas = pessoaRepository.findAll();

        for (Pessoa pessoa : pessoas) {
            PessoaSalarioConsolidado psc = new PessoaSalarioConsolidado();
            psc.setPessoaId(pessoa.getId());
            psc.setNomePessoa(pessoa.getNome());
            psc.setNomeCargo(cargoRepository.findByPessoaId(pessoa.getId()).getNome());

            for (Vencimentos vencimento : vencimentosRepository.findByPessoaId(pessoa.getId())) {
                if ("CREDITO".equals(vencimento.getTipo())) {
                    salario = salario.add(vencimento.getValor());
                } else if ("DEBITO".equals(vencimento.getTipo())) {
                    salario = salario.subtract(vencimento.getValor());
                }
            }
                psc.setSalario(salario);
                dados.add(psc);
        }
        return dados;
    }
}
