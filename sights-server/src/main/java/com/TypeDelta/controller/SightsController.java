package com.TypeDelta.controller;

import com.TypeDelta.pojo.*;
import com.TypeDelta.service.SightsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sights")
@Log4j2
@RefreshScope
/**
 * @Author: TypeDelta
 * 对sights的管理
 */
public class SightsController {
    @Autowired
    private SightsService sightsService;

    @GetMapping("/getSightsAll")
    public List<Sight> getSightsAll() {
        return sightsService.getSightsAll();
    }

    @GetMapping("/getAllNumber")
    public Integer getAllNumber() {
        return sightsService.getAllNumber();
    }

    @GetMapping("/getSightsTypeAll")
    public List<IndexSightsType> getSightsTypeAll() {
        return sightsService.getSightsTypeAll();
    }

    @PostMapping("/getSightsById")
    Sight getSightsById(@RequestBody ReadUser readUser) {
        return sightsService.getSightsById(readUser);
    }

    @PostMapping("/getSightsTypeOne")
    IndexSightsType getSightsTypeOne(@RequestBody Integer id) {
        return sightsService.getSightsTypeOne(id);
    }

    @PostMapping("/getSightsAllByType")
    List<Sight> getSightsAllByType(@RequestBody Integer id) {
        return sightsService.getSightsAllByType(id);
    }

    @PostMapping("/insert")
    Integer insertSight(@RequestBody Sight sight) {
        System.out.println(sight.toString());
        return sightsService.insertSight(sight);
    }

    @PostMapping("/update")
    Integer updateSight(@RequestBody Sight sight) {
        return sightsService.updateSight(sight);
    }

    @PostMapping("/delete")
    Integer deleteSight(@RequestBody Integer id) {
        return sightsService.deleteSight(id);
    }

    @PostMapping("/count")
    Integer countTypeSight(@RequestBody Integer id) {
        return sightsService.countTypeSight(id);
    }


    @PostMapping("/more")
    List<Sight> getSightsAllByTypeTwo(@RequestBody PageInfo pageInfo) {
        return sightsService.getSightsAllByTypeTwo(pageInfo);
    }

    @PostMapping("/me")
    List<Sight> getSightsAllByUser(@RequestBody PageInfo pageInfo) {
        return sightsService.getSightsAllByUser(pageInfo);
    }

    @PostMapping("/meCunt")
    Integer countTypeSightByUser(@RequestBody Integer u_id) {
        return sightsService.countTypeSightByUser(u_id);
    }

    @PostMapping("/insertComment")
    Integer insertComment(@RequestBody Comment comment) {
        return sightsService.insertComment(comment);
    }

    @PostMapping("/getCommentAll")
    List<Comment> getCommentAll(@RequestBody PageInfo pageInfo) {
        return sightsService.getCommentAll(pageInfo);
    }


    @PostMapping("/commentCunt")
    Integer commentCunt(@RequestBody Integer id) {
        return sightsService.commentCunt(id);
    }

    @PostMapping("/top3")
    List<Sight> top3() {
        return sightsService.top3();
    }


    @PostMapping("/beast")
    List<Sight> Beast(@RequestBody Integer u_id) {
        return sightsService.Beast(u_id);
    }
}
