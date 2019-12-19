package mum.itweet.service.impl;

import mum.itweet.model.Advertisement;
import mum.itweet.model.User;
import mum.itweet.repository.AdvertisementRepository;

import mum.itweet.repository.UserRepository;
import mum.itweet.service.AdvertisementService;
import mum.itweet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class AdvertisementServiceImpl implements AdvertisementService {
    @Autowired
    private AdvertisementRepository advertisementRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository ;



    @Override
    public Advertisement create(Advertisement advertisement) {
        return advertisementRepository.saveAndFlush(advertisement);
    }

    @Override
    public Advertisement update(long adId,Advertisement advertisement) {
        Advertisement old = advertisementRepository.getOne(adId);

        old = advertisement ;
        advertisementRepository.deleteById(adId);
        //old.setId(adId);
        return advertisementRepository.save(old);
    }

    @Override
    public void deleteAdvertisement(long id) {
        advertisementRepository.deleteById(id);
    }

    @Override
    public Advertisement getAdvertisementById(long id) {
        return advertisementRepository.getOne(id);
    }

    @Override
    public List<Advertisement> getAllAdvertisements() {
        return advertisementRepository.findAll();
    }

    @Override
    public Advertisement getRandomActiveAdvertisement() {
       List<Advertisement> advertisements = advertisementRepository.getActiveAdvertisements();
        Random random = new Random();
        return advertisements.get(random.nextInt(advertisements.size()));
    }

    @Override
    public List<Advertisement> getAdsByAge(int ageFrom, int ageTo) {
        return advertisementRepository.getAdsByAge(ageFrom,ageTo);
    }

    @Override
    public List<Advertisement> getAdsByGender(String gender) {
        return advertisementRepository.findAllByGender(gender);
    }

    @Override
    public Advertisement getRandomAvilableAd(int userId) {
        System.out.println("entering ");
        String userGender = "";
        User user = userService.get(userId);
        int userAge = userService.calculateUserAge(userId)  ;
        //int userAge =40 ;
        System.out.println("userAge "+ userAge+ " userGender 111"+ userGender);
        if (user.getGender() == 1 ) {userGender = "female";}
       // else userGender = "male";
        System.out.println("userGender ="+user.getGender());
        System.out.println("userbirthDate = "+ user.getBirthDate());
        // userAge =40 ;
        // userGender = "male";
        System.out.println("userAge 222"+ userAge+ " userGender 222"+ userGender);
        //List<Advertisement> avilableAds = advertisementRepository.getAdvertisementForUser(userAge,userGender);
        List<Advertisement> avilableAds = advertisementRepository.findAllByGender(userGender);

        Random random = new Random();
        if(!avilableAds.isEmpty()) {
            return avilableAds.get(random.nextInt(avilableAds.size()));
        }
        return null ;
    }




}
