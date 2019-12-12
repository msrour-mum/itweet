package mum.itweet.service.impl;

import mum.itweet.model.Following;
import mum.itweet.repository.CourseRepository;
import mum.itweet.repository.FollowingDao;
import mum.itweet.service.FollowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class FollowingServiceImpl implements FollowingService {

    @Autowired
    private FollowingDao followingDao;

    @Override
    public Following create(Following following) {
        return followingDao.save(following);
    }

    @Override
    public Following get(long id) {
        return followingDao.findById(id).get();
    }

    @Override
    public Following update(Following following) {
        return followingDao.save(following);
    }

    @Override
    public void delete(long id) {
        followingDao.deleteById(id);
    }

    @Override
    public List<Following> getAll() {
        return (List<Following>) followingDao.findAll();
    }
}


