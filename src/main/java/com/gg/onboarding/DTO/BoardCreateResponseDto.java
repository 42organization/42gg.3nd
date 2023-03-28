package com.gg.onboarding.DTO;

import com.gg.onboarding.domain.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardCreateResponseDto {
    private Long id;
    private String title;
    private String content;
    private String nickname;
    private LocalDateTime create_date;

    public BoardCreateResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.nickname = board.getNickname();
        this.create_date = board.getCreate_date();
    }
}
