package com.blueaxis.blueaxisapi.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.blueaxis.blueaxisapi.dto.BlogSummaryDto;
import com.blueaxis.blueaxisapi.models.Blog;

@Repository
public interface BlogRepo extends MongoRepository<Blog, String>{

    @Query("{ 'title' : { $regex: ?0, $options: 'i' } }")
	    List<BlogSummaryDto> findAllBlogSummaries();
}
