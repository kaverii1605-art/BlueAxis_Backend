package com.blueaxis.blueaxisapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blueaxis.blueaxisapi.dto.ArticleSummaryDto;
import com.blueaxis.blueaxisapi.models.Articles;

@Repository
public interface ArticleRepo extends JpaRepository<Articles, Long> {

	
	  @Query("SELECT new com.blueaxis.blueaxisapi.dto.ArticleSummaryDto(a.id, a.title, a.category, a.imageUrl) FROM Article a ORDER BY a.id DESC")
	    List<ArticleSummaryDto> findAllArticleSummaries();
}
