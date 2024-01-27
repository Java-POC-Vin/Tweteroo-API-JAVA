package com.tweteroo.api.dtos;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {

    @NotBlank(message = "Username cannot be empty")
    @Size(max = 100, message = "Username max length is 100 characters")
    private String username;

    @NotBlank(message = "Avatar cannot be empty")
    @URL(message = "Avatar needs to be a valid URL")
    private String avatar;
}
