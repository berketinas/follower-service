package com.berketinas.sm.follower.repo;

import com.berketinas.sm.follower.domain.Follower;
import com.berketinas.sm.follower.dto.IFollowDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
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

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM followers " +
            "WHERE following = :following AND follower = :follower",
        nativeQuery = true)
    void deleteFollower(@Param("following") UUID following, @Param("follower") UUID follower);
}
