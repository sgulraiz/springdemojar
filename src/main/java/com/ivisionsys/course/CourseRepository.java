package com.ivisionsys.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {

    /**method to find course by name - This is the interface and can only contain
    method definition. The implementation of the method is defined in the implementation class.
     However, if we define the method in a particular way then JPA will automatically create the
     implementation for us. Example below let's us find all courses by name - method name must be
     findByProperty which in this is findByName
     By defining the method this way, JPA will create the implementation for us */
    List<Course> findByName(String name);
    List<Course> findByDescription(String description);
    //In the example below, we need to find Course by Topic id. Topic in the Course entity is not a string
    //it is object type. We need to tell JPA to look at the Topic Entity and use the Id field
    List<Course> findByTopicId(String topicId);
}
