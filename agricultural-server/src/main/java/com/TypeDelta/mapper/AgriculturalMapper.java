package com.TypeDelta.mapper;

import com.TypeDelta.pojo.Agricultural;
import com.TypeDelta.pojo.Comment;
import com.TypeDelta.pojo.PageInfo;
import com.TypeDelta.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AgriculturalMapper {


    @Select("SELECT * FROM agricultural_activities")
    List<Agricultural> getAll();

    @Select("SELECT * FROM agricultural_activities where id=#{id}")
    Agricultural getAgriculturalById(Integer id);


    @Insert("INSERT INTO agricultural_activities (`name`,image,`type`,`desc`,`color`,`where`,`u_id`) VALUES(#{name},#{image},#{type},#{desc},#{color},#{where},#{u_id})")
    Integer insertAgricultural(Agricultural agricultural);

    @Update("UPDATE agricultural_activities  SET  `name` = #{name},image=#{image},`type`=#{type},`desc`=#{desc},`color`=#{color},`where`=#{where} WHERE id =#{id}")
    Integer updateAgricultural(Agricultural agricultural);


    @Delete("DELETE FROM agricultural_activities  WHERE id = #{id}")
    Integer deleteAgricultural(Integer id);


    @Select("SELECT COUNT(id) FROM agricultural_activities ")
    Integer countAgricultural();

    @Select("SELECT * FROM agricultural_activities  limit #{start},#{pageSize}")
    List<Agricultural> getMore(PageInfo pageInfo);

    @Select("SELECT * FROM agricultural_activities WHERE u_id =#{u_id} limit #{start},#{pageSize}")
    List<Agricultural> getAgriculturalAllByUser(PageInfo pageInfo);

    @Select("SELECT COUNT(id) FROM agricultural_activities  where `u_id`=#{u_id}")
    Integer countAgriculturalByUser(Integer u_id);

    @Insert("INSERT INTO agricultural_activities_comment (u_id,p_id,`context`,`time`) VALUES(#{u_id},#{p_id},#{context},#{time}) ")
    Integer insertComment(Comment comment);

    @Select("SELECT * FROM agricultural_activities_comment  where p_id = #{p_id} limit #{start},#{pageSize}")
    @Results({
            @Result(property = "u_id", column = "u_id"),
            @Result(property = "user", column = "u_id",
                    javaType = User.class, one = @One(select = "com.TypeDelta.mapper.AgriculturalMapper.getUser"))
    })
    List<Comment> getCommentAll(PageInfo pageInfo);

    @Select("SELECT COUNT(id) FROM agricultural_activities_comment where `p_id`=#{id}")
    Integer commentCunt(Integer id);

    @Select("select * from user where id=#{id}")
    User getUser(Integer id);

    @Update("UPDATE agricultural_activities SET  `click`=`click`+1 WHERE id =#{id}")
    Integer addClick(Integer id);
}
