package com.gg.onboarding;

import com.gg.onboarding.DTO.BoardCreateRequestDto;
import com.gg.onboarding.DTO.BoardCreateResponseDto;
import com.gg.onboarding.DTO.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;
    @PostMapping("/board")
    public ResponseEntity boardCreate(@RequestBody BoardCreateRequestDto requestDto) {
        return new ResponseEntity(Response.<BoardCreateResponseDto>builder()
                .status(201).message("게시글 등록 성공")
                .data(boardService.boardCreate(requestDto)).build(), HttpStatus.CREATED);
    }
}
