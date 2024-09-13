package br.com.luizortiz.repository;

import br.com.luizortiz.model.Cargo;
import br.com.luizortiz.model.Vencimentos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CargoRepository {
    @PersistenceContext
    private EntityManager em;

    public Cargo findByPessoaId(Integer id) {
        // O método find faz a busca pelo ID
        return em.find(Cargo.class, id);
    }
}


