package com.ws.review.mapper;

import com.ws.review.pojo.Topic;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TopicMapper {
    @Insert("insert into topic(id,c_id,title,content) values(#{id},#{c_id},#{title},#{content})")
    @Options(useGeneratedKeys = true,keyProperty = "p_id",keyColumn = "p_id")
    int insertTopic(Topic topic);

    @Select("select * from topic where p_id=#{p_id}")
    Topic selectByP_id(int p_id);

    @Select("select * from topic where id=#{id}")
    List<Topic> selectAll(int id);

    @Update("update topic set title=#{title},content=#{content} where p_id=#{p_id}")
    Integer updateByP_id(Topic topic);

    @Delete("delete from topic where p_id=#{p_id}")
    Integer deleteByP_id(int p_id);

    @Select("select * from topic where id=#{id} order by rand() limit 1")
    Topic selectRandomById(int id);

    @Select("select * from topic where id=#{id} and c_id=#{c_id} order by rand() limit 1")
    Topic selectRandomByIdAndC_id(int id, int c_id);
}
