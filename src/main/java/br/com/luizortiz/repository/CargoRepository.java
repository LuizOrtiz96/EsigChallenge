package br.com.luizortiz.repository;

import br.com.luizortiz.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {

    @Query("SELECT c FROM Cargo c WHERE c.id = (SELECT cv.cargo.id FROM CargoVencimentos cv WHERE cv.pessoa.id = :pessoaId)")
    Cargo findByPessoaId(@Param("pessoaId") Integer pessoaId);
}
