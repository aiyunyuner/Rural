package com.TypeDelta.service;

import com.TypeDelta.mapper.SightsMapper;
import com.TypeDelta.pojo.Comment;
import com.TypeDelta.pojo.IndexSightsType;
import com.TypeDelta.pojo.PageInfo;
import com.TypeDelta.pojo.Sight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SightsService {
    @Autowired
    private SightsMapper sightsMapper;

    public Sight getSightsById(Integer id) {
        return sightsMapper.getSightsById(id);
    }

    public List<Sight> getSightsAll() {
        return sightsMapper.getSightsAll();
    }

    public Integer getAllNumber() {
        return sightsMapper.getAllNumber();
    }

    public List<IndexSightsType> getSightsTypeAll() {
        return sightsMapper.getSightsTypeAll();
    }

    public IndexSightsType getSightsTypeOne(Integer id) {
        return sightsMapper.getSightsTypeOne(id);
    }

    public List<Sight> getSightsAllByType(Integer id) {
        return sightsMapper.getSightsAllByType(id);
    }


    public Integer insertSight(Sight sight) {
        return sightsMapper.insertSight(sight);
    }

    public Integer updateSight(Sight sight) {
        return sightsMapper.updateSight(sight);
    }

    public Integer deleteSight(Integer id) {
        return sightsMapper.deleteSight(id);
    }

    public Integer countTypeSight(Integer pageInfo) {
        return sightsMapper.countTypeSight(pageInfo);
    }

    public List<Sight> getSightsAllByTypeTwo(PageInfo pageInfo) {
        pageInfo.setStart((pageInfo.getStart() - 1) * pageInfo.getPageSize());
        return sightsMapper.getSightsAllByTypeTwo(pageInfo);
    }

    public List<Sight> getSightsAllByUser(PageInfo pageInfo) {
        pageInfo.setStart((pageInfo.getStart() - 1) * pageInfo.getPageSize());
        return sightsMapper.getSightsAllByUser(pageInfo);
    }

    public Integer countTypeSightByUser(Integer u_id) {
        return sightsMapper.countTypeSightByUser(u_id);
    }

    public Integer insertComment(Comment comment) {
        Date date = new Date();//获取当前的日期
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
        String str = df.format(date);//获取String类型的时间
        comment.setTime(str);
        return sightsMapper.insertComment(comment);
    }

    public List<Comment> getCommentAll(PageInfo pageInfo) {
        pageInfo.setStart((pageInfo.getStart() - 1) * pageInfo.getPageSize());
        return sightsMapper.getCommentAll(pageInfo);
    }

    public Integer commentCunt(Integer id) {
        return sightsMapper.commentCunt(id);
    }
}
