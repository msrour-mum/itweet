package mum.itweet.controller.mvc;

import mum.itweet.security.JPAUserDetails;
import mum.itweet.service.AdvertisementService;
import mum.itweet.service.FollowingService;
import mum.itweet.service.PostService;
import mum.itweet.service.UserService;
import mum.itweet.utitlity.ConstantKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/home")
public class HomeController {

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @Autowired
    FollowingService followingService;

    @Autowired
    AdvertisementService advertisementService ;

    @GetMapping()
    public String getHomeData(Model model, HttpServletRequest request)
    {
        //ToDo: see if we can use another way to get user details such as user id.
        JPAUserDetails userDetails = (JPAUserDetails) request.getSession().getAttribute(ConstantKeys.USER_DETAILS_SESSION_NAME);
        int userId = userDetails.getId();
        model.addAttribute("posts",postService.getAll());
        //model.addAttribute("follower",followingService.listFollower(userId));
        //model.addAttribute("following",followingService.listFollowing(userId));
        return "home";
    }
}
