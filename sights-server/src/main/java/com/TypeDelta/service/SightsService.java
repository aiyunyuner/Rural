package com.TypeDelta.service;

import com.TypeDelta.mapper.SightsMapper;
import com.TypeDelta.pojo.Sight;
import com.TypeDelta.pojo.SightsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SightsService {
    @Autowired
    private SightsMapper sightsMapper;

    public Sight getSightsById(Integer id) {
        return sightsMapper.getSightsById(id);
    }

    public List<Sight> getSightsAll() {
        return sightsMapper.getSightsAll();
    }

    public Integer getAllNumber() {
        return sightsMapper.getAllNumber();
    }

    public List<SightsType> getSightsTypeAll() {
        return sightsMapper.getSightsTypeAll();
    }
}
