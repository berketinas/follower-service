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
    public List<IFollowDTO> getFollowing(@RequestHeader UUID user_id) {
        return repo.findFollowing(user_id);
    }

    @GetMapping("/follower")
    public List<IFollowDTO> getFollower(@RequestHeader UUID user_id) {
        return repo.findFollowers(user_id);
    }

    @PostMapping("/following")
    public void follow(@RequestHeader UUID user_id, @RequestParam("id") UUID id) {
        repo.save(new Follower(user_id, id));
    }

    @DeleteMapping("/follower")
    public void removeFollow(@RequestHeader UUID user_id, @RequestParam("id") UUID id) {
        repo.deleteFollower(user_id, id);
    }

    @DeleteMapping("/following")
    public void unfollow(@RequestHeader UUID user_id, @RequestParam("id") UUID id) {
        repo.unfollow(user_id, id);
    }
}
