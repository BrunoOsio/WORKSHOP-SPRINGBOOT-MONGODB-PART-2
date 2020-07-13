package com.devcran.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.devcran.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
