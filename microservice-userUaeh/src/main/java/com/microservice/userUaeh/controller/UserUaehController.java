package com.microservice.userUaeh.controller;

import com.microservice.userUaeh.model.UserUaeh;
import com.microservice.userUaeh.service.UserUaehService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/userUaeh")
public class UserUaehController {

    @Autowired
    private UserUaehService userUaehService;

    @PostMapping(path = "/create")
    public ResponseEntity<UserUaeh> registerUserUaeh(@RequestBody UserUaeh userUaeh) {
        UserUaeh userUaehRegistered = userUaehService.registerUser(userUaeh);
        return ResponseEntity.status(HttpStatus.CREATED).body(userUaehRegistered);
    }

    @GetMapping(path = "/getAllUsersUaeh")
    public ResponseEntity<?> getAllUsersUaeh() {
        return ResponseEntity.ok(userUaehService.findAll());
    }

    /**
     * Endpoint para brindar la respuesta de http/response
     */
    @GetMapping(path = "/search-user/{idUser}")
    public ResponseEntity<?> findPostByIdUser(@PathVariable Long idUser) {
        return ResponseEntity.ok(userUaehService.findPostByIdUser(idUser));
    }

    // -------------------------------------------------------------------
    /**
     * Habilitacion de un Endpoint el cual va a recibir la peticion de
     * nuestro servicio de Publicaciones -> Post
     */
    @GetMapping(path = "getAll-userinfo-by-post/{idPost}")
    public ResponseEntity<?> findByIdPost(@PathVariable Long idPost) {
        return ResponseEntity.ok(userUaehService.findByIdPost(idPost));
    }
}
