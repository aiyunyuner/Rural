package com.TypeDelta.controller;

import com.TypeDelta.pojo.*;
import com.TypeDelta.service.SightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sights")
@RefreshScope
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

    /**
     * 通过类型获取所有风景限制0到6
     *
     * @param id
     * @return
     */
    @PostMapping("/getSightsAllByType")
    List<Sight> getSightsAllByType(@RequestBody Integer id) {
        return sightsService.getSightsAllByType(id);
    }

    /**
     * 插入
     *
     * @param sight
     * @return
     */
    @PostMapping("/insert")
    Integer insertSight(@RequestBody Sight sight) {
        System.out.println(sight.toString());
        return sightsService.insertSight(sight);
    }

    /**
     * 更新
     *
     * @param sight
     * @return
     */
    @PostMapping("/update")
    Integer updateSight(@RequestBody Sight sight) {
        return sightsService.updateSight(sight);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @PostMapping("/delete")
    Integer deleteSight(@RequestBody Integer id) {
        return sightsService.deleteSight(id);
    }

    /**
     * 用户发布的风景数量
     *
     * @param id
     * @return
     */
    @PostMapping("/count")
    Integer countTypeSight(@RequestBody Integer id) {
        return sightsService.countTypeSight(id);
    }

    /**
     * 获取更多风景（普通用户）
     *
     * @param pageInfo
     * @return
     */
    @PostMapping("/more")
    List<Sight> getSightsAllByTypeTwo(@RequestBody PageInfo pageInfo) {
        return sightsService.getSightsAllByTypeTwo(pageInfo);
    }

    /**
     * 获取更多风景（管理员使用接口）
     *
     * @param pageInfo
     * @return
     */
    @PostMapping("/getMore")
    List<Sight> getMore(@RequestBody PageInfo pageInfo) {
        return sightsService.getMore(pageInfo);
    }

    /**
     * 用户发布的风景
     *
     * @param pageInfo
     * @return
     */
    @PostMapping("/me")
    List<Sight> getSightsAllByUser(@RequestBody PageInfo pageInfo) {
        return sightsService.getSightsAllByUser(pageInfo);
    }

    /**
     * 获取所有风景的数目（管理员）
     *
     * @return
     */
    @PostMapping("/getCount")
    Integer getCount() {
        return sightsService.getCount();
    }

    /**
     * 获取自己的发布的风景数目
     *
     * @param u_id
     * @return
     */
    @PostMapping("/meCunt")
    Integer countTypeSightByUser(@RequestBody Integer u_id) {
        return sightsService.countTypeSightByUser(u_id);
    }

    /**
     * 插入评论
     *
     * @param comment
     * @return
     */
    @PostMapping("/insertComment")
    Integer insertComment(@RequestBody Comment comment) {
        return sightsService.insertComment(comment);
    }

    /**
     * 获取所有评论
     *
     * @param pageInfo
     * @return
     */
    @PostMapping("/getCommentAll")
    List<Comment> getCommentAll(@RequestBody PageInfo pageInfo) {
        return sightsService.getCommentAll(pageInfo);
    }

    /**
     * 已文章的id获取评论数目
     *
     * @param id
     * @return
     */

    @PostMapping("/commentCunt")
    Integer commentCunt(@RequestBody Integer id) {
        return sightsService.commentCunt(id);
    }

    /**
     * 热门访问量top3
     *
     * @return
     */
    @PostMapping("/top3")
    List<Sight> top3() {
        return sightsService.top3();
    }

    /**
     * 推荐算法
     *
     * @param u_id
     * @return
     */
    @PostMapping("/beast")
    List<Sight> Beast(@RequestBody Integer u_id) {
        return sightsService.Beast(u_id);
    }
}
