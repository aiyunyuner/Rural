package com.TypeDelta.service;

import com.TypeDelta.mapper.RuralDynamicsMapper;
import com.TypeDelta.pojo.RuralDynamics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuralDynamicsService {
    @Autowired
    private RuralDynamicsMapper ruralDynamicsMapper;

    public List<RuralDynamics> getAll() {
        return ruralDynamicsMapper.getAll();
    }

    public RuralDynamics getRuralDynamicsById(Integer id) {
        return ruralDynamicsMapper.getRuralDynamicsById(id);
    }
}
