package mum.itweet.service.impl;

import mum.itweet.model.Advertisement;
import mum.itweet.repository.AdvertisementRepository;
import mum.itweet.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.crypto.Data;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class AdvertisementServiceImpl implements AdvertisementService {
    @Autowired
    private AdvertisementRepository advertisementRepository;

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


}
