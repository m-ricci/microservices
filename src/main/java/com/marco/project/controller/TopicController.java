package com.marco.project.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marco.project.model.Topic;
import com.marco.project.service.TopicService;

@RestController
public class TopicController {
	
	private static final Logger log = LogManager.getLogger(TopicController.class);
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping(value="/topics", method=RequestMethod.GET)
	public List<Topic> getAllTopics() {
		log.info("getAllTopics");
		return topicService.getAllTopics();
	}
	
	@RequestMapping(value="/topics/{id}", method=RequestMethod.GET)
	public Topic getTopic(@PathVariable(required=true) String id) {
		log.info("getTopic");
		return topicService.getTopic(id);
	}
	
	@RequestMapping(value="/topics", method=RequestMethod.POST)
	public void addTopic(@RequestBody(required=true) Topic topic) {
		log.info("addTopic");
		topicService.addTopic(topic);
	}
	
	@RequestMapping(value="/topics/{id}", method=RequestMethod.PUT)
	public void updateTopic(@RequestBody(required=true) Topic topic, @PathVariable(required=true) String id) {
		log.info("updateTopic");
		topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(value="/topics/{id}", method=RequestMethod.DELETE)
	public void deleteTopic(@PathVariable(required=true) String id) {
		log.info("deleteTopic");
		topicService.deleteTopic(id);
	}

}
