package br.com.luizortiz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cargo_vencimentos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CargoVencimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "vencimento_id")
    private Vencimentos vencimentos;
}
