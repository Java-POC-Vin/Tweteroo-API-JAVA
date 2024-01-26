package com.tweteroo.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/tweets")
public class TweetController {
    @GetMapping
    public String getTweets() {
        return "To be implemented";
    }

    @GetMapping("/user/{userId}")
    public String getUserTweets(@PathVariable("userId") int userId) {
        return "To be implemented";
    }

    @PostMapping
    public String postTweet(@RequestBody String body) {
        return "To be implemented";
    }

}
