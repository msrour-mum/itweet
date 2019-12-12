package mum.itweet.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import mum.itweet.model.lookups.NotificationType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = true)
    private User fromUser;

    @ManyToOne(optional = false)
    private User toUser;

    @Column(nullable = false, columnDefinition = "DATETIME default now()")
    private Date creationDate;

    @ManyToOne(optional = true)
    private Post post;

    @ManyToOne(optional = true)
    private Comment comment;

    @Column(nullable = false, columnDefinition = "BIT(1) default 0")
    private boolean isSeen;

    @Column(nullable = false)
    private String notificationText;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "typeId", nullable = false)
    private NotificationType notificationType;

}
