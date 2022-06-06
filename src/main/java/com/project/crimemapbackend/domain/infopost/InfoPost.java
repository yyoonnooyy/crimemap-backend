package com.project.crimemapbackend.domain.infopost;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name="info_post")
public class InfoPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer post_num;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "content", length = 3000, nullable = false)
    private String content;

    @Column(name = "reg_time", nullable = false)
    private LocalDate regTime;

    @Column(name = "fix_time", nullable = false)
    private LocalDate fixTime;

    @Builder
    public InfoPost(Integer post_num, String title, String content, LocalDate regTime, LocalDate fixTime) {
        this.post_num = post_num;
        this.title = title;
        this.content = content;
        this.regTime = regTime;
        this.fixTime = fixTime;
    }
}
