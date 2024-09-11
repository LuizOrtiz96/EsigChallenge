package br.com.luizortiz.repository;

import br.com.luizortiz.model.Cargo;
import br.com.luizortiz.model.PessoaSalarioConsolidado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaSalarioConsolidadoRepository extends JpaRepository<PessoaSalarioConsolidado, Integer> {
    public List<PessoaSalarioConsolidado> findAllByOrderAsc();
}
