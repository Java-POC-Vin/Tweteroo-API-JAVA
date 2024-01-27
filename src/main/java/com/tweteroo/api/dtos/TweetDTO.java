package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TweetDTO {

    @NotBlank(message = "Tweet cannot be empty")
    @Size(max = 280)
    private String tweet;

    @NotNull(message = "Tweet must belong to an existing user")
    private Long userId;
}
