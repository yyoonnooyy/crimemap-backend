package com.project.crimemapbackend.domain.missingpost;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
@Table(name="missing_post")
public class MissingPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer post_num;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "region", length = 50, nullable = false)
    private String region;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "content", length = 3000, nullable = false)
    private String content;

    @Column(name = "reg_time", nullable = false)
    private LocalDate regTime;

    @Column(name = "fix_time", nullable = false)
    private LocalDate fixTime;

    @Builder
    public MissingPost(Integer post_num, String title, String region, String name, String content, LocalDate regTime, LocalDate fixTime) {
        this.post_num = post_num;
        this.title = title;
        this.region = region;
        this.name = name;
        this.content = content;
        this.regTime = regTime;
        this.fixTime = fixTime;
    }

    public void update(String title, String region, String name, String content, LocalDate fixTime) {
        this.title = title;
        this.region = region;
        this.name = name;
        this.content = content;
        this.fixTime = fixTime;
    }
}
