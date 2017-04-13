package com.marco.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.marco.project.model.Topic;

@Service
public class TopicService {
	
	@SuppressWarnings("serial")
	private List<Topic> topics = new ArrayList<Topic>() {{
		add(new Topic("id0", "name0", "description0"));
		add(new Topic("id1", "name1", "description1"));
		add(new Topic("id2", "name2", "description2"));
		add(new Topic("id3", "name3", "description3"));
		add(new Topic("id4", "name4", "description4"));
		add(new Topic("id5", "name5", "description5"));
		add(new Topic("id6", "name6", "description6"));
		add(new Topic("id7", "name7", "description7"));
		add(new Topic("id8", "name8", "description8"));
		add(new Topic("id9", "name9", "description9"));
	}};
	
	public List<Topic> getAllTopics() {
		return topics;
	}
	
	public Topic getTopic(String id) {
		try {
			return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	public void updateTopic(String id, Topic topic) {
		for(int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}
	
	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}

}
