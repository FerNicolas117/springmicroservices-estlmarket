package com.microservice.userUaeh.client;

import com.microservice.userUaeh.dto.PostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// Nombre del microservicio el cual se va a consultar
@FeignClient(name = "msvc-post", url = "localhost:8090/api/post")
public interface PostClient {

    @GetMapping(path = "/search-by-user/{idUser}")
    List<PostDTO> findAllPostByUser(@PathVariable Long idUser);
}
