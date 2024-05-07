package com.microservice.post.service;

import com.microservice.post.http.response.UserByPostResponse;
import com.microservice.post.model.Post;

import java.util.List;
import java.util.Map;

public interface PostService {

    List<Post> findByIdUserUaeh(Long idUserUaeh);

    void save(Post post);

    List<Post> findAll();

    Post findById(Long id);

    /**
     * Implementacion del metodo que va a llamar a nuestro
     * microservicio de Publicaciones con una respuesta personalizada
     */
    UserByPostResponse findInfoUserByPostId(Long idPost);

    // todo
    List<Map<String, Object>> findAllPosts();
}
