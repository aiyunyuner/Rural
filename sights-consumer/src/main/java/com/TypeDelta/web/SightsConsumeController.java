package com.TypeDelta.web;

import com.TypeDelta.client.SightsClient;
import com.TypeDelta.pojo.Comment;
import com.TypeDelta.pojo.IndexSightsType;
import com.TypeDelta.pojo.PageInfo;
import com.TypeDelta.pojo.Sight;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/sights")
@Log4j2
@RefreshScope
public class SightsConsumeController {
    @Autowired
    private SightsClient sightsClient;

    @GetMapping("/getSightsAll")
    public List<Sight> getAll() {
        return sightsClient.getSightsAll();
    }

    @GetMapping("/getAllNumber")
    public Integer getAllNumber() {
        return sightsClient.getAllNumber();
    }

    @GetMapping("/getSightsTypeAll")
    public List<IndexSightsType> getSightsTypeAll() {
        return sightsClient.getSightsTypeAll();
    }


    @PostMapping("/getSightsById")
    Sight getSightsById(Integer id) {
        return sightsClient.getSightsById(id);
    }


    @PostMapping("/getSightsTypeOne")
    IndexSightsType getSightsTypeOne(Integer id) {
        return sightsClient.getSightsTypeOne(id);
    }

    @PostMapping("/insert")
    Integer insertSight(Sight sight, HttpServletRequest request) {
        return sightsClient.insertSight(sight);
    }

    @PostMapping("/update")
    Integer updateSight(Sight sight) {
        return sightsClient.updateSight(sight);
    }

    @PostMapping("/delete")
    Integer deleteSight(Integer id) {
        return sightsClient.deleteSight(id);
    }


    @PostMapping("/count")
    Integer countTypeSight(Integer id) {
        return sightsClient.countTypeSight(id);
    }


    @PostMapping("/more")
    List<Sight> getSightsAllByTypeTwo(PageInfo pageInfo) {
        return sightsClient.getSightsAllByTypeTwo(pageInfo);
    }


    @PostMapping("/me")
    List<Sight> getSightsAllByUser( PageInfo pageInfo) {
        return sightsClient.getSightsAllByUser(pageInfo);
    }

    @PostMapping("/meCunt")
    Integer countTypeSightByUser( Integer u_id) {
        return sightsClient.countTypeSightByUser(u_id);
    }

    @PostMapping("/insertComment")
    Integer insertComment( Comment comment) {
        return sightsClient.insertComment(comment);
    }

    @PostMapping("/getCommentAll")
    List<Comment> getCommentAll( PageInfo pageInfo) {
        return sightsClient.getCommentAll(pageInfo);
    }

    @PostMapping("/commentCunt")
    Integer commentCunt( Integer id) {
        return sightsClient.commentCunt(id);
    }
}
