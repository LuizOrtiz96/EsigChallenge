package br.com.luizortiz.repository;

import br.com.luizortiz.model.PessoaSalarioConsolidado;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PessoaSalarioConsolidadoRepository {
    @PersistenceContext
    private EntityManager em;

    public List<PessoaSalarioConsolidado> findAllByOrderAsc() {
        TypedQuery<PessoaSalarioConsolidado> query = em.createQuery(
                "SELECT p FROM PessoaSalarioConsolidado p ORDER BY p.id ASC", PessoaSalarioConsolidado.class);

        return query.getResultList();
    }
}
