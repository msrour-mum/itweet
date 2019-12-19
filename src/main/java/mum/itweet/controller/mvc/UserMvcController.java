package mum.itweet.controller.mvc;

import mum.itweet.components.storage.IStorageService;
import mum.itweet.model.User;
import mum.itweet.service.UserService;
import mum.itweet.utitlity.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class UserMvcController {

    @Autowired
    UserService userService;

    @Autowired
    private IStorageService storageService;

    @GetMapping("/edit-profile")
    public String get(Model model) {

       User user = userService.get(Context.getUserId());
       model.addAttribute("user", user);
        return "edit-profile";
    }

    @PostMapping("/edit-profile")
    public String update(@Valid User user,  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit-profile";
        }

        User userToUpdate = userService.get(Context.getUserId());
        userToUpdate.setName(user.getName());
        userToUpdate.setMobile(user.getMobile());
        userToUpdate.setGender(user.getGender());
        userToUpdate.setBio(user.getBio());
        userService.update(userToUpdate);
        return "redirect:/";
    }

    @PostMapping("/edit-user-image")
    public String update(User userObj) throws IOException {

        User user = userService.get(Context.getUserId());

        if (!userObj.getImage().isEmpty()) {
            String path = storageService.uploadMultipartFile(userObj.getImage(), Context.getUserIdAsString());
            user.setPhotoUrl(path);
            userService.update(user);
        }
        return "redirect:/";
    }

    @PostMapping("/edit-cover-image")
    public String updateCover(User userObj) throws IOException {

        User user = userService.get(Context.getUserId());
        if (!userObj.getCover().isEmpty()) {
            String path = storageService.uploadMultipartFile(userObj.getCover(), Context.getUserIdAsString());
            user.setCoverUrl(path);
            userService.update(user);
        }
        return "redirect:/";
    }
}

