package com.blueaxis.blueaxisapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blueaxis.blueaxisapi.dto.BlogSummaryDto;
import com.blueaxis.blueaxisapi.models.Blog;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Long>{

	  @Query("SELECT new com.blueaxis.blueaxisapi.dto.BlogSummaryDto(b.id, b.title, b.category, b.imageUrl) FROM Blog b ORDER BY b.id DESC")
	    List<BlogSummaryDto> findAllBlogSummaries();
}
