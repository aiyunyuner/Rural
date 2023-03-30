package com.TypeDelta.client;

import com.TypeDelta.pojo.Comment;
import com.TypeDelta.pojo.IndexSightsType;
import com.TypeDelta.pojo.PageInfo;
import com.TypeDelta.pojo.Sight;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "sights-server", fallback = SightsClientFallback.class)
public interface SightsClient {
    @GetMapping("/sights/getSightsAll")
    List<Sight> getSightsAll();

    @GetMapping("/sights/getAllNumber")
    Integer getAllNumber();

    @GetMapping("/sights/getSightsTypeAll")
    List<IndexSightsType> getSightsTypeAll();

    @PostMapping("/sights/getSightsById")
    Sight getSightsById(Integer id);

    @PostMapping("/sights/getSightsTypeOne")
    IndexSightsType getSightsTypeOne(Integer id);

    @PostMapping("/sights/insert")
    Integer insertSight(Sight sight);

    @PostMapping("/sights/update")
    Integer updateSight(Sight sight);

    @PostMapping("/sights/delete")
    Integer deleteSight(Integer id);

    @PostMapping("/sights/count")
    Integer countTypeSight(Integer pageInfo);

    @PostMapping("/sights/more")
    List<Sight> getSightsAllByTypeTwo(PageInfo pageInfo);

    @PostMapping("/sights/me")
    List<Sight> getSightsAllByUser(PageInfo pageInfo);

    @PostMapping("/sights/meCunt")
    Integer countTypeSightByUser(Integer uId);

    @PostMapping("/sights/insertComment")
    Integer insertComment(Comment comment);

    @PostMapping("/sights/getCommentAll")
    List<Comment> getCommentAll(PageInfo pageInfo);

    @PostMapping("/sights/commentCunt")
    Integer commentCunt(Integer id);
}
