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

    @Column(nullable = false, columnDefinition = "BIT(1) default 1")
    private boolean isLike;

    @Column(nullable = false, columnDefinition = "DATETIME default now()")
    private Date creationDate;

}