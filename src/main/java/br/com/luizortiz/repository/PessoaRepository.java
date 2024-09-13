package br.com.luizortiz.repository;

import br.com.luizortiz.model.Pessoa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PessoaRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Pessoa> listAll(){
        String sql = "select e from Endereco e ";
        TypedQuery<Pessoa> query = em.createQuery(sql, Pessoa.class);
        return query.getResultList();
    }
}

