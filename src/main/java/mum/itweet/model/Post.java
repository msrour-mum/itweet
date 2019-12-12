package mum.itweet.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import mum.itweet.model.lookups.PostStatus;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false , length = 200)
    private String postText;

    @Column(nullable = false, columnDefinition = "DATETIME default now()")
    private Date creationDate;

    @Column(nullable = true)
    private Date publishDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "statusId", nullable = false)
    private PostStatus status;

    @ManyToOne(optional = false)
    private User user;

    @OneToMany(mappedBy = "post")
    List<Comment> comments;

    @OneToMany(mappedBy = "post")
    List<PostLikes> postLikes;

    private String imageUrl;
    private String videoUrl;
}
