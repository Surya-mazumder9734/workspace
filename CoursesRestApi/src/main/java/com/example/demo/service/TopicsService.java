package com.example.demo.service;

import com.example.demo.model.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicsService {
    private List<Topic> topicList=new ArrayList<>(Arrays.asList(new Topic("spring","Spring_framework","Spring_descrption"),new Topic("spring","Spring_hibernate","code to do")));


   //All topic List
    public List<Topic> getAllTopicList(){
        return topicList;
    }

    //get a topic
    public Topic getTopic(String id){
        return topicList.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }

    //add a topic
    public void addTopic(Topic topic) {
        topicList.add(topic);
    }

    //update topic
    public void updateTopic(Topic topic, String id) {
        int counter=0;
        for (Topic topic1:topicList){
            if (topic1.getId().equals(id)){
                topicList.set(counter,topic);
            }
            counter++;
        }
    }

    //delete

    public void deleteTopic(String id) {
        topicList.removeIf(topic -> topic.getId().equals(id));
    }
}
