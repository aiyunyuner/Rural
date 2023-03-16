package com.TypeDelta.mapper;

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
    List<SightsType> getSightsTypeAll();

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
}
