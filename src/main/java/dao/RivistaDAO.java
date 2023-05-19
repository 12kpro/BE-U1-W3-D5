package dao;

import entities.Rivista;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class RivistaDAO {
    private EntityManager em;

    public RivistaDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Rivista rivista) {
        em.getTransaction().begin();
        em.persist(rivista);
        em.getTransaction().commit();
    }

    public Rivista findByIsbn(String isbn) {
        return em.find(Rivista.class, isbn);
    }

    public List<Rivista> findAll() {
        TypedQuery<Rivista> query = em.createQuery("SELECT r FROM Rivista r", Rivista.class);
        return query.getResultList();
    }

    public void update(Rivista rivista) {
        em.getTransaction().begin();
        em.merge(rivista);
        em.getTransaction().commit();
    }

    public void delete(Rivista rivista) {
        em.getTransaction().begin();
        em.remove(rivista);
        em.getTransaction().commit();
    }
}
