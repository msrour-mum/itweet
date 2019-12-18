package mum.itweet.service;

import mum.itweet.model.Comment;
import mum.itweet.model.dto.CommentDto;

import java.util.List;

public interface CommentService {

    //Default
    public Comment create(CommentDto addCommentBody);

    public Comment get(long id);

    public List<Comment> getCommentsByPostId(int postid);

    public Comment update(CommentDto comment);

    public void delete(long id);

    public void deleteByPostId(long postId);
}
