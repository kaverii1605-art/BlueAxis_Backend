package com.blueaxis.blueaxisapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blueaxis.blueaxisapi.models.Blog;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Long>{

}
