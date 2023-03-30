package com.TypeDelta.mapper;

import com.TypeDelta.pojo.Comment;
import com.TypeDelta.pojo.PageInfo;
import com.TypeDelta.pojo.RuralDynamics;
import com.TypeDelta.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RuralDynamicsMapper {

    @Select("SELECT * FROM rural_dynamics")
    List<RuralDynamics> getAll();

    @Select("SELECT * FROM rural_dynamics where id=#{id}")
    RuralDynamics getRuralDynamicsById(Integer id);


    @Insert("INSERT INTO rural_dynamics (`name`,image,`type`,`desc`,`color`,`u_id`) VALUES(#{name},#{image},#{type},#{desc},#{color},#{u_id})")
    Integer insertRuralDynamics(RuralDynamics ruralDynamics);

    @Update("UPDATE rural_dynamics SET  `name` = #{name},image=#{image},`type`=#{type},`desc`=#{desc},`color`=#{color} WHERE id =#{id}")
    Integer updateRuralDynamics(RuralDynamics ruralDynamics);


    @Delete("DELETE FROM rural_dynamics WHERE id = #{id}")
    Integer deleteRuralDynamics(Integer id);

    @Select("SELECT COUNT(id) FROM rural_dynamics ")
    Integer countRuralDynamics();

    @Select("SELECT * FROM rural_dynamics  limit #{start},#{pageSize}")
    List<RuralDynamics> getMore(PageInfo pageInfo);

    @Select("SELECT * FROM rural_dynamics WHERE u_id =#{u_id} limit #{start},#{pageSize}")
    List<RuralDynamics> getDynamicsAllByUser(PageInfo pageInfo);

    @Select("SELECT COUNT(id) FROM rural_dynamics  where `u_id`=#{u_id}")
    Integer countDynamicsByUser(Integer uId);

    @Insert("INSERT INTO rural_dynamics_comment (u_id,p_id,`context`,`time`) VALUES(#{u_id},#{p_id},#{context},#{time}) ")
    Integer insertComment(Comment comment);

    @Select("SELECT * FROM rural_dynamics_comment where p_id = #{p_id} limit #{start},#{pageSize}")
    @Results({
            @Result(property = "u_id", column = "u_id"),
            @Result(property = "user", column = "u_id",
                    javaType = User.class, one = @One(select = "com.TypeDelta.mapper.SightsMapper.getUser"))
    })
    List<Comment> getCommentAll(PageInfo pageInfo);

    @Select("SELECT COUNT(id) FROM rural_dynamics_comment  where `p_id`=#{id}")
    Integer commentCunt(Integer id);

    @Select("select * from user where id=#{id}")
    User getUser(Integer id);
}
