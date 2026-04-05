package com.blueaxis.blueaxisapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueaxis.blueaxisapi.models.Articles;
import com.blueaxis.blueaxisapi.repository.ArticleRepo;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepo articlerepo;

	public Articles savearticle(Articles article) {
		
		return articlerepo.save(article);
	}
}
