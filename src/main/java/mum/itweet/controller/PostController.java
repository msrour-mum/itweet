package mum.itweet.controller;

import mum.itweet.model.Comment;
import mum.itweet.model.Post;
import mum.itweet.model.PostLikes;
import mum.itweet.model.User;
import mum.itweet.model.dto.PostDto;
import mum.itweet.model.view.PostDetail;
import mum.itweet.service.CommentService;
import mum.itweet.service.LikeService;
import mum.itweet.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/post")
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    LikeService likeService;

    @Autowired
    CommentService commentService;


    @PostMapping()
    public Post add(@RequestBody PostDto post) {
        return postService.create(post);
    }

    @PutMapping()
    public Post update(@RequestBody PostDto post) {
        return postService.create(post);
    }

    @GetMapping()
    public List<Post> getAll() {
        return postService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Post get(@PathVariable("id") long id) {
        return postService.get(id);
    }

   @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") long id) {
       postService.delete(id);
    }


    @GetMapping("/pendingPosts")
    public List<PostDetail> getPendingPosts(Model model)
    {
        return postService.listPendingPosts();
    }

    @GetMapping("/{postId}/likeCount")
    public int getLikesCount(@PathVariable("postId") long postId) {
        return postService.getLikesCount(postId);
    }

    @GetMapping("/{postId}/CommentCount")
    public int getCommentsCount(@PathVariable("postId") long postId) {
        return postService.getCommentsCount(postId);
    }

    @GetMapping("/{postId}/comment")
    public List<Comment> getCommentsByPostId(@PathVariable int postId){
        return commentService.getCommentsByPostId(postId);
    }

    @PostMapping(value = "/{postId}/liked/{userId}")
    public PostLikes like(@PathVariable("postId") int userId, @PathVariable("userId") long postId) {
        return likeService.like(userId, postId);
    }

    @DeleteMapping(value = "/{postId}/disliked/{userId}")
    public void dislike(@PathVariable("postId") int userId, @PathVariable("userId") long postId) {
        likeService.dislike(userId, postId);
    }

}


