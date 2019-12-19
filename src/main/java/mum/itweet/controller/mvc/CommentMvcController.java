package mum.itweet.controller.mvc;

import mum.itweet.model.dto.CommentDto;
import mum.itweet.service.CommentService;
import mum.itweet.utitlity.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommentMvcController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/comment")
    public String addComment(CommentDto commentDto){
        commentDto.setUserId(Context.getUserId());
        commentService.create(commentDto);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable long id){
        commentService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable long id, Model model){
        model.addAttribute("comment", commentService.get(id));
        return "redirect:/";
    }
}
