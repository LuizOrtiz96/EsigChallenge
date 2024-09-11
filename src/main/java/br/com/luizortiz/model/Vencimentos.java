package br.com.luizortiz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "vencimentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vencimentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "tipo")
    private String tipo;
}
