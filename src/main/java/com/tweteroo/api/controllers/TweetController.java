package com.tweteroo.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.services.TweetService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/tweets")
public class TweetController {
    private final TweetService tweetService;

    TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping
    public List<TweetModel> findAll() {
        return tweetService.findAll();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Object> getUserTweets(@PathVariable("userId") Long userId) {
        Optional<List<TweetModel>> tweets = tweetService.findAllUserTweets(userId);

        if (tweets.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exist");
        }

        return ResponseEntity.status(HttpStatus.OK).body(tweets.get());
    }

    @PostMapping
    public ResponseEntity<Object> postTweet(@RequestBody @Valid TweetDTO body) {

        Optional<TweetModel> tweet = tweetService.save(body);

        if (!tweet.isPresent()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("User does not exist");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(tweet);
    }

}
