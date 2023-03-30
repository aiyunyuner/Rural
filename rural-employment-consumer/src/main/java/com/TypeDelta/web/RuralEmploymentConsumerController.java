package com.TypeDelta.web;

import com.TypeDelta.client.RuralEmploymentClient;
import com.TypeDelta.pojo.Agricultural;
import com.TypeDelta.pojo.Comment;
import com.TypeDelta.pojo.PageInfo;
import com.TypeDelta.pojo.RuralEmployment;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employment")
@Log4j2
@RefreshScope
public class RuralEmploymentConsumerController {
    @Autowired
    private RuralEmploymentClient ruralEmploymentClient;


    @GetMapping("/all")
    List<RuralEmployment> getAll() {
        return ruralEmploymentClient.getAll();
    }

    @PostMapping("/one")
    RuralEmployment getRuralEmploymentById(Integer id) {
        return ruralEmploymentClient.getRuralEmploymentById(id);
    }


    @PostMapping("/insert")
    Integer insertRuralEmployment(RuralEmployment ruralEmployment) {
        return ruralEmploymentClient.insertRuralEmployment(ruralEmployment);
    }

    @PostMapping("/update")
    Integer updateRuralEmployment(RuralEmployment ruralEmployment) {
        return ruralEmploymentClient.updateRuralEmployment(ruralEmployment);
    }

    @PostMapping("/delete")
    Integer deleteRuralEmployment(Integer id) {
        return ruralEmploymentClient.deleteRuralEmployment(id);
    }


    @PostMapping("/count")
    Integer countRuralDynamics() {
        return ruralEmploymentClient.countRuralDynamics();
    }

    @PostMapping("/more")
    List<RuralEmployment> getMore(PageInfo pageInfo) {
        return ruralEmploymentClient.getMore(pageInfo);
    }


    @PostMapping("/me")
    List<Agricultural> getRuralEmploymentAllByUser(PageInfo pageInfo) {
        return ruralEmploymentClient.getRuralEmploymentAllByUser(pageInfo);
    }

    @PostMapping("/meCunt")
    Integer countRuralEmploymentByUser(Integer u_id) {
        return ruralEmploymentClient.countRuralEmploymentByUser(u_id);
    }



    @PostMapping("/insertComment")
    Integer insertComment( Comment comment) {
        return ruralEmploymentClient.insertComment(comment);
    }

    @PostMapping("/getCommentAll")
    List<Comment> getCommentAll( PageInfo pageInfo) {
        return ruralEmploymentClient.getCommentAll(pageInfo);
    }


    @PostMapping("/commentCunt")
    Integer commentCunt( Integer id) {
        return ruralEmploymentClient.commentCunt(id);
    }
}
