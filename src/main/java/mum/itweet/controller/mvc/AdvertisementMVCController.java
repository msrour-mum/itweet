package mum.itweet.controller.mvc;

import mum.itweet.model.Advertisement;
import mum.itweet.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value="/ads")
public class AdvertisementMVCController {
    @Autowired
    AdvertisementService advertisementService;

    @GetMapping("/")
    public String getAdsData(Model model){
        Advertisement ad1 = new Advertisement("job",true,"All",20,50);
        Advertisement ad2 = new Advertisement("job",true,"All",30,40);
        Advertisement ad3 = new Advertisement("job",true,"All",19,29);
        Advertisement ad4 = new Advertisement("job",true,"Male",40,45);
        Advertisement ad5 = new Advertisement("job",true,"All",22,27);
        Advertisement ad6 = new Advertisement("job",true,"Female",24,35);

        List<Advertisement> ads = Arrays.asList(ad1,ad2,ad3,ad4,ad5,ad6);
       // List<Advertisement> ads = advertisementService.getAllAdvertisements();
        model.addAttribute("ads",ads);
        return "adsPage";
    }

    @GetMapping("/edit")
    public String editAds(){

        return "editAd";
    }
}
