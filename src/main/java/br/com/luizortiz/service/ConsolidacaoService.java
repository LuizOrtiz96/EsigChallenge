package br.com.luizortiz.service;

import br.com.luizortiz.model.*;
import br.com.luizortiz.repository.CargoRepository;
import br.com.luizortiz.repository.CargoVencimentoRepository;
import br.com.luizortiz.repository.PessoaRepository;
import br.com.luizortiz.repository.VencimentosRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ConsolidacaoService {
    @EJB
    private PessoaRepository pessoaRepository;
    @EJB
    private CargoRepository cargoRepository;
    @EJB
    private CargoVencimentoRepository cargoVencimentoRepository;
    @EJB
    private VencimentosRepository vencimentosRepository;

    public List<Pessoa> listar() {
        return pessoaRepository.listAll();
    }

    public List<PessoaSalarioConsolidado> consolidarSalarios() {
        //refreshDados();
        List<PessoaSalarioConsolidado> dados = new ArrayList<>();
        List<Pessoa> pessoas = pessoaRepository.listAll();

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
