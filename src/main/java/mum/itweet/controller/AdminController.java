package mum.itweet.controller;

import mum.itweet.components.messages.publish.PostDisabledMessageSender;
import mum.itweet.model.Post;
import mum.itweet.model.dto.Message;
import mum.itweet.model.lookups.PostStatus;
import mum.itweet.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

    @Autowired
    PostService postService;

    @Autowired
    PostDisabledMessageSender postDisabledMessageSender;


    @GetMapping("/pendingPosts")
    public String getPendingPosts(Model model)
    {
        model.addAttribute("pending",postService.listPendingPosts());
        return "admin-pending-post";
    }

    @GetMapping("/pendingPosts/view/{postId}")
    public String approve(@PathVariable long postId,@ModelAttribute Post post,  Model  model) {

        model.addAttribute("item", postService.get(postId));
        return "admin-pending-post-view";
    }

    @PostMapping("/pendingPosts/approve/{postId}")
    public String approve(@PathVariable long postId, @ModelAttribute Post model) {

        postService.updateStatus(postId, PostStatus.Active);
        return "redirect:/admin/pendingPosts";
    }

    @PostMapping("/pendingPosts/reject/{postId}")
    public String reject(@PathVariable long postId, @ModelAttribute Post model) {
        postService.updateStatus(postId, PostStatus.Suspended);
        postDisabledMessageSender.PostDisabledMessageSender(new Message(postId));
        return "redirect:/admin/pendingPosts";
    }


}
