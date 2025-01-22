package com.example.flashcard.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class UserDTO {
    @JsonProperty("username")
    @NotBlank
    private String userName;

    private String address;
    private String email;
    private String firstName;
    private LocalDate dateCreated;
    @NotBlank(message = "Cannot empty")
    private String password;

}
