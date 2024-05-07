package com.microservice.post.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserUaehDTO {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String educationalProgram;
    private String currentSemester;
}
