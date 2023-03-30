package com.TypeDelta.service;

import com.TypeDelta.mapper.AgriculturalMapper;
import com.TypeDelta.pojo.Agricultural;
import com.TypeDelta.pojo.Comment;
import com.TypeDelta.pojo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgriculturalService {

    @Autowired
    private AgriculturalMapper agriculturalMapper;

    public List<Agricultural> getAll() {
        return agriculturalMapper.getAll();
    }

    public Agricultural getAgriculturalById(Integer id) {
        return agriculturalMapper.getAgriculturalById(id);
    }

    public Integer insertAgricultural(Agricultural agricultural) {

        return agriculturalMapper.insertAgricultural(agricultural);
    }

    public Integer updateAgricultural(Agricultural agricultural) {
        return agriculturalMapper.updateAgricultural(agricultural);
    }

    public Integer deleteAgricultural(Integer id) {
        return agriculturalMapper.deleteAgricultural(id);
    }

    public Integer countAgricultural() {

        return agriculturalMapper.countAgricultural();
    }

    public List<Agricultural> getMore(PageInfo pageInfo) {
        pageInfo.setStart((pageInfo.getStart() - 1) * pageInfo.getPageSize());
        return agriculturalMapper.getMore(pageInfo);
    }

    public List<Agricultural> getAgriculturalAllByUser(PageInfo pageInfo) {
        pageInfo.setStart((pageInfo.getStart() - 1) * pageInfo.getPageSize());
        return agriculturalMapper.getAgriculturalAllByUser(pageInfo);
    }

    public Integer countAgriculturalByUser(Integer u_id) {
        return agriculturalMapper.countAgriculturalByUser(u_id);
    }

    public Integer insertComment(Comment comment) {
        return agriculturalMapper.insertComment(comment);
    }

    public List<Comment> getCommentAll(PageInfo pageInfo) {
        pageInfo.setStart((pageInfo.getStart() - 1) * pageInfo.getPageSize());
        return agriculturalMapper.getCommentAll(pageInfo);
    }

    public Integer commentCunt(Integer id) {
        return agriculturalMapper.commentCunt(id);
    }
}
