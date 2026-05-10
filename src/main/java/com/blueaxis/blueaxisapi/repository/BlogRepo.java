package com.blueaxis.blueaxisapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blueaxis.blueaxisapi.models.Blog;

@Repository
public interface BlogRepo extends MongoRepository<Blog, String> {
}