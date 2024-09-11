package br.com.luizortiz.repository;

import br.com.luizortiz.model.Cargo;
import br.com.luizortiz.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
