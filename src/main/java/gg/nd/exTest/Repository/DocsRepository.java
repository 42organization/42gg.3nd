package gg.nd.exTest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public interface DocsRepository extends JpaRepository<Docs, Long> {

    Optional<Docs> findByName(String name);
}
