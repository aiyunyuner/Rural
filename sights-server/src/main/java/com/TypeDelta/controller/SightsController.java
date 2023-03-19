package com.TypeDelta.controller;

import com.TypeDelta.pojo.IndexSightsType;
import com.TypeDelta.pojo.Sight;
import com.TypeDelta.service.SightsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sights")
@Log4j2
@RefreshScope
/**
 * @Author: TypeDelta
 * 对sights的管理
 */
public class SightsController {
    @Autowired
    private SightsService sightsService;

    @GetMapping("/getSightsAll")
    public List<Sight> getSightsAll() {
        return sightsService.getSightsAll();
    }

    @GetMapping("/getAllNumber")
    public Integer getAllNumber() {
        return sightsService.getAllNumber();
    }

    @GetMapping("/getSightsTypeAll")
    public List<IndexSightsType> getSightsTypeAll() {
        return sightsService.getSightsTypeAll();
    }

    @PostMapping("/getSightsById")
    Sight getSightsById(@RequestBody Integer id) {
        return sightsService.getSightsById(id);
    }

    @PostMapping("/getSightsTypeOne")
    IndexSightsType getSightsTypeOne(@RequestBody Integer id) {
        return sightsService.getSightsTypeOne(id);
    }

    @PostMapping("/getSightsAllByType")
    List<Sight> getSightsAllByType(@RequestBody Integer id) {
        return sightsService.getSightsAllByType(id);
    }

    @PostMapping("/insert")
    Integer insertSight(@RequestBody Sight sight) {
        System.out.println(sight.toString());
        return sightsService.insertSight(sight);
    }
}
