package com.gg.onboarding.DTO;

import com.gg.onboarding.domain.Board;
import lombok.Getter;

@Getter
public class BoardModifyRequestDto {
    private String title;
    private String content;
    private String nickname;
}
