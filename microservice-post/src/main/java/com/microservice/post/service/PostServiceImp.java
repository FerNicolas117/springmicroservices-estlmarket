package com.microservice.post.service;

import com.microservice.post.client.UserUaehClient;
import com.microservice.post.dto.UserUaehDTO;
import com.microservice.post.http.response.UserByPostResponse;
import com.microservice.post.model.Post;
import com.microservice.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PostServiceImp implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserUaehClient userUaehClient;

    @Override
    public List<Post> findByIdUserUaeh(Long idUserUaeh) {
        System.out.println("=== Obtencion de datos desde PostServiceImplementatios ===");
        return postRepository.findAllPostByUserUaehId(idUserUaeh);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
        System.out.println(post.toString());
    }

    @Override
    public List<Post> findAll() {
        return (List<Post>) postRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElseThrow();
    }

    // ---
    @Override
    public UserByPostResponse findInfoUserByPostId(Long idPost) {

        // Consulta de la publicacion
        Post post = postRepository.findById(idPost).orElse(new Post());

        // Obtencion de la info del Usuario por cada Publicacion
        List<UserUaehDTO> userUaehDTOList = userUaehClient.findAllInfoUserByPost(idPost);
        return UserByPostResponse.builder()
                .title(post.getTitle())
                .description(post.getDescription())
                //.currentDate(post.getCurrentDate())
                .urlImage(post.getUrlImage())
                .userUaehId(post.getUserUaehId())
                .userUaehDTOList(userUaehDTOList)
                .build();
    }

    @Override
    public List<Map<String, Object>> findAllPosts() {
        return (List<Map<String, Object>>) postRepository.finAllPosts();
    }
}
