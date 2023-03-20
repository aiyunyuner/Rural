package com.TypeDelta.client;

import com.TypeDelta.pojo.RuralEmployment;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class RuralEmploymentClientFallback implements RuralEmploymentClient {
    @Override
    public List<RuralEmployment> getAll() {
        return null;
    }

    @Override
    public RuralEmployment getRuralEmploymentById(Integer id) {
        return null;
    }

    @Override
    public Integer insertRuralEmployment(RuralEmployment ruralEmployment) {
        return null;
    }
}
