package mum.itweet.controller;

import mum.itweet.model.Post;
import mum.itweet.model.User;
import mum.itweet.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "post")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping(value = "/add")
    public Post add(@RequestBody Post post) {
        try {
            return postService.create(post);
        } catch (DataIntegrityViolationException e) {
            System.out.println("Post already exist!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @PutMapping(value = "/update")
    public Post update(@RequestBody Post post) {
        try {
            return postService.create(post);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @GetMapping(value = "/get")
    public List<Post> getAll() {
        try {
            return postService.getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @GetMapping(value = "/get/{id}")
    public Post get(@PathVariable("id") long id) {
        try {
            return postService.get(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        try {
            postService.delete(id);
            return "success";
        } catch (Exception e) {
            return "failed";
        }
    }

    @GetMapping(value = "/user/{userId}/post")
    public List<Post> getUserPosts(@PathVariable("userId") int userId) {
        try {
            User user=new User();
            user.setId(userId);
            return postService.findByUserContains(user);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

   /* @GetMapping(value = "/getCount/{id}")
    public int getLikesCount(@PathVariable("id") int id) {
        try {
            return postService.getLikesCount(id);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }*/

}


