package mum.itweet.model.view;

import io.swagger.models.auth.In;
import lombok.Data;
import mum.itweet.validations.UserName;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Date;
@Data
public class UserDetail {


    private Integer id;
    private String name;
    private String email;
    private Date birthDate;
    private Integer gender;
    private String mobile;
    private String bio;
    private String PhotoUrl;
    private String CoverUrl;
    private Boolean isActive;
    private Boolean isAdmin;


    private String nameIsActive;
    private String nameIsAdmin;
    private String nameGender;

    public UserDetail(Integer id ,String name, String email, Date birthDate, Integer gender, String mobile, String bio, String photoUrl, String coverUrl, Boolean isActive, Boolean isAdmin) {
        this.id=id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.gender = gender;
        this.mobile = mobile;
        this.bio = bio;
        PhotoUrl = photoUrl;
        CoverUrl = coverUrl;
        this.isActive = isActive;
        this.isAdmin = isAdmin;


        if (isActive !=null && isActive )
            this.nameIsActive="Yes" ;
        else
            this.nameIsActive="No" ;

        if (isAdmin !=null && isAdmin )
            this.nameIsAdmin="Yes" ;
        else
            this.nameIsAdmin="No" ;

        if (gender !=null && gender==1 )
            this.nameGender="Male" ;
        else
            this.nameGender="Female" ;


    }
}
