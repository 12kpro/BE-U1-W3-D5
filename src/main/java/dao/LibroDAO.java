package dao;

import entities.Libro;

import java.util.List;
import javax.persistence.*;

public class LibroDAO {
    private EntityManager em;

    public LibroDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Libro libro) {
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
    }
    public void update(Libro libro) {
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();
    }

    public void delete(Libro libro) {
        em.getTransaction().begin();
        em.remove(libro);
        em.getTransaction().commit();
    }
    public Libro findByIsbn(Long isbn) {
        return em.find(Libro.class, isbn);
    }

    public List<Libro> findAll() {
        TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l", Libro.class);
        return query.getResultList();
    }


}

