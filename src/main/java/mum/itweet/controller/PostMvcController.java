package mum.itweet.controller;

import java.io.IOException;

import javax.validation.Valid;

import mum.itweet.model.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import mum.itweet.components.messages.publish.PostAddedMessageSender;
import mum.itweet.components.storage.IStorageService;
import mum.itweet.model.Person;
import mum.itweet.model.Post;
import mum.itweet.model.dto.PostDto;
import mum.itweet.service.LikeService;
import mum.itweet.service.PostService;
import mum.itweet.utitlity.Context;

@Controller
public class PostMvcController {

	@Autowired
	private IStorageService storageService;

	@Autowired
	PostAddedMessageSender postAddedMessageSender;

	@Autowired
	PostService postService;

	@Autowired
	LikeService likeService;

	@GetMapping("/post")
	public String view(@ModelAttribute("post") PostDto postDto, @ModelAttribute Person person) {
		return "person";
	}

	@PostMapping("/post")
	public String add(@Valid @ModelAttribute("post") PostDto postDto, BindingResult bindingResult) throws IOException {

		if (bindingResult.hasErrors()) {
			return "home";
		}
		System.out.println(Context.getUserIdAsString());
		postDto.setUserId(Context.getUserId());
		Post post = postService.create(postDto);
		if (!postDto.getImage().isEmpty()) {
			String path = storageService.uploadMultipartFile(postDto.getImage(), Context.getUserIdAsString());
			post.setImageUrl(path);
			post = postService.update(post);
		} else if (!postDto.getVideo().isEmpty()) {
			String path = storageService.uploadMultipartFile(postDto.getVideo(), Context.getUserIdAsString());
			post.setVideoUrl(path);
			post = postService.update(post);
		}
		postAddedMessageSender.PostAddedMessageSender(new Message(post.getId()));
		return "redirect:/";
	}
}
