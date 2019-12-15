package mum.itweet.repository;


import mum.itweet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> findAllByEmail(String email);

}