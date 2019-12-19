package mum.itweet.repository;

import mum.itweet.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement,Long> {
    @Query("select a from Advertisement a where a.active = true ")
    public List<Advertisement>getActiveAdvertisements();

    @Query("select a from Advertisement a where a.ageFrom >= :ageFrom and a.ageTo <= :ageTo")
    public List<Advertisement> getAdsByAge(@Param("ageFrom") Integer ageFrom,@Param("ageTo") Integer ageTo);

    public List<Advertisement>findAllByGender(String gender);

    @Query("select a from Advertisement a where a.ageFrom <= :userAge and a.ageTo >=:userAge and a.active = true and a.gender =:gender")
    public List<Advertisement> getAdvertisementForUser(@Param("userAge") int userAge,
                                                                         @Param("gender") String userGender);

}
