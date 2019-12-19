package mum.itweet.service;

import mum.itweet.model.Post;
import mum.itweet.model.dto.PostDto;
import mum.itweet.model.lookups.PostStatus;
import mum.itweet.model.view.PostDetail;

import java.util.List;

public interface PostService {

    //Default
    public Post create(PostDto post);
    public Post get(long id);
    public Post update(PostDto post);
    public Post update(Post post);
    public void delete(long id);
    public List<Post> getAll();

    //Custom
    public  List<PostDetail> findByUserId(int userId) ;
    public  List<PostDetail> listPendingPosts() ;
    public  List<PostDetail> listPostForUser(int userId) ;

    public Post updateStatus(long postId, PostStatus postStatus);

    public int getLikesCount(long postId) ;
    public int getCommentsCount(long postId) ;
    public int getDisabledPostCountPerUser(int userId);

    public boolean isPostContainBadWords(String postText);
    public List<PostDetail> searchPost(String txt);


}
