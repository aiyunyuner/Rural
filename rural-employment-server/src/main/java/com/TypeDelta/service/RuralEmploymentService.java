package com.TypeDelta.service;

import com.TypeDelta.mapper.RuralEmploymentMapper;
import com.TypeDelta.pojo.Agricultural;
import com.TypeDelta.pojo.Comment;
import com.TypeDelta.pojo.PageInfo;
import com.TypeDelta.pojo.RuralEmployment;
import com.TypeDelta.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuralEmploymentService {
    @Autowired
    private RuralEmploymentMapper ruralEmploymentMapper;

    public List<RuralEmployment> getAll() {
        return ruralEmploymentMapper.getAll();
    }

    public RuralEmployment getRuralEmploymentById(Integer id) {
        ruralEmploymentMapper.addClick(id);
        return ruralEmploymentMapper.getRuralEmploymentById(id);
    }

    public Integer insertRuralEmployment(RuralEmployment ruralEmployment) {
        return ruralEmploymentMapper.insertRuralEmployment(ruralEmployment);
    }

    public Integer updateRuralEmployment(RuralEmployment ruralEmployment) {
        return ruralEmploymentMapper.updateRuralEmployment(ruralEmployment);
    }

    public Integer deleteRuralEmployment(Integer id) {
        return ruralEmploymentMapper.deleteRuralEmployment(id);
    }

    public Integer countRuralDynamics() {
        return ruralEmploymentMapper.countRuralDynamics();
    }

    public List<RuralEmployment> getMore(PageInfo pageInfo) {
        pageInfo.setStart((pageInfo.getStart() - 1) * pageInfo.getPageSize());
        return ruralEmploymentMapper.getMore(pageInfo);
    }

    public List<Agricultural> getRuralEmploymentAllByUser(PageInfo pageInfo) {
        pageInfo.setStart((pageInfo.getStart() - 1) * pageInfo.getPageSize());
        return ruralEmploymentMapper.getRuralEmploymentAllByUser(pageInfo);
    }

    public Integer countRuralEmploymentByUser(Integer u_id) {
        return ruralEmploymentMapper.countRuralEmploymentByUser(u_id);
    }

    public Integer insertComment(Comment comment) {
        comment.setTime(TimeUtils.setTime());
        return ruralEmploymentMapper.insertComment(comment);
    }

    public List<Comment> getCommentAll(PageInfo pageInfo) {
        pageInfo.setStart((pageInfo.getStart() - 1) * pageInfo.getPageSize());
        return ruralEmploymentMapper.getCommentAll(pageInfo);
    }

    public Integer commentCunt(Integer id) {
        return ruralEmploymentMapper.commentCunt(id);
    }
}
