package com.TypeDelta.client;

import com.TypeDelta.pojo.Agricultural;
import com.TypeDelta.pojo.Comment;
import com.TypeDelta.pojo.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "agricultural-server", fallback = AgriculturalClientFallback.class)
public interface AgriculturalClient {
    @GetMapping("/agricultural/all")
    List<Agricultural> getAll();

    @PostMapping("/agricultural/one")
    Agricultural getAgriculturalById(Integer id);

    @PostMapping("/agricultural/insert")
    Integer insertAgricultural(Agricultural agricultural);

    @PostMapping("/agricultural/update")
    Integer updateAgricultural(Agricultural agricultural);

    @PostMapping("/agricultural/delete")
    Integer deleteAgricultural(Integer id);

    @PostMapping("/agricultural/count")
    Integer countAgricultural();

    @PostMapping("/agricultural/more")
    List<Agricultural> getMore(PageInfo pageInfo);

    @PostMapping("/agricultural/meCunt")
    Integer countAgriculturalByUser(Integer uId);

    @PostMapping("/agricultural/me")
    List<Agricultural> getAgriculturalAllByUser(PageInfo pageInfo);

    @PostMapping("/agricultural/insertComment")
    Integer insertComment(Comment comment);

    @PostMapping("/agricultural/getCommentAll")
    List<Comment> getCommentAll(PageInfo pageInfo);

    @PostMapping("/agricultural/commentCunt")
    Integer commentCunt(Integer id);
}
