package com.project.crimemapbackend.web.dto;

import com.project.crimemapbackend.domain.image.Image;
import lombok.Getter;

@Getter
public class ImageResponseDto {
    private final String imgId;
    private final String imgUrl;

    public ImageResponseDto(Image entity) {
        this.imgId = entity.getImgId();
        this.imgUrl = entity.getImgUrl();
    }
}
