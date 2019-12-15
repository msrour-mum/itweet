package mum.itweet.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Post_Likes")
@Data
@NoArgsConstructor
public class PostLikes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Post post;

    @Column(name = "isLike",nullable = false, columnDefinition = "BIT(1) default 1")
    private boolean isLike;

    @Column(name ="creationDate",nullable = false, columnDefinition = "DATETIME default now()")
    private Date creationDate;

    public PostLikes(User user, Post post, boolean isLike, Date creationDate) {
        this.user = user;
        this.post = post;
        this.isLike = isLike;
        this.creationDate = creationDate;
    }
}
