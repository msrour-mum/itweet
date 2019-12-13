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

    @ManyToOne(optional = false)
    private User user;

    @Column(nullable = false , length = 200)
    private String postText;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "statusId", nullable = false)
    private PostStatus status;

    private String imageUrl;
    private String videoUrl;

    @Column(nullable = false, columnDefinition = "DATETIME default now()")
    private Date creationDate;

    @Column(nullable = true)
    private Date publishDate;

    @OneToMany(mappedBy = "post")
    List<Comment> comments;

    @OneToMany(mappedBy = "post")
    List<PostLikes> postLikes;

    public Post(User user, String postText, PostStatus status, String imageUrl, String videoUrl, Date creationDate, Date publishDate)
    {
        this.user = user;
        this.postText = postText;
        this.status = status;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
        this.creationDate = creationDate;
        this.publishDate = publishDate;

    }
}
