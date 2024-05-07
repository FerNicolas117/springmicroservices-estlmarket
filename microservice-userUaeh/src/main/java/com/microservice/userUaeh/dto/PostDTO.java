package com.microservice.userUaeh.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private Date currentDate;
    private String title;
    private String description;
    private String urlImage;
    private Long userUaehId;
}
