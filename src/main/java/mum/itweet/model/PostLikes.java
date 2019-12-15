package mum.itweet.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Post_Likes")
@Data
@NoArgsConstructor
public class PostLikes  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
//    @JsonManagedReference
//    @JsonIgnore
    private User user;

//    @ManyToOne(optional = false)
//    @JsonBackReference
//    @JsonIgnore
//    private Post post;

    @Column(name = "isLike",nullable = false, columnDefinition = "BIT(1) default 1")
    private boolean isLike;

    @Column(name ="creationDate",nullable = false, columnDefinition = "DATETIME default now()")
    private Date creationDate;

    public PostLikes(User user, boolean isLike, Date creationDate) {
        this.user = user;
//        this.post = post;
        this.isLike = isLike;
        this.creationDate = creationDate;
    }
}
