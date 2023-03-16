package com.TypeDelta.mapper;

import com.TypeDelta.pojo.RuralDynamics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RuralDynamicsMapper {

    @Select("SELECT * FROM rural_dynamics")
    List<RuralDynamics> getAll();

    @Select("SELECT * FROM rural_dynamics where id={id}")
    RuralDynamics getRuralDynamicsById(Integer id);
}