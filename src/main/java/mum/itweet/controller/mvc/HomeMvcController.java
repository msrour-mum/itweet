package mum.itweet.controller.mvc;

import mum.itweet.model.User;
import mum.itweet.model.lookups.UserRoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import mum.itweet.service.FollowingService;
import mum.itweet.service.PostService;
import mum.itweet.service.UserService;
import mum.itweet.utitlity.Context;

import java.util.List;

@Controller
public class HomeMvcController {

	@Autowired
	UserService userService;
	@Autowired
	PostService postService;

	@Autowired
	FollowingService followingService;

	@GetMapping("/")
	public String home(Model model) {
		int userId = Context.getUserId();
		model.addAttribute("user", userService.get(userId));
		model.addAttribute("posts", postService.listPostForUser(userId));
		model.addAttribute("CountFollower", followingService.getCountFollower(userId));
		model.addAttribute("CountFollowing", followingService.getCountFollowing(userId));
		model.addAttribute("PeopleYouMayKnow", userService.PeopleYouMayKnow(userId,5));
		return "home";
	}

}
