package com.example.flashcard.services;

import com.example.flashcard.dtos.UserDTO;
import com.example.flashcard.models.User;
import com.example.flashcard.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
    @Override
    public User createUser(UserDTO userDTO) throws Exception {
        //register user
        String userName = userDTO.getUserName();
        //check xem username đã tồn tại chưa
        if (userRepository.existsByUserName(userName)) {
            throw new DataIntegrityViolationException("Username has already");
        }
        //convert userDTO sang User
        User newUser = User.builder()
                .userName(userDTO.getUserName())
                .password(userDTO.getPassword())
                .address(userDTO.getAddress())
                .email(userDTO.getEmail())
                .firstName(userDTO.getFirstName())
                .dateCreated(userDTO.getDateCreated())
                .build();
        return userRepository.save(newUser);
    }

    @Override
    public String login(String userName, String password) throws Exception {
        Optional<User> optionalUser = userRepository.findByUserName(userName);
        if (optionalUser.isEmpty()) {
            throw new Exception("Invalid username or password");
        }
        User existingUser = optionalUser.get();
        if (!password.equals(existingUser.getPassword())) {
            throw new BadCredentialsException("Wrong username or password");
        }
        return null;
    }
}
