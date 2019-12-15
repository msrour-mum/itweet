package mum.itweet.service;

import mum.itweet.model.Post;
import mum.itweet.model.User;
import mum.itweet.model.dto.PostDto;
import mum.itweet.model.lookups.PostStatus;

import java.util.List;

public interface PostService {

    //Default
    public Post create(PostDto post);
    public Post get(long id);
    public Post update(PostDto post);
    public void delete(long id);
    public List<Post> getAll();

    //Custom
    public  List<Post> findByUserId(int userId) ;
    public  List<Post> listPendingPosts() ;
    public  List<Post> listPostForUser(int userId) ;
    public Post updateStatus(long postId, PostStatus postStatus);

    public int getLikesCount(long postId) ;
    public int getCommentsCount(long postId) ;

}
