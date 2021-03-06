package mum.itweet.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Following {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    private User follower;

    @ManyToOne(optional = false)
    private User following;

    @Column(name ="creationDate",nullable = false, columnDefinition = "DATETIME default now()")
    private Date creationDate;

    public Following(User follower, User following, Date creationDate) {
        this.follower = follower;
        this.following = following;
        this.creationDate = creationDate;
    }
}
