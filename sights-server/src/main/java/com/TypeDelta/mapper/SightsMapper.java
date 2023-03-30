package com.TypeDelta.mapper;

import com.TypeDelta.pojo.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SightsMapper {
    @Select("SELECT * FROM sight")
    @Results({
            @Result(property = "type", column = "type"),
            @Result(property = "sightsType",
                    column = "type",
                    javaType = SightsType.class,
                    one = @One(select = "com.TypeDelta.mapper.SightsMapper.getSightsTypeById"))
    })
    List<Sight> getSightsAll();

    @Select("SELECT  COUNT(*) FROM sight")
    Integer getAllNumber();

    @Select("SELECT * FROM sights_type")
    @Results({
            @Result(column = "sights_type", property = "name")
    })
    List<IndexSightsType> getSightsTypeAll();

    @Select("SELECT * FROM sights_type WHERE type_id = #{id}")
    SightsType getSightsTypeById(Integer id);


    @Select("SELECT * FROM sight where id=#{id}")
    @Results({
            @Result(property = "type", column = "type"),
            @Result(property = "sightsType",
                    column = "type",
                    javaType = SightsType.class,
                    one = @One(select = "com.TypeDelta.mapper.SightsMapper.getSightsTypeById"))
    })
    Sight getSightsById(Integer id);

    @Select("SELECT * FROM sights_type where type_id=#{id}")
    @Results({
            @Result(column = "type_id", property = "type_id"),
            @Result(column = "sights_type", property = "name"),
            @Result(property = "sightList", column = "type_id",
                    javaType = List.class,
                    many = @Many(select = "com.TypeDelta.mapper.SightsMapper.getSightsAllByType"))
    })
    IndexSightsType getSightsTypeOne(Integer id);


    @Select("SELECT * FROM sight WHERE `type`=#{id} limit 0,6")
    List<Sight> getSightsAllByType(Integer id);


    @Insert("INSERT INTO sight (`name`,image,`type`,`desc`,`color`,`where`,`u_id`) VALUES(#{name},#{image},#{type},#{desc},#{color},#{where},#{u_id})")
    Integer insertSight(Sight sight);


    @Update("UPDATE sight SET  `name` = #{name},image=#{image},`type`=#{type},`desc`=#{desc},`color`=#{color},`where`=#{where} WHERE id =#{id}")
    Integer updateSight(Sight sight);


    @Delete("DELETE FROM sight WHERE id = #{id}")
    Integer deleteSight(Integer id);

    @Select("SELECT COUNT(id) FROM sight  where `type`=#{id}")
    Integer countTypeSight(Integer id);

    @Select("SELECT * FROM sight WHERE `type`=#{id} limit #{start},#{pageSize}")
    List<Sight> getSightsAllByTypeTwo(PageInfo pageInfo);


    @Select("SELECT * FROM sight WHERE u_id =#{u_id} limit #{start},#{pageSize}")
    List<Sight> getSightsAllByUser(PageInfo pageInfo);

    @Select("SELECT COUNT(id) FROM sight  where `u_id`=#{u_id}")
    Integer countTypeSightByUser(Integer u_id);


    @Insert("INSERT INTO sight_comment (u_id,p_id,`context`,`time`) VALUES(#{u_id},#{p_id},#{context},#{time}) ")
    Integer insertComment(Comment comment);


    @Select("SELECT * FROM sight_comment where p_id = #{p_id} limit #{start},#{pageSize}")
    @Results({
            @Result(property = "u_id", column = "u_id"),
            @Result(property = "user", column = "u_id",
                    javaType = User.class, one = @One(select = "com.TypeDelta.mapper.SightsMapper.getUser"))
    })
    List<Comment> getCommentAll(PageInfo pageInfo);

    @Select("SELECT COUNT(id) FROM sight_comment  where `p_id`=#{id}")
    Integer commentCunt(Integer id);

    @Select("select * from user where id=#{id}")
    User getUser(Integer id);
}
