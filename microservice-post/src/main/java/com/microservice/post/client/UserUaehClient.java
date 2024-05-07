package com.microservice.post.client;

import com.microservice.post.dto.UserUaehDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-userUaeh", url = "localhost:9090/api/userUaeh/")
public interface UserUaehClient {

    @GetMapping(path = "getAll-userinfo-by-post/{idPost}")
    List<UserUaehDTO> findAllInfoUserByPost(@PathVariable Long idPost);
}
