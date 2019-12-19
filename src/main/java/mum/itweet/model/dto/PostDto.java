package mum.itweet.model.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostDto {

	private int id;
	private String postText;
	private int userId;
	private String imageUrl;
	private String videoUrl;

	public PostDto(int id, String postText, int userId, String imageUrl, String videoUrl) {
		this.id = id;
		this.postText = postText;
		this.userId = userId;
		this.imageUrl = imageUrl;
		this.videoUrl = videoUrl;
	}

	public PostDto(String postText, int userId) {
		this.postText = postText;
		this.userId = userId;
	}

	MultipartFile image;
	MultipartFile video;
}
