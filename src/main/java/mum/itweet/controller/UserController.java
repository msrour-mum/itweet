package mum.itweet.controller;

import mum.itweet.model.Following;
import mum.itweet.model.Post;
import mum.itweet.model.User;
import mum.itweet.model.dto.FollowingDto;
import mum.itweet.service.FollowingService;
import mum.itweet.service.PostService;
import mum.itweet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    FollowingService followingService;

    @Autowired
    PostService postService;

    @PostMapping(value = "/add")
    public User add(@RequestBody User user) {
        try {
            return userService.create(user);
        } catch (DataIntegrityViolationException e) {
            System.out.println("User already exist!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @PutMapping(value = "/update")
    public User update(@RequestBody User user) {
        try {
            return userService.create(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @GetMapping(value = "/get")
    public List<User> getAll() {
        try {
            return userService.getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @GetMapping(value = "/get/{id}")
    public User get(@PathVariable("id") int id) {
        try {
            return userService.get(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        try {
            userService.delete(id);
            return "success";
        } catch (Exception e) {
            return "failed";
        }
    }

    @GetMapping(value = "/search/{email}")
    public List<User> getByEmail(@PathVariable("email") String email) {
        try {
            return userService.findAllByEmail(email);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @GetMapping("/{userId}/follower")
    public List<User> ListFollower(@PathVariable int userId){
        return followingService.listFollower(userId);
    }

    @GetMapping("/{userId}/following")
    public List<User> ListFollowing(@PathVariable int userId){
        return followingService.listFollowing(userId);
    }

    @DeleteMapping(value = "{userId}/unfollow/{followingId}")
    public String delete(@PathVariable("userId") int userId, @PathVariable("followingId") int followingId) {
        try {
            followingService.unfollow(userId,followingId);
            return "success";
        } catch (Exception e) {
            return "failed";
        }
    }

    @PostMapping(value = "{userId}/follow/{followingId}")
    public Following follow(@PathVariable("userId") int userId, @PathVariable("followingId") int followingId) {
        return followingService.addFollow(userId,followingId);
    }


    @GetMapping(value = "/{userId}/post")
    public List<Post> getUserPosts(@PathVariable("userId") int userId) {
        try {
            return postService.findByUserId(userId);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}

