package mum.itweet.model.dto;

public class UserAdvertisementDto {
    int userId;

    public UserAdvertisementDto(int userId) {
        this.userId = userId;
    }

    public UserAdvertisementDto() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
