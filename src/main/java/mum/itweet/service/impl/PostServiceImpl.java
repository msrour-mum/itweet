package mum.itweet.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mum.itweet.model.Comment;
import mum.itweet.model.UnhealthyKey;
import mum.itweet.model.dto.CommentDto;
import mum.itweet.model.view.CommentDetail;
import mum.itweet.model.view.PostDetail;
import mum.itweet.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.itweet.model.Post;
import mum.itweet.model.User;
import mum.itweet.model.dto.PostDto;
import mum.itweet.model.lookups.PostStatus;
import mum.itweet.service.PostService;

@Service
@Transactional
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private PostLiksRepository postLiksRepository;

	@Autowired
	UnhealthykeyRepository unhealthykeyRepository;

	@Override
	public Post create(PostDto postDto) {

		PostStatus postStatus = PostStatus.Active;
		User user = userRepository.getOne(postDto.getUserId());
		Post post = new Post(user, postDto.getPostText(), postStatus, postDto.getImageUrl(), postDto.getVideoUrl(),
				new Date(), new Date());
		return postRepository.save(post);
	}

	@Override
	public Post get(long id) {
		// return postRepository.getOne(id);
		return postRepository.findById(id).get();
	}

	@Override
	public Post update(PostDto postDto) {

		return create(postDto);
	}

	@Override
	public Post update(Post post) {
		return postRepository.save(post);
	}

	@Override
	public void delete(long id) {

		postRepository.deleteById(id);
	}

	@Override
	public List<Post> getAll() {
		return postRepository.findAll();
	}

	@Override
	public List<PostDetail> findByUserId(int userId) {
		 return convertToDetails( postRepository.findByUserId(userId));
		//return convertToDetails( postRepository.findAll());
	}

	@Override
	public int getLikesCount(long postId) {

		return postRepository.getLikesCount(postId);
	}

	@Override
	public int getCommentsCount(long postId) {

		return postRepository.getCommentsCount(postId);
	}

	@Override
	public List<PostDetail> listPendingPosts() {
		return convertToDetails( postRepository.findByStatusOrderByIdDesc(PostStatus.Pending));
	}

	@Override
	public List<PostDetail> listPostForUser(int userId) {
		return convertToDetails( postRepository.listPostForUser(userId));
	}

	@Override
	public Post updateStatus(long postId, PostStatus postStatus) {
		Post post = get(postId);
		post.setStatus(postStatus);
		return postRepository.save(post);
	}

	@Override
	public int getDisabledPostCountPerUser(int userId)
	{
		return postRepository.getDisabledPostCountPerUser(userId);
	}

	@Override
	public boolean isPostContainBadWords(String postText)
	{
		String[] words = postText.split(" ");
		for (String w : words)
		{
			List<UnhealthyKey> lst= unhealthykeyRepository.findByWordKeyIgnoreCase(w);
			if(lst!=null && lst.size()>0)
				return  true;
		}
		return false;
	}

	@Override
	public List<PostDetail> searchPost(String txt)
	{
		return convertToDetails( postRepository.searchPost(txt));
	}

	public  List<PostDetail> convertToDetails(List<Post> lst)
	{
		if (lst==null) return null;
		List<PostDetail> resultPost=new ArrayList<>();
		for (Post post : lst)
		{
			int commetsCount=post.getComments().size();
			CommentDetail lastComment = null;
			if (commetsCount>0) {
				//Comment comment=post.getComments().get(commetsCount - 1);
				Comment comment=post.getComments().get(0);
				lastComment = new CommentDetail(comment.getId(),comment.getCommentText(),comment.getCreationDate(), comment.getUser(),post.getId());
			}
			PostDetail postView =new PostDetail(post.getId(), post.getUser(),post.getPostText(),post.getStatus().ordinal(),post.getImageUrl(),post.getVideoUrl(),post.getCreationDate(),post.getPublishDate(),post.getPostLikes().size(),commetsCount,lastComment);
			resultPost.add(postView);
		}
		return resultPost;
	}



}
