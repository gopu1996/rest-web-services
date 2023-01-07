package com.rest.webservices.restwebservices.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.webservices.restwebservices.user.PostEntity;




public interface PostsRepository extends JpaRepository<PostEntity, Integer> {



}
