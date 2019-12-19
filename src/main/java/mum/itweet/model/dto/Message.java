package mum.itweet.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Message implements Serializable {

    long id;

    public Message(long id) {
        this.id = id;
    }
}
