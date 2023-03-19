package com.TypeDelta.service;

import com.TypeDelta.mapper.SightsMapper;
import com.TypeDelta.pojo.IndexSightsType;
import com.TypeDelta.pojo.Sight;
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

    public List<IndexSightsType> getSightsTypeAll() {
        return sightsMapper.getSightsTypeAll();
    }

    public IndexSightsType getSightsTypeOne(Integer id) {
        return sightsMapper.getSightsTypeOne(id);
    }

    public List<Sight> getSightsAllByType(Integer id) {
        return sightsMapper.getSightsAllByType(id);
    }


    public Integer insertSight(Sight sight) {
        return sightsMapper.insertSight(sight);
    }
}
