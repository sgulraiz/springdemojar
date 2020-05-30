package com.ivisionsys.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourse(String topicId){

        List<Course> courses = new ArrayList<>();
        courses.addAll(courseRepository.findByTopicId(topicId));
        return courses;

    }

    public Course getCourse(String id){
        return courseRepository.findOne(id);
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(String id, Course course){
        courseRepository.save(course);
    }

    public void deleteCourse(String id){
        courseRepository.delete(id);
    }

}
