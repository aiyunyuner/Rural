package com.TypeDelta.controller;

import com.TypeDelta.pojo.Comment;
import com.TypeDelta.pojo.PageInfo;
import com.TypeDelta.pojo.RuralDynamics;
import com.TypeDelta.service.RuralDynamicsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rural")
@Log4j2
@RefreshScope
public class RuralDynamicsController {
    @Autowired
    private RuralDynamicsService ruralDynamicsService;

    @GetMapping("/all")
    public List<RuralDynamics> getAll() {
        return ruralDynamicsService.getAll();
    }

    @PostMapping("/one")
    public RuralDynamics getRuralDynamicsById(@RequestBody Integer id) {
        return ruralDynamicsService.getRuralDynamicsById(id);
    }


    @PostMapping("/insert")
    Integer insertRuralDynamics(@RequestBody RuralDynamics ruralDynamics) {
        return ruralDynamicsService.insertRuralDynamics(ruralDynamics);
    }

    @PostMapping("/update")
    Integer updateRuralDynamics(@RequestBody RuralDynamics ruralDynamics) {
        return ruralDynamicsService.updateRuralDynamics(ruralDynamics);
    }


    @PostMapping("/delete")
    Integer deleteRuralDynamics(@RequestBody Integer id) {
        return ruralDynamicsService.deleteRuralDynamics(id);
    }

    @PostMapping("/count")
    Integer countRuralDynamics() {
        return ruralDynamicsService.countRuralDynamics();

    }

    @PostMapping("/more")
    List<RuralDynamics> getMore(@RequestBody PageInfo pageInfo) {
        return ruralDynamicsService.getMore(pageInfo);
    }


    @PostMapping("/me")
    List<RuralDynamics> getDynamicsAllByUser(@RequestBody PageInfo pageInfo) {
        return ruralDynamicsService.getDynamicsAllByUser(pageInfo);
    }

    @PostMapping("/meCunt")
    Integer countDynamicsByUser(@RequestBody Integer u_id) {
        return ruralDynamicsService.countDynamicsByUser(u_id);
    }

    @PostMapping("/insertComment")
    Integer insertComment(@RequestBody Comment comment) {
        return ruralDynamicsService.insertComment(comment);
    }

    @PostMapping("/getCommentAll")
    List<Comment> getCommentAll(@RequestBody PageInfo pageInfo) {
        return ruralDynamicsService.getCommentAll(pageInfo);
    }


    @PostMapping("/commentCunt")
    Integer commentCunt(@RequestBody Integer id) {
        return ruralDynamicsService.commentCunt(id);
    }
}
