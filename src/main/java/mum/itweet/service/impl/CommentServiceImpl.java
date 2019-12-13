package mum.itweet.service.impl;

import mum.itweet.model.Comment;
import mum.itweet.model.dto.CommentDto;
import mum.itweet.model.Post;
import mum.itweet.model.User;
import mum.itweet.repository.PostDao;
import mum.itweet.repository.UserDao;
import mum.itweet.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private mum.itweet.repository.CommentDao commentDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private PostDao postDao ;

    @Override
    public Comment create(CommentDto commentDto) {
        User user = userDao.getOne(commentDto.getUserId());
        //@ToDo why post id is long in jpaRepository
        Post post = postDao.getOne((long)commentDto.getPostId());
        Comment comment = new Comment(user,post,commentDto.getCommentText());
        return commentDao.save(comment);
    }

    @Override
    public Comment get(long id) {
        return commentDao.findById(id).get();
    }

    @Override
    public List<Comment> getAllComments(int postid) {
        //@ToDo get commets by using postDao
        return null;
    }

    @Override
    public Comment update(Comment comment) {
        return commentDao.save(comment);
    }

    @Override
    public void delete(long id) {
         commentDao.deleteById(id);
    }


}







