package com.TypeDelta.client;

import com.TypeDelta.pojo.Agricultural;
import com.TypeDelta.pojo.Comment;
import com.TypeDelta.pojo.PageInfo;
import com.TypeDelta.pojo.RuralEmployment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "rural-employment-server", fallback = RuralEmploymentClientFallback.class)
public interface RuralEmploymentClient {
    @GetMapping("/employment/all")
    List<RuralEmployment> getAll();

    @PostMapping("/employment/one")
    RuralEmployment getRuralEmploymentById(Integer id);

    @PostMapping("/employment/insert")
    Integer insertRuralEmployment(RuralEmployment ruralEmployment);

    @PostMapping("/employment/update")
    Integer updateRuralEmployment(RuralEmployment ruralEmployment);

    @PostMapping("/employment/delete")
    Integer deleteRuralEmployment(Integer id);

    @PostMapping("/employment/count")
    Integer countRuralDynamics();

    @PostMapping("/employment/more")
    List<RuralEmployment> getMore(PageInfo pageInfo);

    @PostMapping("/employment/me")
    List<Agricultural> getRuralEmploymentAllByUser(PageInfo pageInfo);

    @PostMapping("/employment/meCunt")
    Integer countRuralEmploymentByUser(Integer uId);

    @PostMapping("/employment/insertComment")
    Integer insertComment(Comment comment);

    @PostMapping("/employment/getCommentAll")
    List<Comment> getCommentAll(PageInfo pageInfo);

    @PostMapping("/employment/commentCunt")
    Integer commentCunt(Integer id);
}
