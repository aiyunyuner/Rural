package com.TypeDelta.mapper;

import com.TypeDelta.pojo.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RuralEmploymentMapper {

    @Select("SELECT * FROM rural_employment")
    List<RuralEmployment> getAll();

    @Select("SELECT * FROM rural_employment where id=#{id}")
    RuralEmployment getRuralEmploymentById(Integer id);


    @Insert("INSERT INTO rural_employment (`name`,image,`type`,`desc`,`color`,`u_id`) VALUES(#{name},#{image},#{type},#{desc},#{color},#{u_id})")
    Integer insertRuralEmployment(RuralEmployment ruralEmployment);


    @Update("UPDATE rural_employment SET  `name` = #{name},image=#{image},`type`=#{type},`desc`=#{desc},`color`=#{color} WHERE id =#{id}")
    Integer updateRuralEmployment(RuralEmployment ruralEmployment);


    @Delete("DELETE FROM rural_employment WHERE id = #{id}")
    Integer deleteRuralEmployment(Integer id);

    @Select("SELECT COUNT(id) FROM rural_employment ")
    Integer countRuralDynamics();

    @Select("SELECT * FROM rural_employment  limit #{start},#{pageSize}")
    List<RuralEmployment> getMore(PageInfo pageInfo);

    @Select("SELECT COUNT(id) FROM rural_employment  where `u_id`=#{u_id}")
    Integer countRuralEmploymentByUser(Integer u_id);

    @Select("SELECT * FROM rural_employment WHERE u_id =#{u_id} limit #{start},#{pageSize}")
    List<Agricultural> getRuralEmploymentAllByUser(PageInfo pageInfo);

    @Insert("INSERT INTO rural_employment_comment (u_id,p_id,`context`,`time`) VALUES(#{u_id},#{p_id},#{context},#{time}) ")
    Integer insertComment(Comment comment);

    @Select("SELECT * FROM rural_employment_comment  where p_id = #{p_id} limit #{start},#{pageSize}")
    @Results({
            @Result(property = "u_id", column = "u_id"),
            @Result(property = "user", column = "u_id",
                    javaType = User.class, one = @One(select = "com.TypeDelta.mapper.RuralEmploymentMapper.getUser"))
    })
    List<Comment> getCommentAll(PageInfo pageInfo);

    @Select("SELECT COUNT(id) FROM rural_employment_comment  where `p_id`=#{id}")
    Integer commentCunt(Integer id);


    @Select("select * from user where id=#{id}")
    User getUser(Integer id);

    @Update("UPDATE rural_employment SET  `click`=`click`+1 WHERE id =#{id}")
    Integer addClick(Integer id);
}
