package com.gg.onboarding;

import com.gg.onboarding.DTO.*;
import com.gg.onboarding.domain.Board;
import com.gg.onboarding.domain.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public BoardCreateResponseDto boardCreate(BoardCreateRequestDto createRequestDto) {
        return new BoardCreateResponseDto(boardRepository.save(new Board(createRequestDto)));
    }

    public BoardDetailsResponseDto boardDetails(Long board_id) {
        return new BoardDetailsResponseDto(boardRepository.findBoardById(board_id).orElseThrow());
    }

    public List<BoardListResponseDto> boardList() {
        return boardRepository.findAll().stream()
                .map(BoardListResponseDto::new).collect(Collectors.toList());
    }
    public BoardDetailsResponseDto boardModify(Long boardId, BoardModifyRequestDto requestDto) {
        Board board = boardRepository.findBoardById(boardId).orElseThrow();
        board.boardModify(requestDto);
        return new BoardDetailsResponseDto(board);
    }
    public boolean boardRemove(Long boardId) {
        if (boardRepository.findBoardById(boardId).isPresent()) {
            boardRepository.deleteById(boardId);
        } else {
            return false;
        }
        return true;
    }
}
