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

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
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

    public List<PessoaSalarioConsolidado> consolidarSalarios() {
        //refreshDados();
        BigDecimal salario = BigDecimal.ZERO;
        dados = new ArrayList<>();

        PessoaSalarioConsolidado psc = new PessoaSalarioConsolidado();
        List<Pessoa> pessoas = pessoaRepository.findAll();
        for (Pessoa pessoa : pessoas) {
            Cargo cargo = cargoRepository.findByPessoaId(pessoa.getId());
            for (Vencimentos vencimento : vencimentosRepository.findByPessoaId(pessoa.getId())) {
                if ("CREDITO".equals(vencimento.getTipo())) {
                    salario = salario.add(vencimento.getValor());
                } else if ("DEBITO".equals(vencimento.getTipo())) {
                    salario = salario.subtract(vencimento.getValor());
                }
                psc.setPessoaId(pessoa.getId());
                psc.setNomePessoa(pessoa.getNome());
                psc.setNomeCargo(cargo.getNome());
                psc.setSalario(salario);
                dados.add(psc);
            }
        }
        return dados;
    }
}
