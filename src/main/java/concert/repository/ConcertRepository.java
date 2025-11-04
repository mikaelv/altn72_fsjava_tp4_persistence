package concert.repository;

import concert.entity.Concert;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ConcertRepository {
    private final EntityManagerFactory emf;

    public ConcertRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<Concert> findAll() {
        try (EntityManager em = emf.createEntityManager()) {
            String jpql = ""; // TODO
            TypedQuery<Concert> query = em.createQuery( jpql, Concert.class);
            return query.getResultList();
        }
    }

}
