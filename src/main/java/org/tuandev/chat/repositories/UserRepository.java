package org.tuandev.chat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tuandev.chat.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
