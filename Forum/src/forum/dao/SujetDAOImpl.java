/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.dao;

import forum.entity.Sujet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public class SujetDAOImpl implements SujetDAOInterface {
    
    public void ajouter(Sujet s) {
        EntityManager em = Persistence.createEntityManagerFactory("ForumPU").createEntityManager();
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
    }

    public void supprimer(Long id) {
        EntityManager em = Persistence.createEntityManagerFactory("ForumPU").createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Sujet s WHERE s.id =" + id).executeUpdate();
        em.getTransaction().commit();
    }

    public void modifier(Sujet s) {
        EntityManager em = Persistence.createEntityManagerFactory("ForumPU").createEntityManager();
        em.getTransaction().begin();
        em.merge(s);
        em.getTransaction().commit();
    }

    public Sujet rechercherParId(Long id) {
        EntityManager em = Persistence.createEntityManagerFactory("ForumPU").createEntityManager();

        return em.find(Sujet.class, id);
    }

    public List<Sujet> listerTous() {
        EntityManager em = Persistence.createEntityManagerFactory("ForumPU").createEntityManager();
        return em.createQuery("SELECT s FROM Sujet s").getResultList();

    }
    
}
