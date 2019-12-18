package mum.itweet.controller;

import mum.itweet.components.IStorageService;
import mum.itweet.components.StorageService;
import mum.itweet.model.Person;
import mum.itweet.model.Post;
import mum.itweet.model.PostLikes;
import mum.itweet.model.dto.PostDto;
import mum.itweet.service.LikeService;
import mum.itweet.service.PostService;
import mum.itweet.utitlity.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class PostMvcController {

    //@Autowired
    private IStorageService storageService = new StorageService();

    @Autowired
    PostService postService;

    @Autowired
    LikeService likeService;

    @GetMapping("/post")
    public String view(@ModelAttribute("post") PostDto postDto, @ModelAttribute Person person) {
        return "person";
    }

    @PostMapping("/user/{userId}/post")
    public String add(@Valid @ModelAttribute("post") PostDto postDto, @PathVariable("userId") int userId, BindingResult bindingResult) throws IOException {

        if (bindingResult.hasErrors()) {
            return "home";
        }

        System.out.println(Context.getUserIdAsString());
        postDto.setUserId(userId);
        Post post = postService.create(postDto);
        if (!postDto.getImage().isEmpty()) {
            String path = storageService.uploadMultipartFile(postDto.getImage(), Integer.toString(userId));
            post.setImageUrl(path);
            postService.update(post);
        } else if (!postDto.getVideo().isEmpty()) {
            String path = storageService.uploadMultipartFile(postDto.getVideo(),  Integer.toString(userId));
            post.setVideoUrl(path);
            postService.update(post);
        }
        return "redirect:/home";
    }
}


