package com.blueaxis.blueaxisapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blueaxis.blueaxisapi.models.Infographic;

@Repository
public interface InfographicRepo extends JpaRepository<Infographic, Long> {

	
}
