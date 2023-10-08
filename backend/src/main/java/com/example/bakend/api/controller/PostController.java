package com.example.bakend.api.controller;

import com.example.bakend.api.service.PostService;
import com.example.bakend.model.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
}
