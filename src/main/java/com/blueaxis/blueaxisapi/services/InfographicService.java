package com.blueaxis.blueaxisapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueaxis.blueaxisapi.models.Infographic;
import com.blueaxis.blueaxisapi.repository.InfographicRepo;


@Service
public class InfographicService {

	@Autowired
	private InfographicRepo inforepo;
	
	public Infographic saveinfo(Infographic infographic) {
		return inforepo.save(infographic);
	}
	
}
