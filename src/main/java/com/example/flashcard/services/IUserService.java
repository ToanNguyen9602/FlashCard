package com.example.flashcard.services;

import com.example.flashcard.dtos.UserDTO;
import com.example.flashcard.models.User;

public interface IUserService {
    User createUser(UserDTO userDTO) throws Exception;
    String login(String userName, String password) throws Exception;
}
