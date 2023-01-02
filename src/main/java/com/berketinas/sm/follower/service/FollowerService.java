package com.berketinas.sm.follower.service;

import com.berketinas.sm.follower.domain.Follower;
import com.berketinas.sm.follower.dto.IFollowDTO;
import com.berketinas.sm.follower.repo.FollowerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FollowerService {
    private final FollowerRepository repo;

    FollowerService(FollowerRepository repo) {
        this.repo = repo;
    }

    public List<IFollowDTO> getFollowing(UUID user_id) {
        return repo.findFollowing(user_id);
    }

    public List<IFollowDTO> getFollower(UUID user_id) {
        return repo.findFollowers(user_id);
    }

    public void follow(UUID user_id, UUID id) {
        repo.save(new Follower(user_id, id));
    }

    public void removeFollower(UUID user_id, UUID id) {
        repo.removeFollower(user_id, id);
    }

    public void unfollow(UUID user_id, UUID id) {
        repo.unfollow(user_id, id);
    }
}
