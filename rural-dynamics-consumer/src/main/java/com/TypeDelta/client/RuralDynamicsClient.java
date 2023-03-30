package com.TypeDelta.client;

import com.TypeDelta.pojo.Comment;
import com.TypeDelta.pojo.PageInfo;
import com.TypeDelta.pojo.RuralDynamics;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "rural-dynamics-server", fallback = RuralDynamicsClientFallback.class)
public interface RuralDynamicsClient {
    @GetMapping("/rural/all")
    List<RuralDynamics> getAll();

    @PostMapping("/rural/one")
    RuralDynamics getRuralDynamicsById(Integer id);

    @PostMapping("/rural/insert")
    Integer insertRuralDynamics(RuralDynamics ruralDynamics);

    @PostMapping("/rural/update")
    Integer updateRuralDynamics(RuralDynamics ruralDynamics);

    @PostMapping("/rural/delete")
    Integer deleteRuralDynamics(Integer id);

    @PostMapping("/rural/count")
    Integer countRuralDynamics();

    @PostMapping("/rural/more")
    List<RuralDynamics> getMore(PageInfo pageInfo);

    @PostMapping("/rural/me")
    List<RuralDynamics> getDynamicsAllByUser(PageInfo pageInfo);

    @PostMapping("/rural/meCunt")
    Integer countDynamicsByUser(Integer uId);

    @PostMapping("/rural/insertComment")
    Integer insertComment(Comment comment);

    @PostMapping("/rural/getCommentAll")
    List<Comment> getCommentAll(PageInfo pageInfo);

    @PostMapping("/rural/commentCunt")
    Integer commentCunt(Integer id);
}
