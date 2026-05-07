package com.blueaxis.blueaxisapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blueaxis.blueaxisapi.models.Contacts;

public interface ContactRepo extends MongoRepository<Contacts, String> {

}
