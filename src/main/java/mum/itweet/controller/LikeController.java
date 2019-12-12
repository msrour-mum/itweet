package mum.itweet.controller;

import mum.itweet.model.PostLikes;
import mum.itweet.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "PostLikes")
public class LikeController {
    @Autowired
    LikeService likeService;

    @PostMapping(value = "/add")
    public PostLikes add(@RequestBody PostLikes postLikes) {
        try {
            return likeService.create(postLikes);
        } catch (DataIntegrityViolationException e) {
            System.out.println("PostLikes already exist!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

   /* @DeleteMapping(value = "/getPostLiks/{postId}")
    public List<PostLikes> getPostLiks(@PathVariable("postId") long postId) {
        try {
            return likeService.getPostLikes(postId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
*/
    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        try {
            likeService.delete(id);
            return "success";
        } catch (Exception e) {
            return "failed";
        }
    }
}


