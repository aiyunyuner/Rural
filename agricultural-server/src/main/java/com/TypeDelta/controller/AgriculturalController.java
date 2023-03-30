package com.TypeDelta.controller;

import com.TypeDelta.pojo.Agricultural;
import com.TypeDelta.pojo.Comment;
import com.TypeDelta.pojo.PageInfo;
import com.TypeDelta.service.AgriculturalService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agricultural")
@Log4j2
@RefreshScope
/**
 * @Author: TypeDelta
 * 对sights的管理
 */
public class AgriculturalController {

    @Autowired
    private AgriculturalService agriculturalService;

    @GetMapping("/all")
    List<Agricultural> getAll() {
        return agriculturalService.getAll();
    }

    @PostMapping("/one")
    Agricultural getAgriculturalById(@RequestBody Integer id) {
        return agriculturalService.getAgriculturalById(id);
    }


    @PostMapping("/insert")
    Integer insertAgricultural(@RequestBody Agricultural agricultural) {


        return agriculturalService.insertAgricultural(agricultural);
    }

    @PostMapping("/update")
    Integer updateAgricultural(@RequestBody Agricultural agricultural) {
        return agriculturalService.updateAgricultural(agricultural);
    }

    @PostMapping("/delete")
    Integer deleteAgricultural(@RequestBody Integer id) {
        return agriculturalService.deleteAgricultural(id);
    }

    @PostMapping("/count")
    Integer countAgricultural() {
        return agriculturalService.countAgricultural();
    }

    @PostMapping("/more")
    List<Agricultural> getMore(@RequestBody PageInfo pageInfo) {

        return agriculturalService.getMore(pageInfo);
    }

    @PostMapping("/me")
    List<Agricultural> getSightsAllByUser(@RequestBody PageInfo pageInfo) {
        return agriculturalService.getAgriculturalAllByUser(pageInfo);
    }

    @PostMapping("/meCunt")
    Integer countTypeSightByUser(@RequestBody Integer u_id) {
        return agriculturalService.countAgriculturalByUser(u_id);
    }

    @PostMapping("/insertComment")
    Integer insertComment(@RequestBody Comment comment) {
        return agriculturalService.insertComment(comment);
    }

    @PostMapping("/getCommentAll")
    List<Comment> getCommentAll(@RequestBody PageInfo pageInfo) {
        return agriculturalService.getCommentAll(pageInfo);
    }


    @PostMapping("/commentCunt")
    Integer commentCunt(@RequestBody Integer id) {
        return agriculturalService.commentCunt(id);
    }
}
