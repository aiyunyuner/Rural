package com.TypeDelta.client;

import com.TypeDelta.pojo.Agricultural;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "agricultural-server", fallback = AgriculturalClientFallback.class)
public interface AgriculturalClient {
    @GetMapping("/agricultural/all")
    List<Agricultural> getAll();

    @PostMapping("/agricultural/one")
    Agricultural getAgriculturalById(Integer id);
}
