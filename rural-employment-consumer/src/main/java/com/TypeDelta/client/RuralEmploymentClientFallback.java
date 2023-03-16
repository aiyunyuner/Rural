package com.TypeDelta.client;

import com.TypeDelta.pojo.RuralEmployment;

import java.util.List;

public class RuralEmploymentClientFallback implements RuralEmploymentClient {
    @Override
    public List<RuralEmployment> getAll() {
        return null;
    }

    @Override
    public RuralEmployment getRuralEmploymentById(Integer id) {
        return null;
    }
}