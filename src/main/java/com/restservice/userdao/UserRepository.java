package com.restservice.userdao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restservice.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>  {

}
