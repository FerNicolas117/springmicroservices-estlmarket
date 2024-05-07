package com.microservice.post.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "post_uaeh")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDateTime currentDate;

    private String title;
    private String description;
    private String urlImage;

    @Column(name = "user_uaeh_id")
    private Long userUaehId; // Es el ID del usuario que publico el Post

    @PrePersist
    public void prePersist() {
        currentDate = LocalDateTime.now();
    }
}
