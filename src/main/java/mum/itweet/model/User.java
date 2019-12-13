package mum.itweet.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import mum.itweet.model.lookups.Gender;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false, columnDefinition = "BIT(1) default 0")
    private boolean isAdmin;

    @ManyToOne(optional = false)
    private Role role;

    @Column(nullable = false)
    private String pass;

    @Column(nullable = false, columnDefinition = "BIT(1) default 1")
    private boolean isActive;

    private Date birthDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "genderId")
    private Gender gender;
    private String mobile;
    private String bio;

    @OneToMany(mappedBy = "user")
    List<Post> posts;

    @OneToMany(mappedBy = "user")
    List<Comment> comments;

    @OneToMany(mappedBy = "user")
    List<PostLikes> postLikes;

    public User(String email, boolean isAdmin, Role role, String pass, boolean isActive, Date birthDate, Gender gender, String mobile, String bio) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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
}
