package com.microservice.post.controller;

import com.microservice.post.client.UserUaehClient;
import com.microservice.post.dto.UserUaehDTO;
import com.microservice.post.model.Post;
import com.microservice.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePost(@RequestBody Post post) {
        postService.save(post);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<?> findAllPost() {
        return ResponseEntity.ok(postService.findAll());
    }

    // todo
    @GetMapping(path = "/allposts")
    public ResponseEntity<?> findAllPostWithInfoUser() {
        return ResponseEntity.ok(postService.findAllPosts());
    }

    @GetMapping(path = "/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    // -------------------------------------------------------------------
    /**
     * Habilitacion de un Endpoint el cual pueda ser consumido desde nuestro
     * microservicio de Usuarios -> userUaeh
     */
    @GetMapping(path = "/search-by-user/{idUser}")
    public ResponseEntity<?> findByIdUser(@PathVariable Long idUser) {
        System.out.println("=== Obtencion de datos desde PostServiceImplementatios <= PostController ===");
        return ResponseEntity.ok(postService.findByIdUserUaeh(idUser));
    }

    /**
     * Endpoint para brindar la respuesta de http/response al
     * servcio de usuarios
     */
    @GetMapping(path = "/getall-info-by-post/{idPost}")
    public ResponseEntity<?> findInfoUserByPostId(@PathVariable Long idPost) {
        return ResponseEntity.ok(postService.findInfoUserByPostId(idPost));
    }
}
