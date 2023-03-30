package com.TypeDelta.client;

import com.TypeDelta.pojo.Comment;
import com.TypeDelta.pojo.PageInfo;
import com.TypeDelta.pojo.RuralDynamics;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RuralDynamicsClientFallback implements RuralDynamicsClient {
    @Override
    public List<RuralDynamics> getAll() {
        return null;
    }

    @Override
    public RuralDynamics getRuralDynamicsById(Integer id) {
        return null;
    }

    @Override
    public Integer insertRuralDynamics(RuralDynamics ruralDynamics) {
        return null;
    }

    @Override
    public Integer updateRuralDynamics(RuralDynamics ruralDynamics) {
        return null;
    }

    @Override
    public Integer deleteRuralDynamics(Integer id) {
        return null;
    }

    @Override
    public Integer countRuralDynamics() {
        return null;
    }

    @Override
    public List<RuralDynamics> getMore(PageInfo pageInfo) {
        return null;
    }

    @Override
    public List<RuralDynamics> getDynamicsAllByUser(PageInfo pageInfo) {
        return null;
    }

    @Override
    public Integer countDynamicsByUser(Integer uId) {
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
}
