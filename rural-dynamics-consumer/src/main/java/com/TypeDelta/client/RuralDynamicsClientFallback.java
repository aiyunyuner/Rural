package com.TypeDelta.client;

import com.TypeDelta.pojo.RuralDynamics;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
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
