package com.project.crimemapbackend.web;

import com.project.crimemapbackend.domain.infopost.InfoPost;
import com.project.crimemapbackend.service.infopost.InfoPostService;
import com.project.crimemapbackend.web.dto.InfoPostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

    // get all infoPosts
    @GetMapping("/Community")
    public List<InfoPostResponseDto> getAllInfoPosts() { return infoPostService.findAll(); };
}
