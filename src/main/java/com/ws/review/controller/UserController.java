package com.ws.review.controller;

import com.ws.review.pojo.Category;
import com.ws.review.pojo.User;
import com.ws.review.service.CategoryService;
import com.ws.review.service.TopicService;
import com.ws.review.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request,Model m) {
        HttpSession session = request.getSession();
        Object idObject = session.getAttribute("id");
        if(idObject==null){
            return "redirect:/loginPage";
        }
        List<Category> categoryList = categoryService.findAll();
        m.addAttribute("categoryList",categoryList);
        return "index";


    }

    @RequestMapping("/loginPage")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/registerPage")
    public String registerPage(){
        return "register";
    }

    @RequestMapping("/register")
    public String register(@ModelAttribute("user") User user, Model m){
        int result = userService.addUser(user);
        if(result>0)
            m.addAttribute("message","注册成功");
        else
            m.addAttribute("message","注册失败");
        return "redirect:/loginPage";
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute("u") User u, HttpServletRequest request, Model m){
        HttpSession session = request.getSession();
        User user = null;
        user = userService.checkUser(u.getUser_name(),u.getPassword());
        if(user != null){
            session.setAttribute("id",user.getId());
            session.setAttribute("user_name",user.getUser_name());
            m.addAttribute("message","登录成功");
        }
        else{
            m.addAttribute("message","登录失败");
        }
        return "redirect:/index";
    }
}
