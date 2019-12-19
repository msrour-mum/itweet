package mum.itweet.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import mum.itweet.model.dto.CommentDto;
import mum.itweet.model.dto.PostDto;
import mum.itweet.service.FollowingService;
import mum.itweet.service.PostService;
import mum.itweet.service.UserService;
import mum.itweet.utitlity.Context;

@Controller
public class ProfileMvcController {

	@Autowired
	UserService userService;
	@Autowired
	PostService postService;
	@Autowired
	FollowingService followingService;

	@GetMapping({ "/profile", "/profile/{userId}" })
//	public String home(@PathVariable int userId, Model model, @ModelAttribute("post") PostDto postDto) {
	public String home(Model model, @ModelAttribute("post") PostDto postDto,
			@ModelAttribute("comment") CommentDto commentDto,

			@PathVariable(name = "userId", required = false) Integer userId) {
		if (userId == null) {
			userId = Context.getUserId();
		}
		model.addAttribute("user", userService.get(userId));
		model.addAttribute("posts", postService.findByUserId(userId)); // list of post owend by this user
		model.addAttribute("CountFollower", followingService.getCountFollower(userId));
		model.addAttribute("CountFollowing", followingService.getCountFollowing(userId));
		model.addAttribute("PeopleYouMayKnow", userService.PeopleYouMayKnow(userId, 5));
		return "profile";
	}
}
