package mum.itweet.service.impl;

import mum.itweet.model.Following;
import mum.itweet.model.User;
import mum.itweet.model.dto.FollowingDto;
import mum.itweet.repository.FollowingRepository;
import mum.itweet.repository.UserRepository;
import mum.itweet.service.FollowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional

public class FollowingServiceImpl implements FollowingService {

    @Autowired
    private FollowingRepository followingRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Following create(FollowingDto followingDto) {

        User userFollower=userRepository.getOne(followingDto.getFollowerId());
        User userFollowing=userRepository.getOne(followingDto.getFollowingId());

        Following following=new Following(userFollower,userFollowing, new Date());
        return followingRepository.save(following);
    }

    @Override
    public Following addFollow(int followerId, int followingId) {

        User userFollower=userRepository.getOne(followerId);
        User userFollowing=userRepository.getOne(followingId);

        Following following=new Following(userFollower,userFollowing, new Date());
        return followingRepository.save(following);
    }


    @Override
    public void unfollow(int followerId, int followingId) {
         followingRepository.deleteByFollowerIdAndFollowingId(followerId,followingId);
    }


    @Override
    public Following get(long id) {
        return followingRepository.findById(id).get();
    }


    @Override
    public void delete(long id) {
        followingRepository.deleteById(id);
    }

    @Override
    public List<Following> getAll() {
        return (List<Following>) followingRepository.findAll();
    }

    @Override
    public List<User> listFollower(int userId) {
        return userRepository.ListFollower(userId);
    }

    @Override
    public List<User> listFollowing(int userId) {
        return userRepository.ListFollowing(userId);
    }



}


