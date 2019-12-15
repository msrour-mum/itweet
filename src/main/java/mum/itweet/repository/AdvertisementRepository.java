package mum.itweet.repository;

import mum.itweet.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository<Advertisement,Long> {
}
