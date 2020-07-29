package com.ws.review.controller;

import com.ws.review.pojo.Category;
import com.ws.review.pojo.Topic;
import com.ws.review.pojo.User;
import com.ws.review.service.CategoryService;
import com.ws.review.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class TopicController {
    @Autowired
    TopicService topicService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/addTopicPage")
    public String addTopicPage(Model m){
        List<Category> categoryList = categoryService.findAll();
        m.addAttribute("categoryList",categoryList);
        return "addTopic";
    }


    @RequestMapping("/addTopic")
    public String addTopic(HttpServletRequest request, @ModelAttribute("topic") Topic topic, Model m){
        HttpSession session = request.getSession();
        int id = (Integer) session.getAttribute("id");
        topic.setId(id);
        System.out.println(topic.getC_id());
        System.out.println(topic.getId());
        int result = topicService.addTopic(topic);
        if(result>0){
            m.addAttribute("message","添加题目成功");
        }
        else{
            m.addAttribute("message","添加题目失败");
        }
        return "redirect:/index";
    }

    /**
     * 根据题目id查询题目信息
     * @param p_id
     * @param m
     * @return
     */
    @RequestMapping("/displayTopic")
    public String displayTopic(@RequestParam("p_id") int p_id,Model m){
        Topic topic = topicService.displayTopic(p_id);
        m.addAttribute("topic",topic);
        return "displayTopic";
    }

    @RequestMapping("/displayAll")
    public String displayAll(HttpServletRequest request,Model m){
        HttpSession session = request.getSession();
        int id = (Integer) session.getAttribute("id");
        List<Topic> topicList=topicService.displayAll(id);
        m.addAttribute("topicList",topicList);
        return "displayAll";
    }

    @RequestMapping("/updateTopic")
    public String updateTopic(@ModelAttribute("topic") Topic topic, Model m){
        int result = topicService.updateTopic(topic);
        if(result>0){
            m.addAttribute("message","修改成功");
        }
        else
            m.addAttribute("message","修改失败");

        return "forward:/displayTopic";
    }

    @RequestMapping("/deleteTopic")
    public String deleteTopic(@RequestParam("p_id") int p_id,Model m){
        int result = topicService.deleteTopic(p_id);
        if(result>0){
            m.addAttribute("message","删除成功");
        }
        else
            m.addAttribute("message","删除失败");
        //为什么要用forward,因为要将message消息带给前台
        return "forward:/displayAll";
    }
    @RequestMapping("/randomPickTopic")
    public String RandomPickTopic(HttpServletRequest request,@RequestParam("c_id") int c_id,Model m){
        HttpSession session = request.getSession();
        int id = (Integer) session.getAttribute("id");
        Topic topic = topicService.RandomPickTopic(id,c_id);
        List<Category> categoryList = categoryService.findAll();
        m.addAttribute("categoryList",categoryList);
        m.addAttribute("topic",topic);
        return "index";
    }

}
