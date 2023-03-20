package com.TypeDelta.service;

import com.TypeDelta.mapper.RuralEmploymentMapper;
import com.TypeDelta.pojo.RuralEmployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuralEmploymentService {
    @Autowired
    private RuralEmploymentMapper ruralEmploymentMapper;

    public List<RuralEmployment> getAll() {
        return ruralEmploymentMapper.getAll();
    }

    public RuralEmployment getRuralEmploymentById(Integer id) {
        return ruralEmploymentMapper.getRuralEmploymentById(id);
    }

    public Integer insertRuralEmployment(RuralEmployment ruralEmployment) {
        return ruralEmploymentMapper.insertRuralEmployment(ruralEmployment);
    }
}
