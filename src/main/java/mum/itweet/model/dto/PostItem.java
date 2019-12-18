package mum.itweet.model.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ColumnResult;
import javax.persistence.SqlResultSetMapping;



@Data
@NoArgsConstructor
public class PostItem {


    private long id;
    private String postText;
    private int userId;
    private String imageUrl;
    private String videoUrl;


    private int likeCount;
    private int commentCount;
    private String lastComment;

    public PostItem(long id, String postText, int userId, String imageUrl, String videoUrl, int likeCount, int commentCount, String lastComment) {
        this.id = id;
        this.postText = postText;
        this.userId = userId;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.lastComment = lastComment;
    }
}
