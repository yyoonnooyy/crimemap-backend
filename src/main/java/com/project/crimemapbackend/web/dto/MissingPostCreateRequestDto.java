package com.project.crimemapbackend.web.dto;

import com.project.crimemapbackend.domain.missingpost.MissingPost;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class MissingPostCreateRequestDto {
    private Integer post_num;
    private String title;
    private String region;
    private String name;
    private String content;
    private LocalDate regTime;
    private LocalDate fixTime;

    @Builder
    public MissingPostCreateRequestDto(Integer post_num, String title, String region, String name, String content, LocalDate regTime, LocalDate fixTime) {
        this.post_num = post_num;
        this.title = title;
        this.region = region;
        this.name = name;
        this.content = content;
        this.regTime = regTime;
        this.fixTime = fixTime;
    }

    public MissingPost toEntity() {
        return MissingPost.builder()
                .title(title)
                .region(region)
                .name(name)
                .content(content)
                .regTime(regTime)
                .fixTime(fixTime)
                .build();
    }
}
