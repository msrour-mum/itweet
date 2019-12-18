package mum.itweet.repository;

import mum.itweet.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement,Long> {
    @Query("select a from Advertisement a where a.active = true ")
    public List<Advertisement>getActiveAdvertisements();
}
