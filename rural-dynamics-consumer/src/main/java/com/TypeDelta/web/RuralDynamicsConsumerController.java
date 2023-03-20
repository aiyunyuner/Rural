package com.TypeDelta.web;

import com.TypeDelta.client.RuralDynamicsClient;
import com.TypeDelta.pojo.RuralDynamics;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rural")
@Log4j2
@RefreshScope
public class RuralDynamicsConsumerController {
    @Autowired
    private RuralDynamicsClient ruralDynamicsClient;

    @GetMapping("/all")
    public List<RuralDynamics> getAll() {
        return ruralDynamicsClient.getAll();
    }

    @PostMapping("/one")
    public RuralDynamics getRuralDynamicsById(Integer id) {
        return ruralDynamicsClient.getRuralDynamicsById(id);
    }


    @PostMapping("/insert")
    Integer insertRuralDynamics(RuralDynamics ruralDynamics) {
        return ruralDynamicsClient.insertRuralDynamics(ruralDynamics);
    }
}
