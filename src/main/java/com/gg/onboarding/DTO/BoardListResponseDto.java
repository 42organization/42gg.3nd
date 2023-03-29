package com.gg.onboarding.DTO;

import com.gg.onboarding.domain.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardListResponseDto {
    private Long id;
    private String title;
    private String nickname;
    private LocalDateTime createDate;

    public BoardListResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.nickname = board.getNickname();
        this.createDate = board.getCreate_date();
    }
}
