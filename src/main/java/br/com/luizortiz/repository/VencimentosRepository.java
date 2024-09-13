package br.com.luizortiz.repository;

import br.com.luizortiz.model.Cargo;
import br.com.luizortiz.model.Pessoa;
import br.com.luizortiz.model.Vencimentos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Stateless
public class VencimentosRepository {
    @PersistenceContext
    private EntityManager em;
    public List<Vencimentos> findByPessoaId(Integer pessoaId) {
        TypedQuery<Vencimentos> query = em.createQuery(
                "SELECT v FROM Vencimentos v WHERE v.pessoa.id = :pessoaId", Vencimentos.class);
        query.setParameter("pessoaId", pessoaId);
        return query.getResultList();
    }
}
