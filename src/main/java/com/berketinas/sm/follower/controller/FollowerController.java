package com.berketinas.sm.follower.controller;

import com.berketinas.sm.follower.dto.IFollowDTO;
import com.berketinas.sm.follower.repo.FollowerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class FollowerController {
    private final FollowerRepository repo;

    FollowerController(FollowerRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/following")
    public List<IFollowDTO> getFollowing(@RequestHeader UUID id) {
        return repo.findFollowing(id);
    }

    @GetMapping("/follower")
    public List<IFollowDTO> getFollower(@RequestHeader UUID id) {
        return repo.findFollowers(id);
    }
}
