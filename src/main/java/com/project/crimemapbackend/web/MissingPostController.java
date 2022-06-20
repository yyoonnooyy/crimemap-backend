package com.project.crimemapbackend.web;

import com.project.crimemapbackend.service.image.ImageService;
import com.project.crimemapbackend.service.missingpost.MissingPostService;
import com.project.crimemapbackend.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://crimemap-web.herokuapp.com")
@RequiredArgsConstructor
@Controller
@RestController
public class MissingPostController {
    @Autowired
    private final MissingPostService missingPostService;
    private final ImageService imageService;

    // Create missingpost
    @PostMapping("/MissingPost")
    public Integer save(@RequestBody MissingPostCreateRequestDto dto) {
        return missingPostService.createMissingPost(dto);
    }

    // Create missingpost image
    @PostMapping("/MissingPost/Image")
    public String save(@RequestBody ImageCreateRequestDto dto) {
        return imageService.createImage(dto);}

    // Read all missingposts
    @GetMapping("/Community/Missing")
    public List<MissingPostResponseDto> getAllMissingPosts() {
        return missingPostService.findAll(); };

    // Read detail missingpost
    @GetMapping("/MissingPost/{post_num}")
    public MissingPostResponseDto getDetailMissingPost(@PathVariable Integer post_num) {
        return missingPostService.searchByNum(post_num);
    }

    // Read all missingposts image
    @GetMapping("/Community/Image")
    public List<ImageResponseDto> getAllImages() {
        return imageService.findAll(); };

    // Read detail missingpost image
    @GetMapping("/MissingPost/Image/{img_id}")
    public ImageResponseDto getDetailMissingPostImage(@PathVariable String img_id) {
        return imageService.searchByNum(img_id);
    }

    // Update missingpost
    @PatchMapping("/MissingPost/{post_num}")
    public Integer update(@PathVariable Integer post_num, @RequestBody MissingPostUpdateRequestDto requestDto) {
        return missingPostService.update(post_num, requestDto);
    }

    // Delete missingpost
    @DeleteMapping("/MissingPost/{post_num}")
    public String delete(@PathVariable Integer post_num) {
        missingPostService.delete(post_num);
        return "success DELETE missingpost(post_num: "+post_num+")";
    }

    // Delete image
    @DeleteMapping("/MissingPost/Image/{img_id}")
    public String delete(@PathVariable String img_id) {
        imageService.delete(img_id);
        return "success DELETE missingpost image";
    }

}
