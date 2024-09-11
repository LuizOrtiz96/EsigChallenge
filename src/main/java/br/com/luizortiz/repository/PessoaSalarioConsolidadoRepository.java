package br.com.luizortiz.repository;

import br.com.luizortiz.model.Cargo;
import br.com.luizortiz.model.PessoaSalarioConsolidado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PessoaSalarioConsolidadoRepository extends JpaRepository<PessoaSalarioConsolidado, Integer> {
    public List<PessoaSalarioConsolidado> findAllByOrderAsc();
}
