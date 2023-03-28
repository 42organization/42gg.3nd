package com.gg.onboarding;

import com.gg.onboarding.DTO.BoardCreateRequestDto;
import com.gg.onboarding.DTO.BoardCreateResponseDto;
import com.gg.onboarding.domain.Board;
import com.gg.onboarding.domain.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public BoardCreateResponseDto boardCreate(BoardCreateRequestDto createRequestDto) {
        return new BoardCreateResponseDto(boardRepository.save(new Board(createRequestDto)));
    }
}
