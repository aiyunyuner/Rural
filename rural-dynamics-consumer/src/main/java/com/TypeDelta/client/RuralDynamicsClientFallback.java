package com.TypeDelta.client;

import com.TypeDelta.pojo.RuralDynamics;

import java.util.List;

public class RuralDynamicsClientFallback implements RuralDynamicsClient{
    @Override
    public List<RuralDynamics> getAll() {
        return null;
    }

    @Override
    public RuralDynamics getRuralDynamicsById(Integer id) {
        return null;
    }
}
