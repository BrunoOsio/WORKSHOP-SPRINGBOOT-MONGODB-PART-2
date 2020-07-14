package com.devcran.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.devcran.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
