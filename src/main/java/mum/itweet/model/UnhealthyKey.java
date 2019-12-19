package mum.itweet.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Unhealthy_Key")
@Data
@NoArgsConstructor
public class UnhealthyKey {
    @Id
    private int id;

    @Column(nullable = false)
    private String wordKey;

    public UnhealthyKey(int id, String wordKey) {
        this.id = id;
        this.wordKey = wordKey;
    }
}

