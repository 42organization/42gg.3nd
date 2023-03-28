package com.gg.onboarding.domain;

import com.gg.onboarding.DTO.BoardCreateRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(length = 30)
    private String nickname;
    @Column
    private LocalDateTime create_date;

    @Column
    private LocalDateTime update_date;

    public Board(BoardCreateRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.nickname = requestDto.getNickname();
        this.create_date = LocalDateTime.now();
        this.update_date = LocalDateTime.now();
    }

}
