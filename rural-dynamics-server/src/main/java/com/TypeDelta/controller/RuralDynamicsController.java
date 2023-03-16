package com.TypeDelta.controller;

import com.TypeDelta.pojo.RuralDynamics;
import com.TypeDelta.service.RuralDynamicsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rural")
@Log4j2
@RefreshScope
public class RuralDynamicsController {
    @Autowired
    private RuralDynamicsService ruralDynamicsService;

    @GetMapping("/all")
    public List<RuralDynamics> getAll() {
        return ruralDynamicsService.getAll();
    }

    @PostMapping("/one")
    public RuralDynamics getRuralDynamicsById(@RequestBody Integer id) {
        return ruralDynamicsService.getRuralDynamicsById(id);
    }
}
