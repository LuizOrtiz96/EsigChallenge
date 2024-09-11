package br.com.luizortiz.repository;

import br.com.luizortiz.model.Cargo;
import br.com.luizortiz.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}

