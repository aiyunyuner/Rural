package com.TypeDelta.client;

import com.TypeDelta.pojo.Sight;
import com.TypeDelta.pojo.SightsType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "sights-server", fallback = SightsClientFallback.class)
public interface SightsClient {
    @GetMapping("/sights/getSightsAll")
    List<Sight> getSightsAll();

    @GetMapping("/sights/getAllNumber")
    Integer getAllNumber();

    @GetMapping("/sights/getSightsTypeAll")
    List<SightsType> getSightsTypeAll();

    @PostMapping("/sights/getSightsById")
    Sight getSightsById(Integer id);
}
