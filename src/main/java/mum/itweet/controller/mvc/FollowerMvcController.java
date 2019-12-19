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
public class FollowerMvcController {

    @Autowired
    UserService userService;
    @Autowired
    PostService postService;
    @Autowired
    FollowingService followingService;

    @GetMapping("/follower")
    public String home(Model model) {
        int userId = Context.getUserId();
        model.addAttribute("user", userService.get(userId));
        model.addAttribute("followers", followingService.listFollower(userId));
        model.addAttribute("CountFollower", followingService.getCountFollower(userId));
        model.addAttribute("CountFollowing", followingService.getCountFollowing(userId));
        model.addAttribute("PeopleYouMayKnow", userService.PeopleYouMayKnow(userId,5));
        return "follower";
    }
}
