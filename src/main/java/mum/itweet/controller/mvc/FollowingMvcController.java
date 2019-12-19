package mum.itweet.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import mum.itweet.service.FollowingService;
import mum.itweet.service.PostService;
import mum.itweet.service.UserService;
import mum.itweet.utitlity.Context;

@Controller
public class FollowingMvcController {

	@Autowired
	UserService userService;
	@Autowired
	PostService postService;
	@Autowired
	FollowingService followingService;

	@GetMapping("/following")
	public String home(Model model, @PathVariable(name = "userId", required = false) Integer userId) {
		if (userId == null) {
			userId = Context.getUserId();
		}
		model.addAttribute("user", userService.get(userId));
		model.addAttribute("followings", followingService.listFollowing(userId));
		model.addAttribute("followers", followingService.listFollower(userId));
		model.addAttribute("CountFollower", followingService.getCountFollower(userId));
		model.addAttribute("CountFollowing", followingService.getCountFollowing(userId));
		model.addAttribute("PeopleYouMayKnow", userService.PeopleYouMayKnow(userId, 5));
		return "following";
	}
}
