package com.project.crimemapbackend.web.dto;

import com.mysql.cj.jdbc.Blob;
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
    private String region;
    private String content;
    private LocalDate regTime;
    private LocalDate fixTime;
    private String flag;

    @Builder
    public InfoPostCreateRequestDto(Integer post_num, String title, String region, String content, LocalDate regTime, LocalDate fixTime, String flag) {
        this.post_num = post_num;
        this.title = title;
        this.region = region;
        this.content = content;
        this.regTime = regTime;
        this.fixTime = fixTime;
        this.flag = flag;
    }

    public InfoPost toEntity() {
        return InfoPost.builder()
                .title(title)
                .region(region)
                .content(content)
                .regTime(regTime)
                .fixTime(fixTime)
                .flag(flag)
                .build();
    }
}
