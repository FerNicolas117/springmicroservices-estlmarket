package com.microservice.userUaeh.repository;

import com.microservice.userUaeh.model.UserUaeh;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.Set;

@Repository
public interface UserUaehRepository extends CrudRepository<UserUaeh, Long> {

    Optional<UserUaeh> findByName(String name);

    UserUaeh findByEmail(String email);
}
