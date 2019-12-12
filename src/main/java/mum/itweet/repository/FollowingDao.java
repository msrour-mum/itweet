package mum.itweet.repository;

import mum.itweet.model.Following;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowingDao extends JpaRepository<Following,Long> {
}
