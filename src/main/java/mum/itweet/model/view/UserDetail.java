package mum.itweet.model.view;

import io.swagger.models.auth.In;
import lombok.Data;
import lombok.NoArgsConstructor;
import mum.itweet.validations.UserName;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Date;
@Data
@NoArgsConstructor
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
    private Boolean active;
    private Boolean admin;


    private String nameIsActive;
    private String nameIsAdmin;
    private String nameGender;

    public UserDetail(Integer id ,String name, String email, Date birthDate, Integer gender, String mobile, String bio, String photoUrl, String coverUrl, Boolean active, Boolean admin) {
        this.id=id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.gender = gender;
        this.mobile = mobile;
        this.bio = bio;
        PhotoUrl = photoUrl;
        CoverUrl = coverUrl;
        this.active = active;
        this.admin = admin;


        if (active !=null && active )
            this.nameIsActive="Yes" ;
        else
            this.nameIsActive="No" ;

        if (admin !=null && admin )
            this.nameIsAdmin="Yes" ;
        else
            this.nameIsAdmin="No" ;

        if (gender !=null && gender==1 )
            this.nameGender="Male" ;
        else
            this.nameGender="Female" ;


    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhotoUrl() {
        return PhotoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        PhotoUrl = photoUrl;
    }

    public String getCoverUrl() {
        return CoverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        CoverUrl = coverUrl;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        active = active;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        admin = admin;
    }

    public String getNameIsActive() {
        return nameIsActive;
    }

    public void setNameIsActive(String nameIsActive) {
        this.nameIsActive = nameIsActive;
    }

    public String getNameIsAdmin() {
        return nameIsAdmin;
    }

    public void setNameIsAdmin(String nameIsAdmin) {
        this.nameIsAdmin = nameIsAdmin;
    }

    public String getNameGender() {
        return nameGender;
    }

    public void setNameGender(String nameGender) {
        this.nameGender = nameGender;
    }
}
