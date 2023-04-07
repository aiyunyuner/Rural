package com.TypeDelta.mapper;

import com.TypeDelta.pojo.LogMe;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper

public interface LogMapper {
    @Insert("INSERT INTO history (u_id,ip,`where`,`action`,`time`,`type`) VALUES(#{u_id},#{ip},#{where},#{action},#{time},#{type})")
    Integer insertLog(LogMe logMe);

    @Select("SELECT STR_TO_DATE(`time`,'%Y-%m-%d') AS aaa , COUNT(`time`) AS num FROM history  GROUP BY aaa ORDER BY time DESC  LIMIT 0,7")
    @Results({
            @Result(property = "time", column = "aaa")
    })
    List<LogMe> PV7();
}
