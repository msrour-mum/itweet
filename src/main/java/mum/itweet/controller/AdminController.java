package mum.itweet.controller;

import mum.itweet.model.Post;
import mum.itweet.model.User;
import mum.itweet.model.lookups.PostStatus;
import mum.itweet.model.view.UserDetail;
import mum.itweet.service.PostService;
import mum.itweet.service.UserService;
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
        return "redirect:/admin/pendingPosts";
    }












    @GetMapping(value ="/users" )
    public String getUser( Model model)
    {


        model.addAttribute("users",userService.getAllUser());
        return "admin-user-manage";
    }

    @GetMapping(value ="/searchUser" , params = { "name","email", "enabled" } )
    public String getSearchUser(
//            @RequestParam(name = "name" ,defaultValue = "") String name,
//            @RequestParam(name = "email" ,defaultValue = "") String email,
//            @RequestParam(name = "enabled" ,defaultValue = "0") String enabled,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam boolean enabled,

            Model model)
    {


        model.addAttribute("users",userService.quickSearch(name,email,enabled));
        return "admin-user-manage";
    }

    @GetMapping("/users/{userId}")
    public String usersSearch(@PathVariable int userId, @ModelAttribute UserDetail user, Model  model) {

        model.addAttribute("item", userService.get(userId));
        return "admin-user-view";
    }

    @PostMapping("/users/enable/{userId}")
    public String enable(@PathVariable int userId, @ModelAttribute Post model) {

        postService.updateStatus(userId, PostStatus.Active);
        return "redirect:/admin/users";
    }

    @PostMapping("/users/disable/{userId}")
    public String disable(@PathVariable int userId, @ModelAttribute Post model) {

        postService.updateStatus(userId, PostStatus.Suspended);
        return "redirect:/admin/users";
    }


}
