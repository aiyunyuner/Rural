package com.TypeDelta.mapper;

import com.TypeDelta.pojo.RuralEmployment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RuralEmploymentMapper {

    @Select("SELECT * FROM rural_employment")
    List<RuralEmployment> getAll();

    @Select("SELECT * FROM rural_employment where id=#{id}")
    RuralEmployment getRuralEmploymentById(Integer id);


    @Insert("INSERT INTO rural_employment (`name`,image,`type`,`desc`,`color`) VALUES(#{name},#{image},#{type},#{desc},#{color})")
    Integer insertRuralEmployment(RuralEmployment ruralEmployment);
}
