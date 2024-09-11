package br.com.luizortiz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "pessoa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "email")
    private String email;

    @Column(name = "cep")
    private String cep;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "pais")
    private String pais;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "data_nascimento")
    private String dataNascimento;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;
}
