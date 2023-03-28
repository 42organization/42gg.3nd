package gg.nd.exTest.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class DocsRepository {
    private final EntityManager em;

    public DocsRepository(EntityManager em){
        this.em = em;
    }

    public Docs save(Docs docs){
        em.persist(docs);
        return docs;
    }

    public Optional<Docs> findById(Long id){
        Docs docs = em.find(Docs.class, id);
        return Optional.ofNullable(docs);
    }

    public List<Docs> findAll() {
        return em.createQuery("select m from Docs m", Docs.class).getResultList();
    }

    public Optional<Docs> findByName(String name) {
        List<Docs> result = em.createQuery("select m from Docs m where m.name = :name", Docs.class)
                .setParameter("name", name).getResultList();
        return result.stream().findAny();
    }
}
