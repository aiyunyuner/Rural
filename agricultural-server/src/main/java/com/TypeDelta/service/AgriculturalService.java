package com.TypeDelta.service;

import com.TypeDelta.mapper.AgriculturalMapper;
import com.TypeDelta.pojo.Agricultural;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AgriculturalService {

    @Autowired
    private AgriculturalMapper agriculturalMapper;

    public List<Agricultural> getAll() {
        return agriculturalMapper.getAll();
    }

    public Agricultural getAgriculturalById(@RequestBody Integer id) {
        return agriculturalMapper.getAgriculturalById(id);
    }
}
