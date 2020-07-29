package com.ws.review.serviceImpl;

import com.ws.review.mapper.CategoryMapper;
import com.ws.review.mapper.TopicMapper;
import com.ws.review.pojo.Category;
import com.ws.review.pojo.Topic;
import com.ws.review.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicMapper topicMapper;
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public int addTopic(Topic topic) {
        return topicMapper.insertTopic(topic);
    }

    @Override
    public Topic displayTopic(int p_id) {
        return topicMapper.selectByP_id(p_id);
    }

    @Override
    public List<Topic> displayAll(int id) {
        return topicMapper.selectAll(id);
    }

    @Override
    public Integer updateTopic(Topic topic) {
        return topicMapper.updateByP_id(topic);
    }

    @Override
    public Integer deleteTopic(int p_id) {
        return topicMapper.deleteByP_id(p_id);
    }

    @Override
    public Topic RandomPickTopic(int id,int c_id) {
        Topic topic = null;
        //Map<String,Object> map = new HashMap<>();
        if(c_id == 0){
            topic = topicMapper.selectRandomById(id);
            //map.put("topic",topic);
        }
        else{
            topic = topicMapper.selectRandomByIdAndC_id(id,c_id);
            /*String c_name = categoryMapper.selectByPrimaryKey(c_id).getC_name();
            map.put("topic",topic);
            map.put("c_name",c_name);*/
        }


        return topic;
    }

}
