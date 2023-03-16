package com.TypeDelta.controller;

import com.TypeDelta.service.ImgService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/img")
@Log4j2
@RefreshScope
public class ImgController {
    @Autowired
    private ImgService imgService;

    @PostMapping("/upload")
    public String upload(@RequestParam("uploadFile") MultipartFile zipFile) {
        return imgService.upload(zipFile);
    }
}
