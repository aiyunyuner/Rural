package com.TypeDelta.mapper;

import com.TypeDelta.pojo.LogMe;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper

public interface LogMapper {
    @Insert("INSERT INTO history (u_id,ip,`where`,`action`,`time`) VALUES(#{u_id},#{ip},#{where},#{action},#{time})")
    Integer insertLog(LogMe logMe);

    @Select("SELECT right(STR_TO_DATE(`time`,'%Y-%m-%d'),5) AS ccc ,COUNT(`time`) AS num   FROM history GROUP BY ccc  ORDER BY ccc DESC  LIMIT 0,7")
    @Results({
            @Result(property = "time", column = "ccc")
    })
    List<LogMe> PV7();

    @Select("SELECT `type` ,COUNT(`type`)  AS num  FROM history GROUP BY `type` ")
    @Results({
            @Result(property = "value", column = "num"),
            @Result(property = "name", column = "type")
    })
    List<LogMe> pieMoules();

    @Select("SELECT right(STR_TO_DATE(`time`,'%Y-%m-%d'),5) AS ccc ,COUNT(`time`) AS num   FROM history WHERE `type`='风景' GROUP BY ccc  ORDER BY ccc DESC  LIMIT 0,7")
    @Results({
            @Result(property = "time", column = "ccc")
    })
    List<LogMe> sightsPV7();

    @Select("SELECT right(STR_TO_DATE(`time`,'%Y-%m-%d'),5) AS ccc ,COUNT(`time`) AS num   FROM history WHERE `type`='就业' GROUP BY ccc  ORDER BY ccc DESC  LIMIT 0,7")
    @Results({
            @Result(property = "time", column = "ccc")
    })
    List<LogMe> emPV7();

    @Select("SELECT right(STR_TO_DATE(`time`,'%Y-%m-%d'),5) AS ccc ,COUNT(`time`) AS num   FROM history WHERE `type`='活动' GROUP BY ccc  ORDER BY ccc DESC  LIMIT 0,7")
    @Results({
            @Result(property = "time", column = "ccc")
    })
    List<LogMe> agPV7();

    @Select("SELECT right(STR_TO_DATE(`time`,'%Y-%m-%d'),5) AS ccc ,COUNT(`time`) AS num   FROM history WHERE `type`='动态' GROUP BY ccc  ORDER BY ccc DESC  LIMIT 0,7")
    @Results({
            @Result(property = "time", column = "ccc")
    })
    List<LogMe> ruPV7();

    @Select("SELECT u_id ,COUNT(u_id) AS num FROM history GROUP BY u_id LIMIT 0,5")
    @Results({
            @Result(property = "u_id", column = "u_id"),
            @Result(property = "name", column = "u_id", javaType = String.class, one = @One(select = "com.TypeDelta.mapper.LogMapper.getUserName"))
    })
    List<LogMe> userTOP5();

    @Select("SELECT `name` from user where id=#{id}")
    String getUserName(Integer id);

    @Select("SELECT SUBSTRING(`time`,12,2) AS se ,COUNT(`time`) AS num FROM history  GROUP BY se ")
    @Results({
            @Result(property = "time", column = "se")
    })
    List<LogMe> dayPV();
}
