package com.TypeDelta.controller;

import com.TypeDelta.pojo.LogMe;
import com.TypeDelta.service.ImgService;
import com.TypeDelta.service.LogService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/img")
@Log4j2
@RefreshScope
public class ImgController {
    @Autowired
    private LogService logService;
    @Autowired
    private ImgService imgService;

    @PostMapping("/upload")
    public String upload(MultipartFile file) {
        return imgService.upload(file);
    }


    @PostMapping("/pv7")
    public List<LogMe> PV7() {
        return logService.PV7();
    }

    @PostMapping("/pieMoules")
    List<LogMe> pieMoules() {
        return logService.pieMoules();
    }

    @PostMapping("/sightsPV7")
    List<LogMe> sightsPV7() {
        return logService.sightsPV7();
    }


    @PostMapping("/emPV7")
    List<LogMe> emPV7() {
        return logService.emPV7();
    }

    @PostMapping("/agPV7")
    List<LogMe> agPV7() {
        return logService.agPV7();
    }

    @PostMapping("/ruPV7")
    List<LogMe> ruPV7() {
        return logService.ruPV7();
    }

    @PostMapping("/userTOP5")
    List<LogMe> userTOP5() {
        return logService.userTOP5();
    }

    @PostMapping("/dayPV")
    List<LogMe> dayPV() {
        return logService.dayPV();
    }
}
