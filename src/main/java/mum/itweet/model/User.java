package mum.itweet.model;

import io.swagger.models.auth.In;
import lombok.Data;
import lombok.NoArgsConstructor;
import mum.itweet.model.lookups.Gender;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotEmpty
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "isAdmin",nullable = false, columnDefinition = "BIT(1) default 0")
    private boolean isAdmin;

    @ManyToOne(optional = false)
    private Role role=new Role();

    @Column(nullable = false)
    private String pass;

    @Column(name = "isActive",nullable = false, columnDefinition = "BIT(1) default 1")
    private Boolean isActive;

    private Date birthDate;

    //@Enumerated(EnumType.ORDINAL)
    @Column(name = "genderId")
    private Integer gender;
    private String mobile;
    @Lob
    private String bio;

    private String PhotoUrl;
    private String CoverUrl;

    @Transient
    MultipartFile image;
    @Transient
    MultipartFile cover;

    public User(String name,String email, boolean isAdmin, Role role, String pass, boolean isActive, Date birthDate, int gender, String mobile, String bio) {
        this.name = name;
        this.email = email;
        this.isAdmin = isAdmin;
        this.role = role;
        this.pass = pass;
        this.isActive = isActive;
        this.birthDate = birthDate;
        this.gender = gender;
        this.mobile = mobile;
        this.bio = bio;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public Role getRole() {
        return role;
    }

    public String getPass() {
        return pass;
    }

    public boolean isActive() {
        return isActive;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Integer getGender() {
        return gender;
    }

    public String getMobile() {
        return mobile;
    }

    public String getBio() {
        return bio;
    }

    public String getPhotoUrl() {
        return PhotoUrl;
    }

    public String getCoverUrl() {
        return CoverUrl;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setPhotoUrl(String photoUrl) {
        PhotoUrl = photoUrl;
    }

    public void setCoverUrl(String coverUrl) {
        CoverUrl = coverUrl;
    }
}
