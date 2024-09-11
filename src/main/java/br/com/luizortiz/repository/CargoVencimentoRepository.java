package br.com.luizortiz.repository;

import br.com.luizortiz.model.Cargo;
import br.com.luizortiz.model.CargoVencimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoVencimentoRepository extends JpaRepository<CargoVencimento, Integer> {
}
