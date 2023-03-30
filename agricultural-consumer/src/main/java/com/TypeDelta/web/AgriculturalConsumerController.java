package com.TypeDelta.web;

import com.TypeDelta.client.AgriculturalClient;
import com.TypeDelta.pojo.Agricultural;
import com.TypeDelta.pojo.Comment;
import com.TypeDelta.pojo.PageInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agricultural")
@Log4j2
@RefreshScope
public class AgriculturalConsumerController {
    @Autowired
    private AgriculturalClient agriculturalClient;

    @GetMapping("/all")
    List<Agricultural> getAll() {
        return agriculturalClient.getAll();
    }

    @PostMapping("/one")
    Agricultural getAgriculturalById(Integer id) {
        return agriculturalClient.getAgriculturalById(id);
    }


    @PostMapping("/insert")
    Integer insertAgricultural(Agricultural agricultural) {
        return agriculturalClient.insertAgricultural(agricultural);
    }

    @PostMapping("/update")
    Integer updateAgricultural( Agricultural agricultural) {
        return agriculturalClient.updateAgricultural(agricultural);
    }

    @PostMapping("/delete")
    Integer deleteAgricultural( Integer id) {
        return agriculturalClient.deleteAgricultural(id);
    }


    @PostMapping("/count")
    Integer countAgricultural(){
        return  agriculturalClient.countAgricultural();
    }

    @PostMapping("/more")
    List<Agricultural> getMore(PageInfo pageInfo){

        return agriculturalClient.getMore(pageInfo);
    }




    @PostMapping("/me")
    List<Agricultural> getSightsAllByUser( PageInfo pageInfo) {
        return agriculturalClient.getAgriculturalAllByUser(pageInfo);
    }

    @PostMapping("/meCunt")
    Integer countTypeSightByUser( Integer u_id) {
        return agriculturalClient.countAgriculturalByUser(u_id);
    }

    @PostMapping("/insertComment")
    Integer insertComment( Comment comment) {
        return agriculturalClient.insertComment(comment);
    }

    @PostMapping("/getCommentAll")
    List<Comment> getCommentAll( PageInfo pageInfo) {
        return agriculturalClient.getCommentAll(pageInfo);
    }


    @PostMapping("/commentCunt")
    Integer commentCunt( Integer id) {
        return agriculturalClient.commentCunt(id);
    }
}
