package com.project.crimemapbackend.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class MissingPostUpdateRequestDto {
    private String title;
    private String region;
    private String name;
    private String content;
    private LocalDate fixTime;

    @Builder
    public MissingPostUpdateRequestDto(String title, String region, String name, String content, LocalDate fixTime) {
        this.title = title;
        this.region = region;
        this.name = name;
        this.content = content;
        this.fixTime = fixTime;
    }
}