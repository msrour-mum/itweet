package mum.itweet.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor

public class Comment  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    private User user;

//    @ManyToOne(optional = false)
//    @JsonBackReference
//    private Post post;

    @Column(nullable = false,length = 200)
    private String commentText;

    @Column(name ="creationDate",nullable = false, columnDefinition = "DATETIME default now()")
    private Date creationDate;

    public Comment(User user, Post post, String commentText) {
        this.user = user;
        //this.post = post;
        this.commentText = commentText;
        this.creationDate=new Date();
    }
}
