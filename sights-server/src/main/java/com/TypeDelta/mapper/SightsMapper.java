package com.TypeDelta.mapper;

import com.TypeDelta.pojo.IndexSightsType;
import com.TypeDelta.pojo.Sight;
import com.TypeDelta.pojo.SightsType;
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


    @Select("SELECT * FROM sight WHERE `type`=#{id}")
    List<Sight> getSightsAllByType(Integer id);


    @Insert("INSERT INTO sight (`name`,image,`type`,`desc`,`color`,`where`) VALUES(#{name},#{image},#{type},#{desc},#{color},#{where})")
    Integer insertSight(Sight sight);
}
