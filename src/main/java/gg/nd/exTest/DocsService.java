package gg.nd.exTest;

import gg.nd.exTest.Repository.Docs;
import gg.nd.exTest.Repository.DocsRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class DocsService {
    private final DocsRepository docsRepository;

    public DocsService(DocsRepository docsRepository){
        this.docsRepository = docsRepository;
    }

    public Long save(Docs docs) {
        docsRepository.save(docs);
        return docs.getId();
    }

    public List<Docs> findDocs() {
        return docsRepository.findAll();
    }

    public Optional<Docs> findOne(Long docsId) {
        return docsRepository.findById(docsId);
    }

    public void delete(Long id){
        docsRepository.deleteById(id);
    }
}
