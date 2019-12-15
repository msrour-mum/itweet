package mum.itweet.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Role {
    @Id
    private int id;

    @Column(nullable = false)
    private String name;

    public Role(int id) {
        this.id = id;
    }
}
