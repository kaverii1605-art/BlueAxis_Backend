package com.blueaxis.blueaxisapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blueaxis.blueaxisapi.models.Articles;

@Repository
public interface ArticleRepo extends JpaRepository<Articles, Long> {

}
