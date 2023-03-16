package com.TypeDelta.client;

import com.TypeDelta.pojo.RuralEmployment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "rural-employment-server", fallback = RuralEmploymentClientFallback.class)
public interface RuralEmploymentClient {
    @GetMapping("/employment/all")
    List<RuralEmployment> getAll();

    @PostMapping("/employment/one")
    RuralEmployment getRuralEmploymentById(Integer id);
}
