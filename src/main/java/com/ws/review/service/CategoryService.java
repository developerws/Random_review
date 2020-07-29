package com.ws.review.service;

import com.ws.review.pojo.Category;

import java.util.List;

public interface CategoryService {
    int addCategory(Category category);

    Category selectByC_name(String c_name);

    List<Category> findAll();

    Category selectByC_id(int c_id);
}
