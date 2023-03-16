package com.TypeDelta.web;

import com.TypeDelta.client.SightsClient;
import com.TypeDelta.pojo.Sight;
import com.TypeDelta.pojo.SightsType;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sights")
@Log4j2
@RefreshScope
public class SightsConsumeController {
    @Autowired
    private SightsClient sightsClient;

    @GetMapping("/getSightsAll")
    public List<Sight> getAll() {
        return sightsClient.getSightsAll();
    }

    @GetMapping("/getAllNumber")
    public Integer getAllNumber() {
        return sightsClient.getAllNumber();
    }

    @GetMapping("/getSightsTypeAll")
    public List<SightsType> getSightsTypeAll() {
        return sightsClient.getSightsTypeAll();
    }


    @PostMapping("/getSightsById")
    Sight getSightsById(Integer id) {
        log.info(id);
        return sightsClient.getSightsById(id);
    }
}
