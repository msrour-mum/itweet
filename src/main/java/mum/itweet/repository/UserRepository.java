package mum.itweet.repository;


import mum.itweet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> findAllByEmail(String email);
    public Optional<User> findByEmail(String email);

}
