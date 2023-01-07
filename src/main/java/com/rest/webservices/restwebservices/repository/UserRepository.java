package com.rest.webservices.restwebservices.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.rest.webservices.restwebservices.user.UserEntity;



public interface UserRepository extends JpaRepository<UserEntity, Integer> {



}
