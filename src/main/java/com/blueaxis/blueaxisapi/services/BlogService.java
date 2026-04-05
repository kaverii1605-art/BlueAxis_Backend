package com.blueaxis.blueaxisapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueaxis.blueaxisapi.models.Blog;
import com.blueaxis.blueaxisapi.repository.BlogRepo;

@Service
public class BlogService {

	 @Autowired
	    private BlogRepo blogRepository;

	    public Blog saveBlog(Blog blog){
	        return blogRepository.save(blog);
	    }
}
