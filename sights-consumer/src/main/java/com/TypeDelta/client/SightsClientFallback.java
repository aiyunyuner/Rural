package com.TypeDelta.client;

import com.TypeDelta.pojo.Sight;
import com.TypeDelta.pojo.SightsType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SightsClientFallback implements SightsClient {
    @Override
    public List<Sight> getSightsAll() {
        return null;
    }

    @Override
    public Integer getAllNumber() {
        return null;
    }

    @Override
    public List<SightsType> getSightsTypeAll() {
        return null;
    }

    @Override
    public Sight getSightsById(Integer id) {
        return null;
    }
}
