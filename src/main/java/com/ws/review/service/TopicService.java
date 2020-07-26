package com.ws.review.service;

import com.ws.review.pojo.Topic;

import java.util.List;

public interface TopicService {
    int addTopic(Topic topic);

    Topic displayTopic(int p_id);

    List<Topic> displayAll(int id);

    Integer updateTopic(Topic topic);

    Integer deleteTopic(int p_id);

    Topic RandomPickTopic(int id);

}
