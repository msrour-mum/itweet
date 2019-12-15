package mum.itweet.validations;

import mum.itweet.model.User;
import mum.itweet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UserNameValidator implements ConstraintValidator<UserName, String> {

    @Autowired
    UserService userService;
    @Override
    public void initialize(UserName constraintAnnotation) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

        Optional<User> user = userService.findByEmail(email);
        return !user.isPresent();
    }
}
