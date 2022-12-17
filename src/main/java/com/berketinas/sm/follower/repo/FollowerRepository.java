package com.berketinas.sm.follower.repo;

import com.berketinas.sm.follower.domain.Follower;
import com.berketinas.sm.follower.dto.IFollowDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface FollowerRepository extends JpaRepository<Follower, UUID> {
    @Query(value = "SELECT followers.following AS following, followers.follower AS follower, users.given_name AS given, users.family_name AS family " +
            "FROM followers, users " +
            "WHERE followers.follower = users.id AND followers.following = :id",
        nativeQuery = true)
    List<IFollowDTO> findFollowers(@Param("id") UUID id);

    @Query(value = "SELECT followers.following AS following, followers.follower AS follower, users.given_name AS given, users.family_name AS family " +
            "FROM followers, users " +
            "WHERE followers.following = users.id AND followers.follower = :id",
        nativeQuery = true)
    List<IFollowDTO> findFollowing(@Param("id") UUID id);
}
