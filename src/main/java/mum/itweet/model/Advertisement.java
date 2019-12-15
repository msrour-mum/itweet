package mum.itweet.model;

import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String image ;

    private Date creationDate;

    private Boolean active;

    private int ageFrom ;

    private int ageTo ;

    private String gender ;

    public Advertisement(String name, String image, Date creationDate, Boolean active, int ageFrom, int ageTo, String gender) {
        this.name = name;
        this.image = image;
        this.creationDate = creationDate;
        this.active = active;
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
        this.gender = gender;
    }
}
