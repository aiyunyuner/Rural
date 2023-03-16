package com.TypeDelta.client;

import com.TypeDelta.pojo.Agricultural;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AgriculturalClientFallback implements AgriculturalClient{
    @Override
    public List<Agricultural> getAll() {
        return null;
    }

    @Override
    public Agricultural getAgriculturalById(Integer id) {
        return null;
    }
}
