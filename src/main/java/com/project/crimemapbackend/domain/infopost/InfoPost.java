package com.project.crimemapbackend.domain.infopost;

import com.mysql.cj.jdbc.Blob;
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

    @Column(name = "region", length = 50, nullable = false)
    private String region;

    @Column(name = "content", length = 3000, nullable = false)
    private String content;

    @Column(name = "reg_time", nullable = false)
    private LocalDate regTime;

    @Column(name = "fix_time", nullable = false)
    private LocalDate fixTime;

    @Column(name = "flag", nullable = false)
    private String flag;

    @Builder
    public InfoPost(Integer post_num, String title, String region, String content, LocalDate regTime, LocalDate fixTime, String flag) {
        this.post_num = post_num;
        this.title = title;
        this.region = region;
        this.content = content;
        this.regTime = regTime;
        this.fixTime = fixTime;
        this.flag = flag;
    }

    public void update(String title, String region, String content, LocalDate fixTime) {
        this.title = title;
        this.region = region;
        this.content = content;
        this.fixTime = fixTime;
    }
}
