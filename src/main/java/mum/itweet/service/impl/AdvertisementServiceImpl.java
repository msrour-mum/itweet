package mum.itweet.service.impl;

import mum.itweet.model.Advertisement;
import mum.itweet.repository.AdvertisementRepository;
import mum.itweet.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdvertisementServiceImpl implements AdvertisementService {
    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Override
    public Advertisement create(Advertisement advertisement) {
        return advertisementRepository.save(advertisement);
    }

    @Override
    public Advertisement update(Advertisement advertisement) {
        return advertisementRepository.save(advertisement);
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

}
