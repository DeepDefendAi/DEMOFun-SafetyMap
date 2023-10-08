package com.example.bakend.api.repo;

import com.example.bakend.model.Post;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
