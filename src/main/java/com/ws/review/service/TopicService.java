package com.ws.review.service;

import com.sun.corba.se.impl.oa.toa.TOA;
import com.ws.review.pojo.Topic;

import java.util.List;
import java.util.Map;

public interface TopicService {
    int addTopic(Topic topic);

    Topic displayTopic(int p_id);

    List<Topic> displayAll(int id);

    Integer updateTopic(Topic topic);

    Integer deleteTopic(int p_id);

    Topic RandomPickTopic(int id, int c_id);
}
