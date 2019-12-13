package mum.itweet.service;

import mum.itweet.model.PostLikes;
import mum.itweet.model.PostLikes;
import mum.itweet.model.dto.PostLikesDto;

import java.util.List;

public interface LikeService {
    //Default
    public PostLikes create(PostLikesDto postLikes);
    public PostLikes like(int userId,long postId);
    public PostLikes get(long id);
    public void delete(long id);
    //Custom
    public List<PostLikes> findByPostId(long postId);
}
