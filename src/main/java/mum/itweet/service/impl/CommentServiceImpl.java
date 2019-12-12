package mum.itweet.service.impl;

import mum.itweet.model.Comment;
import mum.itweet.model.Course;
import mum.itweet.repository.CommentDao;
import mum.itweet.repository.CourseRepository;
import mum.itweet.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public Comment create(Comment comment) {
        return commentDao.save(comment);
    }

    @Override
    public Comment get(long id) {
        return commentDao.findById(id).get();
    }

    @Override
    public Comment update(Comment comment) {
        return commentDao.save(comment);
    }

    @Override
    public void delete(long id) {
         commentDao.deleteById(id);
    }


    @Override
    public List<Comment> getAll() {
        return (List<Comment>) commentDao.findAll();
    }
}







