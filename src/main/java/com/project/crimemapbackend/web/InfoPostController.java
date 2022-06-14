package com.project.crimemapbackend.web;

import com.fasterxml.jackson.core.JsonParser;
import com.project.crimemapbackend.domain.infopost.InfoPost;
import com.project.crimemapbackend.service.infopost.InfoPostService;
import com.project.crimemapbackend.web.dto.InfoPostCreateRequestDto;
import com.project.crimemapbackend.web.dto.InfoPostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@Controller
@RestController
public class InfoPostController {

    @Autowired
    private InfoPostService infoPostService;

    @GetMapping("/")
    public String main() {
        return "main page";
    }

    // Create infoPosts
    @PostMapping("/InfoPost")
    public Integer save(@RequestBody InfoPostCreateRequestDto dto) {
        return infoPostService.createInfoPost(dto);
    }

    // Read all infoposts
    @GetMapping("/Community")
    public List<InfoPostResponseDto> getAllInfoPosts() {
        return infoPostService.findAll(); };

    // Read detail infoost
    @GetMapping("/InfoPost/{post_num}")
    public InfoPostResponseDto getDetailInfoPosts(@PathVariable Integer post_num) {
        return infoPostService.searchByNum(post_num);
    }


}
