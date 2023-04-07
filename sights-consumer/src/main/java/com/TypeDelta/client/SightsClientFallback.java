package com.TypeDelta.client;

import com.TypeDelta.pojo.*;
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
    public Sight getSightsById(ReadUser readUser) {
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

    @Override
    public Integer updateSight(Sight sight) {
        return null;

    }

    @Override
    public Integer deleteSight(Integer id) {
        return null;
    }

    @Override
    public Integer countTypeSight(Integer pageInfo) {
        return null;
    }

    @Override
    public List<Sight> getSightsAllByTypeTwo(PageInfo pageInfo) {
        return null;
    }

    @Override
    public List<Sight> getSightsAllByUser(PageInfo pageInfo) {
        return null;
    }

    @Override
    public Integer countTypeSightByUser(Integer uId) {
        return null;
    }

    @Override
    public Integer insertComment(Comment comment) {
        return null;
    }

    @Override
    public List<Comment> getCommentAll(PageInfo pageInfo) {
        return null;
    }

    @Override
    public Integer commentCunt(Integer id) {
        return null;
    }

    @Override
    public List<Sight> top3() {
        return null;
    }

    @Override
    public List<Sight> Beast(Integer u_id) {
        return null;
    }
}
