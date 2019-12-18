package mum.itweet.model.view;

import mum.itweet.model.Comment;
import mum.itweet.model.PostLikes;
import mum.itweet.model.User;
import mum.itweet.model.lookups.PostStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@org.hibernate.annotations.Immutable
@org.hibernate.annotations.Subselect(
        value = "select * , \n" +
                "(select count(c.id) from comment c where c.post_id=p.id ) as commentCount ,\n" +
                "(select count(k.id) from post_likes k where k.post_id=p.id ) as likeCount ,\n" +
                "(select  ct.commentText  from comment ct where ct.post_id=p.id order by ct.id desc limit 1 ) as lastComment \n" +
                "from post p\n")
public class PostView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private int userId;
    @Column
    private String postText;
    @Column
    private int statusId;
    @Column
    private String imageUrl;
    @Column
    private String videoUrl;
    @Column(name ="creationDate")
    private Date creationDate;
    @Column(name ="publishDate")
    private Date publishDate;
    @Column
    private int likeCount;
    @Column
    private int commentCount;
    @Column
    private String lastComment;

}
