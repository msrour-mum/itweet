package mum.itweet.service;

import mum.itweet.model.Following;

import java.util.List;

public interface FollowingService {

    public Following create(Following following);

    public Following get(long id);

    public Following update(Following following);

    public void delete(long id);

    public List<Following> getAll();

}
