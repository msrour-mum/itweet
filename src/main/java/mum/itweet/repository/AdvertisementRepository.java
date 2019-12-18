package mum.itweet.repository;

import mum.itweet.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement,Long> {
    List<Advertisement> findAdvertisementsByCreationDateAndActive(Date creationDate,Boolean active);
}
