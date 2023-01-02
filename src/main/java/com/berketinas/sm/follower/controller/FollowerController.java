package com.berketinas.sm.follower.controller;

import com.berketinas.sm.follower.dto.IFollowDTO;
import com.berketinas.sm.follower.service.FollowerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class FollowerController {
    private final FollowerService service;

    FollowerController(FollowerService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String test() {
        return "hello";
    }

    @GetMapping("/following")
    public List<IFollowDTO> getFollowing(@RequestHeader UUID user_id) {
        return service.getFollowing(user_id);
    }

    @GetMapping("/follower")
    public List<IFollowDTO> getFollower(@RequestHeader UUID user_id) {
        return service.getFollower(user_id);
    }

    @PostMapping("/following")
    public void follow(@RequestHeader UUID user_id, @RequestParam("id") UUID id) {
        service.follow(user_id, id);
    }

    @DeleteMapping("/follower")
    public void removeFollower(@RequestHeader UUID user_id, @RequestParam("id") UUID id) {
        service.removeFollower(user_id, id);
    }

    @DeleteMapping("/following")
    public void unfollow(@RequestHeader UUID user_id, @RequestParam("id") UUID id) {
        service.unfollow(user_id, id);
    }
}
