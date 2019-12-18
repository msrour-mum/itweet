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


    private int id;
    private String postText;
    private int userId;
    private String imageUrl;
    private String videoUrl;


    private int likeCount;
    private int commentCount;
    private String lastComment;

}
