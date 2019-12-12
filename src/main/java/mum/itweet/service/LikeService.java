package mum.itweet.service;

import mum.itweet.model.PostLikes;
import mum.itweet.model.PostLikes;

import java.util.List;

public interface LikeService {
    public PostLikes create(PostLikes postLikes);

    public PostLikes get(long id);

//    public PostLikes update(PostLikes postLikes);

    public void delete(long id);

    //public List<PostLikes> getPostLikes(long postId);

}
