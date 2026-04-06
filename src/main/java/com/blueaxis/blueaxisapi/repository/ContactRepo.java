package com.blueaxis.blueaxisapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blueaxis.blueaxisapi.models.Contacts;

public interface ContactRepo extends JpaRepository<Contacts, Long> {

}
