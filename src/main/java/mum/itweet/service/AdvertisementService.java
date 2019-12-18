package mum.itweet.service;

import mum.itweet.model.Advertisement;

import javax.xml.crypto.Data;
import java.util.List;

public interface AdvertisementService {

    public Advertisement create(Advertisement advertisement);
    public Advertisement update(Advertisement advertisement);
    public void deleteAdvertisement(long id);
    public Advertisement getAdvertisementById(long id);
    public List<Advertisement> getAllAdvertisements();
    public Advertisement getRandomActiveAdvertisement();

}
