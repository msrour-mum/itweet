package mum.itweet.service.impl;

import mum.itweet.model.Post;
import mum.itweet.model.PostLikes;
import mum.itweet.model.User;
import mum.itweet.model.dto.PostLikesDto;
import mum.itweet.repository.PostLiksRepository;
import mum.itweet.repository.PostRepository;
import mum.itweet.repository.UserRepository;
import mum.itweet.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional

public class LikeServiceImpl implements LikeService {
    @Autowired
    private PostLiksRepository postLiksRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;


    @Override
    public PostLikes create(PostLikesDto postLikesDto) {

       /* User user=userRepository.getOne(userId);
        Post post =postRepository.getOne(postId);
        PostLikes postLikes=new PostLikes(user,true,new Date());
        //return postLiksRepository.save(postLikes);
        post.addLike(postLikes);
        postRepository.save(post);
        return postLikes;*/
       return null;
    }

    @Override
    public PostLikes like(int userId,long postId) {
        User user=userRepository.getOne(userId);
        Post post =postRepository.getOne(postId);
        PostLikes postLikes=new PostLikes(user,true,new Date());
        post.addLike(postLikes);
        postRepository.save(post);
        return postLikes;
    }

    @Override
    public void dislike(int userId,long postId) {
        User user=userRepository.getOne(userId);
        Post post =postRepository.getOne(postId);
        PostLikes postLikes=new PostLikes(user,true,new Date());
        post.removeLike(postLikes);
        postRepository.save(post);
        //return postLikes;
    }


    @Override
    public PostLikes get(long id) {

        return postLiksRepository.findById(id).get();
    }

    @Override
    public void delete(long id) {

        postLiksRepository.deleteById(id);
    }

    @Override
    public List<PostLikes> findByPostId(long postId) {

        return postLiksRepository.findByPostId(postId);

    }


    @Override
    public void deleteByPostId(long postId)
    {
        postLiksRepository.deleteByPostId(postId);
    }


}
