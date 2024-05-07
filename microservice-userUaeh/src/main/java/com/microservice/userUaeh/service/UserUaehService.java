package com.microservice.userUaeh.service;

import com.microservice.userUaeh.http.response.PostByUserResponse;
import com.microservice.userUaeh.model.UserUaeh;

import java.util.List;

public interface UserUaehService {

    List<UserUaeh> findAll();

    UserUaeh registerUser(UserUaeh userUaeh);

    UserUaeh getUserUaehById(Long id);

    List<UserUaeh> findByIdPost(Long idPost);

    //-----------------------------------------------------------
    /**
     * Implementacion del metodo que va a llamar a nuestro
     * microservicio de Publicaciones con una respuesta personalizada
     */
    PostByUserResponse findPostByIdUser(Long idUser);
}
