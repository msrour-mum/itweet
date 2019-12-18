package mum.itweet.controller.mvc;

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

    @GetMapping("/pendingPosts")
    public String getPendingPosts(Model model)
    {
        model.addAttribute("pending",postService.listPendingPosts());
        return "admin-pending-post";
    }


   /* @PostMapping("/pendingPosts/approve/{postId}")
    public String approve(@PathVariable long postId, Model model)
    {
        postService.updateStatus(postId, PostStatus.Active);
        return "redirect:/admin/pendingPosts";
    }

    @PostMapping("/pendingPosts/reject/{postId}")
    public String reject(@PathVariable long postId, Model model)
    {
        postService.updateStatus(postId, PostStatus.Suspended);
        return "redirect:/admin/pendingPosts";
    }
*/
    @PostMapping("/pendingPosts/approve/{postId}")
    public String approve(@PathVariable long postId, @ModelAttribute Model model,
                             @RequestParam(value="action", required=true) String action) {

        if (action.equals("Approve")) {
            postService.updateStatus(postId, PostStatus.Active);
            return "redirect:/admin/pendingPosts";
        }

        if (action.equals("Reject")) {
            postService.updateStatus(postId, PostStatus.Suspended);
            return "redirect:/admin/pendingPosts";
        }
        //return modelAndView;
        return "redirect:/admin/pendingPosts";
    }
}
