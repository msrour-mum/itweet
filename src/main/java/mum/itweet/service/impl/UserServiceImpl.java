package mum.itweet.service.impl;

import mum.itweet.model.Comment;
import mum.itweet.model.Post;
import mum.itweet.model.Role;
import mum.itweet.model.User;
import mum.itweet.model.lookups.UserRoleType;
import mum.itweet.model.view.CommentDetail;
import mum.itweet.model.view.PostDetail;
import mum.itweet.model.view.UserDetail;
import mum.itweet.repository.RoleRepository;
import mum.itweet.repository.UserRepository;
import mum.itweet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.xml.crypto.Data;
import java.time.Period;
import java.util.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Bean
    public PasswordEncoder passwordUtil() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public User create(User user) {
        user.setRole(new Role(4));
        user.setPass(passwordUtil().encode(user.getPass()));
        return userRepository.save(user);}

    @Override
    public User get(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public List<User> findAllByEmail(String email) {
        return (List<User>) userRepository.findAllByEmail(email);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public List<User> PeopleYouMayKnow(int userId , int fetchRecordCount)
    {
        List<User> lst =userRepository.PeopleYouMayKnow(userId);
        List<User> resultList =new ArrayList<>();
        Random rand = new Random();

        if (fetchRecordCount>lst.size())
            fetchRecordCount=lst.size();

        for (int i = 0; i < fetchRecordCount; i++) {
            int randomIndex = rand.nextInt(lst.size());
            User selcetedUser = lst.get(randomIndex);
            resultList.add(selcetedUser);
            lst.remove(randomIndex);
        }
        return resultList;
    }


    @Override
    public List<User> getUsersByRole(UserRoleType userRoleType)
    {
        Role role= roleRepository.getOne(userRoleType.ordinal());
        return userRepository.getAllByRole(role);
    }

    @Override
    public List<UserDetail> quickSearch(String name, String email, boolean enable)
    {
       // return userRepository.quickSearch(name,email,enable);
      //  return convertToDetails( userRepository.findAll());
        return convertToDetails(userRepository.getAllByNameContainsAndEmailContainingAndIsActiveEquals(name,email,enable));
    }


    @Override
    public List<UserDetail> getAllUser() {
        return
                convertToDetails( userRepository.findAll());
    }

    public  List<UserDetail> convertToDetails(List<User> lst)
    {
        if (lst==null) return null;
        List<UserDetail> resultUser=new ArrayList<>();
        for (User user : lst)
        {

            UserDetail userDetail=new UserDetail(user.getId(), user.getName(),user.getEmail(),user.getBirthDate(),user.getGender(),user.getMobile(),user.getBio(),user.getPhotoUrl(),user.getCoverUrl(),user.isActive(),user.isAdmin());

            resultUser.add(userDetail);
        }
        return resultUser;
    }

    public int calculateUserAge(int userId){
        Date curDate = new Date();
        Date userBirthDate = userRepository.getOne(userId).getBirthDate();
        long ageMillisecond = curDate.getTime() - userBirthDate.getTime();

        Date age = new Date(ageMillisecond);
        return age.getYear() -70;
    }

}
