package com.TypeDelta.service;

import com.TypeDelta.mapper.AgriculturalMapper;
import com.TypeDelta.pojo.Agricultural;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgriculturalService {

    @Autowired
    private AgriculturalMapper agriculturalMapper;

    public List<Agricultural> getAll() {
        return agriculturalMapper.getAll();
    }

    public Agricultural getAgriculturalById(Integer id) {
        return agriculturalMapper.getAgriculturalById(id);
    }

    public Integer insertAgricultural(Agricultural agricultural) {

        return agriculturalMapper.insertAgricultural(agricultural);
    }
}
