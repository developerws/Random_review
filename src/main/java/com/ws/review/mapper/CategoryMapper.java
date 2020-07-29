package com.ws.review.mapper;

import com.ws.review.pojo.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {


    int deleteByPrimaryKey(Integer cId);

    @Insert("insert into category (c_name) values (#{c_name})")
    @Options(useGeneratedKeys = true,keyProperty = "c_id",keyColumn = "c_id")
    int insert(Category record);

    @Select("select * from category where c_id=#{cId}")
    Category selectByPrimaryKey(Integer cId);

    @Select("select * from category where c_name=#{c_name}")
    Category selectByC_name(String c_name);

    @Select("select * from category")
    List<Category> selectAll();

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}
