package com.TypeDelta.controller;

import com.TypeDelta.pojo.Agricultural;
import com.TypeDelta.pojo.Comment;
import com.TypeDelta.pojo.PageInfo;
import com.TypeDelta.pojo.RuralEmployment;
import com.TypeDelta.service.RuralEmploymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employment")
@Log4j2
@RefreshScope
public class RuralEmploymentController {
    @Autowired
    private RuralEmploymentService ruralEmploymentService;

    @GetMapping("/all")
    List<RuralEmployment> getAll() {
        return ruralEmploymentService.getAll();
    }

    @PostMapping("/one")
    RuralEmployment getRuralEmploymentById(@RequestBody Integer id) {
        return ruralEmploymentService.getRuralEmploymentById(id);
    }


    @PostMapping("/insert")
    Integer insertRuralEmployment(@RequestBody RuralEmployment ruralEmployment) {
        return ruralEmploymentService.insertRuralEmployment(ruralEmployment);
    }


    @PostMapping("/update")
    Integer updateRuralEmployment(@RequestBody RuralEmployment ruralEmployment) {
        return ruralEmploymentService.updateRuralEmployment(ruralEmployment);
    }

    @PostMapping("/delete")
    Integer deleteRuralEmployment(@RequestBody Integer id) {
        return ruralEmploymentService.deleteRuralEmployment(id);
    }


    @PostMapping("/count")
    Integer countRuralDynamics() {
        return ruralEmploymentService.countRuralDynamics();
    }

    @PostMapping("/more")
    List<RuralEmployment> getMore(@RequestBody PageInfo pageInfo) {
        return ruralEmploymentService.getMore(pageInfo);
    }


    @PostMapping("/me")
    List<Agricultural> getRuralEmploymentAllByUser(@RequestBody PageInfo pageInfo) {
        return ruralEmploymentService.getRuralEmploymentAllByUser(pageInfo);
    }

    @PostMapping("/meCunt")
    Integer countRuralEmploymentByUser(@RequestBody Integer u_id) {
        return ruralEmploymentService.countRuralEmploymentByUser(u_id);
    }

    @PostMapping("/insertComment")
    Integer insertComment(@RequestBody Comment comment) {
        return ruralEmploymentService.insertComment(comment);
    }

    @PostMapping("/getCommentAll")
    List<Comment> getCommentAll(@RequestBody PageInfo pageInfo) {
        return ruralEmploymentService.getCommentAll(pageInfo);
    }


    @PostMapping("/commentCunt")
    Integer commentCunt(@RequestBody Integer id) {
        return ruralEmploymentService.commentCunt(id);
    }
}
