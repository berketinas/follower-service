package com.berketinas.sm.follower.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="followers")
public class Follower {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    private UUID follower;
    private UUID following;

    public Follower() {}

    public Follower(UUID follower, UUID following) {
        this.follower = follower;
        this.following = following;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getFollower() {
        return follower;
    }

    public void setFollower(UUID follower) {
        this.follower = follower;
    }

    public UUID getFollowing() {
        return following;
    }

    public void setFollowing(UUID following) {
        this.following = following;
    }
}
