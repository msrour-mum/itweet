package mum.itweet.controller;

import mum.itweet.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping(value="/admin")
public class AdminController {

    @Autowired
    PostService postService;

    @GetMapping("/admin/pendingPosts")
    public String getPendingPosts(Model model)
    {

        model.addAttribute("pending",postService.listPendingPosts());

        return "AdminPendingPost";
    }
}
