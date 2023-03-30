package com.TypeDelta.client;

import com.TypeDelta.pojo.Agricultural;
import com.TypeDelta.pojo.Comment;
import com.TypeDelta.pojo.PageInfo;
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

    @Override
    public Integer updateRuralEmployment(RuralEmployment ruralEmployment) {
        return null;
    }

    @Override
    public Integer deleteRuralEmployment(Integer id) {
        return null;
    }

    @Override
    public Integer countRuralDynamics() {
        return null;
    }

    @Override
    public List<RuralEmployment> getMore(PageInfo pageInfo) {
        return null;
    }

    @Override
    public List<Agricultural> getRuralEmploymentAllByUser(PageInfo pageInfo) {
        return null;
    }

    @Override
    public Integer countRuralEmploymentByUser(Integer uId) {
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
