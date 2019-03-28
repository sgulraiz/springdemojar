package com.ivisionsys.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**This is the Topic business service. A singleton (single) instance of this service
will be created during runtime.
To tell Spring that this is the Business Service use Spring Stereotype Service annotation
*/
@Service
public class TopicService {
	//Create an instance of the TopicRepositry by creating a new member variable and Auto wiring it.
	//When this instance is created, spring will inject the Topic Repository in this member variable.
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics(){
		//find all method goes out to the database and gets all the rows from the Topic table and converts those rows to Topic instances and returns it.
		//since findAll() is iterable we need to create a list and add all instances to the list and return it.
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id){
		return topicRepository.findOne(id);
	}
	
	public void addTopic(Topic topic){
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepository.delete(id);
	}

}
