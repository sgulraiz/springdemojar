package com.ivisionsys.course;

import com.ivisionsys.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping ("/topics/{topicId}/courses")
    public List<Course> getCourses(@PathVariable String topicId){
        return courseService.getAllCourse(topicId);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public void getCourse(@PathVariable String id, @PathVariable String topicId){
        courseService.getCourse(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/topics/{topicID}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicID){
        course.setTopic(new Topic(topicID, "", ""));
        courseService.addCourse(course);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/topics/{topicID}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicID){
        course.setTopic(new Topic(topicID, "",""));
        courseService.updateCourse(id, course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/topics/{topicID}/course/{id}")
    public void deleteCourse(@PathVariable String id, @PathVariable String topicID){
        courseService.deleteCourse(id);
    }

}
