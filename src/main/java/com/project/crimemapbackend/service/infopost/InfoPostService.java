package com.project.crimemapbackend.service.infopost;

import com.project.crimemapbackend.domain.infopost.InfoPost;
import com.project.crimemapbackend.domain.infopost.InfoPostRepository;
import com.project.crimemapbackend.web.dto.InfoPostResponseDto;
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

    // Create
    public InfoPost createBoard(@RequestBody InfoPost info_post) {
        return infoPostRepository.save(info_post);
    }

    // Read
    @Transactional(readOnly = true)
    public List<InfoPostResponseDto> findAll() {
        return infoPostRepository.findAll().stream()
                .map(InfoPostResponseDto::new)
                .collect(Collectors.toList());
    }

    // Update


    // Delete

}
