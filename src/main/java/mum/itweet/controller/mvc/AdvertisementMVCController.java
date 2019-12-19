package mum.itweet.controller.mvc;

import mum.itweet.components.storage.IStorageService;
import mum.itweet.components.storage.IStorageService;
import mum.itweet.components.storage.StorageService;
import mum.itweet.model.Advertisement;
import mum.itweet.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="admin/ads")
public class AdvertisementMVCController {
    @Autowired
    AdvertisementService advertisementService;

    private IStorageService storageService = new StorageService();


    @GetMapping("/")
    public String getAdsData(Model model){

        List<Advertisement> ads = advertisementService.getAllAdvertisements();
        model.addAttribute("ads",ads);
        return "allAds";
    }

    @GetMapping("/create")
    public String createAdd(@ModelAttribute("add") Advertisement add){
        return "adForm";
    }

    @PostMapping("/create")
    public String saveAdd(@ModelAttribute("add") Advertisement add){
        add.setCreationDate(new Date());
        if(!add.getImage().isEmpty()){
            try {
                String imageUrl = storageService.uploadMultipartFile(add.getImage(),"advertising");
                add.setImageUrl(imageUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //else add.setImageUrl("");
        advertisementService.create(add);
        return "redirect:/admin/ads/";
    }

    @GetMapping("/delete/{id}")
    public String deleteAd(@PathVariable String id , Model model ){
        System.out.println(id);
        advertisementService.deleteAdvertisement(Long.parseLong(id));

        return "redirect:/admin/ads/";

    }
}
