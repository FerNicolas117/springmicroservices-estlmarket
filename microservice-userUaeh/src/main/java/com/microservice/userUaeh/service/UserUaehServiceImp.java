package com.microservice.userUaeh.service;

import com.microservice.userUaeh.client.PostClient;
import com.microservice.userUaeh.dto.PostDTO;
import com.microservice.userUaeh.http.response.PostByUserResponse;
import com.microservice.userUaeh.model.UserUaeh;
import com.microservice.userUaeh.repository.UserUaehRepository;
import org.apache.catalina.core.ContextNamingInfoListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class UserUaehServiceImp implements UserUaehService {

    @Autowired
    private UserUaehRepository userUaehRepository;

    // Conexion del Cliente de Post para tener el Repository de UserUaeh
    @Autowired
    private PostClient postClient;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserUaeh> findAll() {
        return (List<UserUaeh>) userUaehRepository.findAll();
    }

    @Override
    public UserUaeh registerUser(UserUaeh userUaeh) {
        if (userUaehRepository.findByEmail(userUaeh.getEmail()) != null) {
            throw new RuntimeException("El usuario con el correo " + userUaeh.getEmail() + "" +
                    " ya ha sido registrado");
        }

        if (userUaeh.getLastName() == null || userUaeh.getEducationalProgram().isEmpty()
                || userUaeh.getEducationalProgram() == null) {
            throw new RuntimeException("El campo de EdcationalPorgram no puede estar" +
                    " vacio o no puede ser Null");
        }

        userUaeh.setPassword(bCryptPasswordEncoder.encode(userUaeh.getPassword())); // Encriptacion
        System.out.println("=== Usuario uaeh registrado ===");
        return userUaehRepository.save(userUaeh);
    }

    @Override
    public UserUaeh getUserUaehById(Long id) {
        return userUaehRepository.findById(id).orElse(null);
    }


    // ---------------------------------------------------------------------------------------
    @Override
    public PostByUserResponse findPostByIdUser(Long idUser) {

        // Consulta del Usuario
        System.out.println("Consulta de UserUaeh");
        UserUaeh userUaeh = userUaehRepository.findById(idUser).orElse(new UserUaeh());

        // Obtencion de las Publicaciones por cada Usuario
        System.out.println("=== Antes de obtener la List<> ===");
        List<PostDTO> postDTOList = postClient.findAllPostByUser(idUser);

        return PostByUserResponse.builder()
                .nameUser(userUaeh.getName())
                .lastNameUser(userUaeh.getLastName())
                .emailUser(userUaeh.getEmail())
                .educationalProgramUser(userUaeh.getEducationalProgram())
                .currentSemesterUser(userUaeh.getCurrentSemester())
                .postDTOList(postDTOList)
                .build();
    }

    @Override
    public List<UserUaeh> findByIdPost(Long idPost) {
        // findAllById no existen sebreescrito en UserUaehRepository
        return (List<UserUaeh>) userUaehRepository.findAllById(Collections.singleton(idPost));
    }
}
