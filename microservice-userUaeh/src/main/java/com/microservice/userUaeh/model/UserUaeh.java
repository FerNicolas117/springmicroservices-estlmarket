package com.microservice.userUaeh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "user_uaeh")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserUaeh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    private String email;

    private String educationalProgram;

    private String currentSemester;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}
