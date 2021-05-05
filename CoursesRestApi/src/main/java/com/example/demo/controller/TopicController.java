package com.example.demo.controller;

import com.example.demo.model.Topic;
import com.example.demo.service.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {
    @Autowired
    private TopicsService topicsService;

    @RequestMapping(path = "/topics")
    public List<Topic> all_topics(){
        return topicsService.getAllTopicList();
    }

    @RequestMapping(path = "/topics/{id}")
    public Topic getTopic(@PathVariable("id")String id){
        return topicsService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST ,value = "/topics")
    public void addTopic(@RequestBody Topic topic){
        topicsService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT ,value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic,@PathVariable("id")String id){
        topicsService.updateTopic(topic,id);
    }

    @RequestMapping(method =RequestMethod.DELETE,value = "/topics/{id}")
    public void deleteTopic(@PathVariable("id") String id){
        topicsService.deleteTopic(id);
    }
}
