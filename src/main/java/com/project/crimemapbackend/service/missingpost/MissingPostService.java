package com.project.crimemapbackend.service.missingpost;

import com.project.crimemapbackend.domain.missingpost.MissingPost;
import com.project.crimemapbackend.domain.missingpost.MissingPostRepository;
import com.project.crimemapbackend.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MissingPostService {
    private final MissingPostRepository missingPostRepository;

    // Create missingpost
    @Transactional
    public Integer createMissingPost(@RequestBody MissingPostCreateRequestDto requestDto) {
        return missingPostRepository.save(requestDto.toEntity()).getPost_num();
    }

    // Read all missingposts
    @Transactional(readOnly = true)
    public List<MissingPostResponseDto> findAll() {
        return missingPostRepository.findAll().stream()
                .map(MissingPostResponseDto::new)
                .collect(Collectors.toList());
    }

    // Read detail missingpost
    @Transactional(readOnly = true)
    public MissingPostResponseDto searchByNum(Integer post_num) {
        MissingPost missingPost = missingPostRepository.findById(post_num).orElseThrow(()
                -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));

        return new MissingPostResponseDto(missingPost);
    }

    // Update missingpost
    @Transactional
    public Integer update(Integer post_num, MissingPostUpdateRequestDto requestDto) {
        MissingPost missingPost = missingPostRepository.findById(post_num).orElseThrow(()
                -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));

        missingPost.update(requestDto.getTitle(),
                requestDto.getRegion(),
                requestDto.getName(),
                requestDto.getContent(),
                requestDto.getFixTime());

        return post_num;
    }

    // Delete missingpost
    @Transactional
    public void delete(Integer post_num) {
        MissingPost missingPost = missingPostRepository.findById(post_num).orElseThrow(()
                -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));

        missingPostRepository.delete(missingPost);
    }
}
