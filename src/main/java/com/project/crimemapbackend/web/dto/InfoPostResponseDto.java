package com.project.crimemapbackend.web.dto;

import com.project.crimemapbackend.domain.infopost.InfoPost;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class InfoPostResponseDto {
    private final Integer post_num;
    private final String title;
    private final String content;
    private final LocalDate reg_time;
    private final LocalDate fix_time;

    public InfoPostResponseDto(InfoPost entity) {
        this.post_num = entity.getPost_num();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.reg_time = entity.getRegTime();
        this.fix_time = entity.getFixTime();
    }
}
