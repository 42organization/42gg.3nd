package gg.nd.exTest;

import gg.nd.exTest.Repository.DocsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.persistence.EntityManager;


@Configuration
public class DocsConfig {
    private final EntityManager em;

    public DocsConfig(EntityManager em){
        this.em = em;
    }
    @Bean
    public DocsRepository docsRepository(){
        return new DocsRepository(em);
    }
}
