package br.com.luizortiz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "pessoa_salario_consolidado")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaSalarioConsolidado {
    @Id
    @Column(name = "pessoa_id")
    private int pessoaId;

    @Column(name = "nome_pessoa")
    private String nomePessoa;

    @Column(name = "nome_cargo")
    private String nomeCargo;

    @Column(name = "salario")
    private BigDecimal salario;

}
