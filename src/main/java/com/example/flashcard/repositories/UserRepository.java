package com.example.flashcard.repositories;

import com.example.flashcard.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUserName (String userName);
    //Optional kiểm tra xem có null hay k
    Optional<User> findByUserName (String userName);
}
