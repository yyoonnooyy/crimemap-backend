package com.project.crimemapbackend.domain.image;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
@Table(name="image")
public class Image {
    @Id
    @Column(name = "img_id", length = 50, nullable = false)
    private String imgId;

    @Column(name = "img_url", length = 500, nullable = false)
    private String imgUrl;

    @Builder
    public Image(String imgId, String imgUrl) {
        this.imgId = imgId;
        this.imgUrl = imgUrl;
    }
}
