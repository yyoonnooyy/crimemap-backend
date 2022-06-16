package com.project.crimemapbackend.service.infopost;

import com.project.crimemapbackend.domain.infopost.InfoPost;
import com.project.crimemapbackend.domain.infopost.InfoPostRepository;
import com.project.crimemapbackend.web.dto.InfoPostCreateRequestDto;
import com.project.crimemapbackend.web.dto.InfoPostResponseDto;
import com.project.crimemapbackend.web.dto.InfoPostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class InfoPostService {
    private final InfoPostRepository infoPostRepository;
    //private final InfoPost infoPost;

    // Create infopost
    @Transactional
    public Integer createInfoPost(@RequestBody InfoPostCreateRequestDto requestDto) {
        return infoPostRepository.save(requestDto.toEntity()).getPost_num();
    }

    // Read all infoposts
    @Transactional(readOnly = true)
    public List<InfoPostResponseDto> findAll() {
        return infoPostRepository.findAll().stream()
                .map(InfoPostResponseDto::new)
                .collect(Collectors.toList());
    }

    // Read detail Infopost
    @Transactional(readOnly = true)
    public InfoPostResponseDto searchByNum(Integer post_num) {
        InfoPost infoPost = infoPostRepository.findById(post_num).orElseThrow(()
                -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));

        return new InfoPostResponseDto(infoPost);
    }

    // Update
    @Transactional
    public Integer update(Integer post_num, InfoPostUpdateRequestDto requestDto) {
        InfoPost infoPost = infoPostRepository.findById(post_num).orElseThrow(()
                -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));

        infoPost.update(requestDto.getTitle(),
                requestDto.getContent(),
                requestDto.getFixTime());

        return post_num;
    }

    // Delete
    @Transactional
    public void delete(Integer post_num) {
        InfoPost infoPost = infoPostRepository.findById(post_num).orElseThrow(()
                -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));

        infoPostRepository.delete(infoPost);
    }

}
