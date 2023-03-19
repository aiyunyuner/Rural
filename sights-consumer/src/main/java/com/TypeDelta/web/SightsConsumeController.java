package com.TypeDelta.web;

import com.TypeDelta.client.SightsClient;
import com.TypeDelta.pojo.IndexSightsType;
import com.TypeDelta.pojo.Sight;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

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
    public List<IndexSightsType> getSightsTypeAll() {
        return sightsClient.getSightsTypeAll();
    }


    @PostMapping("/getSightsById")
    Sight getSightsById(Integer id) {

        return sightsClient.getSightsById(id);
    }


    @PostMapping("/getSightsTypeOne")
    IndexSightsType getSightsTypeOne(Integer id) {
        return sightsClient.getSightsTypeOne(id);
    }

    @PostMapping("/insert")
    Integer insertSight( Sight sight) {
        return sightsClient.insertSight(sight);
    }
}
