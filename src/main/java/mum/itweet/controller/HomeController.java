package mum.itweet.controller;

import mum.itweet.security.JPAUserDetails;
import mum.itweet.service.AdvertisementService;
import mum.itweet.service.FollowingService;
import mum.itweet.service.PostService;
import mum.itweet.service.UserService;
import mum.itweet.utitlity.ConstantKeys;
import mum.itweet.utitlity.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

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
    public String getHomeData(Model model, HttpServletRequest request)
    {
        model.addAttribute("posts",postService.getAll());
        //model.addAttribute("follower",followingService.listFollower(Context.getUserId()));
        //model.addAttribute("following",followingService.listFollowing(Context.getUserId()));
        return "home";
    }
}
