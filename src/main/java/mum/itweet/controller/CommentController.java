package mum.itweet.controller;

import mum.itweet.model.Comment;
import mum.itweet.model.dto.CommentDto;
import mum.itweet.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/post/comment")

public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping()
    public Comment addComment(@RequestBody CommentDto commentDto){

        return commentService.create(commentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable long id){
        commentService.delete(id);
    }

    @GetMapping("/{id}")
    public Comment getOne(@PathVariable long id){
        return commentService.get(id);
    }


}
