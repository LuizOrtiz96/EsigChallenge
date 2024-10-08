package br.com.luizortiz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cargo")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nome")
    private String nome;


}
