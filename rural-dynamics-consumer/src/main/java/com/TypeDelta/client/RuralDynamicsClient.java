package com.TypeDelta.client;

import com.TypeDelta.pojo.RuralDynamics;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "rural-dynamics-server", fallback = RuralDynamicsClientFallback.class)
public interface RuralDynamicsClient {
    @GetMapping("/rural/all")
    List<RuralDynamics> getAll();

    @PostMapping("/rural/one")
    RuralDynamics getRuralDynamicsById(Integer id);
    @PostMapping("/rural/insert")
    Integer insertRuralDynamics(RuralDynamics ruralDynamics);
}
