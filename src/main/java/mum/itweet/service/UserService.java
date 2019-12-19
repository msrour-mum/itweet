package mum.itweet.service;


import mum.itweet.model.User;
import mum.itweet.model.lookups.UserRoleType;
import mum.itweet.model.view.UserDetail;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserService {
    //Default
    public User create(User user);
    public User get(int id);
    public User update(User user);
    public void delete(int id);
    public List<User> findAllByEmail(String name);
    public Optional<User> findByEmail(String email);
    public List<User> getAll();

    public List<UserDetail> quickSearch(String name, String email, boolean enable);
    public List<UserDetail> getAllUser();

    public List<User> PeopleYouMayKnow(int userId , int fetchRecordCount);
    public List<User> getUsersByRole(UserRoleType userRoleType);
}
