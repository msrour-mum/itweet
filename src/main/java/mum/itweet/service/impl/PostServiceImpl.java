package mum.itweet.service.impl;

import mum.itweet.model.Post;
import mum.itweet.repository.PostDao;
import mum.itweet.repository.UserDao;
import mum.itweet.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    public Post create(Post post) {
        return postDao.save(post);
    }

    @Override
    public Post get(long id) {
        return postDao.findById(id).get();
    }

    @Override
    public Post update(Post post) {
        return postDao.save(post);
    }

    @Override
    public void delete(long id) {
        postDao.deleteById(id);
    }

    @Override
    public List<Post> getAll() {
        return postDao.findAll();
    }

    @Override
    public List<Post> getUserPosts(int userId) {
        return postDao.getUserPosts(userId);
    }

    @Override
    public int getLikesCount(long id) {
        return postDao.getLikesCount(id);
    }
}
