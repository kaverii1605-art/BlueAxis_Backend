package com.blueaxis.blueaxisapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blueaxis.blueaxisapi.models.Infographic;

@Repository
public interface InfographicRepo extends MongoRepository<Infographic, Long> {

	
}
