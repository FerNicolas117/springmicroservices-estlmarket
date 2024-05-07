package com.microservice.post.http.response;

import com.microservice.post.dto.UserUaehDTO;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserByPostResponse {

    private Date currentDate;
    private String title;
    private String description;
    private String urlImage;
    private Long userUaehId;
    private List<UserUaehDTO> userUaehDTOList;
}
