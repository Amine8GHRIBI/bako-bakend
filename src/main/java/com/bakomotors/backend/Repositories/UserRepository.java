package com.bakomotors.backend.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bakomotors.backend.Model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUserName(String name);

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
    User findUserByEmail(String email);

    User findUserById(Long id);



}
