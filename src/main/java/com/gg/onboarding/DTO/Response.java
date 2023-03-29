package com.gg.onboarding.DTO;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Response<T> {
    private int status;
    private String message;
    private List<T> data;
}
