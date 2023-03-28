package com.gg.onboarding.DTO;

import com.gg.onboarding.domain.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardDetailsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String nickname;
    private LocalDateTime createDate;

    public BoardDetailsResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.nickname = board.getNickname();
        this.createDate = board.getCreate_date();
    }
}
