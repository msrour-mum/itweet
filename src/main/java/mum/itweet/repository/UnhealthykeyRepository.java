package mum.itweet.repository;

import mum.itweet.model.Post;
import mum.itweet.model.UnhealthyKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnhealthykeyRepository extends JpaRepository<UnhealthyKey, Integer> {

    public List<UnhealthyKey> findByWordKeyIgnoreCase(String word);

}
