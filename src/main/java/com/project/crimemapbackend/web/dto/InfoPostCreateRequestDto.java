package com.project.crimemapbackend.web.dto;

import com.project.crimemapbackend.domain.infopost.InfoPost;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class InfoPostCreateRequestDto {
    private Integer post_num;
    private String title;
    private String content;
    private LocalDate regTime;
    private LocalDate fixTime;

    @Builder
    public InfoPostCreateRequestDto(Integer post_num, String title, String content, LocalDate regTime, LocalDate fixTime) {
        this.post_num = post_num;
        this.title = title;
        this.content = content;
        this.regTime = regTime;
        this.fixTime = fixTime;
    }

    public InfoPost toEntity() {
        return InfoPost.builder()
                .title(title)
                .content(content)
                .regTime(regTime)
                .fixTime(fixTime)
                .build();
    }
}
