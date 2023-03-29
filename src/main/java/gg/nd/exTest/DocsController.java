package gg.nd.exTest;

import gg.nd.exTest.Repository.Docs;
import gg.nd.exTest.Repository.ReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class DocsController {
    private final DocsService docsService;

    @Autowired
    public DocsController(DocsService docsService) {
        this.docsService = docsService;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Docs> getHome() {//"/" 게시물 리스트 출력
        System.out.println(docsService.findDocs());
        List<Docs> req = docsService.findDocs();
        return req;
    }

    @PostMapping("/docs")
    public void postDocs(ReqDto res) {//post "/docs" 게시물 등록 버튼 선택 시 오는 요청 디비 저장
        Docs docs = new Docs();
        docs.setName(res.getName());
        docs.setContent(res.getContent());

        docsService.save(docs);
    }

    @GetMapping("/docs/{id}")
    @ResponseBody
    public Optional<Docs> getDocsId(@PathVariable Long id) {//get "/docs/:id" 선택한 게시물 내용(/docs/:id)로 반환
        return docsService.findOne(id);
    }

    @PostMapping("/put/docs/")
    public void putDocsId(ReqDto res) {//post "/put/docs" 수정페이지(/docs, 내용물 있음) 내용 디비에 수정
        Docs docs = new Docs();
        docs.setName(res.getName());
        docs.setContent(res.getContent());

        docsService.save(docs);
    }

    @PostMapping("/del/docs/{id}")
    public void postDelDocsId(@PathVariable Long id) {//post "/del/docs/:id" 메인페이지에서 해당 게시물 디비에서 삭제
        docsService.delete(id);
    }
}
