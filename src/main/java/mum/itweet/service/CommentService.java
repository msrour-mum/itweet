package mum.itweet.service;

import mum.itweet.model.Comment;

import java.util.List;

public interface CommentService {

    public Comment create(Comment comment);

    public Comment get(long id);

    public Comment update(Comment comment);

    public void delete(long id);

    public List<Comment> getAll();
}
