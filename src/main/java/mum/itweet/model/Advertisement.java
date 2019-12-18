package mum.itweet.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name ;

    private String imageUrl ;

    @Column(nullable = false, columnDefinition = "DATETIME default now()")
    private Date creationDate;

    private Boolean active;

    private int ageFrom ;

    private int ageTo ;

    private String gender ;

    public Advertisement(String name, String imageUrl, Date creationDate, Boolean active, int ageFrom, int ageTo, String gender, MultipartFile image) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.creationDate = creationDate;
        this.active = active;
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
        this.gender = gender;
        this.image = image;
    }

    @Transient
    MultipartFile image;

    public Advertisement(String name, Boolean active ,String gender, int ageFrom, int ageTo) {
        this.name = name;
        this.active = active;
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
        this.gender = gender;
    }
}
