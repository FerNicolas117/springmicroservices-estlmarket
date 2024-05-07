package com.microservice.userUaeh.http.response;

import com.microservice.userUaeh.dto.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostByUserResponse {

    private String nameUser;
    private String lastNameUser;
    private String emailUser;
    private String educationalProgramUser;
    private String currentSemesterUser;
    private List<PostDTO> postDTOList;
}
