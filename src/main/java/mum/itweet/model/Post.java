package mum.itweet.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import mum.itweet.model.lookups.PostStatus;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Post  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    private User user;

    @Column(nullable = false , length = 200)
    private String postText;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "statusId", nullable = false)
    private PostStatus status;

    private String imageUrl;
    private String videoUrl;

    @Column(name ="creationDate", nullable = false, columnDefinition = "DATETIME default now()")
    private Date creationDate;

    @Column(name ="publishDate" , nullable = true)
    private Date publishDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="post_id", nullable = false)
    List<Comment> comments =new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="post_id" , nullable = false)
    //@JsonManagedReference
    List<PostLikes> postLikes =new ArrayList<>();


    public void addLike(PostLikes likes)    {        postLikes.add(likes);    }
    public void removeLike(PostLikes likes)
    {
        postLikes.remove(likes);
    }

    public void addComment(Comment comment)    {

        if (comment!=null)    comments.add(comment);    }
    public void removeComment(Comment comment)
    {
        comments.remove(comment);
    }

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

 public int getCoSize()
 {
     return comments.size();
 }
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public PostStatus getStatus() {
        return status;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<PostLikes> getPostLikes() {
        return postLikes;
    }
}
