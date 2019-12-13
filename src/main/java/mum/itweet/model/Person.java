package mum.itweet.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @NotEmpty // any characters including "space"
//	 @NotNull
//	 @NotBlank // must have characters BESIDES "space"
    @Size(min = 4, max = 50, message = "{person.name}")
    private String name;
    @NotNull
    private int age;

    private String imageUrl;

    private String videoUrl;

    @Transient
    MultipartFile image;

    @Transient
    MultipartFile video;
}
