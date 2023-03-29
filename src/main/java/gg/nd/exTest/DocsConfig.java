package gg.nd.exTest;

import gg.nd.exTest.Repository.DocsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.persistence.EntityManager;


@Configuration
public class DocsConfig {
    private final DocsRepository docsRepository;

    public DocsConfig(DocsRepository docsRepository){
        this.docsRepository = docsRepository;
    }

    @Bean
    public DocsService docsService(){
        return new DocsService(docsRepository);
    }
}
