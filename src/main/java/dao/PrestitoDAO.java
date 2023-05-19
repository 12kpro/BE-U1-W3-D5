package dao;

import entities.Prestito;
import entities.Pubblicazione;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class PrestitoDAO {
    private EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Prestito prestito) {
        em.getTransaction().begin();
        em.persist(prestito);
        em.getTransaction().commit();
    }
    public void update(Prestito prestito) {
        em.getTransaction().begin();
        em.merge(prestito);
        em.getTransaction().commit();
    }

    public void delete(Prestito prestito) {
        em.getTransaction().begin();
        em.remove(prestito);
        em.getTransaction().commit();
    }
    public Prestito findById(UUID id) {
        return em.find(Prestito.class, id);
    }

    public List<Prestito> findAll() {
        Query q = em.createQuery("SELECT p FROM Prestito p");
        return q.getResultList();
    }

    public List<Prestito>  findByTesseraUtente(String t) {
        Query q = em.createQuery("SELECT p FROM Prestito p JOIN Utente u on p.utente=u.id WHERE u.numeroTessera = :t");
        q.setParameter("t", UUID.fromString(t));
        return q.getResultList();
    }
    public List<Prestito>  findExpired() {
        Query q = em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva < now()");
        return q.getResultList();
    }
}
