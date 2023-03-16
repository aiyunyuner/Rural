package com.TypeDelta.mapper;

import com.TypeDelta.pojo.Agricultural;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AgriculturalMapper {


    @Select("SELECT * FROM agricultural_activities")
    List<Agricultural> getAll();

    @Select("SELECT * FROM agricultural_activities where id=#{id}")
    Agricultural getAgriculturalById(Integer id);

}