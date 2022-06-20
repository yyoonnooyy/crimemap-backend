package com.project.crimemapbackend.web.dto;

import com.project.crimemapbackend.domain.image.Image;
import com.project.crimemapbackend.domain.infopost.InfoPost;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class ImageCreateRequestDto {
    private String imgId;
    private String imgUrl;

    @Builder
    public ImageCreateRequestDto(String imgId, String imgUrl) {
        this.imgId = imgId;
        this.imgUrl = imgUrl;
    }

    public Image toEntity() {
        return Image.builder()
                .imgId(imgId)
                .imgUrl(imgUrl)
                .build();
    }
}
