package com.gg.onboarding;

import com.gg.onboarding.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
public class BoardController {
    @Autowired
    private BoardService boardService;
    @PostMapping("/board")
    public ResponseEntity boardCreate(@RequestBody BoardCreateRequestDto requestDto) {
        return new ResponseEntity(Response.<BoardCreateResponseDto>builder()
                .status(201).message("게시글 등록 성공")
                .data(Collections.singletonList(boardService.boardCreate(requestDto))).build(), HttpStatus.CREATED);
    }

    @GetMapping("/board/{id}")
    public ResponseEntity boardDetails(@PathVariable("id") Long id) {
        return new ResponseEntity(Response.<BoardDetailsResponseDto>builder()
                .status(200).message("게시글 1건 조회 성공")
                .data(Collections.singletonList(boardService.boardDetails(id))).build(), HttpStatus.OK);
    }

    @GetMapping("/board/list")
    public ResponseEntity boardList() {
        return new ResponseEntity(Response.<BoardListResponseDto>builder()
                .status(200).message("게시글 리스트 조회 성공")
                .data(boardService.boardList()).build(),HttpStatus.OK);
    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity boardRemove(@PathVariable("id") Long boardId) {
        if (boardService.boardRemove(boardId)) {
            return new ResponseEntity(Response.builder()
                    .status(204).message("게시글 삭제 성공")
                    .build(), HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(Response.builder()
                    .status(404).message("존재하지 않는 게시글입니다.")
                    .build(), HttpStatus.OK);
        }
    }
}
