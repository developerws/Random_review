package com.ws.review.mapper;

import com.ws.review.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
@Mapper
@Repository
public interface UserMapper {
    @Select("select number_file_owned from user where id=#{id}")
    int selectById(int id);
    @Select("update user set number_file_owned=number_file_owned+1 where id=#{id}")
    Integer updateNumById(int id);
    @Insert("insert into user(user_name,password) values(#{user_name},#{password})")
    @Options(useGeneratedKeys = true,keyProperty = "user_id",keyColumn = "user_id")
    int insertUser(User user);
    @Select("select * from user where user_name=#{user_name} and password=#{password}")
    User findByUsernameAndPassword(@Param("user_name") String user_name, @Param("password") String password);
}
