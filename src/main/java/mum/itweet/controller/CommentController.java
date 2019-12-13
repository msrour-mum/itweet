package mum.itweet.controller;

import mum.itweet.model.Comment;
import mum.itweet.model.dto.CommentDto;
import mum.itweet.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/comment")

public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/")
    public Comment addComment(@RequestBody CommentDto commentDto){
        return commentService.create(commentDto);
    }

    @GetMapping("/{id}")
    public Comment getOne(@PathVariable long commentId){
        return commentService.get(commentId);
    }

    @GetMapping("/post/{id}")
    //@ToDo post id dateType
    public List<Comment> getAllComments(@PathVariable int postId){
        return commentService.getAllComments(postId);
    }
}
