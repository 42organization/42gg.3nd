package com.gg.onboarding.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
public class BoardCreateRequestDto {
    private String title;
    private String content;
    private String nickname;
}
