package mum.itweet.model;

import io.swagger.models.auth.In;
import lombok.Data;
import lombok.NoArgsConstructor;
import mum.itweet.model.lookups.Gender;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "isAdmin",nullable = false, columnDefinition = "BIT(1) default 0")
    private boolean isAdmin;

    @ManyToOne(optional = false)
    private Role role;

    @Column(nullable = false)
    private String pass;

    @Column(name = "isActive",nullable = false, columnDefinition = "BIT(1) default 1")
    private boolean isActive;

    private Date birthDate;

    //@Enumerated(EnumType.ORDINAL)
    @Column(name = "genderId")
    private Integer gender;
    private String mobile;
    @Lob
    private String bio;

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
}
