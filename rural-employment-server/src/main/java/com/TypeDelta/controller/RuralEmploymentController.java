package com.TypeDelta.controller;

import com.TypeDelta.pojo.RuralEmployment;
import com.TypeDelta.service.RuralEmploymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employment")
@Log4j2
@RefreshScope
public class RuralEmploymentController {
    @Autowired
    private RuralEmploymentService ruralEmploymentService;

    @GetMapping("/all")
    List<RuralEmployment> getAll() {
        return ruralEmploymentService.getAll();
    }

    @PostMapping("/one")
    RuralEmployment getRuralEmploymentById(@RequestBody Integer id) {
        return ruralEmploymentService.getRuralEmploymentById(id);
    }


    @PostMapping("/insert")
    Integer insertRuralEmployment(@RequestBody RuralEmployment ruralEmployment) {
        return ruralEmploymentService.insertRuralEmployment(ruralEmployment);
    }
}
