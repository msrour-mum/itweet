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
}
