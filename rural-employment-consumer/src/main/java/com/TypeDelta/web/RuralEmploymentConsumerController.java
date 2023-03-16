package com.TypeDelta.web;

import com.TypeDelta.client.RuralEmploymentClient;
import com.TypeDelta.pojo.RuralEmployment;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employment")
@Log4j2
@RefreshScope
public class RuralEmploymentConsumerController {
    @Autowired
    private RuralEmploymentClient ruralEmploymentClient;


    @GetMapping("/all")
    List<RuralEmployment> getAll() {
        return ruralEmploymentClient.getAll();
    }

    @PostMapping("/one")
    RuralEmployment getRuralEmploymentById(@RequestBody Integer id) {
        return ruralEmploymentClient.getRuralEmploymentById(id);
    }
}
