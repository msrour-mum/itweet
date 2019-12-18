package mum.itweet.controller.mvc;

import mum.itweet.model.Advertisement;
import mum.itweet.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/ads")
public class AdvertisementMVCController {
    @Autowired
    AdvertisementService advertisementService;

    @GetMapping("/")
    public String getAdsData(Model model){

//        Advertisement ad1 = new Advertisement("job1","",new Date(),true,29,
//                50,"male",null);
//        advertisementService.create(ad1);
//
//        Advertisement ad2 = new Advertisement("job2","",new Date(),false,29,
//                50,"male",null);
//        advertisementService.create(ad2);
////
        Advertisement ad3 = new Advertisement("updated","",new Date(),true,29,
                50,"" +
                "all",null);
//        advertisementService.create(ad3);
//
//        Advertisement ad4 = new Advertisement("job4","",new Date(),false,29,
//                50,"male",null);
//        advertisementService.create(ad4);

       // List<Advertisement> ads = Arrays.asList(ad1,ad2,ad3,ad4);
        advertisementService.update(advertisementService.getAllAdvertisements().get(0).getId(),ad3);
        List<Advertisement> ads = advertisementService.getAllAdvertisements();
        //ads.add(advertisementService.getRandomActiveAdvertisement());

        model.addAttribute("ads",ads);
        return "adsPage";
    }

    @GetMapping("/edit")
    public String editAds(){

        return "editAd";
    }
}
