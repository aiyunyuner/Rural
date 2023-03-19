package com.TypeDelta.client;

import com.TypeDelta.pojo.IndexSightsType;
import com.TypeDelta.pojo.Sight;
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
    public List<IndexSightsType> getSightsTypeAll() {
        return null;
    }

    @Override
    public Sight getSightsById(Integer id) {
        return null;
    }

    @Override
    public IndexSightsType getSightsTypeOne(Integer id) {
        return null;
    }

    @Override
    public Integer insertSight(Sight sight) {
        return null;
    }
}
