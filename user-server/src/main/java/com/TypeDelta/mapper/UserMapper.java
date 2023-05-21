package com.TypeDelta.mapper;

import com.TypeDelta.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 *  user操作
 *  @authour TypeDelta
 */
@Repository
@Mapper

public interface UserMapper {
    /***
     * 插入User
     * @param user
     */
    @Insert("INSERT into user (name,password)VALUE(#{name},#{password})")
    void addUser(User user);

    /***
     * 删除User
     * @param user
     * @return 1:成功 0：失败
     */
    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleterUser(User user);

    @Update("UPDATE user set name =#{name},password=#{password},image=#{image} WHERE id = #{u_id};")
    int updateUser(User user);

    @Select("SELECT * FROM user WHERE name=#{name} AND password=#{password}")
    User loginUser(User user);

    @Select("select id,name,password,valid from user")
    List<User> selectAll();

    @Select("SELECT `name`,`password`,valid,id FROM `user` LIMIT #{startNum}, #{pageSize}")
    List<User> userListAndPage(int startNum, int pageSize);

    @Select("select count(id) from user")
    Integer countUser();


    @Select("select * from user where id=#{id}")
    User getUser(Integer id);

    @Select("SELECT maner FROM `user` WHERE id=#{id}")
    Integer isManager(Integer id);
}
