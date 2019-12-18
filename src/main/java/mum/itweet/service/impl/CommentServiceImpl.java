package mum.itweet.service.impl;

import mum.itweet.model.Comment;
import mum.itweet.model.dto.CommentDto;
import mum.itweet.model.Post;
import mum.itweet.model.User;
import mum.itweet.repository.CommentRepository;
import mum.itweet.repository.PostRepository;
import mum.itweet.repository.UserRepository;
import mum.itweet.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;


    @Override
    public Comment create(CommentDto commentDto) {
        User user = userRepository.getOne(commentDto.getUserId());
        Post post = postRepository.getOne((long)commentDto.getPostId());
        Comment comment = new Comment(user,commentDto.getCommentText());
        post.addComment(comment);
        return commentRepository.saveAndFlush(comment);
    }

    @Override
    public Comment get(long id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public List<Comment> getCommentsByPostId(int postid) {
         return commentRepository.findByPostId(postid);
    }


    @Override
    public Comment update(CommentDto commentDto) {

        User user = userRepository.getOne(commentDto.getUserId());
        Post post = postRepository.getOne((long)commentDto.getPostId());
        Comment comment = new Comment(user,commentDto.getCommentText());
        return commentRepository.save(comment);
    }

    @Override
    public void delete(long id) {

        commentRepository.deleteById(id);
    }

    @Override
    public void deleteByPostId(long postId)
    {
        commentRepository.deleteByPostId(postId);
    }

}







