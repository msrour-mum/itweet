package mum.itweet.controller;

import mum.itweet.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/ads")
public class AdsPage {
    @Autowired
    AdvertisementService advertisementService;

    @GetMapping()
    public String getAdsData(Model model){
        model.addAttribute("advertisements",advertisementService.getAllAdvertisements());
        return "adsPage";
    }

    @GetMapping("/edit")
    public String editAds(){

        return "editAds";
    }
}
