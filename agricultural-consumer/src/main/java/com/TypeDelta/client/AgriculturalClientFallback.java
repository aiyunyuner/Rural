package com.TypeDelta.client;

import com.TypeDelta.pojo.Agricultural;
import com.TypeDelta.pojo.Comment;
import com.TypeDelta.pojo.PageInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AgriculturalClientFallback implements AgriculturalClient {
    @Override
    public List<Agricultural> getAll() {
        return null;
    }

    @Override
    public Agricultural getAgriculturalById(Integer id) {
        return null;
    }

    @Override
    public Integer insertAgricultural(Agricultural agricultural) {
        return null;
    }

    @Override
    public Integer updateAgricultural(Agricultural agricultural) {
        return null;
    }

    @Override
    public Integer deleteAgricultural(Integer id) {
        return null;
    }

    @Override
    public Integer countAgricultural() {
        return null;
    }

    @Override
    public List<Agricultural> getMore(PageInfo pageInfo) {
        return null;
    }

    @Override
    public Integer countAgriculturalByUser(Integer uId) {
        return null;
    }

    @Override
    public List<Agricultural> getAgriculturalAllByUser(PageInfo pageInfo) {
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
