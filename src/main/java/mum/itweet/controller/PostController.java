package mum.itweet.controller;

import mum.itweet.model.Post;
import mum.itweet.model.PostLikes;
import mum.itweet.model.User;
import mum.itweet.model.dto.PostDto;
import mum.itweet.service.LikeService;
import mum.itweet.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/post")
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    LikeService likeService;

    @PostMapping()
    public Post add(@RequestBody PostDto post) {
        try {
            return postService.create(post);
        } catch (DataIntegrityViolationException e) {
            System.out.println("Post already exist!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @PutMapping()
    public Post update(@RequestBody PostDto post) {
        try {
            return postService.create(post);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @GetMapping()
    public List<Post> getAll() {
        try {
            return postService.getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @GetMapping(value = "/{id}")
    public Post get(@PathVariable("id") long id) {
        try {
            return postService.get(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

   @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable("id") long id) {
        try {
            postService.delete(id);
            return "success";
        } catch (Exception e) {
            return "failed";
        }
    }



    @GetMapping("/{postId}/likeCount")
    public int getLikesCount(long postId) {
        return postService.getLikesCount(postId);
    }

    @GetMapping("/{postId}/CommentCount")
    public int getCommentsCount(long postId) {
        return postService.getCommentsCount(postId);
    }

    @PostMapping(value = "/{postId}/liked/{userId}")
    public PostLikes add(@PathVariable("postId") int userId, @PathVariable("userId") long postId) {
        return likeService.like(userId, postId);
    }
}


