package com.TypeDelta.service;

import com.TypeDelta.mapper.RuralDynamicsMapper;
import com.TypeDelta.pojo.Comment;
import com.TypeDelta.pojo.PageInfo;
import com.TypeDelta.pojo.RuralDynamics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuralDynamicsService {
    @Autowired
    private RuralDynamicsMapper ruralDynamicsMapper;

    public List<RuralDynamics> getAll() {
        return ruralDynamicsMapper.getAll();
    }

    public RuralDynamics getRuralDynamicsById(Integer id) {
        return ruralDynamicsMapper.getRuralDynamicsById(id);
    }

    public Integer insertRuralDynamics(RuralDynamics ruralDynamics) {
        return ruralDynamicsMapper.insertRuralDynamics(ruralDynamics);
    }

    public Integer updateRuralDynamics(RuralDynamics ruralDynamics) {
        return ruralDynamicsMapper.updateRuralDynamics(ruralDynamics);
    }

    public Integer deleteRuralDynamics(Integer id) {
        return ruralDynamicsMapper.deleteRuralDynamics(id);
    }

    public Integer countRuralDynamics() {
        return ruralDynamicsMapper.countRuralDynamics();
    }

    public List<RuralDynamics> getMore(PageInfo pageInfo) {
        pageInfo.setStart((pageInfo.getStart() - 1) * pageInfo.getPageSize());
        return ruralDynamicsMapper.getMore(pageInfo);
    }

    public List<RuralDynamics> getDynamicsAllByUser(PageInfo pageInfo) {
        pageInfo.setStart((pageInfo.getStart() - 1) * pageInfo.getPageSize());
        return ruralDynamicsMapper.getDynamicsAllByUser(pageInfo);
    }

    public Integer countDynamicsByUser(Integer uId) {
        return ruralDynamicsMapper.countDynamicsByUser(uId);
    }

    public Integer insertComment(Comment comment) {
        return ruralDynamicsMapper.insertComment(comment);
    }

    public List<Comment> getCommentAll(PageInfo pageInfo) {
        pageInfo.setStart((pageInfo.getStart() - 1) * pageInfo.getPageSize());
        return ruralDynamicsMapper.getCommentAll(pageInfo);
    }

    public Integer commentCunt(Integer id) {
        return ruralDynamicsMapper.commentCunt(id);
    }
}
