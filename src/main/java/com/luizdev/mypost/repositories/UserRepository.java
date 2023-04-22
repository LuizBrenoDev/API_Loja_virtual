package com.luizdev.mypost.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.luizdev.mypost.domain.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User,String>{
    
}
