package mum.itweet.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import mum.itweet.model.Comment;
import mum.itweet.model.Post;
import mum.itweet.model.PostLikes;
import mum.itweet.model.Role;
import mum.itweet.model.lookups.Gender;
import mum.itweet.validations.UserName;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDto {

    @UserName
    private String email;
    @NotEmpty
    private String pass;
    @NotEmpty
    private String name;
    private Date birthDate;
    private Gender gender;
    private String mobile;
    private String bio;
}
