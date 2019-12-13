package mum.itweet.service;

import mum.itweet.model.Comment;
import mum.itweet.model.dto.CommentDto;

import java.util.List;

public interface CommentService {

    public Comment create(CommentDto addCommentBody);

    public Comment get(long id);

    public List<Comment> getAllComments(int postid) ;

    public Comment update(Comment comment);

    public void delete(long id);


}
