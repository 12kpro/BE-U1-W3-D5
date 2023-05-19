package dao;

import entities.Libro;
import entities.Pubblicazione;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
@Slf4j
public class PubblicazioneDAO {
    private EntityManager em;

    public PubblicazioneDAO(EntityManager em) {
        this.em = em;
    }

    public Pubblicazione findByIsbn(String isbn) {
        return em.find(Pubblicazione.class, isbn);
    }
    public void deleteByIsbn(String isbn) {
        Pubblicazione p = em.find(Pubblicazione.class, isbn);
        if (p != null) em.remove(p);
    }
    public List<Pubblicazione> findAll() {
        Query q = em.createQuery("SELECT p FROM Pubblicazione p");
        return q.getResultList();
    }
    public List<Pubblicazione>  findByAutore(String a) {
        Query q = em.createQuery("SELECT p FROM Pubblicazione p WHERE p.autore = :autore");
        q.setParameter("autore", a);
        return q.getResultList();
    }
    public List<Pubblicazione>  findByAnnoPubblicazione(int a) {
        Query q = em.createQuery("SELECT p FROM Pubblicazione p WHERE p.annoPubblicazione = :anno");
        q.setParameter("anno", a);
        return q.getResultList();
    }
    public List<Pubblicazione>  findByTitolo(String str) {
        Query q = em.createQuery("SELECT p FROM Pubblicazione p WHERE LOWER(p.titolo) LIKE :str");
        q.setParameter("str", "%" + str.toLowerCase() + "%");
        return q.getResultList();
    }


}
