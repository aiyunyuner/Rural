package com.TypeDelta.controller;

import com.TypeDelta.pojo.Agricultural;
import com.TypeDelta.service.AgriculturalService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agricultural")
@Log4j2
@RefreshScope
/**
 * @Author: TypeDelta
 * 对sights的管理
 */
public class AgriculturalController {

    @Autowired
    private AgriculturalService agriculturalService;

    @GetMapping("/all")
    List<Agricultural> getAll() {
        return agriculturalService.getAll();
    }

    @PostMapping("/one")
    Agricultural getAgriculturalById(@RequestBody Integer id) {
        return agriculturalService.getAgriculturalById(id);
    }


    @PostMapping("insert")
    Integer insertAgricultural(@RequestBody Agricultural agricultural) {
        return agriculturalService.insertAgricultural(agricultural);
    }
}
