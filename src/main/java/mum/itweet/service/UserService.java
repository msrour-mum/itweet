package mum.itweet.service;


import mum.itweet.model.User;

import java.util.List;

public interface UserService {
    //Default
    public User create(User user);
    public User get(int id);
    public User update(User user);
    public void delete(int id);
    public List<User> findAllByEmail(String name);
    public List<User> getAll();
}
