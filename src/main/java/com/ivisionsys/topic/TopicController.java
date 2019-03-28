package com.ivisionsys.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//To make this class a rest controller which will map the incoming requests to specific URI
//use the annotation to tell the spring that this class is the Rest Controller
@RestController
public class TopicController {
	
	//to get the singleton instance of the business service use the auto wired annotation
	//this annotation will create the dependency of this controller on the business service
	//and will inject the instance to this private variable
	
	@Autowired
	private TopicService topicService;
	
	//To map the request to specific URI use Request Mapping annotation
	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		return topicService.getAllTopics();
	}
	
	//To map the request to the URI which contains the ID for a specific record use variable in the URI
	@RequestMapping("/topics/{id}")
	//use path variable annotation to tell spring that the value passed in the id variable in the URI needs to be passed as
	//an argument in the get topic method
	public Topic getTopic(@PathVariable String id){
		return topicService.getTopic(id);
	}
	
	//to create a POST request mapping use the request method
	//POST request will create a new record 
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	//to tell spring to POST (save) whatever comes in the Request body use the annotation
	//it will take the json from the request body and convert it to the Topic object called topic
	public void addTopic(@RequestBody Topic topic){
		topicService.addTopic(topic);
	}
	
	//PUT request will be updating an existing record
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
		topicService.updateTopic(id, topic);
	}
	
	//Delete request will be deleting an existing record
	
		@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
		public void deleteTopic(@PathVariable String id){
			topicService.deleteTopic(id);
		}
}
