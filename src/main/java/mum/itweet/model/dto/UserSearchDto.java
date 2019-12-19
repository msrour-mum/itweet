package mum.itweet.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserSearchDto {

    private String name;
    private String email;
    private Boolean active;
}
