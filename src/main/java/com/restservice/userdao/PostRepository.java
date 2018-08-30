package com.restservice.userdao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restservice.usercontroller.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
