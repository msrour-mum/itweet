package mum.itweet.controller.mvc;

import mum.itweet.service.FollowingService;
import mum.itweet.service.PostService;
import mum.itweet.service.UserService;
import mum.itweet.utitlity.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeMvcController {

    @Autowired
    UserService userService;
    @Autowired
    PostService postService;

    @Autowired
    FollowingService followingService;



    @GetMapping("/")
    public String home(Model model)
    {
        model.addAttribute("user",userService.get(Context.getUserId()));
        model.addAttribute("posts",postService.listPostForUser(Context.getUserId()));
        model.addAttribute("CountFollower",followingService.getCountFollower(Context.getUserId()));
        model.addAttribute("CountFollowing",followingService.getCountFollowing(Context.getUserId()));
        return "home";
    }

}
