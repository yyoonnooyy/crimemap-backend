package com.project.crimemapbackend.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class InfoPostUpdateRequestDto {
    private String title;
    private String content;
    private LocalDate fixTime;

    @Builder
    public InfoPostUpdateRequestDto(String title, String content, LocalDate fixTime) {
        this.title = title;
        this.content = content;
        this.fixTime = fixTime;
    }
}
