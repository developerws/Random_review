package com.ws.review.controller;

import com.ws.review.pojo.Category;
import com.ws.review.pojo.User;
import com.ws.review.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.awt.*;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/addCategoryPage")
    public String addCategoryPage(Model m){

        return "addCategory";
    }


    @RequestMapping("/addCategory")
    public String addCategory(@ModelAttribute("category") Category category, Model m){
        int result = categoryService.addCategory(category);
        if(result>0){
            m.addAttribute("message","增加类别成功");
        }
        else{
            m.addAttribute("message","增加类别失败");
        }
        return "redirect:/addCategoryPage";
    }

}
