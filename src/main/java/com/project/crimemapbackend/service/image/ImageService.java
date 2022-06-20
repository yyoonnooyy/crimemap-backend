package com.project.crimemapbackend.service.image;

import com.project.crimemapbackend.domain.image.Image;
import com.project.crimemapbackend.domain.image.ImageRepository;
import com.project.crimemapbackend.web.dto.ImageCreateRequestDto;
import com.project.crimemapbackend.web.dto.ImageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ImageService {
    private final ImageRepository imageRepository;

    // Create image
    @Transactional
    public String createImage(@RequestBody ImageCreateRequestDto requestDto) {
        return imageRepository.save(requestDto.toEntity()).getImgId();
    }

    // Read all Missingposts Image
    @Transactional(readOnly = true)
    public List<ImageResponseDto> findAll() {
        return imageRepository.findAll().stream()
                .map(ImageResponseDto::new)
                .collect(Collectors.toList());
    }

    // Read detail Infopost Image
    @Transactional(readOnly = true)
    public ImageResponseDto searchByNum(String img_id) {
        Image image = imageRepository.findById(img_id).orElseThrow(()
                -> new IllegalArgumentException("해당 이미지가 존재하지 않습니다."));

        return new ImageResponseDto(image);
    }

    // Delete
    @Transactional
    public void delete(String img_id) {
        Image image = imageRepository.findById(img_id).orElseThrow(()
                -> new IllegalArgumentException("해당 이미지가 존재하지 않습니다."));

        imageRepository.delete(image);
    }
}
