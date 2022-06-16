package com.project.crimemapbackend.web;

import com.fasterxml.jackson.core.JsonParser;
import com.project.crimemapbackend.domain.infopost.InfoPost;
import com.project.crimemapbackend.service.infopost.InfoPostService;
import com.project.crimemapbackend.web.dto.InfoPostCreateRequestDto;
import com.project.crimemapbackend.web.dto.InfoPostResponseDto;
import com.project.crimemapbackend.web.dto.InfoPostUpdateRequestDto;
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

    /*
    @GetMapping("/")
    public String main() {
        return "main page";
    }

     */

    // Create infopost
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

    // Update infopost
    @PatchMapping("/InfoPost/{post_num}")
    public Integer update(@PathVariable Integer post_num, @RequestBody InfoPostUpdateRequestDto requestDto) {
        return infoPostService.update(post_num, requestDto);
    }

    // Delete infopost
    @DeleteMapping("/InfoPost/{post_num}")
    public String delete(@PathVariable Integer post_num) {
        infoPostService.delete(post_num);
        return "success DELETE infopost(post_num: "+post_num+")";
    }


}
