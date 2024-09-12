package br.com.luizortiz.service;

import br.com.luizortiz.model.*;
import br.com.luizortiz.repository.CargoRepository;
import br.com.luizortiz.repository.CargoVencimentoRepository;
import br.com.luizortiz.repository.PessoaRepository;
import br.com.luizortiz.repository.VencimentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.enterprise.context.ApplicationScoped;
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

    @Transactional
    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    @Transactional
    public List<PessoaSalarioConsolidado> consolidarSalarios() {
        //refreshDados();
        List<PessoaSalarioConsolidado> dados = new ArrayList<>();
        List<Pessoa> pessoas = pessoaRepository.findAll();

        for (Pessoa pessoa : pessoas) {
            PessoaSalarioConsolidado psc = new PessoaSalarioConsolidado();
            psc.setPessoaId(pessoa.getId());
            psc.setNomePessoa(pessoa.getNome());
            psc.setNomeCargo(cargoRepository.findByPessoaId(pessoa.getId()).getNome());

            BigDecimal salario = BigDecimal.ZERO;

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
