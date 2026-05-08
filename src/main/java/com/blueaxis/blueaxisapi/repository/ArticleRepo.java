package com.blueaxis.blueaxisapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blueaxis.blueaxisapi.models.Articles;

@Repository
public interface ArticleRepo extends MongoRepository<Articles, String> {

}
