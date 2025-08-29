package com.maykon.spring_segurity_jwt.repository;

import java.util.Optional;

import com.maykon.spring_segurity_jwt.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findByUsername(String username);
}
