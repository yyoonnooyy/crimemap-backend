package com.project.crimemapbackend.web;

import com.project.crimemapbackend.service.image.ImageService;
import com.project.crimemapbackend.service.infopost.InfoPostService;
import com.project.crimemapbackend.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://crimemap-web.herokuapp.com")
@RequiredArgsConstructor
@Controller
@RestController
public class InfoPostController {

    @Autowired
    private final InfoPostService infoPostService;
    private final ImageService imageService;

    // Create infopost
    @PostMapping("/InfoPost")
    public Integer save(@RequestBody InfoPostCreateRequestDto dto) {
        return infoPostService.createInfoPost(dto);
    }

    // Create infopost image
    @PostMapping("/InfoPost/Image")
    public String save(@RequestBody ImageCreateRequestDto dto) {
        return imageService.createImage(dto);}

    // Read all infoposts
    @GetMapping("/Community/InfoPost")
    public List<InfoPostResponseDto> getAllInfoPosts() {
        return infoPostService.findAll(); };

    // Read detail infoost
    @GetMapping("/InfoPost/{post_num}")
    public InfoPostResponseDto getDetailInfoPost(@PathVariable Integer post_num) {
        return infoPostService.searchByNum(post_num);
    }

    // Read detail infopost image
    @GetMapping("/InfoPost/Image/{img_id}")
    public ImageResponseDto getDetailInfoPostImage(@PathVariable String img_id) {
        return imageService.searchByNum(img_id);
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

    // Read detail missingpost

    // Read all missingposts image

    // Delete image
    @DeleteMapping("/InfoPost/Image/{img_id}")
    public String delete(@PathVariable String img_id) {
        imageService.delete(img_id);
        return "success DELETE infopost image";
    }


}
