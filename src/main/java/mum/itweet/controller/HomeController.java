package mum.itweet.controller;

import mum.itweet.service.FollowingService;
import mum.itweet.service.PostService;
import mum.itweet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/home")
public class HomeController {

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @Autowired
    FollowingService followingService;

    @GetMapping()
    public String getHomeData(Model model)
    {
        int userId=1;
        model.addAttribute("posts",postService.getAll());
        model.addAttribute("follower",followingService.listFollower(userId));
        model.addAttribute("following",followingService.listFollowing(userId));
        return "home";
    }
}
