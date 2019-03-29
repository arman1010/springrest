package com.example.springrest.rest;

import com.example.springrest.model.Post;
import com.example.springrest.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
public class PostEndpoint {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts")
    public ResponseEntity getAllPosts() {
        return ResponseEntity.ok(postRepository.findAll());
    }

    @PostMapping("/post/add")

    public ResponseEntity addPost(@RequestBody Post post) {
        postRepository.save(post);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity postById(@PathVariable("id") int id) {
        Optional<Post> byId = postRepository.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok(byId.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePostById(@PathVariable("id") int id) {
        Optional<Post> byId = postRepository.findById(id);
        if (byId.isPresent()) {
            postRepository.deleteById(id);
            ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
