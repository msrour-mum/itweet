package mum.itweet.controller;

import mum.itweet.model.PostLikes;
import mum.itweet.model.dto.PostLikesDto;
import mum.itweet.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/post/like")
public class PostLikesController {
    @Autowired
    LikeService likeService;

  /*  @PostMapping()
    public PostLikes addLike(@RequestBody PostLikesDto postLikes) {
        return likeService.create(postLikes);
    }

    @DeleteMapping()
    public void deleteLike(@PathVariable long id){
        likeService.delete(id);
    }*/

}


