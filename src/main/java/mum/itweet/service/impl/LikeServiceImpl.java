package mum.itweet.service.impl;

import mum.itweet.model.PostLikes;
import mum.itweet.repository.LikeDao;
import mum.itweet.repository.PostDao;
import mum.itweet.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class LikeServiceImpl implements LikeService {
    @Autowired
    private LikeDao likeDao;

    @Override
    public PostLikes create(PostLikes postLikes) {
        return likeDao.save(postLikes);
    }

    @Override
    public PostLikes get(long id) {
        return likeDao.findById(id).get();
    }

    @Override
    public void delete(long id) {
        likeDao.deleteById(id);
    }

    @Override
    public List<PostLikes> getPostLikes(long postId) {
        return likeDao.getPostLikes(postId);
    }
}
