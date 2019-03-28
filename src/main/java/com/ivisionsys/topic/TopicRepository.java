package com.ivisionsys.topic;

import org.springframework.data.repository.CrudRepository;

//This is the data service which will provide necessary CRUD operations to run against the Topic.
//This is the interface which will extend Spring Data JPAs interface CrudRepository
//Implementation of CrudRepository contains and provides all the necessary out of the box CRUD operations
//Any special CRUD operation which is specific to the business requirement and not available in the implementation needs to be custom built.
//CustomRepository is of the Generic type so we need to pass the Generic Type information. In this case we will pass the Entity (Topic) and the ID (String)
public interface TopicRepository extends CrudRepository<Topic, String> {

}
