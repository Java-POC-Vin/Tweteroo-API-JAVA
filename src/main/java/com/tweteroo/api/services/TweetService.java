package com.tweteroo.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.repositories.TweetRepository;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class TweetService {
    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;

    TweetService(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public List<TweetModel> findAll() {
        return tweetRepository.findAll();
    }

    public String findUserTweets() {
        return "To be implemented";
    }

    public Optional<TweetModel> save(TweetDTO body) {
        Optional<UserModel> user = userRepository.findById(body.getUserId());

        if (!user.isPresent()) {
            return Optional.empty();
        }

        TweetModel tweet = new TweetModel(body, user.get());

        return Optional.of(tweetRepository.save(tweet));
    }
}
