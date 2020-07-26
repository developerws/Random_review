package com.ws.review.serviceImpl;

import com.ws.review.mapper.TopicMapper;
import com.ws.review.pojo.Topic;
import com.ws.review.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicMapper topicMapper;
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
    public Topic RandomPickTopic(int id) {
        return topicMapper.selectRandomById(id);
    }
}
