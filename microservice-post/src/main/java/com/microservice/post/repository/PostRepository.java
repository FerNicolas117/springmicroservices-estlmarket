package com.microservice.post.repository;

import com.microservice.post.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.userUaehId = :idUserUaeh")
    List<Post> findAllPostByUserUaehId(Long idUserUaeh);

    @Query(value = "SELECT p.id, p.title, p.description, p.date, p.url_image, p.user_uaeh_id, " +
            "u.name, u.last_name, u.email, u.educational_program, u.current_semester " +
            "FROM post_uaeh p JOIN user_uaeh u ON p.user_uaeh_id = u.id", nativeQuery = true)
    List<Map<String, Object>> finAllPosts();
}
