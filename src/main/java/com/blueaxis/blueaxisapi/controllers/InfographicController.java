package com.blueaxis.blueaxisapi.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blueaxis.blueaxisapi.models.Blog;
import com.blueaxis.blueaxisapi.models.Infographic;
import com.blueaxis.blueaxisapi.repository.InfographicRepo;
import com.blueaxis.blueaxisapi.services.InfographicService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class InfographicController {

	 @Autowired
	    private InfographicService infoservice;
	    
	    @Autowired
	    private InfographicRepo inforepo;


	    @PostMapping("/addinfo")
	    public Object addInfo(@RequestBody Infographic infographic){

	        infoservice.saveinfo(infographic);

	        return Map.of("message","Infographic created successfully");
	    }
	    
	    
	    @GetMapping("/getinfo")
	    public List<Infographic> getInfo(){

	    return inforepo.findAll();

	    }
	    
	    @GetMapping("/info")
	    public Page<Infographic> getinfo(
	            @RequestParam int page,
	            @RequestParam int size) {
	        return inforepo.findAll(PageRequest.of(page - 1, size));
	    }
}
