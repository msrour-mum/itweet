package mum.itweet.controller;

import mum.itweet.components.messages.publish.PostDisabledMessageSender;
import mum.itweet.model.Post;
import mum.itweet.model.User;
import mum.itweet.model.dto.Message;
import mum.itweet.model.dto.UserDto;
import mum.itweet.model.dto.UserSearchDto;
import mum.itweet.model.lookups.PostStatus;
import mum.itweet.model.view.UserDetail;
import mum.itweet.service.PostService;
import mum.itweet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

    @Autowired
    PostService postService;

    @Autowired
    PostDisabledMessageSender postDisabledMessageSender;


    @Autowired
    UserService userService;

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












    @GetMapping(value ="/users" )
    public String getUser(@ModelAttribute UserSearchDto userSearchDto, Model model)
    {

        return "admin-user-manage";
    }

    @PostMapping(value ="/users" )
    public String getSearchUser(@ModelAttribute UserSearchDto userSearchDto, RedirectAttributes redirectAttributes)
    {
        if (userSearchDto!=null)
            redirectAttributes.addFlashAttribute("users",userService.quickSearch(userSearchDto.getName(),userSearchDto.getEmail(),userSearchDto.getActive()));
        return "redirect:/admin/userSearch";
    }

    @GetMapping(value ="/userSearch" )
    public String userSearchResul(@ModelAttribute UserSearchDto userSearchDto, Model model)
    {
        return "admin-user-search-result";
    }

    @GetMapping("/users/{userId}")
    public String usersSearch(@PathVariable int userId, @ModelAttribute UserDetail user, Model  model) {

        model.addAttribute("item", userService.get(userId));
        return "admin-user-view";
    }

    @PostMapping("/users/enable/{userId}")
    public String enable(@PathVariable int userId, @ModelAttribute User model) {

        User user =userService.get(userId);
        user.setActive(true);
        userService.update(user);
        return "redirect:/admin/users";
    }

    @PostMapping("/users/disable/{userId}")
    public String disable(@PathVariable int userId, @ModelAttribute User model) {

        User user =userService.get(userId);
        user.setActive(false);
        userService.update(user);
        return "redirect:/admin/users";
    }


}
