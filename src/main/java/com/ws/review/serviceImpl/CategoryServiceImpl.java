package com.ws.review.serviceImpl;


import com.ws.review.mapper.CategoryMapper;
import com.ws.review.pojo.Category;
import com.ws.review.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public int addCategory(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public Category selectByC_name(String c_name) {
        return categoryMapper.selectByC_name(c_name);
    }

    @Override
    public List<Category> findAll() {
        return categoryMapper.selectAll();
    }

    @Override
    public Category selectByC_id(int c_id) {
        return categoryMapper.selectByPrimaryKey(c_id);
    }
}
