package mum.itweet.service.impl;

import mum.itweet.model.Course;
import mum.itweet.model.User;
import mum.itweet.repository.CourseRepository;
import mum.itweet.repository.UserDao;
import mum.itweet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User create(User user) {return userDao.save(user);}

    @Override
    public User get(int id) {return userDao.findById(id).get();}

    @Override
    public User update(User user) {
        return userDao.save(user);
    }

    @Override
    public void delete(int id) {
        userDao.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userDao.findAll();
    }

    @Override
    public List<User> findAllByEmail(String email) {


        return (List<User>) userDao.findAllByEmail(email);
    }

}
