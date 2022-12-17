package com.berketinas.sm.follower.controller;

import com.berketinas.sm.follower.domain.Follower;
import com.berketinas.sm.follower.dto.IFollowDTO;
import com.berketinas.sm.follower.repo.FollowerRepository;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/")
    public void addFollowing(@RequestHeader UUID follower_id, @RequestParam("id") UUID id) {
        repo.save(new Follower(follower_id, id));
    }
}
