package br.com.luizortiz.repository;

import br.com.luizortiz.model.Cargo;
import br.com.luizortiz.model.Vencimentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VencimentosRepository extends JpaRepository<Vencimentos, Integer> {

    @Query("SELECT v FROM Vencimentos v WHERE v.pessoa.id = :pessoaId")
    List<Vencimentos> findByPessoaId(@Param("pessoaId") Integer pessoaId);
}
