package mum.itweet.controller;

import mum.itweet.model.User;
import mum.itweet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/add")
    public User add(@RequestBody User user) {
        try {
            return userService.create(user);
        } catch (DataIntegrityViolationException e) {
            System.out.println("User already exist!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @PutMapping(value = "/update")
    public User update(@RequestBody User user) {
        try {
            return userService.create(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @GetMapping(value = "/get")
    public List<User> getAll() {
        try {
            return userService.getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @GetMapping(value = "/get/{id}")
    public User get(@PathVariable("id") int id) {
        try {
            return userService.get(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        try {
            userService.delete(id);
            return "success";
        } catch (Exception e) {
            return "failed";
        }
    }

    @GetMapping(value = "/search/{email}")
    public List<User> getByEmail(@PathVariable("email") String email) {
        try {
            return userService.findAllByEmail(email);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}

