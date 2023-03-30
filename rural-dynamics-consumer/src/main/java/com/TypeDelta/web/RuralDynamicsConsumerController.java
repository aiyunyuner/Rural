package com.TypeDelta.web;

import com.TypeDelta.client.RuralDynamicsClient;
import com.TypeDelta.pojo.Comment;
import com.TypeDelta.pojo.PageInfo;
import com.TypeDelta.pojo.RuralDynamics;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rural")
@Log4j2
@RefreshScope
public class RuralDynamicsConsumerController {
    @Autowired
    private RuralDynamicsClient ruralDynamicsClient;

    @GetMapping("/all")
    public List<RuralDynamics> getAll() {
        return ruralDynamicsClient.getAll();
    }

    @PostMapping("/one")
    public RuralDynamics getRuralDynamicsById(Integer id) {
        return ruralDynamicsClient.getRuralDynamicsById(id);
    }


    @PostMapping("/insert")
    Integer insertRuralDynamics(RuralDynamics ruralDynamics) {
        return ruralDynamicsClient.insertRuralDynamics(ruralDynamics);
    }

    @PostMapping("/update")
    Integer updateRuralDynamics(RuralDynamics ruralDynamics) {
        return ruralDynamicsClient.updateRuralDynamics(ruralDynamics);
    }


    @PostMapping("/delete")
    Integer deleteRuralDynamics(Integer id) {
        return ruralDynamicsClient.deleteRuralDynamics(id);
    }

    @PostMapping("/count")
    Integer countRuralDynamics() {
        return ruralDynamicsClient.countRuralDynamics();
    }

    @PostMapping("/more")
    List<RuralDynamics> getMore(PageInfo pageInfo) {
        return ruralDynamicsClient.getMore(pageInfo);
    }


    @PostMapping("/me")
    List<RuralDynamics> getDynamicsAllByUser(PageInfo pageInfo) {
        return ruralDynamicsClient.getDynamicsAllByUser(pageInfo);
    }

    @PostMapping("/meCunt")
    Integer countDynamicsByUser(Integer u_id) {
        return ruralDynamicsClient.countDynamicsByUser(u_id);
    }

    @PostMapping("/insertComment")
    Integer insertComment( Comment comment) {
        return ruralDynamicsClient.insertComment(comment);
    }

    @PostMapping("/getCommentAll")
    List<Comment> getCommentAll( PageInfo pageInfo) {
        return ruralDynamicsClient.getCommentAll(pageInfo);
    }


    @PostMapping("/commentCunt")
    Integer commentCunt( Integer id) {
        return ruralDynamicsClient.commentCunt(id);
    }
}
