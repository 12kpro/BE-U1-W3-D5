package dao;

import entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class UtenteDAO {
    private EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Utente utente) {
        em.getTransaction().begin();
        em.persist(utente);
        em.getTransaction().commit();
    }

    public Utente findById(Long id) {
        return em.find(Utente.class, id);
    }

    public List<Utente> findAll() {
        Query q = em.createQuery("SELECT u FROM Utente u");
        return q.getResultList();
    }

    public void update(Utente utente) {
        em.getTransaction().begin();
        em.merge(utente);
        em.getTransaction().commit();
    }

    public void delete(Utente utente) {
        em.getTransaction().begin();
        em.remove(utente);
        em.getTransaction().commit();
    }
}
