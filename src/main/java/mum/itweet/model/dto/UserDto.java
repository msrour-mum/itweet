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

    @NotEmpty
    private String name;
    @UserName
    private String email;
    @NotEmpty
    private String pass;
    private Date birthDate;
    private int gender;
    private String mobile;
    private String bio;
}
