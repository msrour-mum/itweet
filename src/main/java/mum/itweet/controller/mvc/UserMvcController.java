package mum.itweet.controller.mvc;

import mum.itweet.model.User;
import mum.itweet.service.UserService;
import mum.itweet.utitlity.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserMvcController {
    @Autowired
    UserService userService;

    @GetMapping("/edit-profile")
    public String get(Model model ) {

       User user = userService.get(Context.getUserId());
       model.addAttribute("user", user);
        return "edit-profile";
    }

    @PostMapping("/edit-profile")
    public String update(User user, BindingResult bindingResult) {
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
}

