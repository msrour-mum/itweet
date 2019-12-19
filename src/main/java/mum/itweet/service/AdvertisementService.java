package mum.itweet.service;

import mum.itweet.model.Advertisement;

import javax.xml.crypto.Data;
import java.util.List;

public interface AdvertisementService {

    public Advertisement create(Advertisement advertisement);
    public Advertisement update(long adId,Advertisement advertisement);
    public void deleteAdvertisement(long id);
    public Advertisement getAdvertisementById(long id);
    public List<Advertisement> getAllAdvertisements();
    public Advertisement getRandomActiveAdvertisement();
    public List<Advertisement> getAdsByAge(int ageFrom,int ageTo);
    public List<Advertisement>getAdsByGender(String gender);

}
