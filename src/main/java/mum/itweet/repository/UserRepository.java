package mum.itweet.repository;


import mum.itweet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> findAllByEmail(String email);
    public Optional<User> findByEmail(String email);

    @Query(value = "Select u.* from following f inner join user u on u.id=f.follower_id where f.following_id=:userId", nativeQuery = true)
    public List<User> ListFollower(@Param("userId") int userId);

    @Query(value = "Select u.* from following f inner join user u on u.id=f.following_id where f.follower_id=:userId", nativeQuery = true)
    public List<User> ListFollowing(@Param("userId")  int userId);

    @Query(value = "Select count (u.*) from following f inner join user u on u.id=f.follower_id where f.following_id=:userId", nativeQuery = true)
    public int getCountFollower(@Param("userId")  int userId);

    @Query(value = "Select count (u.*)  from following f inner join user u on u.id=f.following_id where f.follower_id=:userId", nativeQuery = true)
    public int getCountFollowing(@Param("userId")  int userId);


}
